<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@include file="/common/taglib.jsp" %>
        <header class="site-navbar" role="banner">
    

          
         

        
            <nav class="site-navigation" role="navigation">
              <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
               
               <c:forEach items="${listCat }" var="l">
               		<c:url value="/web-category?page=1&limit=6" var="cat">
               		<c:param name="CategoryCode" value="${l.code}"></c:param>
               		</c:url>
                <li><a href="${cat}">${l.name }</a></li>
               </c:forEach>
                
                
              </ul>
            </nav>
                   
         </header>     