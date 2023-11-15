
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="index.html">
								<img src="/assets/img/pizza-logo.jpeg" alt="">
							</a>
						</div>
						<!-- logo -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="ServletAccueil">Accueil</a></li>
								<li><a href="ServletListeProduit">Plats</a></li>
								<li><a href="ServletValiderCommande">Commandes</a></li>
								<li><a href="ServletListeUser">Utilisateurs</a></li>
								<li>
									<div class="header-icons">
										<a class="shopping-cart" href="ServletCart"><i class="fas fa-shopping-cart"></i></a>
										<a class="mobile-hide " href="#">${nom}</a>
										<c:choose>
										    <c:when test="${empty nom}">
										        <a href="SerlvetLogin">Se connecter</a>
										    </c:when>
										    <c:otherwise>
										        <a href="ServletDeconnection">Se deconnecter</a>
										    </c:otherwise>
										</c:choose>
									</div>
								</li>
							</ul>
						</nav>
						<a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>