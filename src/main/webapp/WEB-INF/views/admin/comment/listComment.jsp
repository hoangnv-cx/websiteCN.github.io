<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@include file="/common/taglib.jsp" %>
 <form action="<c:url value='/admin-comment'/>" id="formSubmit" method="get">
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
						
							
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
											<c:url var="NewUrlAdd" value="/admin-add-new"></c:url>
												
											
											</div>
										</div>
									</div>
								</div>
								
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Nội dung bình luận</th>
														<th>Người bình luận</th>
														<th>Trả lời bình luận</th>
														<th colspan="2">Thao tác</th>
														
														
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${models}">
														<tr>
																<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.comments}</td>
															<td>${item.userName}</td>
															<td>${item.repComments}</td>
															
																
															<td>
															
																<c:url var="commentDelete" value="/admin-delete-comment">
																	<c:param name="id" value="${item.id }"/>
																</c:url>
																<a class="btn btn-danger btn-circle btn-sm" data-toggle="tooltip"
																   title="delete" href='${ commentDelete}'><i class="fas fa-trash" aria-hidden="true"></i>
																</a>
																
																
															</td>
															<td>
															
																<c:url var="commentDetail" value="/admin-detail-comment">
																	<c:param name="id" value="${item.id }"/>
																</c:url>
																<a class="btn btn-info btn-circle btn-sm" data-toggle="tooltip"
																   title="Chi tiết" href='${commentDetail}'><i class="fas fa-info-circle" aria-hidden="true"></i>
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