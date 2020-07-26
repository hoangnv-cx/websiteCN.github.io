<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	   <%@include file="/common/taglib.jsp" %>
<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tên tài khoản (anonymousUser là trống)</label>
								<div class="col-sm-9">
									<p>${model.user }</p>
									<form:hidden path="user" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Họ tên</label>
								<div class="col-sm-9">
									<p>${model.firstName }</p>
									<form:hidden path="firstName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Email</label>
								<div class="col-sm-9">
									<p>${model.email }</p>
									<form:hidden path="email" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Subject</label>
								<div class="col-sm-9">
									<p>${model.subject }</p>
									<form:hidden path="subject" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Message</label>
								<div class="col-sm-9">
									<p>${model.message }</p>
									<form:hidden path="message" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Trạng thái</label>
								<div class="col-sm-9">
									<p>${model.status }</p>
									<form:hidden path="status" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tiêu đề trả lời</label>
								<div class="col-sm-9">
									<p>${model.title }</p>
									<form:hidden path="title" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Nội dung trả lời</label>
								<div class="col-sm-9">
									<p>${model.reply }</p>
									<form:hidden path="reply" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người gửi đến</label>
								<div class="col-sm-9">
									<p>${model.createdBy }</p>
									<form:hidden path="createdBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian gửi</label>
								<div class="col-sm-9">
									<p>${model.dateNew }</p>
									<form:hidden path="dateNew" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>  
						   
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Người trả lời </label>
								<div class="col-sm-9">
									<p>${model.modifiedBy }</p>
									<form:hidden path="modifiedBy" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Thời gian trả lời</label>
								<div class="col-sm-9">
									<p>${model.dateUpdate }</p>
									<form:hidden path="dateUpdate" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
					
		                
		                
</form:form>