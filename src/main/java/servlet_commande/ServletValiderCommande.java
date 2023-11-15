package servlet_commande;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.CommandeJdbc;
import jdbc.CommandeUserJdbc;
import jdbc.ListePlat_jdbc;
import jdbc.ValiderCommandeJdbc;

/**
 * Servlet implementation class ServletValiderCommande
 */
@WebServlet("/ServletValiderCommande")
public class ServletValiderCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValiderCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);

	    if (session != null && session.getAttribute("email") != null) {
	    	String profil =  (String) session.getAttribute("profil");
	    	if (profil.equals("admin")) {
	    		ValiderCommandeJdbc plats = new ValiderCommandeJdbc();
	    		
	    		session.setAttribute("plats", plats.validerCommande());
	    		this.getServletContext().getRequestDispatcher("/WEB-INF/commandes.jsp").forward(request, response);
			}else {
				String referer = request.getHeader("referer");
			    response.sendRedirect(referer);
			}
	    } else {
	    	request.setAttribute("errorMessage", "Vueillez-vous connecter d'abord");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCommande");
		
		if (id != null) {
			int id_commande = Integer.parseInt(id);
    		ValiderCommandeJdbc plats = new ValiderCommandeJdbc();
    		plats.valider(id_commande);
    		String referer = request.getHeader("referer");
		    response.sendRedirect(referer);
		}
	}

}
