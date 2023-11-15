package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utilisateur;
import form.FormInscription;
import jdbc.User.InsererJDBC;



/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscriptionUser")
public class ServletInscriptionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscriptionUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FormInscription form = new FormInscription();
		Utilisateur bean = form.inscrire(request);
		
		bean.setNom(request.getParameter("nom"));
		bean.setPrenom(request.getParameter("prenom"));
		bean.setTelephone(request.getParameter("telephone"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setProfil(request.getParameter("profil"));
		
		request.setAttribute("form", form);
		request.setAttribute("bean", bean);

		if (form.getErreurs().isEmpty()) {
			HttpSession session = request.getSession();
			

			InsererJDBC user = new InsererJDBC();
			String email = bean.getEmail();
			
			
			boolean emailExiste = user.emailExiste(email);
			
				if (emailExiste) {
					request.setAttribute("message", "Cet email existe deja");	
					
				}else {
					user.inserer(bean);
					request.setAttribute("users", bean);
					response.sendRedirect("SerlvetLogin");
				}

		} else {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
		
	}
	
	
	

}
