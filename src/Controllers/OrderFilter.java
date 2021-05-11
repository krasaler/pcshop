package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderFilter
 */
@WebServlet("/OrderFilter")
public class OrderFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFilter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("idorder", null);
		session.setAttribute("priceStart", null);
		session.setAttribute("priceEnd",null);
		session.setAttribute("dateStart", null);
		session.setAttribute("dateEnd",null);
		session.setAttribute("userFilter",null);
		if (!request.getParameter("idorder").equals(""))
			session.setAttribute("idorder", request.getParameter("idorder"));
		if (!request.getParameter("dateEnd") .equals(""))
			session.setAttribute("dateEnd", request.getParameter("dateEnd"));
		if (!request.getParameter("dateStart").equals("")) 
			session.setAttribute("dateStart", request.getParameter("dateStart"));
		if (!request.getParameter("userFilter").equals(""))
			session.setAttribute("userFilter", request.getParameter("userFilter"));
		RequestDispatcher view = request.getRequestDispatcher("/OrderItemFull");
		view.forward(request, response);
	}

}
