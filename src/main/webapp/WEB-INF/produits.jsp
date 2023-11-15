<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- title -->
	<title>Administrateur</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
						<p></p>
						<h1>Produits</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- check out section -->
		<div class="container mt-10">
				<div class="order-details-wrap">
						<table class="order-details">
							<thead>
								<tr>
									<th>Image</th>
									<th>Nom du plat</th>
									<th>Prix</th>
									<th>Description</th>
									<th>Disponibilite</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody class="order-details-body">
								<c:forEach var="plat" items="${plats}">
								<tr>
									<td> 
										<img src="assets/img/products/${plat.image}" width="100px" height="80px" alt="Image du plat" />
									</td>
									<td> <c:out value="${plat.nom_plat}"/> </td>
									<td><c:out value="${plat.prix}"/></td>
									<td><c:out value="${plat.description}"/></td>
									<td><c:out value="${plat.disponibilité}"/></td>
									<td class="d-flex">
										<a href="ServletModifierProduit?id=${plat.id_plat}" class="btn btn-outline-primary rounded-pill btn-sm">
											<span class="material-symbols-outlined edit">border_color</span>
										</a>
											&nbsp;&nbsp;
										<a href="ServletSupprimerProd?id=${plat.id_plat}" class="btn btn-outline-danger rounded-pill btn-sm">
											<span class="material-symbols-outlined supp">delete_forever</span>
										</a>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
							
		</div>
		
		<div class="billing-address-form container mt-20 w-70 ">
				<h2>${empty bean.id_plat ? 'Ajouter un plat' : 'Modifier un plat'}</h2>
					<form action="${empty bean.id_plat ? 'ServletListeProduit' : 'ServletModifierProduit'}" 
						enctype="multipart/form-data" method="post">
						<p><input type="text" min="4" placeholder="Nom du plat" name="nom_plat" value="${bean.nom_plat}" required></p>
						<p><input type="text" min="3" pattern="[0-9]+" placeholder="Prix" name="prix" value="${bean.prix}" required></p>
						<p>
						  <input class="form-control form-control-lg" accept="image/*" name="image" id="formFileLg" type="file" required>
						</p>
						<input type="hidden" name="id" value="${bean.id_plat}">
						<p><textarea name="description" id="bill" cols="20" rows="10" placeholder="Description" value="${bean.description}" required></textarea></p>
						<p><input class="form-check-input" name="disponibilite" value="true" type="checkbox" hidden="true"></p>
						<p><input class="boxed-btn" type="submit" value="${empty bean.id_plat ? 'Ajouter' : 'Modifier'}"></p>						 
					</form>
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