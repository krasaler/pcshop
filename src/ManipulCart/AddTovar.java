package ManipulCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.hibernate.service.TovarService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Tovar;

import bean.CartList;

public class AddTovar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		resp.setContentType("text/html;charset=UTF-8");
		CartList cart = (CartList) s.getAttribute("cart");
		if (cart == null) {
			cart = new CartList();
			s.setAttribute("cart", cart);
		}
		int id = Integer.parseInt(req.getParameter("id"));
		
		Session sessionH = HibernateUtil.getSessionFactory().getCurrentSession();
		sessionH.beginTransaction();
		TovarService tovarService = new TovarService();
		Tovar tovar = tovarService.getTovar(id);
		sessionH.getTransaction().commit();
		cart.Add(tovar);

		s.setAttribute("cart", cart);
        RequestDispatcher view = req.getRequestDispatcher("/TovarItems");
        view.forward(req, resp); 
	}
}
