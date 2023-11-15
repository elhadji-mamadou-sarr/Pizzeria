package servlet_commande;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CarteCommande;
import jdbc.CommandeJdbc;
import jdbc.ListePlat_jdbc;
import jdbc.ModifierProduitJdbc;

/**
 * Servlet implementation class ServletCommande
 */
@WebServlet("/ServletCommande")
public class ServletCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

	    if (session != null && session.getAttribute("email") != null) {
	    	//int id_session = (Integer) session.getAttribute("id");
	    	String id_plat = request.getParameter("id_plat");
	    	
    			try {
    				int id_user = (Integer) session.getAttribute("id");
    				int id_cart = Integer.parseInt(id_plat);

    				CarteCommande commande = new CarteCommande();
    				commande.setId_user(id_user);
    				commande.setId_plat(id_cart);
    				CommandeJdbc cmjdbc = new CommandeJdbc();
    				cmjdbc.commander(commande);

    				String message = "La commande a été effectuée avec succès.";
    				request.setAttribute("success", message);
    			    response.sendRedirect(request.getHeader("referer"));

				} catch (NumberFormatException  e) {
					// TODO: handle exception
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
