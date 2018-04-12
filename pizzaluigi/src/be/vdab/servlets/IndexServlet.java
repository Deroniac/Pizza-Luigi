package be.vdab.servlets;

import be.vdab.entities.Begroeting;
import be.vdab.entities.Adres;
import be.vdab.entities.Persoon;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index.htm", name = "indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private static final String INDEX_REQUESTS = "indexRequests";
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(INDEX_REQUESTS, new AtomicInteger());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setAttribute("begroeting", new Begroeting());
			request.setAttribute("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true,
					new Adres("Grote Markt", "3", 9700, "Oudenaarde")));
			request.getRequestDispatcher(VIEW).forward(request, response);
			request.setAttribute("emailAdresWebMaster", this.getServletContext().getInitParameter("emailAdresWebMaster"));
			((AtomicInteger) this.getServletContext().getAttribute(INDEX_REQUESTS)).incrementAndGet();
			
	}
}
