<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	   <%@include file="/common/taglib.jsp" %>
<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="userModel" enctype="multipart/form-data">
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tên đăng nhập</label>
								<div class="col-sm-9">
									<p>${userModel.userName }</p>
									<form:hidden path="userName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Mật khẩu</label>
								<div class="col-sm-9">
									<p>${userModel.password }</p>
									<form:hidden path="password" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Quyền truy cập</label>
								<div class="col-sm-9">
									<p>${userModel.roleName }</p>
									<form:hidden path="roleName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tên đầy đủ</label>
								<div class="col-sm-9">
									<p>${userModel.fullName }</p>
									<form:hidden path="fullName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Số điện thoại</label>
								<div class="col-sm-9">
									<p>${userModel.sdt }</p>
									<form:hidden path="sdt" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Gmail</label>
								<div class="col-sm-9">
									<p>${userModel.email }</p>
									<form:hidden path="email" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Giới tính</label>
								<div class="col-sm-9">
									<p>${userModel.sex }</p>
									<form:hidden path="sex" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Ngày Sinh</label>
								<div class="col-sm-9">
									<p>${userModel.dateofbirth }</p>
									<form:hidden path="dateofbirth" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người đăng kí</label>
								<div class="col-sm-9">
									<p>${userModel.createdBy }</p>
									<form:hidden path="createdBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian đăng kí</label>
								<div class="col-sm-9">
									<p>${userModel.dateNew }</p>
									<form:hidden path="dateNew" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>  
						   
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người đổi mật khẩu</label>
								<div class="col-sm-9">
									<p>${userModel.modifiedBy }</p>
									<form:hidden path="modifiedBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian đổi mật khẩu</label>
								<div class="col-sm-9">
									<p>${userModel.dateUpdate }</p>
									<form:hidden path="dateUpdate" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
</form:form>