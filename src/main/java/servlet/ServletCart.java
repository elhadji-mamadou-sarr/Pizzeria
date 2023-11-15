package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Carte;
import jdbc.CommandeUserJdbc;


/**
 * Servlet implementation class ServletCart
 */
@WebServlet("/ServletCart")
public class ServletCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

	    if (session != null && session.getAttribute("email") != null) {
	    	int id = (Integer) session.getAttribute("id");
	    	CommandeUserJdbc commandeUser = new CommandeUserJdbc();
	    	List<Carte> panier = null;
	    	session.setAttribute("panier", commandeUser.listerCommande(id));
			this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	    } else {
	    	request.setAttribute("errorMessage", "Vueillez-vous connecter d'abord");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
