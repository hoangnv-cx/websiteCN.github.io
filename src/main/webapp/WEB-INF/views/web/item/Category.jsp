<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
    <div class="py-5 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <span >Category</span>
            <h3>${modelCategory }</h3>
          </div>
        </div>
      </div>
    </div>
    <%@include file="/common/taglib.jsp" %>
      

 <form action="<c:url value='/web-category'/>" id="formSubmit" method="get">
    <div class="site-section bg-white">
      <div class="container">
        <div class="row">
        <c:forEach items="${listNew }" var="item">
        		<c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      			</c:url>
          <div class="col-lg-4 mb-4">
            <div class="entry2">
              <a href="${url }"><img src="https://ngocngo99.000webhostapp.com/image/imageTitle/${item.thumbnail }"  width="364.44px" height="205.16"></a>
              <div class="excerpt">
              <span class="post-category text-white bg-secondary mb-3">${item.categoryName }</span>
				
              <h2><a href="${url }">${item.title }</a></h2>
              <div class="post-meta align-items-center text-left clearfix">
                <span class="d-inline-block mt-1">By <a href="#">
                <c:if test="${empty item.modifiedBy }">
                	${item.createdBy }
                </c:if> 
                <c:if test="${not empty item.modifiedBy }">
                	${item.modifiedBy }
                </c:if> 
                </a></span>
                <span>&nbsp;-&nbsp;
                <c:if test="${not empty item.modifiedDate }">
                	${item.timeLine }
                </c:if>       
                <c:if test="${empty item.modifiedDate }">
                	${item.timeLine }
                </c:if>
                </span>
                
              </div>
              
                <p>${l.shortDescription }</p>
                <p><a href="${url }">Đọc tin</a></p>
              </div>
            </div>
          </div>
        
        </c:forEach>
           
          </div>
        </div>
        <div class="row text-center pt-5 border-top">
          <div class="col-md-12">
            <ul class="pagination" id="pagination"></ul>
             <input type="hidden" value="${CategoryCode}" id="CategoryCode" name="CategoryCode"/>
			<input type="hidden" value="" id="page" name="page"/>
			 <input type="hidden" value="" id="limit" name="limit"/>
			
          </div>
      </div>
    </div>
</form>

