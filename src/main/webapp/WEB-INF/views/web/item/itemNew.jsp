<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/common/taglib.jsp" %> 
<c:url  value="/api-comment" var="commentApi"> </c:url>
<c:url  value="/login" var="login"> </c:url>
<c:url  value="/web-item?id=${newModel.id }" var="items"> </c:url>
<%@ page import="com.javaweb.springmvc.Util.SecurityUtils" %>
   <div class="site-wrap">
    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div> 
    <div class="site-cover site-cover-sm same-height overlay single-page" style="background-image: url('https://ngocngo99.000webhostapp.com/image/imageTitle/${newModel.thumbnail}');">
      <div class="container">
        <div class="row same-height justify-content-center">
          <div class="col-md-12 col-lg-10">
            <div class="post-entry text-center">
              <span class="post-category text-white bg-success mb-3">${newModel.categoryName }</span>
              <h1 class="mb-4"><a href="#">${newModel.title}</a></h1>
              <div class="post-meta align-items-center text-center">
                
                 <span class="d-inline-block mt-1">By <a href="#">
                <c:if test="${empty newModel.modifiedBy }">
                	${newModel.createdBy }
                </c:if> 
                <c:if test="${not empty newModel.modifiedBy }">
                	${newModel.modifiedBy }
                </c:if> 
                </a></span>
                <span>&nbsp;-&nbsp;
                <c:if test="${not empty newModel.modifiedDate }">
                	${newModel.timeLine }
                </c:if>       
                <c:if test="${empty newModel.modifiedDate }">
                	${newModel.timeLine }
                </c:if></span>
                <span>&nbsp;-&nbsp;
                <c:if test="${not empty newModel.modifiedDate }">
                	${newModel.dateNew }
                </c:if>       
                <c:if test="${empty newModel.modifiedDate }">
                	${newModel.dateNew }
                </c:if></span>   
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>   
    <section class="site-section py-lg">
      <div class="container">      
        <div class="row blog-entries element-animate">
          <div class="col-md-12 col-lg-8 main-content">        
            <div class="post-content-body">
             <h5><b>${newModel.shortDescription }</b></h5>
             <br/>
             <br/>
              <p style="background-image: 761px" >${newModel.content }</p>          
            <p></p>
            </div>           
            <div class="pt-5">
              <p>Categories:  <a href="#">${newModel.categoryName }</a>, <a href="#">Travel</a>  Tags: <a href="#">#manila</a>, <a href="#">#asia</a></p>
            </div>
            <div class="pt-5">
              <h3 class="mb-5">Comments</h3>
 <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="comment">             
              	<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Comment</label>
								<div class="col-sm-9">									
									<form:textarea path="comments" cssClass="col-xs-10 col-sm-5" style="width: 450px;height: 40px"/>
									<form:hidden path="userName" value="<%=SecurityUtils.getName()%>"/>
									<form:hidden path="newid" value="${newModel.id }"/>
								</div>
				</div>
              <button class="btn btn-info" type="button" id="btnComment" class="btnComment">
						<i class="ace-icon fa fa-check bigger-110"></i>
						Xác nhận
				</button>
     </form:form>               
              <ul class="comment-list">            
              <c:forEach items="${listComment }" var="item">
                <li class="comment">                
                  <div class="comment-body">
                    <h3>${item.userName }</h3>
                    <p>${item.comments}</p>
                    <div class="meta">${item.timeLine }</div>
                 <c:forEach items="${listCommentUser }" var="itemcommentuser">
                  <c:if test="${itemcommentuser.useridcomment eq item.id }">                                                         
                      <div class="comment-body">
                        <h3>${itemcommentuser.userName }</h3>                      
                        <p>${itemcommentuser.comments}</p>
                        <div class="meta">${itemcommentuser.timeLine }</div>                       
                      </div>                  
                   </c:if>  
                   </c:forEach>
                    <c:url value="/api-post-comment-user" var="url"></c:url>                                     
                <form class="form-horizontal" role="form" id="formSubmitCommentUser" modelAttribute="comment" action="${url }" method="POST">    
              	<div class="form-group">
							<label class="col-sm-4 control-label no-padding-right m-0 font-weight-bold text-primary" for="form-field-1">Comment</label>
								<div class="col-sm-9">											
									<textarea rows="" cols="" id="comments" name="comments" style="width: 450px;height: 30px"></textarea>									
									<input type="hidden" id="userName" name="userName" value="<%=SecurityUtils.getName()%>">									
									<input type="hidden" id="newid" name="newid" value="${newModel.id }">
									
									
									
									<input type="hidden" id="useridcomment" name="useridcomment" value="${item.id }">
								</div>
				</div>
              <button class="reply rounded" type="submit">
						<i class="ace-icon fa fa-check bigger-110"></i>
						Xác nhận
				</button>
     </form>
    
                  </div>
                 
                  
                </li>
			</c:forEach>
			  
               </ul>
        
              <!-- END comment-list -->
              
              
            </div>
            
            

          </div>

          <!-- END main-content -->

          <div class="col-md-12 col-lg-4 sidebar">
            <div class="sidebar-box search-form-wrap">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="icon fa fa-search"></span>
                  <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter">
                </div>
              </form>
            </div>
           
            <div class="sidebar-box">
              <h3 class="heading">Popular Posts</h3>
              <div class="post-entry-sidebar">
                <ul>
                <c:forEach items="${ListNew}" var="item">
                <c:url value="/web-item" var="url">
      				<c:param name="id" value="${item.id }"></c:param>
      	
      			</c:url>
                
                    <a href="${url }">
                      <img src="https://ngocngo99.000webhostapp.com/image/imageTitle/${item.thumbnail }" width="300px" height="140px">
                      <div class="text">
                        <h4>${item.title }</h4>
                        <div class="post-meta">
                          <span class="mr-2">
                          <c:if test="${not empty item.modifiedDate }">
			                	${item.timeLine }
			                </c:if>       
			                <c:if test="${empty item.modifiedDate }">
			                	${item.timeLine }
			                </c:if>
                          </span>
                        </div>
                      </div>
                    </a>
                 
                 </c:forEach> 
                  
                </ul>
              </div>
            </div>
            <!-- END sidebar-box -->

            <div class="sidebar-box">
              <h3 class="heading">Categories</h3>
              <ul class="categories">
              
              <c:forEach items="${listCat }" var="l">
              <c:url value="/web-category?page=1&limit=6" var="cat">
              	<c:param name="CategoryCode" value="${l.code}"/>
              </c:url>
                <li><a href="${cat}">${l.name }
                <span>(12)</span></a></li>
                </c:forEach>
              </ul>
            </div>
            <!-- END sidebar-box -->

            <div class="sidebar-box">
              <h3 class="heading">Tags</h3>
              <ul class="tags">
                <li><a href="#">Travel</a></li>
                <li><a href="#">Adventure</a></li>
                <li><a href="#">Food</a></li>
                <li><a href="#">Lifestyle</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Freelancing</a></li>
                <li><a href="#">Travel</a></li>
                <li><a href="#">Adventure</a></li>
                <li><a href="#">Food</a></li>
                <li><a href="#">Lifestyle</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Freelancing</a></li>
              </ul>
            </div>
          </div>
          <!-- END sidebar -->

        </div>
      </div>
    </section>

    


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
    
    
   
    
  </div>
  
  <script>					
	 $('#btnComment').click(function (e) {
    	e.preventDefault();
    	 var data = {};
    	
        
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
        	
            data[""+v.name+""] = v.value;
        });
       
        
    /*   if(userName=="anonymousUser"){
    	  
      }else{ */
    	  updateNew(data);
      
        
            
          
       
    });
	 
	 
    function updateNew(data) {
        $.ajax({
            url: '${commentApi}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result);
            	window.location.href = "${items}";
            /* 	?id="+result.id+"&message=update_success */
            },
            error: function (error) {
            	console.log(error);
            	window.location.href = "${login}";
            	/* ?id="+result.id+"&message=error_system */
            }
        });
    }
    </script>		