<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
   <c:url var="APIurl" value="/api-user"></c:url>
   <c:url var="UserUrlList" value="/admin-list-user"></c:url>
              
                        
                       <c:url value="/admin-add-user" var="l"></c:url>
						<form:form class="form-horizontal" role="form" id="formSubmit"  modelAttribute="user">
                            
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">ten dang nhap</label>
                                <div class="col-sm-9">
                                    
                                    <form:input path="userName"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">pass</label>
                                <div class="col-sm-9">
                                   <form:input path="password"/> 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">fullName</label>
                                <div class="col-sm-9">
                                   <form:input path="fullName"/> 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">sdt</label>
                                <div class="col-sm-9">
                                   <form:input path="sdt"/> 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">email</label>
                                <div class="col-sm-9">
                                   <form:input path="email"/> 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">image</label>
                                <div class="col-sm-9">
                                   <form:input path="image"/> 
                                </div>
                            </div>
                            <br/>
                            	<form:select path="sex" id="sex">
								<form:option value="" label="-- Chọn thể loại --"/>
								<form:option value="nam">Nam</form:option>
								<form:option value="nu">Nữ</form:option>
								<form:option value="khac">Khác</form:option>
								</form:select>
                            <br/>
                            <br/>
                            	<form:select path="roleCode" id="roleCode">
								<form:option value="" label="-- Chọn thể loại --"/>
								<form:options items="${rolec}"/>
								</form:select>
							<br/>
                            
                           <input type="button" id="btnAddUser" class="btnAddUser" value="click"/>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>  
                        </form:form>
                        
 <script>

    $('#btnAddUser').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
       
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
            	window.location.href = "${UserUrlList}?page=1&limit=4&message=insert_success";
            /* 	?id="+result.id+"&message=insert_success */
            },
            error: function (error) {
            	window.location.href = "${UserUrlList}?page=1&limit=4&message=error_system";
            	/* ?page=1&limit=2&message=error_system */
            }
        });
    }
   
    </script>              