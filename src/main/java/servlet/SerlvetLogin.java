package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jdbc.ConnexionJDBC;
/**
 * Servlet implementation class SerlvetLogin
 */
@WebServlet("/SerlvetLogin")
public class SerlvetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerlvetLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(); 
		
			ConnexionJDBC connect = new ConnexionJDBC();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			connect = connect.authentification(email, password);
		if (connect != null) {		
			
			session.setAttribute("email", email);
			String profil = connect.getStatus();
			String id = connect.getUserId();
			String nom = connect.getName();
			
			session.setAttribute("nom", nom);
			session.setAttribute("id", Integer.parseInt(id));
			session.setAttribute("profil", profil);
			if ("admin".equals(profil)) {
				response.sendRedirect("ServletListeUser");
			}else if("client".equals(profil)){
						
				this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);	
			}
			
		}else{
			request.setAttribute("errorMessage", "Identifiant incorrect");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	
	}

}
