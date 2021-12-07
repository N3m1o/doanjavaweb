<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang tin tức</title>
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
  <section id="sliderSection">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-sm-8">
        <div class="slick_slider">
        <c:forEach var="o" items="${lastestNews}">
          <div class="single_iteam"> <a href="/details/${o.newsId}"> <img src="${o.display_img}" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" href="/details/${o.newsId}">${o.title}</a></h2>
              <p>${o.shortDescription}</p>
            </div>
          </div>
        </c:forEach>
          </div>
      </div>
      
      <jsp:include page="lastest.jsp"></jsp:include>
      
    </div>
  </section>
  <section id="contentSection">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-sm-8">
      
        <jsp:include page="left.jsp"></jsp:include>
      
      </div>
      
      <jsp:include page="right.jsp"></jsp:include>
      
    </div>
  </section>
  
  <jsp:include page="footer.jsp"></jsp:include>
  
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/slick.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery.li-scroller.1.0.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery.newsTicker.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery.fancybox.pack.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>