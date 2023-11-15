<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	
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
</head>
<body>

	<div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div>
    <!--PreLoader Ends-->
	
	<!-- header -->
	<%@ include file="include/nav.jsp" %>


	<div class="checkout-section row mt-150 mb-150">
		<div class="container col-md-6">
			<div id="collapseOne" class="collapse card show " style="background: #eee;">
				<div class="card-body">
					<div class="billing-address-form">
						<form action=ServletInscriptionUser method="post">
						   	<p><input type="text" placeholder="Nom" name="nom" value="${bean.nom}" required></p>
						   	<p><input type="text" placeholder="Prenom" name="prenom"  value="${bean.prenom}" required></p>
						    <p><input type="email" placeholder="Email" name="email"  value="${bean.email}" required></p>
						    <p><input type="tel" placeholder="Telephone" name="telephone" value="${bean.telephone}" required></p>
						    
						    <p><input type="password" placeholder="Mot de passe" name="password">
						    	<div id="emailHelp" class="form-text">${form.erreurs['password']}</div>
						    </p>
						    <input type="hidden" value="client" name="profil">
						    <p><input type="password" placeholder="Confirmer le mot de passe" name="confPassword">
						    	<div id="emailHelp" class="form-text">${form.erreurs['confPassword']}</div>
						    </p>
							<p> 
								<input type="submit" value="S'inscrire">
							</p>						 
						</form>
					</div>
				</div>
			</div>
				
			<div class="col-md-6">
				<img src="illustrator.png" alt="" width="550px">
				<img src="assets/img/company-logos/2.png" alt="">
			</div>
		
		</div>	
	
	</div>

	<%@ include file="include/footer.jsp" %>
	
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
	<!-- form validation js -->
	<script src="assets/js/form-validate.js"></script>
	<!-- main js -->
	<script src="assets/js/main.js"></script>

</body>
</html>