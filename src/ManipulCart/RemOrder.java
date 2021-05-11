package ManipulCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hibernate.service.OrderService;
import com.hibernate.service.StatusService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Order;
import com.hibernate.vo.Status;

/**
 * Servlet implementation class RemOrder
 */
@WebServlet("/RemOrder")
public class RemOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemOrder() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Session sessionH = HibernateUtil.getSessionFactory().getCurrentSession();
		sessionH.beginTransaction();
		OrderService orderService  = new OrderService();
		StatusService statusService = new StatusService();
		Order order = orderService.getOrder(id);
		sessionH.getTransaction().commit();
		sessionH = HibernateUtil.getSessionFactory().getCurrentSession();
		sessionH.beginTransaction();
		Status status = statusService.getStatusByName("Отменен");
		order.setStatus(status);
		orderService.saveOrUpdateOrder(order);
		sessionH.getTransaction().commit();
		RequestDispatcher view = request.getRequestDispatcher("/OrderItemFull");
		view.forward(request, response);
	}

}
