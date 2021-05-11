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
 * Servlet implementation class OrderIFilter
 */
@WebServlet("/OrderIFilter")
public class OrderIFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderIFilter() {
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
		session.setAttribute("priceStart", null);
		session.setAttribute("priceEnd",null);
		session.setAttribute("dateStart", null);
		session.setAttribute("dateEnd",null);
		if (!request.getParameter("priceEnd") .equals(""))
			session.setAttribute("priceEnd", request.getParameter("priceEnd"));
		if (!request.getParameter("priceStart").equals("")) 
			session.setAttribute("priceStart", request.getParameter("priceStart"));
		if (!request.getParameter("dateEnd") .equals(""))
			session.setAttribute("dateEnd", request.getParameter("dateEnd"));
		if (!request.getParameter("dateStart").equals("")) 
			session.setAttribute("dateStart", request.getParameter("dateStart"));
		RequestDispatcher view = request.getRequestDispatcher("/OrderItems");
		view.forward(request, response);
	}

}
