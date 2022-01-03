<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${details.title}</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/li-scroller.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/slick.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.fancybox.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		
		
		<section id="contentSection">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8">
					<div class="left_content">
						<div class="single_page">
							<ol class="breadcrumb">
								<li><a href="/home">Trang chủ</a></li>
								<li><a href="/category/${cate.cid}">${cate.cname}</a></li>
							</ol>
							<h1>${details.title}</h1>
							<div class="post_commentbox">
								<a href="#"><i class="fa fa-user"></i>${person.fullname}</a> 
								<a href="/category/${cate.cid}"> <i class="fa fa-tags"></i>${cate.cname}</a>
							</div>
							<div class="single_page_content">
								<img class="img-center" src="${details.display_img}" alt="">
								
								<blockquote>${details.shortDescription}</blockquote>
								<p>${details.content}</p>
								<br>
								<p align = "right"><b>Tác giả: ${person.fullname}</b></p>
							</div>
							<div class="social_link">
								<ul class="sociallink_nav">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-google"></i></a></li>
									<li><a href="https://www.youtube.com/c/vtv24" target="_blank"><i class="fa fa-youtube"></i></a></li>
									<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
								</ul>
							</div>
							<div class="related_post">
								<h2>
									Bài viết liên quan
								</h2>
								<ul class="spost_nav wow fadeInDown animated">
								<c:forEach var="r" items="${random}">
									<li>
										<div class="media">
											<a class="media-left" href="/details/${r.newsId}"> 
												<img src="${r.display_img}">
											</a>
											<div class="media-body">
												<a class="catg_title" href="/details/${r.newsId}">${r.title}</a>
											</div>
										</div>
									</li>
								</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
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