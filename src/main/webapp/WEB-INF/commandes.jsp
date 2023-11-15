<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- title -->
	<title>Commandes</title>

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
	
						<!-- menu start -->
	<%@ include file="include/navAdmin.jsp" %>
						
			
	<!-- end header -->
	
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Commande de vos client</p>
						<h1>Commandes</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- cart -->
	<div class="cart-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-12">
					<div class="cart-table-wrap">
						<table class="cart-table">
							<thead class="cart-table-head">
								<tr class="table-head-row">
									<th class="product-image">Image du Plat</th>
									<th class="product-name">nom</th>
									<th class="product-price">prix</th>
									<th class="product-quantity">Statut</th>
									<th class="product-total">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="plat" items="${plats}">
								<tr class="table-body-row">
									<td class="product-image"><img src="assets/img/products/${plat.image}" alt=""></td>
									<td class="product-name">${plat.nom_plat}</td>
									<td class="product-price">${plat.prix}</td>
									<td class="product-total">${plat.statut}</td>
									<td class="product-total">
									<c:choose>
									    <c:when test="${plat.statut eq 'Validé'}">
									        <button class="btn btn-secondary btn-sm">Déjà validé</button>
									    </c:when>
									    <c:otherwise>		
											<form action="ServletValiderCommande" method="post">
												<input type="hidden" name="idCommande" value="${plat.id_plat}">
												<button class="btn btn-primary">Valider</button>
											</form>
									    </c:otherwise>
									</c:choose>
									
									</td>
								</tr>
								</c:forEach>
								<c:if test="${empty plats}">
								    <tr>
								        <td colspan="6"><h4> Aucune commande effectuer.</h4></td>
								    </tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end cart -->

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
	
	<script>
	    function calculateTotal(input, prix) {
	        var quantite = input.value;
	        var total = quantite * prix;
	        var row = input.parentNode.parentNode;
	        var totalCell = row.querySelector('.product-total');
	        totalCell.textContent = total;
	    }
	</script>

</body>
</html>

