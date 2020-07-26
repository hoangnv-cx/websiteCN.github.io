<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="/common/taglib.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<link href='<c:url value="Template/admin/vendor/fontawesome-free/css/all.min.css"></c:url>' rel="stylesheet" type="text/css">
 <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">



  <link href='<c:url value="Template/admin/css/sb-admin-2.min.css"></c:url>' rel="stylesheet" type="text/css">
  <link href='<c:url value="Template/admin/vendor/datatables/dataTables.bootstrap4.min.css"></c:url>' rel="stylesheet" type="text/css">
   
   
	 <script src='<c:url value="Template/admin/vendor/jquery/jquery.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></c:url>'></script>
    <script src='<c:url value="Template/paging/jquery.twbsPagination.js"/>' type="text/javascript"></script>
    
    

    
  <%--    <script src="<c:url value='/ckeditor/ckeditor.js' />"></script> --%>
   
</head>
<body id="page-top">

 <div id="wrapper">

<tiles:insertAttribute name="menu" />
  <div id="content-wrapper" class="d-flex flex-column">
<tiles:insertAttribute name="header" />
      <!-- Main Content -->
      <div id="content">

<tiles:insertAttribute name="body" />

	</div>
							
						
	
<tiles:insertAttribute name="footer" /> 
</div>
	</div>	
 <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>



  <tiles:insertAttribute name="script" /> 
  



 <script src='<c:url value="Template/admin/vendor/jquery-easing/jquery.easing.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/js/sb-admin-2.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/vendor/chart.js/Chart.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/js/demo/chart-area-demo.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/js/demo/chart-area-demo.js"></c:url>'></script>
 
 <script src='<c:url value="Template/admin/vendor/datatables/jquery.dataTables.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/vendor/datatables/dataTables.bootstrap4.min.js"></c:url>'></script>
 <script src='<c:url value="Template/admin/js/demo/datatables-demo.js"></c:url>'></script>
 
  
</body>
</html>