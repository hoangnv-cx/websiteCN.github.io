

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
        <%@include file="/common/taglib.jsp" %>

    <c:url var="APIurl" value="/post-new"></c:url>
    <c:url var="delete" value="/delete-new"></c:url>
 	<c:url var="NewUrlDelete" value="/admin-delete-one-new"></c:url>
	<c:url var="deleteUrl" value="/api-post-new"></c:url>

       <form action="<c:url value='/admin-list-new'/>" id="formSubmit" method="get">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
  								${messageResponse}
							</div>
						</c:if>
							
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
											<c:url var="NewUrlAdd" value="/admin-add-new"></c:url>
												<a 
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='${NewUrlAdd }'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
											<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Tên bài viết</th>
														<th >Mô tả ngắn</th>
														<th colspan="3">Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${news}">
														<tr>
																<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.title}</td>
															<td>${item.shortDescription}</td>
															
																
															
															
															<c:url var="NewUrlDelete" value="/admin-delete-one-new">
																<c:param name="id" value="${item.id }"/>
															</c:url>
																<c:url var="NewUrlEdit" value="/admin-update-new">
																	
																	<c:param name="id" value="${item.id}"/>
																</c:url>
																<c:url var="NewDetailUrl" value="/admin-detail-new">
																	
																	<c:param name="id" value="${item.id}"/>
																</c:url>
																<td>
																
																<a class="btn btn-success btn-circle btn-sm" data-toggle="tooltip"
																   title="Cập nhật bài viết" href='${ NewUrlEdit}'><i class="fas fa-check" aria-hidden="true"></i>
																</a>
																</td>
																<td>
																<a class="btn btn-danger btn-circle btn-sm" data-toggle="tooltip"
																   title="delete" href='${ NewUrlDelete}'><i class="fas fa-trash" aria-hidden="true"></i>
																</a>
																</td>
																<td>
																<a class="btn btn-info btn-circle btn-sm" data-toggle="tooltip"
																   title="Chi tiết" href='${ NewDetailUrl}'><i class="fas fa-info-circle" aria-hidden="true"></i>
																</a>
																</td>
															
														</tr>
													</c:forEach>
												</tbody>
											</table>
											 <ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/> 
										
										</div>
									</div>
								
							</div>
						</form>
					
				
		<script>
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			var limit = 4;
			$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPages,
					visiblePages: 10,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#limit').val(limit);
							$('#page').val(page);
							
							$('#formSubmit').submit();
						}
					}
				});
			});
			
			$("#btnDelete").click(function() {
				var data = {};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				data['ids'] = ids;
				deleteNew(data);
				
			});
			function deleteNew(data) {
		        $.ajax({
		            url: '${APIurl}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		           
		            success: function (result) {
		                window.location.href = "${NewURL}";
		            },
		            error: function (error) {
		            	window.location.href = "${NewURL}";
		            }
		        });
		    }
		</script>


	
