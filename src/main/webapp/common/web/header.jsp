<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@include file="/common/taglib.jsp" %>
              <%@ page import="com.javaweb.springmvc.Util.SecurityUtils" %>
       <header class="site-navbar" role="banner">
      <div class="container-fluid">
<div class="row align-items-center">

<c:url value="/web-search?page=1&limit=6" var="urlSearch">

</c:url>         
          <div class="col-12 search-form-wrap js-search-form">
            <form method="get" action="${urlSearch }">
              <input type="text" id="search" name="search" class="form-control" placeholder="Search...">
              <input type="hidden" name="page" value="1">
              <input type="hidden" name="limit" value="6">
              <button class="search-btn" type="submit"><span class="icon-search"></span></button>
            </form>
          </div>

          <div class="col-4 site-logo">
          <c:url value="/web?page=1&limit=6" var="url"></c:url>
            <a href="${url }" class="text-black h2 mb-0">Tin Nhanh</a>
          </div>

          <div class="col-8 text-right">
            <nav class="site-navigation" role="navigation">
              <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
                <li><a href="category.html">Home</a></li>
                <c:url value="/web-about" var="about"></c:url>
                <li><a href="${about }">About</a></li>
                <c:url value="/web-help" var="help"></c:url>
                <li><a href="${help }">Help</a></li>
                
                
                
             	<security:authorize access = "isAnonymous()">
					<c:url value="/login" var="login"></c:url>
                	<li><a href="${login }">Login</a></li>
                	<c:url value="/signin" var="signin"></c:url>
               		<li><a href="${signin }">Signin</a></li>
				</security:authorize>
				<security:authorize access = "isAuthenticated()">
				 	<li><a href="">Xin chào : <%=SecurityUtils.getName()%></a></li>					
					
					<c:url value="/web-user" var="User"></c:url>
                	<li><a href="${User }"> Tài khoản</a></li>		
					
				</security:authorize>
				
				
				
                <li class="d-none d-lg-inline-block"><a href="#" class="js-search-toggle"><span class="icon-search"></span></a></li>
              </ul>
            </nav>
            <a href="#" class="site-menu-toggle js-menu-toggle text-black d-inline-block d-lg-none"><span class="icon-menu h3"></span></a></div>
          </div>
           </div>
    </header>