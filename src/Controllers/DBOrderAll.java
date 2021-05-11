package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import bean.AOList;

import com.hibernate.service.AccountService;
import com.hibernate.service.OrderService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;

/**
 * Servlet implementation class DBOrderAll
 */
@WebServlet("/DBOrderAll")
public class DBOrderAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBOrderAll() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int page = 1;
		int recordsPerPage = 10;
		int noOfPages = 1;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		String username = (String) session.getAttribute("name");
		AOList data = null;
		if (username != null) {
			try{
			Session sessionH = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			sessionH.beginTransaction();
			AccountService accountService = new AccountService();
			OrderService orderService = new OrderService();
			data = new AOList();
			List<Account> accounts = accountService.getAccounts();
			for (Account account : accounts) {		
				data.Add(account, orderService.getOrdersByAccount(account));
			}
			if (session.getAttribute("idorder") != null) {
				data = data.getIndexOfbyID(
						session.getAttribute("idorder").toString());
			} 
			if (session.getAttribute("priceStart") != null) {
				data = data.getOrderPriceOver(Integer.parseInt(
						session.getAttribute("priceStart").toString()));
			} 
			if (session.getAttribute("priceEnd") != null) {
				data = data.getOrderPriceLess(Integer.parseInt(
						session.getAttribute("priceEnd").toString()));
			} 
			if (session.getAttribute("dateStart") != null) {
				try {
					data = data.getOrderDateOver(
							new SimpleDateFormat("yyyy-MM-dd")
							.parse(session.getAttribute("dateStart")
									.toString()
									));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} 
			if (session.getAttribute("dateEnd") != null) {
				try {
					data = data.getOrderDateLess(							
							new SimpleDateFormat("yyyy-MM-dd")
							.parse(session.getAttribute("dateEnd")
							.toString()
							));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} 
			if (session.getAttribute("userFilter") != null) {
				data = data.getOrderbyAccount(
						session.getAttribute("userFilter").toString());
			} 
			noOfPages = (int) Math.ceil((double) data.Size()/ (double) recordsPerPage);
			data = data.getOrderBeetween((page - 1) * recordsPerPage,
					recordsPerPage);
			}
			catch(Exception  ex)
			{
				data = new AOList();
				ex.printStackTrace();
			}
			finally{
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			session.setAttribute("ordersall", data);
	        RequestDispatcher view = request.getRequestDispatcher("AdminList.jsp");
	        view.forward(request, response);
			}
		}

	}
}
