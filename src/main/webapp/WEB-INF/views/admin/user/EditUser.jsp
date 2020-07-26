<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
    
            
                        
                       <c:url value="/admin-put-edit-user" var="l"></c:url>
						<form:form action="${l }" method="POST" modelAttribute="user">
                            
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">mật khẩu mới</label>
                                <div class="col-sm-9">
                                    
                                    <input type="text" name="passwordNew" id="passwordNew"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Xác Nhận lại</label>
                                <div class="col-sm-9">
                                  <%--  <form:input path="retypePassword"/> --%> 
                                   <input type="text" name="retypePassword" id="retypePassword"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <form:select path="roleCode" id="roleCode">
								<form:option value="" label="-- Chọn thể loại --"/>
								<form:options items="${rolec}"/>
							</form:select>
							<br/>
							<form:hidden path="id"/>
							<form:hidden path="password"/>
                            <form:hidden path="userName"/>  
                            <form:hidden path="fullName"/>  
                            <form:hidden path="sdt"/> 
                            <form:hidden path="email"/> 
                            <form:hidden path="image"/> 
                            <form:hidden path="roleid"/> 
                          <%--   <form:hidden path="email"/>  --%>
                            <form:hidden path="sex"/> 
                           <%--  <form:hidden path="dateofbirth"/> --%> 
                           <input type="submit" value="update"/>
                            
                        </form:form>
   <script>

    $('#btnAddOrUpdateNew').click(function (e) {
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
    
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result);
            	window.location.href = "${NewUrlList}?page=1&limit=2&message=update_success";
            /* 	?id="+result.id+"&message=update_success */
            },
            error: function (error) {
            	console.log(error);
            	window.location.href = "${NewUrlList}?page=1&limit=2&message=error_system";
            	/* ?id="+result.id+"&message=error_system */
            }
        });
    }
    </script>           