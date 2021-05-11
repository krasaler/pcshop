package Controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hibernate.service.AccountService;
import com.hibernate.service.AccountTypeService;
import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;
import com.hibernate.vo.AccountType;

/**
 * Servlet implementation class Registers
 */
@WebServlet("/Registers")
public class Registers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registers() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String name = request.getParameter("Login");
		String pwd = request.getParameter("Password");
		Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})");
		Matcher matcher = pattern.matcher(pwd);
		if (matcher.matches() & name.length()>6) {
				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();
				AccountTypeService accounttypeService = new AccountTypeService();
				AccountType accountType = accounttypeService
						.getAccountTypeByName("user");
				Account account = new Account();
				account.setAccountType(accountType);
				account.setLogin(name);
				account.setPwd(pwd);
				account.setFirstName(fname);
				account.setLastName(lname);
				AccountService accountService = new AccountService();
				accountService.saveOrUpdateAccount(account);
				session.getTransaction().commit();
				getServletContext().getRequestDispatcher("/input").forward(
						request, response);
		} else {
			response.sendRedirect("Register.jsp");
		}
		return;
	}
}
