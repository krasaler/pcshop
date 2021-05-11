package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.hibernate.service.PCTypeService;
import com.hibernate.service.TovarService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.PCType;
import com.hibernate.vo.Tovar;

import bean.TovarList;

public class DBTovarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBTovarList() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int page = 1;
		int recordsPerPage = 10;
		int noOfPages = 1;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		Session sessionH = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		sessionH.beginTransaction();
		TovarService tovarService = new TovarService();
		PCTypeService pcTypeService = new PCTypeService();
		List<PCType> pcType = null;
		TovarList tovarlist = null;
		try {
			List<Tovar> tovars = tovarService.getTovars();
			pcType = pcTypeService.getPCTypes();
			sessionH.getTransaction().commit();
			tovarlist = new TovarList(tovars);
			if (session.getAttribute("priceStart") != null) {
					Integer tt = new Integer(session.getAttribute("priceStart")
							.toString());
					if (tt != null)
						tovarlist = tovarlist.getTovarPriceOver(tt.intValue());
			}
			if (session.getAttribute("priceEnd") != null) {
					Integer tt = new Integer(session.getAttribute("priceEnd")
							.toString());
					if (tt != null)
						tovarlist = tovarlist.getTovarPriceLess(tt.intValue());
			}
			if (session.getAttribute("RAM") != null) {
					Integer tt = new Integer(session.getAttribute("RAM")
							.toString());
					if (tt != null)
						tovarlist = tovarlist.getTovarByRAM(tt.intValue());
			}
			if (session.getAttribute("CORE") != null) {
					Integer tt = new Integer(session.getAttribute("CORE")
							.toString());
					if (tt != null)
						tovarlist = tovarlist.getTovarByCORE(tt.intValue());
			}
			if (session.getAttribute("HDD") != null) {
					Integer tt = new Integer(session.getAttribute("HDD")
							.toString());
					if (tt != null)
						tovarlist = tovarlist.getTovarByHDD(tt.intValue());
			}
			if (session.getAttribute("pcTypes") != null) {
				tovarlist = tovarlist.getTovarByPCType((List<String>) session
						.getAttribute("pcTypes"));
			}

		} catch (Exception e) {
			tovarlist=new TovarList();
			e.printStackTrace();
		} finally {
			noOfPages = (int) Math.ceil((double) tovarlist.Size()
					/ (double) recordsPerPage);
			tovarlist = tovarlist.getTovarBeetween((page - 1) * recordsPerPage,
					recordsPerPage);
			session.setAttribute("pctype", pcType);
			session.setAttribute("tovars", tovarlist);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			RequestDispatcher view = request.getRequestDispatcher("Tovars.jsp");
			view.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
