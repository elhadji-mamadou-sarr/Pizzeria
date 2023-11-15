<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

	<!-- title -->
	<title>Administrateur</title>

	<!-- favicon -->
	<link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="assets/css/all.min.css">
	<!-- bootstrap -->
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<!-- owl carousel -->
	<link rel="stylesheet" href="assets/css/owl.carousel.css">
	<!-- magnific popup -->
	<link rel="stylesheet" href="assets/css/magnific-popup.css">
	<!-- animate css -->
	<link rel="stylesheet" href="assets/css/animate.css">
	<!-- mean menu css -->
	<link rel="stylesheet" href="assets/css/meanmenu.min.css">
	<!-- main style -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- responsive -->
	<link rel="stylesheet" href="assets/css/responsive.css">
	<style>
		
		.edit{
			color: blue;
		}
		.edit:hover{
			color: white;
		}
		.supp{
			color: red;
		}
		.supp:hover{
			color: white;
		}
		
		
	</style>

</head>
<body>
	
	<!--PreLoader-->
    <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div>
    <!--PreLoader Ends-->
	
	<!-- header -->
	<%@ include file="include/navAdmin.jsp" %>
	
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Gérer la confidentialité de tes clients</p>
						<h1>Utilisateurs</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- check out section -->
	<div class="checkout-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<div class="checkout-accordion-wrap">
						<div class="accordion" id="accordionExample">
						  <div class="card single-accordion">
						    <div class="card-header" id="headingOne">
						      <h5 class="mb-0">
						        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						          Liste utilisateur
						        </button>
						      </h5>
						    </div>

						    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
						      <div class="card-body">
						        <table class="order-details" style="width: 100%;">
									<thead>
										<tr>
											<th>Nom</th>
											<th>Prenom</th>
											<th>Telephone</th>
											<th>Email</th>
											<th>Profil</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody class="order-details-body">
										<c:forEach var="utilisateur" items="${utilisateurs}">
										<tr>
											<td>${utilisateur.nom}</td>
											<td>${utilisateur.prenom}</td>
											<td>${utilisateur.telephone}</td>
											<td>${utilisateur.email}</td>
											<td>${utilisateur.profil}</td>
											<td class="d-flex action">
												<a href="ServletModifierUser?id=${utilisateur.id_user}" class="btn btn-outline-primary rounded-pill btn-sm">
													<span class="material-symbols-outlined edit">border_color</span>
												</a>
												&nbsp;&nbsp;
												<a href="ServletSupprimerUser?id=${utilisateur.id_user}" class="btn btn-outline-danger rounded-pill btn-sm">
													<span class="material-symbols-outlined supp">delete_forever</span>
												</a>	
											</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
						        	<!-- -->
						      </div>
						    </div>
						  </div>
						  
						  
						</div>

					</div>
				</div>

				
			</div>
				
				<div class="billing-address-form">
				 	<h4> ${empty bean.id_user ? 'Ajouter un Utilisateur' : 'Modifier un Utilisateur'}</h4>
					<form action="${empty bean.id_user ? 'ServletListeUser' : 'ServletModifierUser'}" method="post">
						<p><input type="text" placeholder="Nom" name="nom" value="${bean.nom}" required></p>
						<p><input type="text" placeholder="Prenom" name="prenom"  value="${bean.prenom}" required></p>
						<p><input type="email" placeholder="Email" name="email"  value="${bean.email}" required></p>
						<p><input type="tel" placeholder="Telephone" name="telephone" value="${bean.telephone}" required></p>
							<input type="hidden" name="id" value="${bean.id_user}">
						<p><input type="password" placeholder="Mot de passe" name="password">
						<div id="emailHelp" class="form-text">${form.erreurs['password']}</div>
						</p>
						<p><select name="profil" style="width: 100%; padding: 15px; background: white;">
							<option value="admin">Admin</option>
							<option value="client">Client</option>
							</select>
						</p>
						<p><input type="password" placeholder="Confirmer le mot de passe" name="confPassword">
							<div id="emailHelp" class="form-text">${form.erreurs['confPassword']}</div>
						 </p>
						<p> 
							<input class="boxed-btn" type="submit" value="${empty bean.id_user ? 'Ajouter' : 'Modifier'}">
						</p>						 
					</form>
				</div>	
						
		</div>
		
		
	</div>
	<!-- end check out section -->

	

	<%@ include file="include/footer.jsp" %>
	
	<!-- jquery -->
	<script src="assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="assets/js/main.js"></script>

</body>
</html>