<%@page import="org.springframework.ui.Model"%>
<%@page import="com.laptrinhjavaweb.controller.CategoryController"%>
<%@page import="com.laptrinhjavaweb.entity.CateEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.laptrinhjavaweb.serviceImpl.CategoryServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- 
	TRANG DUYỆT BÀI CỦA ADMIN
 -->

<!DOCTYPE html>
<html lang="en"> 
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manager Product</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/manager.css" rel="stylesheet" />
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							QUẢN LÝ <b>BÀI VIẾT</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="/home" class="btn btn-primary">
						<i class="material-icons">&#xE88A;</i><span>Home</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Status</th>
						<th>Tiêu đề</th>
						<th>Hình đại diện</th>
						<th>Mô tả ngắn</th>
						
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${news.pageList}">
						<tr>
							<td>
									<c:choose>
                                    		<c:when test="${c.status==true}">
                                    			<label>Đã duyệt</label>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<label>Chưa duyệt</label>
                                    		</c:otherwise>
                            		</c:choose>
                            </td>
							<td>${c.title}</td>
							<td><img src="${c.display_img}"></td>
							<td>${c.shortDescription}</td>

							<td>
								<a href="/preview/${c.newsId}" class="edit" data-toggle="modal"> 
								<i class="material-icons" data-toggle="tooltip" title="Xem trước">&#xe8f4;</i></a> 
								<a href="/delete/${c.newsId}" class="delete" data-toggle="modal"> 
								<i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">
					Hiển thị <a>${pageSize}</a> trong số <a>${totalPageCount}</a> trường
				</div>
				<ul class="pagination">
					<li class="${currentIndex == 1 ? 'page-item disabled' : 'page-item'}"><a href="${baseUrl}1" title="Trang đầu tiên">Đầu</a></li>
					<li class="${currentIndex == 1 ? 'page-item disabled' : 'page-item'}"><a href="${baseUrl}${currentIndex - 1}">Trước</a></li>
					<li class="${currentIndex == totalPageCount ? 'page-item disabled' : 'page-item'}"><a href="${baseUrl}${currentIndex + 1}">Sau</a></li>
					<li class="${currentIndex == totalPageCount ? 'page-item disabled' : 'page-item'}"><a href="${baseUrl}${totalPageCount}" title="Trang cuối cùng" class="page-link">Cuối</a></li>
				</ul>
			</div>
		</div>
		<a href="/home"><button type="button" class="btn btn-primary">Quay lại trang chủ</button></a>
	</div>
	
	<!-- Add Modal HTML -->
	
	
	<!-- Delete Modal HTML--> 
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog" style="max-width: 500px;">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">Xóa bài viết</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body" style="height: 200px;">
						<p>Bạn có chắc muốn xóa bài viết này không?</p>
						<p class="text-warning">
							<small>Hành động này sẽ không thể hủy bỏ.</small>
						</p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy"> 
						<input type="submit" class="btn btn-danger" value="Xóa">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/resources/js/manager.js" type="text/javascript"></script>
</body>
</html>