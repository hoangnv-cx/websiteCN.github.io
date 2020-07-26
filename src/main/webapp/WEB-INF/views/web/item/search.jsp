<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<c:url value="/web" var="URLHOME"></c:url>
<c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      			</c:url>
   
 <form action="<c:url value='/web-search'/>" id="formSubmit" method="get">
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-12">
            <h2>SEARCH</h2>
          </div>
        </div>
         
        <div class="row">
        <c:forEach items="${newSearch }" var="item">
      		<c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      			</c:url>
          <div class="col-lg-4 mb-4">
            <div class="entry2">
              <a href="${url }" ><img src="https://ngocngo99.000webhostapp.com/image/imageTitle/${item.thumbnail }" width="364.44px" height="205.16"> </a>
              <div class="excerpt">
              <span class="post-category text-white bg-secondary mb-3">Politics</span>
				
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
              	
                
                <p><a href="${url }">Read More</a></p>
              </div>
            </div>
          </div>
          </c:forEach>

        </div>
     
        <div class="row text-center pt-5 border-top">
          <div class="col-md-12">
            <ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="limit" name="limit"/>
			<input type="hidden" value="${search}" id="search" name="search" />
			 </div>
        </div>
		
        
      </div>
    </div>
		
  </form> 


    <div class="site-section bg-lightx">
      <div class="container">
        <div class="row justify-content-center text-center">
          <div class="col-md-5">
            <div class="subscribe-1 ">
              <h2>Subscribe to our newsletter</h2>
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit nesciunt error illum a explicabo, ipsam nostrum.</p>
              <form action="#" class="d-flex">
                <input type="text" class="form-control" placeholder="Enter your email address">
                <input type="submit" class="btn btn-primary" value="Subscribe">
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
   <script>
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			var limit = 6;
			$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPages,
					visiblePages: 10,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#limit').val(limit);
							$('#page').val(page);
							$('#search').val(search);
							
							$('#formSubmit').submit();
						}
					}
				});
			});
	
			</script> 
    