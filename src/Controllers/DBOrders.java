package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.hibernate.service.AccountService;
import com.hibernate.service.OrderService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;
import com.hibernate.vo.Order;

import bean.OrderList;

public class DBOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBOrders() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int page = 1;
		int recordsPerPage = 10;
		int noOfPages = 1;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		String username = (String) session.getAttribute("name");
		if (username != null) {
			Session sessionH = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			sessionH.beginTransaction();
			AccountService accountService = new AccountService();
			OrderService orderService = new OrderService();
			OrderList orderList = null;
			try {
				Account account = accountService.getAccountByLogin(username);
				List<Order> orders = orderService.getOrdersByAccount(account);
				sessionH.getTransaction().commit();
				orderList = new OrderList(orders);
			
				if (session.getAttribute("priceStart") != null) {
					orderList = orderList.getOrderPriceOver(Integer.parseInt(
							session.getAttribute("priceStart").toString()));
				} 
				if (session.getAttribute("priceEnd") != null) {
					orderList = orderList.getOrderPriceLess(Integer.parseInt(
							session.getAttribute("priceEnd").toString()));
				} 
				if (session.getAttribute("dateStart") != null) {
					try {
						orderList = orderList.getOrderDateOver(
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
						orderList = orderList.getOrderDateLess(							
								new SimpleDateFormat("yyyy-MM-dd")
								.parse(session.getAttribute("dateEnd")
								.toString()
								));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} 

			} catch (Exception e) {
				orderList = new OrderList();
				e.printStackTrace();
			} finally {
				noOfPages = (int) Math.ceil((double) orderList.Size() / (double) recordsPerPage);
				orderList = orderList.getOrderBeetween((page - 1) * recordsPerPage,
						recordsPerPage);
				request.setAttribute("noOfPages", noOfPages);
				request.setAttribute("currentPage", page);
				session.setAttribute("orders", orderList);
				RequestDispatcher view = request
						.getRequestDispatcher("ListOrder.jsp");
				view.forward(request, response);
			}
		}
	}

}
