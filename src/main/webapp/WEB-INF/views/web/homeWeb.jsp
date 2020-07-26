<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<c:url value="/web" var="URLHOME"></c:url>
<c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      			</c:url>
      			
      					<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
  								${messageResponse}
							</div>
						</c:if>
      			
    <div class="site-section bg-light">
      <div class="container">
        <div class="row align-items-stretch retro-layout-2">
          <div class="col-md-4">
            <a href="<c:url value="/web-item?id=${newTop[1].id }"/>" class="h-entry mb-30 v-height gradient" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${dataNew[1].thumbnail }')">
              
              <div class="text">
                <h2>${newTop[1].title }</h2>
                <span class="date">
                <c:if test="${not empty newTop[1].modifiedDate }">
                	${newTop[1].timeLine }
                </c:if>       
                <c:if test="${empty newTop[1].modifiedDate }">
                	${newTop[1].timeLine }
                </c:if>
                </span>
              </div>
            </a>
            
            <a href='<c:url value="/web-item?id=${newTop[2].id }"/>' class="h-entry v-height gradient" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${dataNew[2].thumbnail }');">
              
              <div class="text">
                <h2>${newTop[2].title }</h2>
                <span class="date">
                <c:if test="${not empty newTop[2].modifiedDate }">
                	${newTop[2].timeLine }
                </c:if>       
                <c:if test="${empty newTop[2].modifiedDate }">
                	${newTop[2].timeLine }
                </c:if>
                </span>
              </div>
            </a>
          </div>
          <div class="col-md-4">
            <a  href="<c:url value="/web-item?id=${newTop[0].id }"/>" class="h-entry mb-30 v-height gradient" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${dataNew[0].thumbnail }');" >
              
              <div class="text">
                <div class="post-categories mb-4">
                  <span class="post-category bg-danger">Travel</span>
                  <span class="post-category bg-primary">Food</span>
                </div>
                <h2>${newTop[0].title }</h2>
                <span class="date">
                <c:if test="${not empty newTop[0].modifiedDate }">
                	${newTop[0].timeLine }
                </c:if>       
                <c:if test="${empty newTop[0].modifiedDate }">
                	${newTop[0].timeLine }
                </c:if>
                </span>
              </div>
            </a>
          </div>
          <div class="col-md-4">
            <a href="<c:url value="/web-item?id=${newTop[3].id }"/>" class="h-entry mb-30 v-height gradient" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${dataNew[3].thumbnail }');">
              
              <div class="text">
                <h2>${newTop[3].title }</h2>
                <span class="date">
                <c:if test="${not empty newTop[3].modifiedDate }">
                	${newTop[3].timeLine }
                </c:if>       
                <c:if test="${empty newTop[3].modifiedDate }">
                	${newTop[3].timeLine }
                </c:if>
                </span>
              </div>
            </a>
            <a href="<c:url value="/web-item?id=${newTop[4].id }"/>" class="h-entry v-height gradient" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${dataNew[4].thumbnail }');">
              
              <div class="text">
                <h2>${newTop[4].title }</h2>
                <span class="date">
                <c:if test="${not empty newTop[4].modifiedDate }">
                	${newTop[4].timeLine }
                </c:if>       
                <c:if test="${empty newTop[4].modifiedDate }">
                	${newTop[4].timeLine }
                </c:if>
                </span>
              </div>
            </a>
          </div>
        </div>
      </div>
    </div>
 <form action="<c:url value='/web'/>" id="formSubmit" method="get">
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-12">
            <h2>News</h2>
          </div>
        </div>
         
        <div class="row">
        <c:forEach items="${dataNew }" var="item">
      		<c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      	
      		</c:url>
      		
          <div class="col-lg-4 mb-4" >
            <div class="entry2">
              <a href="${url }" ><img src="https://ngocngo99.000webhostapp.com/image/imageTitle/${item.thumbnail }"  width="364.44px" height="205.16"> </a>
              <div class="excerpt">
              <span class="post-category text-white bg-secondary mb-3">${item.categoryName }</span>
				
              <h2 ><a href="${url }" >${item.title }</a></h2>
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
     
        <div class="row text-center pt-5 border-top">
          <div class="col-md-12">
            <ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="limit" name="limit"/>
			
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
    
    
    
   