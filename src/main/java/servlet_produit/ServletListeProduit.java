package servlet_produit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Carte;
import jdbc.ListePlat_jdbc;
import jdbc.ListeUserJdbc;
import jdbc.ModifierProduitJdbc;
import jdbc.PosterJdbc;

/**
 * Servlet implementation class ServletListeProduit
 */
@WebServlet("/ServletListeProduit")
@MultipartConfig
public class ServletListeProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletListeProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

	    if (session != null && session.getAttribute("email") != null) {
	    	String profil =  (String) session.getAttribute("profil");
	    	if (profil.equals("admin")) {
	    		ListePlat_jdbc plats = new ListePlat_jdbc();
	    		
	    		session.setAttribute("plats", plats.lister());
	    		this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
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
		
		Carte bean = new Carte();	
		Part filePart = request.getPart("image");
		String fileName = bean.extractFileName(filePart);
		String savePath = getServletContext().getRealPath("/")+"assets/img/products/" + fileName;
		
		try (
			InputStream fileContent = filePart.getInputStream();
			FileOutputStream out = new FileOutputStream(new File(savePath))) {

			int read;
		    final byte[] bytes = new byte[1024];
		    while ((read = fileContent.read(bytes)) != -1) {
		        out.write(bytes, 0, read);
			}
			    
			String nom_plat = request.getParameter("nom_plat");
			String prix = request.getParameter("prix");
			String description = request.getParameter("description");
			String disponibilité = request.getParameter("disponibilité");
			
			Float price = Float.valueOf(prix);
			Boolean dispo = Boolean.valueOf(disponibilité);
			bean.setNom_plat(nom_plat);
			bean.setPrix(price);
			bean.setDescription(description);
			bean.setDisponibilité(dispo);
			bean.setImage(fileName);																																																																																																																																																																																																																																																																																																					bean.setImage(fileName);
																																																																																																																																																																																																																																																																																																												System.out.println(bean.getImage());
			PosterJdbc post = new PosterJdbc();
			post.Poster(bean);
			
			response.sendRedirect("ServletListeProduit");	

		} catch (IOException e) {
		    e.printStackTrace(); 
		}
		
	
	}


	
	

}
