<%@page import="com.laptrinhjavaweb.entity.UserEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Object object = session.getAttribute("userEntity");
UserEntity userEntity = (UserEntity)object;
%>
<!-- Header -->
<header id="header">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="header_top">
				<div class="header_top_left">
					<ul class="top_nav">
						<li><a href="/home">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="/contact">Contact</a></li>
						<li><div class="box">
  							<div class="container-1" style="width: 300px; vertical-align: middle; white-space: nowrap; position: relative;">
      						<span class="icon"><i class="fa fa-search"></i></span>
      						<input type="search" id="search" placeholder="Search..." />
  							</div>
							</div>
						</li>
						<%
						if (userEntity != null) {
						%>

						<li style="float: right" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#"><%=userEntity.getUsername()%><span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li style="display: block"><a style="width: 100%" href="#"><%=userEntity.getUsername()%></a></li>
								<li style="display: block"><a style="width: 100%"  href="/author">Bài Viết của Tôi</a></li>
								<li style="display: block"><a style="width: 100%" href="/user/edit/${userEntity.userID}">Tài Khoản của Tôi</a></li>
								<li style="display: block"><a style="width: 100%" href="/logout">Đăng Xuất</a></li>
							</ul>
						</li>
						<%
						} else {
						%>
						<li style="float: right"><a href="/login">Login</a></li>
						<%
						}
						%>

					</ul>
				</div>
			</div>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="header_bottom">
				<div class="logo_area">
					<a href="/home" class="logo"><img
						src="${pageContext.request.contextPath}/resources/images/logo.jpg"
						alt=""></a>
				</div>
				<div class="add_banner">
					<a href="/home"><img
						src="${pageContext.request.contextPath}/resources/images/addbanner_728x90_V1.jpg"
						alt=""></a>
				</div>
			</div>
		</div>
	</div>
</header>
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
          		<a href="/category/${c.cid}">${c.cname}</a>
          		</c:forEach>
          </li>
          <li><a href="/contact">Liên hệ</a></li>
        </ul>
      </div>
    </nav>
  </section>