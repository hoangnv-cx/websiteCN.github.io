<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
    <c:url value="/web-help" var="addHelp"></c:url>
    <c:url value="/web" var="web"></c:url>
    
    <div class="site-cover site-cover-sm same-height overlay single-page" style="background-image: url('images/img_4.jpg');">
      <div class="container">
        <div class="row same-height justify-content-center">
          <div class="col-md-12 col-lg-10">
            <div class="post-entry text-center">
              <h1 class="">Contact Us</h1>
              <p class="lead mb-4 text-white">Mọi thắc mắc về bản quyền hãy liên hệ với chúng tôi </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    <div class="site-section bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-7 mb-5">

            			<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
  								${messageResponse}
							</div>
						</c:if>
			<c:url value="/web-help" var="url"></c:url>
            <form:form  action="${url }" method="POST" class="form-horizontal" role="form" id="formSubmit"  modelAttribute="mail">
             
				<form:hidden path="user"/>
				
				
              <div class="row form-group">
                <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="fname">First Name</label>
                  <form:input path="firstName" id="fname" class="form-control"/>
                </div>
               
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="email">Email</label> 
                  <form:input path="email" type="email" id="email" class="form-control"/>
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="subject">Subject</label> 
                  <form:input path="subject" type="subject" id="subject" class="form-control"/>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="message">Message</label> 
                  <form:textarea path="message" name="message" id="message" cols="30" rows="7" class="form-control" placeholder="Write your notes or questions here..."/>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-12">
                  <input type="button" value="Send Message" class="btn btn-primary py-2 px-4 text-white" id="btnAddHelp">
                </div>
              </div>

  
            </form:form>
          </div>
          <div class="col-md-5">
            
            <div class="p-4 mb-3 bg-white">
              <p class="mb-0 font-weight-bold">Address</p>
              <p class="mb-4">Hà Nội,Việt Nam</p>

              <p class="mb-0 font-weight-bold">Phone</p>
              <p class="mb-4"><a href="#">0367582***</a></p>

              <p class="mb-0 font-weight-bold">Email Address</p>
              <p class="mb-0"><a href="#">Hoang9xhht@gmail.com</a></p>

            </div>

          </div>
        </div>
      </div>
    </div>
   <script>


     $('#btnAddHelp').click(function (e) {
    	e.preventDefault();
    	 var data = {};      
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
        	
            data[""+v.name+""] = v.value;
        });
       
        
       
       
            addNew(data);
           
       
    });
    function addNew(data) {
        $.ajax({
            url: '${addHelp}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${web}?page=1&limit=6&message=handling_success";
          
            },
            error: function (error) {
            	window.location.href = "${web}?page=1&limit=6&message=error_system";
            	
            }
        });
    }

    </script>  
    