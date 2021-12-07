<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${details.title}</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/animate.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/li-scroller.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/slick.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jquery.fancybox.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/theme.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		<section id="navArea">
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav main_nav">
          <li class="active"><a href="/home"><span class="fa fa-home desktop-home"></span><span class="mobile-show">Home</span></a></li>
          <li>
          		<c:forEach var="c" items="${cateList}">
          			<a href="#">${c.cname}</a>
          		</c:forEach>>
          </li>
          <li><a href="contact.jsp">Liên hệ</a></li>
        </ul>
      </div>
    </nav>
  </section>
		
		<section id="contentSection">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8">
					<div class="left_content">
						<div class="single_page">
							<ol class="breadcrumb">
								<li><a href="../index.html">Trang chủ</a></li>
								<li><a href="#">${cate.cname}</a></li>
							</ol>
							<h1>${details.title}</h1>
							<div class="post_commentbox">
								<a href="#"><i class="fa fa-user"></i>${author.fullname}</a> 
								<a href="#"> <i class="fa fa-tags"></i>${cate.cname}</a>
							</div>
							<div class="single_page_content">
								<img class="img-center" src="${details.display_img}"
									alt="">
								
								<blockquote>${details.shortDescription}</blockquote>
								<p>${details.content}</p>
								
								
							</div>
							<div class="social_link">
								<ul class="sociallink_nav">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
								</ul>
							</div>
							<div class="related_post">
								<h2>
									Related Post <i class="fa fa-thumbs-o-up"></i>
								</h2>
								<ul class="spost_nav wow fadeInDown animated">
									<li>
										<div class="media">
											<a class="media-left" href="single_page.html"> <img
												src="../images/post_img1.jpg" alt="">
											</a>
											<div class="media-body">
												<a class="catg_title" href="single_page.html"> Aliquam
													malesuada diam eget turpis varius</a>
											</div>
										</div>
									</li>
									<li>
										<div class="media">
											<a class="media-left" href="single_page.html"> <img
												src="../images/post_img2.jpg" alt="">
											</a>
											<div class="media-body">
												<a class="catg_title" href="single_page.html"> Aliquam
													malesuada diam eget turpis varius</a>
											</div>
										</div>
									</li>
									<li>
										<div class="media">
											<a class="media-left" href="single_page.html"> <img
												src="../images/post_img1.jpg" alt="">
											</a>
											<div class="media-body">
												<a class="catg_title" href="single_page.html"> Aliquam
													malesuada diam eget turpis varius</a>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<nav class="nav-slit">
					<a class="prev" href="#"> <span class="icon-wrap"><i
							class="fa fa-angle-left"></i></span>
						<div>
							<h3>City Lights</h3>
							<img src="../images/post_img1.jpg" alt="" />
						</div>
					</a> <a class="next" href="#"> <span class="icon-wrap"><i
							class="fa fa-angle-right"></i></span>
						<div>
							<h3>Street Hills</h3>
							<img src="../images/post_img1.jpg" alt="" />
						</div>
					</a>
				</nav>
				
				<jsp:include page="lastest.jsp"></jsp:include>

				<jsp:include page="right.jsp"></jsp:include>

			</div>
		</section>

		<jsp:include page="footer.jsp"></jsp:include>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/slick.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.li-scroller.1.0.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.newsTicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.fancybox.pack.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>