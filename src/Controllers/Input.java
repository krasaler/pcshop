package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.hibernate.service.AccountService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;

import bean.CartList;

public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Input() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("Login");
		String pwd = request.getParameter("Password");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AccountService accountService = new AccountService();
		Account account = accountService.getAccountByLogin(name);
		session.getTransaction().commit();
		try {
				if (account.getPwd().equals(pwd)) {
					HttpSession s = request.getSession();
					s.setAttribute("name", name);
					if(!account.getAccountType().getName().equals("admin"))
					{
						CartList cart = new CartList();
						s.setAttribute("cart", cart);
						s.setAttribute("atype", "user");
					}
					else
					{
						s.setAttribute("atype", "admin");
					}
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
				}
				else
				{
					response.sendRedirect("Error.jsp");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return;
	}
}
