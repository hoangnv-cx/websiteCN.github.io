<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp" %>
 <c:url value="/post-web-user" var="updateWebUser"> </c:url>
  <c:url value="/web-user" var="tk"> </c:url>
  <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="user" enctype="multipart/form-data">    
      <div class="site-section">
      <div class="container">
        <div class="row mb-5 justify-content-center">
          <div class="col-md-5 text-center">
            <h2>Meet The Team</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus commodi blanditiis, soluta magnam atque laborum ex qui recusandae</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 col-lg-4 mb-5 text-center">
          
       
          </div>

          <div class="col-md-6 col-lg-4 mb-5 text-center">
            <img src="images/person_2.jpg" alt="Image" class="img-fluid w-50 rounded-circle mb-4">
            <p class="mb-3 h5">Tên đăng nhập</p>
            <h2 class="mb-3 h5">${user.userName }</h2>
            <form:hidden path="userName"/>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum neque nobis eos quam necessitatibus rerum aliquid est tempore, cupiditate iure at voluptatum dolore, voluptates. Debitis accusamus, beatae ipsam excepturi mollitia.</p>

            <p class="mt-5">
              <a href="#" class="p-3"><span class="icon-facebook"></span></a>
              <a href="#" class="p-3"><span class="icon-instagram"></span></a>
              <a href="#" class="p-3"><span class="icon-twitter"></span></a>
            </p>
            <c:url value="/thoat" var="singout"></c:url>
			<p><a href="${singout }" class="btn btn-primary btn-sm rounded px-4 py-2">SignOut</a></p>
            
          </div>

          <div class="col-md-6 col-lg-4 mb-5 text-center">
          
            
          </div>
        </div>
        
        
        <div class="p-12 mb-12 bg-white"></div>
        <p class="mb-8 font-weight-bold">Tên đăng nhập</p>
        <p class="mb-8">${user.userName }</p>

		<p class="mb-8 font-weight-bold">Password</p>
        <p class="mb-8">${user.password } &ensp; <button type="button" >Thay đổi</button></p>

        <p class="mb-8 font-weight-bold">Tên</p>
        <p class="mb-8"><form:input path="fullName"/></p>
		
        <p class="mb- font-weight-bold">Email Address</p>
        <p class="mb-8"><form:input path="email"/></p>
        <p class="mb- font-weight-bold">Số điện thoại</p>
        <p class="mb-8"><form:input path="sdt"/></p>
        <p class="mb- font-weight-bold">Ngày sinh</p>
        <p class="mb-8"><form:input path="dateofbirth"/></p>
        <p class="mb- font-weight-bold">Giới tính</p>
        <p class="mb-8"><form:input path="sex"/></p>
        <form:hidden path="roleid"/>
        <form:hidden path="roleCode"/>
        <form:hidden path="status"/>
        
        <button type="button" id="btnUpdateUser" class="btnUpdateUser">Thay đổi</button>
      </div>
        
      </div>
 
   </form:form>   
   
    
  <script>




     $('#btnUpdateUser').click(function (e) {
    	e.preventDefault();
    	 var data = {};      
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
        	
            data[""+v.name+""] = v.value;
        });
       
        
       
       
            addNew(data);
           
       
    });
    function addNew(data) {
        $.ajax({
            url: '${updateWebUser}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${tk}";
            /* 	?id="+result.id+"&message=insert_success */
            },
            error: function (error) {
            	window.location.href = "${tk}";
            	/* ?page=1&limit=2&message=error_system */
            }
        });
    }

    </script> 