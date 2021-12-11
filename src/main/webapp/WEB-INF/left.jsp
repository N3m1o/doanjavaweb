<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="left_content">

          <div class="single_post_content">
            <h2><span>Thể Thao</span></h2> 
            
            <div class="single_post_content_left">
              <ul class="business_catgnav wow fadeInDown">
              <c:forEach var="c" items="${cate}">
                <li>
                  <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    <figcaption> <a href="/details/${c.newsId}">${c.title}</a></figcaption>
                    <p>${o.shortDescription}</p>
                  </figure>
                </li>
                </c:forEach>
              </ul>
            </div>
            
            <div class="single_post_content_right">
              <ul class="spost_nav">
              <c:forEach var="c" items="${cate}">
                <li>
                  <div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    <div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  </div>
                </li>
              </c:forEach>
              </ul>
            </div>
          </div>
          
          <div class="fashion_technology_area">
            <div class="fashion">
            
              <div class="single_post_content">
                <h2><span>Văn Hóa</span></h2>
                <ul class="business_catgnav wow fadeInDown">
                <c:forEach var="c" items="${news}">
                  <li>
                    <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    	<figcaption> <a href="/details/${c.newsId}">${c.title}</a> </figcaption>
                    	<p>${o.shortDescription}</p>
                  	</figure>
                  </li>
                  </c:forEach>
                </ul>
                <ul class="spost_nav">
                <c:forEach var="c" items="${news}">
                  	<li>
                  		<div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    		<div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  		</div>
                	</li>
                </c:forEach>
                </ul>
              </div>
              
            </div>
            <div class="technology">
              <div class="single_post_content">
                <h2><span>Du Lịch</span></h2>
                <ul class="business_catgnav">
                <c:forEach var="c" items="${news}">
                  <li>
                    <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    	<figcaption> <a href="/details/${c.newsId}">${c.title}</a> </figcaption>
                    	<p>${o.shortDescription}</p>
                  	</figure>
                  </li>
                  </c:forEach>
                </ul>
                <ul class="spost_nav">
                <c:forEach var="c" items="${news}">
                  <li>
                  	<div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    	<div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  	</div>
                </li>
                </c:forEach>
                </ul>
              </div>
            </div>
          </div>
          
          <div class="single_post_content">
            <h2><span>Thời Sự</span></h2>
            <div class="single_post_content_left">
              <ul class="business_catgnav">
              <c:forEach var="c" items="${news}">
                <li>
                  <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    	<figcaption> <a href="/details/${c.newsId}">${c.title}</a> </figcaption>
                    	<p>${o.shortDescription}</p>
                  	</figure>
                </li>
                </c:forEach>
              </ul>
            </div>
            <div class="single_post_content_right">
              <ul class="spost_nav">
              <c:forEach var="c" items="${news}">
                <li>
                  <div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    	<div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  	</div>
                </li>
                </c:forEach>
              </ul>
            </div> 
          </div>
          
          <div class="single_post_content">
            <h2><span>Chính Trị</span></h2>
            <div class="single_post_content_left">
              <ul class="business_catgnav">
              <c:forEach var="c" items="${news}">
                <li>
                  <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    	<figcaption> <a href="/details/${c.newsId}">${c.title}</a> </figcaption>
                    	<p>${o.shortDescription}</p>
                  	</figure>
                </li>
                </c:forEach>
              </ul>
            </div>
            <div class="single_post_content_right">
              <ul class="spost_nav">
              <c:forEach var="c" items="${news}">
                <li>
                  <div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    	<div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  	</div>
                </li>
                </c:forEach>
              </ul>
            </div>
          </div>
          
          <div class="single_post_content">
            <h2><span>Giải Trí</span></h2>
            <div class="single_post_content_left">
              <ul class="business_catgnav">
              <c:forEach var="c" items="${news}">
                <li>
                  <figure class="bsbig_fig"> <a href="/details/${c.newsId}" class="featured_img"> <img alt="" src="${c.display_img}"> <span class="overlay"></span> </a>
                    	<figcaption> <a href="/details/${c.newsId}">${c.title}</a> </figcaption>
                    	<p>${o.shortDescription}</p>
                  	</figure>
                </li>
                </c:forEach>
              </ul>
            </div>
            <div class="single_post_content_right">
              <ul class="spost_nav">
              <c:forEach var="c" items="${news}">
                <li>
                  <div class="media wow fadeInDown"> <a href="/details/${c.newsId}" class="media-left"> <img alt="" src="${c.display_img}"> </a>
                    	<div class="media-body"> <a href="/details/${c.newsId}" class="catg_title">${c.title}</a> </div>
                  	</div>
                </li>
                </c:forEach>
              </ul>
            </div> 
          </div>
    
</div>