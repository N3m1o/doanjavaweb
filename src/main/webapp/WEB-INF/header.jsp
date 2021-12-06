<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Header -->
<header id="header">
    <div class="row">
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="header_top">
          <div class="header_top_left">
            <ul class="top_nav">
              <li><a href="index.html">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="pages/contact.html">Contact</a></li>
			  <li><a href="#">Login</a></li>
			  <li><a href="#">Logout</a></li>
			  <li><a href="#">Manager</a></li>
			  <li><a href="#">Journalist</a></li>
            </ul>
          </div>
          <div class="header_top_right">
            <script>
				<p id="ngaygio"></p>
				var today = new Date();
				var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
				var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
				var dateTime = date+' '+time;
				document.getElementById("ngaygio").innerHTML = dateTime;
			</script>
          </div>
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="header_bottom">
          <div class="logo_area"><a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" alt=""></a></div>
          <div class="add_banner"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/addbanner_728x90_V1.jpg" alt=""></a></div>
        </div>
      </div>
    </div>
  </header>