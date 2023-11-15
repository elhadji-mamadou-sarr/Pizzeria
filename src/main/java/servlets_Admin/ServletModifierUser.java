package servlets_Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utilisateur;
import form.FormInscription;
import jdbc.ListeUserJdbc;
import jdbc.User.InsererJDBC;
import jdbc.User.ModifierUserJDBC;

/**
 * Servlet implementation class ServletModifierUser
 */
@WebServlet("/ServletModifierUser")
public class ServletModifierUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierUser() {
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
	    		String idUser = request.getParameter("id");
	    		if (idUser != null && !idUser.isEmpty()) {
	    			try {
	    				int id = Integer.parseInt(idUser);
	    				ModifierUserJDBC user = new ModifierUserJDBC();
			    		request.setAttribute("bean", user.personne_a_modifier(id));
			    		session.setAttribute("utilisateurs", session.getAttribute("utilisateurs"));
			    		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
			    	
					} catch (NumberFormatException  e) {
						// TODO: handle exception
					}	
				}else
	    		response.sendRedirect("ServletListeUser");
	    	}else {
		    	request.setAttribute("errorMessage", "Vous ne pouvez pas acceder a cette page");
				this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
		FormInscription form = new FormInscription();
		Utilisateur bean = form.inscrire(request);
		String idUser = request.getParameter("id");
		
		if (idUser != null && !idUser.isEmpty()) {
			
			ModifierUserJDBC modifier = new ModifierUserJDBC();
			try {
				int id = Integer.parseInt(idUser);
				bean = modifier.personne_a_modifier(id);
				
				bean.setNom(request.getParameter("nom"));
				bean.setPrenom(request.getParameter("prenom"));
				bean.setTelephone(request.getParameter("telephone"));
				bean.setEmail(request.getParameter("email"));
				bean.setPassword(request.getParameter("password"));
				bean.setProfil(request.getParameter("profil"));
				
				request.setAttribute("form", form);
				request.setAttribute("bean", bean);

				if (form.getErreurs().isEmpty()) {
					modifier.update(bean);
					response.sendRedirect("ServletListeUser");
					
				} else {			
		    		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
				}
				
			} catch (NumberFormatException  e) {
				String referer = request.getHeader("referer");
				response.sendRedirect(referer);
			}
			
		}else {// 
			 String referer = request.getHeader("referer");
			 response.sendRedirect(referer);
	    }
		
		
		
	}

	
	
}
