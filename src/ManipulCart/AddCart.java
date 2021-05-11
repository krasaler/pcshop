package ManipulCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartList;

public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		resp.setContentType("text/html;charset=UTF-8");
		CartList cart = (CartList) s.getAttribute("cart");

		int id = Integer.parseInt(req.getParameter("id"));
		int index = cart.IndexOf(id);
		if (index == -1) {
			resp.sendRedirect("Error.jsp");
			return;
		} else {
			cart.setCounts(index,cart.getCounts(index) + 1);
			s.setAttribute("cart", cart);
			resp.sendRedirect("/pcshop/Zakaz.jsp");
		}
	}
}
