<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@include file="/common/taglib.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
	 <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700|Playfair+Display:400,700,900" rel="stylesheet">
    <link rel="stylesheet" href='<c:url value="Template/web/fonts/icomoon/style.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/css/bootstrap.min.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/css/magnific-popup.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/jquery-ui.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/owl.carousel.min.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/owl.theme.default.min.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/bootstrap-datepicker.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/fonts/flaticon/font/flaticon.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/css/aos.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="Template/web/css/style.css"></c:url>'>
 	<script src='<c:url value="Template/web/js/jquery-3.3.1.min.js"></c:url>'></script>
  	<script src='<c:url value="Template/web/js/bootstrap.min.js"></c:url>'></script>
     <script src='<c:url value="Template/web/paging/jquery.twbsPagination.js"/>' type="text/javascript"></script>
   
</head>
<body>
<div class="site-wrap">

    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="menu" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" /> 



  </div>
  <tiles:insertAttribute name="script" /> 
  
 
  <script src='<c:url value="Template/web/js/jquery-migrate-3.0.1.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/jquery-ui.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/popper.min.js"></c:url>'></script>
 
  <script src='<c:url value="Template/web/js/owl.carousel.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/jquery.stellar.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/jquery.countdown.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/jquery.magnific-popup.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/bootstrap-datepicker.min.js"></c:url>'></script>
  <script src='<c:url value="Template/web/js/aos.js"></c:url>'></script>
   <script src='<c:url value="Template/web/js/main.js"></c:url>'></script>
  
</body>
</html>