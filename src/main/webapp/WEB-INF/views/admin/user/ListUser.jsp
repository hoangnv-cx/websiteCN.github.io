<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
   
       <form action="<c:url value=''/>" id="formSubmit" method="get">
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
											<c:url var="createNewURL" value="/admin-add-user"></c:url>
												<a 
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href="<c:url value='/admin-add-user'/>">
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
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
														<th>Tên đăng nhập</th>
														<th>PassWord</th>
														<th>Quyền truy cập</th>
														<th colspan="2">Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${user}">
														<tr>
															<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.userName}</td>
															<td>${item.password}</td>
															<td>${item.roleName}</td>
															<%-- <h1 class="font-weight-light">${model.userName}</h1> --%>
																
															<td>
															<c:url var="DetailUser" value="/admin-detail-user">
																<c:param name="id" value="${item.id }"></c:param>
																</c:url>	
															<a class="btn btn-info btn-circle btn-sm" data-toggle="tooltip"
																   title="Chi tiết" href='${ DetailUser}'><i class="fas fa-info-circle" aria-hidden="true"></i>
																</a>
																
																
															</td>
															<td>
															<c:url var="UserUrlUpdate" value="/admin-edit-user">
																<c:param name="id" value="${item.id }"></c:param>
																</c:url>
															<a class="btn btn-success btn-circle btn-sm" data-toggle="tooltip"
																   title="Đổi mật khẩu" href='${ UserUrlUpdate}'><i class="fas fa-check" aria-hidden="true"></i>
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
