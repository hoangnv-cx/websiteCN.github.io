<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>

<body class="bg-gradient-primary">
 <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <c:url value="/login-form" var="l"></c:url>
                  <form class="user" action="${l }" method="POST">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" name="username" id="username" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" name="password" id="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                    </div>
                    <a class="btn btn-primary btn-user btn-block">
                      <input type="submit" value="Login">
                    </a>
                    <hr>
                    
                  </form>
                  <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Google
                    </a>
                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="register.html">Create an Account!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>
<!-- aaaaaa -->
<%-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
  <!--   <link rel="stylesheet" type="text/css" href="styles.css"> -->
    <link rel="stylesheet" type="text/css" href='<c:url value="Template/logina/styles.css"/>' >
</head>
<body>
<div class="login-box">
    <img src="<c:url value="Template/logina/logo.png"/>" alt="avatar" class="avatar">
    <c:url value="/login-form" var="l"></c:url>
    <form class="user" action="${l }" method="POST">
        <div class="user-box">
            <input type="text" name="username" id="username" required>
            <label >UserName</label>
        </div>
        <div class="user-box">
            <input type="Password" name="password" id="password" required>
            <label>Password</label>
        </div>
        <button type="submit">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
          <!-- <input value=" Login here" type="submit" id="btn-click-box"> -->
        Login here
        </button>
    </form>
</div> 
 
</body>
</html> --%>