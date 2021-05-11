package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AOList;
import bean.CartList;
import bean.OrderList;

/**
 * Servlet implementation class OrderLoad
 */
@WebServlet("/OrderContent")
public class OrderContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderContent() {
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
		CartList cartList = null;
		if (request.getParameter("id") != "") {
			String idOrder = request.getParameter("id");
			if (session.getAttribute("orders") != null) {
				OrderList orderList = (OrderList) session
						.getAttribute("orders");
				cartList = orderList.getID(Integer.parseInt(idOrder))
						.getCartList();
				session.setAttribute("cart", cartList);
			}
			if (session.getAttribute("ordersall") != null) {
				AOList aoList = (AOList) session.getAttribute("ordersall");
				cartList = aoList.getOrderByID(Integer.parseInt(idOrder))
						.getCartList();
			}
		}
		session.setAttribute("cart", cartList);
		RequestDispatcher view = request.getRequestDispatcher("OrderItem.jsp");
		view.forward(request, response);
	}

}
