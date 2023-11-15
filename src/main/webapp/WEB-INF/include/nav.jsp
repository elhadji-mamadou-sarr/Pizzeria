
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="">
								<img src="../assets/img/pizza-logo.jpeg" alt="">
							</a>
						</div>
						<!-- logo -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="ServletAccueil">Accueil</a></li>
								<li><a href="">A propos</a></li>
								<li><a href="">Contact</a></li>
								<li><a href="">Boutique</a></li>
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