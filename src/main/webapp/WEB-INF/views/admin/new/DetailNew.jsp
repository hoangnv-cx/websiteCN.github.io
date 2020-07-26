<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	   <%@include file="/common/taglib.jsp" %>
<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thể loại</label>
								<div class="col-sm-9">
									<p>${model.categoryName }</p>
									<form:hidden path="categoryName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tiêu đề</label>
								<div class="col-sm-9">
									<p>${model.title }</p>
									<form:hidden path="title" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Hình ảnh</label>
								<div class="col-sm-9">
									<p>${model.thumbnail }</p>
									<form:hidden path="thumbnail" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Mô tả ngắn</label>
								<div class="col-sm-9">
									<p>${model.shortDescription }</p>
									<form:hidden path="shortDescription" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Chi tiết bài viết</label>
								<div class="col-sm-9">
									<p>${model.content }</p>
									<form:hidden path="content" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người đăng</label>
								<div class="col-sm-9">
									<p>${model.createdBy }</p>
									<form:hidden path="createdBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian đăng</label>
								<div class="col-sm-9">
									<p>${model.dateNew }</p>
									<form:hidden path="dateNew" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>  
						   
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người sửa</label>
								<div class="col-sm-9">
									<p>${model.modifiedBy }</p>
									<form:hidden path="modifiedBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian sửa</label>
								<div class="col-sm-9">
									<p>${model.dateUpdate }</p>
									<form:hidden path="dateUpdate" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
					
		                
		                
</form:form>