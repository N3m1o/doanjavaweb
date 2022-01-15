<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chỉnh sửa</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/manager.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Tài Khoản <b>Bạn Đọc</b>
						</h2>
					</div>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>
		<div id="editEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<a href="/home"><i class="fa fa-close" style="font-size:48px;color:red;float:right;"></i></a>
					<form action="/user/edit/${user.userID}" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thông tin cá nhân</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Biệt danh</label> <input value="${user.username}" name="username"
									type="text" class="form-control" readonly required>
							</div>
							<div class="form-group">
								<label>Tên đầy đủ</label> <input value="${user.fullname}" name="fullname"
									type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Ảnh đại diện</label> <input value="${user.user_img}"
									name="user_img" type="text" class="form-control" required>
								<center><img src="${user.user_img}"></center>
							</div>

							<div class="form-group">
                                <label>Giới tính</label> 
                                <div>
                                <c:choose>
                                    <c:when test="${user.gender==1}">
                                        <label style="width:33.33%;"><input type="radio" name="gender" value="1" checked> Nam </label>
                                        <label style="width:33.33%;"><input type="radio" name="gender" value="0" > Nữ </label>
                                    </c:when>
                                    <c:otherwise>
                                        <label style="width:33.33%;"><input type="radio" name="gender" value="1" > Nam </label>
                                        <label style="width:33.33%;"><input type="radio" name="gender" value="0" checked > Nữ </label>
                                    </c:otherwise> 
                                </c:choose>
                                </div>
                            </div>
						
							<div class="form-group">
								<label>Tiểu sử</label> <input value="${user.short_description}"
									name="short_description" type="text" class="form-control" required>
							</div>

						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="Sửa">
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>


	<script
		src="${pageContext.request.contextPath}/resources/js/manager.js"
		type="text/javascript"></script>
</body>
</html>
