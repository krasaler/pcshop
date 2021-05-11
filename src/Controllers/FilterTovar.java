package Controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FilterTovar
 */
@WebServlet("/FilterTovar")
public class FilterTovar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterTovar() {
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
		session.setAttribute("priceStart", null);
		session.setAttribute("priceEnd",null);
		session.setAttribute("CORE",null);
		session.setAttribute("HDD", null);
		session.setAttribute("RAM", null);
		session.setAttribute("pcTypes", null);
		if (request.getParameterValues("checkedRows")!=null)
			session.setAttribute("pcTypes", Arrays.asList(request.getParameterValues("checkedRows")));
		if (!request.getParameter("priceEnd") .equals(""))
			session.setAttribute("priceEnd", request.getParameter("priceEnd"));
		if (!request.getParameter("priceStart").equals("")) 
			session.setAttribute("priceStart", request.getParameter("priceStart"));
		if (!request.getParameter("RAM").equals(""))
			session.setAttribute("RAM", request.getParameter("RAM"));
		if (!request.getParameter("CORE").equals("")) 
			session.setAttribute("CORE", request.getParameter("CORE"));
		if (!request.getParameter("HDD").equals(""))
			session.setAttribute("HDD", request.getParameter("HDD"));
		RequestDispatcher view = request.getRequestDispatcher("/TovarItems");
		view.forward(request, response);
	}
}
