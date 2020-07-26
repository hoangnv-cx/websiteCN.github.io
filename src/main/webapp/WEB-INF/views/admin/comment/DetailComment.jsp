<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	   <%@include file="/common/taglib.jsp" %>
<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tên tài khoản</label>
								<div class="col-sm-9">
									<p>${model.userName }</p>
									<form:hidden path="userName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>						
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Bình luận</label>
								<div class="col-sm-9">
									<p>${model.userName }</p>
									<p>${model.comments }</p>
									<p>${model.createdBy }</p>
									<p>${model.dateNew }</p>
									<form:hidden path="comments" cssClass="col-xs-10 col-sm-5"/>
								</div>
								<c:forEach items="${modelUser }" var="item">
									<div class="form-group">
									<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Trả lời bình luận</label>
									<div class="col-sm-9">
										<p>${model.userName }</p>
										<p>${item.comments }</p>
										<p>${item.createdBy }</p>
										<p>${item.dateNew }</p>										
									</div>
									</div>
									</c:forEach>
						</div>
</form:form>