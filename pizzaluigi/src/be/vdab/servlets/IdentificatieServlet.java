package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IdentificatieServlet
 */
@WebServlet("/identificatie.htm")
public class IdentificatieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/identificatie.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentificatieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			String gebruikersnaam = (String)session.getAttribute("gebruikersnaam");
				if (gebruikersnaam != null) {
					request.setAttribute("gebruikersnaam", gebruikersnaam);
				}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("gebruikersnaam", request.getParameter("gebruikersnaam"));
		//redirect naar huidige URL
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

}
