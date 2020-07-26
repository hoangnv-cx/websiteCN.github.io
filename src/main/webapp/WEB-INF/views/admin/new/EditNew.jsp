<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="/common/taglib.jsp" %>
   <c:url var="APIurl" value="/post-new"></c:url>
   	<c:url var="EditUrl" value="/admin-update-new"></c:url>
    <c:url var="NewUrlList" value="/admin-list-new"></c:url>
    <c:url var="newURL" value="/post-new"></c:url>
 
    <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>

 <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
								<div class="form-group">
							  <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại:</label>
							  <div class="col-sm-9">
							  	 <form:select path="categoryCode" id="categoryCode">
							  	 	<form:option value="" label="-- Chọn thể loại --"/>
							  	 	<form:options items="${categorys}"/>
							  	 </form:select>
							  </div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên bài viết</label>
								<div class="col-sm-9">
									<form:input path="title" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
						 
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ảnh đại diện</label>
						
								<div class="col-sm-9">
									
									<form:input path="thumbnail" cssClass="col-xs-10 col-sm-5"/>
									<form:input  path="image" type="file"  name="images" id="images"/>
									
								</div>
						</div>
						<div class="form-group">
						  	<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả ngắn:</label>
						  	<div class="col-sm-9">
						  		<form:textarea path="shortDescription" rows="5" cols="10" cssClass="form-control" id="shortDescription"/>
						  		
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="content" class="col-sm-3 control-label no-padding-right">Nội dung:</label>
						  	<div class="col-sm-9">
						  	  <%--  <textarea rows="" cols="" id="contents" name="contents" style="width: 820px;height: 175px">${model.content }</textarea> --%>
						  	  		<form:textarea path="content" rows="5" cols="10" cssClass="form-control"  id="contents" name="contents" />
						  	</div>
						</div>
						<form:hidden path="id" id="id"/>
						
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
							 				<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew" class="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật bài viết
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew" class="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm bài viết
												</button>
											</c:if>

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
//var file='';
var ida = $('#id').val();
var editor = '';
//var eee ='';
$(document).ready(function(){
	editor = CKEDITOR.replace('contents');
	
});


     $('#btnAddOrUpdateNew').click(function (e) {
    	e.preventDefault();
    	 var data = {};
    	/* 
    	 file=$('#images')[0].files[0];
       
        
        if(file!=undefined){
        	 var reader=new FileReader();
        	 reader.onload=function(e){
             	eee=e.target.result;
             };
            
        } 
     */
        
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
        	//data["base64"] = eee;
        	//data["imageName"] = file.name;
            data[""+v.name+""] = v.value;
        });
        data["content"] = editor.getData();
        
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
           
        } else {
            updateNew(data);
          
        }
    });
    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${NewUrlList}?page=1&limit=4&message=insert_success";
            /* 	?id="+result.id+"&message=insert_success */
            },
            error: function (error) {
            	window.location.href = "${NewUrlList}?page=1&limit=4&message=error_system";
            	/* ?page=1&limit=2&message=error_system */
            }
        });
    }
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result);
            	window.location.href = "${NewUrlList}?page=1&limit=4&message=update_success";
            /* 	?id="+result.id+"&message=update_success */
            },
            error: function (error) {
            	console.log(error);
            	window.location.href = "${EditUrl}?id="+ida+"&message=error_system";
            	/* ?id="+result.id+"&message=error_system */
            }
        });
    }
    
    
    
  
    </script>



