package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.hibernate.service.AccountService;
import com.hibernate.service.OrderService;
import com.hibernate.service.StatusService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;
import com.hibernate.vo.Order;
import com.hibernate.vo.Status;
import com.hibernate.vo.Tovar;

import bean.CartList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class SubOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubOrder() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			CartList cl = (CartList) session.getAttribute("cart");
			String address = session.getAttribute("address").toString();
			Calendar calendar = Calendar.getInstance();
			String username = (String) session.getAttribute("name");
		
			Session sessionH = HibernateUtil.getSessionFactory().getCurrentSession();
			sessionH.beginTransaction();
			
			
			AccountService accountservice = new AccountService();
			StatusService statusService = new StatusService();
			OrderService orderService = new OrderService();
			
			
			Account account = accountservice.getAccountByLogin(username);
			sessionH.beginTransaction();
			List<Tovar> tovars = new ArrayList<Tovar>();
			for	(int i=0;i<cl.Size();i++)
			{
					for(int j=0;j<cl.getCounts(i);j++)
						tovars.add(cl.get(i));
			}
			Status status = statusService.getStatusByName("Действителен");
			Order order = new Order();
			order.setAccount(account);
			order.setAdress(address);
			order.setDate(new Date(calendar.getTime().getTime()));
			order.setTovars(tovars);
			order.setStatus(status);
			orderService.saveOrUpdateOrder(order);
			sessionH.getTransaction().commit();
			session.setAttribute("cart", null);
			session.setAttribute("orderid", order.getId());
			response.sendRedirect("/pcshop/OrderMen.jsp");

		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendRedirect("/pcshop/Error.jsp");
		}
	}

}
