<%@page import="org.springframework.ui.Model"%>
<%@page import="com.laptrinhjavaweb.controller.CategoryController"%>
<%@page import="com.laptrinhjavaweb.entity.CateEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.laptrinhjavaweb.serviceImpl.CategoryServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en"> 
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manager Product</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/manager.css"
	rel="stylesheet" />
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
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
						<i class="material-icons">&#xE147;</i> <span>Thêm bài viết</span></a> 
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">
						<i class="material-icons">&#xE15C;</i> <span>Xóa bài</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
						<th>ID</th>
						<th>Tiêu đề</th>
						<th>Hình đại diện</th>
						<th>Mô tả ngắn</th>
						<th>Nội dung</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${news}">
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
							<td>${c.newsId}</td>
							<td>${c.title}</td>
							<td><img src="${c.display_img}"></td>
							<td>${c.shortDescription}</td>
							<td><div style="overflow: hidden;
  											display: -webkit-box;
  											-webkit-line-clamp: 7;
  											-webkit-box-orient: vertical;">${c.content}
  								</div>
  							</td>
							<td>
								<a href="/edit/${c.newsId}" class="edit" data-toggle="modal"> 
								<i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a> 
								<a href="/delete/${c.newsId}" class="delete" data-toggle="modal"> 
								<i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">
					Hiển thị <b>5</b> trong số <b>25</b> trường
				</div>
				<ul class="pagination">
					<li class="page-item disabled"><a href="#">Trước</a></li>
					<li class="page-item active"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item"><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">5</a></li>
					<li class="page-item"><a href="#" class="page-link">Sau</a></li>
				</ul>
			</div>
		</div>
		<a href="/home"><button type="button" class="btn btn-primary">Quay lại trang chủ</button></a>
	</div>
	
	<!-- Add Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/author" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Thêm bài viết</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tiêu đề</label> <input name="title" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ảnh đại diện</label> <input name="display_image" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Mô tả ngắn</label>
							<textarea name="short_description" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Thể loại</label>
							<select name="category" class="form-select" aria-label="Default select example" style = "width: 120px; margin-left: 30px;">
									<c:forEach var="c" items="${cateList}">
									<option value = "${c.cid}">${c.cname}</option>
									</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Nội dung</label>
							<textarea name="content" class="form-control" required
								id="content"></textarea>
							<script type="text/javascript">
								CKEDITOR.replace('content', {
									width : "520px",
									height : "500px"
								});
							</script>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy"> 
						<input type="submit" class="btn btn-success" value="Thêm">
					</div>
				</form>
			</div>
		</div>
	</div>
	
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