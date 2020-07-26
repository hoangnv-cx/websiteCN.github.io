<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
   <c:url var="APIurl" value="/api-user-web"></c:url>
        <c:url var="UserUrlList" value="/web"></c:url>

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
               <form:form class="form-horizontal" role="form" id="formSubmit"  modelAttribute="user">  
              
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                 
                    <form:input path="userName" class="form-control form-control-user" id="exampleFirstName" placeholder="User Name"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input path="fullName" class="form-control form-control-user" id="exampleLastName" placeholder="Full Name"/>
                  </div>
                </div>
                <div class="form-group">
                  <form:input path="email" type="email" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email Address"/>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <form:input path="password" type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input path="repeatPassword" type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Repeat Password"/>
                  </div>
                </div>
                <div class="form-group">
                  <form:input path="sdt" class="form-control form-control-user" id="exampleInputEmail" placeholder="Số điện thoại"/>
                </div>
               
                
                  <input type="button" id="btnadduser" class="btnadduser" value="Register Account" class="btn btn-primary btn-user btn-block">
               
               
                <hr>
                <form:hidden path="id"/>
                <a href="index.html" class="btn btn-google btn-user btn-block">
                  <i class="fab fa-google fa-fw"></i> Register with Google
                </a>
                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                  <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                </a>
              
              </form:form>
              <hr>
              <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Password?</a>
              </div>
              <div class="text-center">
                <a class="small" href="login.html">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
     

  </div>
  <script>

    $('#btnadduser').click(function (e) {
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
            	window.location.href = "${UserUrlList}?page=1&limit=6";
            /* 	?id="+result.id+"&message=insert_success */
            },
            error: function (error) {
            	window.location.href = "${UserUrlList}?page=1&limit=6";
            	/* ?page=1&limit=2&message=error_system */
            }
        });
    }
    
    </script>
	