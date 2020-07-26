<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/common/taglib.jsp" %>
    
    <c:url  value="/api-put-help" var="helpApi"> </c:url>
    <c:url  value="/admin-help" var="helpList"> </c:url>
<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
								
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Tình trạng</label>
								<div class="col-sm-9">
									<p>${model.status }</p>
									<form:hidden path="status" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary">Người xử lí</label>
						  	<div class="col-sm-9">
						  	<p>${model.admin }</p>
						  		<form:hidden path="admin" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  		
						  	</div>
						</div>
						<div class="form-group">
								<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Name</label>
								<div class="col-sm-9">
									<p>${model.firstName }</p>
									<form:hidden path="firstName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
						 
								<label class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Mail</label>
						
								<div class="col-sm-9">
									<p>${model.email }</p>
									<form:hidden path="email" cssClass="col-xs-10 col-sm-5"/>
								<%-- 	<form:input  path="image" type="file"  name="images" id="images"/> --%>
									
								</div>
						</div>
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary">subject</label>
						  	<div class="col-sm-9">
						  		<p>${model.subject }</p>
						  		<form:hidden path="subject" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  		
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary">Messenge</label>
						  	<div class="col-sm-9">
						  	<p>${model.message }</p>
						  		<form:hidden path="message" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  		
						  	</div>
						</div>
						
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary">title</label>
						  	<div class="col-sm-9">
						  		<form:textarea path="title" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  		
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right m-0 font-weight-bold text-primary">trả lời </label>
						  	<div class="col-sm-9">
						  		<form:textarea path="reply" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>						  		
						  	</div>
						</div>
						
						<form:hidden path="id" id="id"/>
						<form:hidden path="user"/>
						<form:hidden path="status"/>
						
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
							 				
												<button class="btn btn-info" type="button" id="btnHelp" class="btnHelp">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Xác nhận
												</button>
											
											

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Hủy
											</button>
							</div>		
						</div>
						  <input type="hidden" value="${model.id}" id="id" name="id"/>
					</form:form>
<script>					
	 $('#btnHelp').click(function (e) {
    	e.preventDefault();
    	 var data = {};
    	
        
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
        	
            data[""+v.name+""] = v.value;
        });
       
        
      
        
            updateNew(data);
          
       
    });
    
    function updateNew(data) {
        $.ajax({
            url: '${helpApi}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result);
            	window.location.href = "${helpList}?page=1&limit=4&message=handling_success";
            /* 	?id="+result.id+"&message=update_success */
            },
            error: function (error) {
            	console.log(error);
            	window.location.href = "${helpList}?page=1&limit=4&message=error_system";
            	/* ?id="+result.id+"&message=error_system */
            }
        });
    }
    </script>				