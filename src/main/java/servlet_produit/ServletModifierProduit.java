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
import jdbc.ModifierProduitJdbc;
import jdbc.User.ModifierUserJDBC;

/**
 * Servlet implementation class ServletModifierProduit
 */
@WebServlet("/ServletModifierProduit")
@MultipartConfig
public class ServletModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProduit() {
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
	    				ModifierProduitJdbc produit = new ModifierProduitJdbc();
			    		request.setAttribute("bean", produit.produit_a_mod(id));
			    		this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
			    	
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
        
		ModifierProduitJdbc prod = new ModifierProduitJdbc();
		String idString = request.getParameter("id");
		
		    try {
		        int id = Integer.parseInt(idString);
		        Carte bean = prod.produit_a_mod(id);
		        
		        Part filePart = request.getPart("image");
		        String fileName = bean.extractFileName(filePart);
		        String savePath = getServletContext().getRealPath("/") + "assets/img/products/" + fileName;

		        try (InputStream fileContent = filePart.getInputStream();
					     FileOutputStream out = new FileOutputStream(new File(savePath))) {

					    int read;
					    final byte[] bytes = new byte[1024];
					    while ((read = fileContent.read(bytes)) != -1) {
					        out.write(bytes, 0, read);
					    }
				
						Float price = Float.valueOf(request.getParameter("prix"));
						Boolean dispo = Boolean.valueOf(request.getParameter("disponibilite"));
						bean.setNom_plat(request.getParameter("nom_plat"));
						bean.setPrix(price);
						bean.setDescription(request.getParameter("description"));
						bean.setDisponibilité(dispo);
						bean.setImage(fileName);
						
				        prod.updateProduit(bean);
		        
		        } catch (IOException e) {
				    e.printStackTrace(); 
				}
		        
		    } catch (NumberFormatException e) {
		        
		    }		
		
		response.sendRedirect("ServletListeProduit");
		
	}

}
