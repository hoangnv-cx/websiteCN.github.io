<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@include file="/common/taglib.jsp" %>
 <form action="<c:url value='/admin-help'/>" id="formSubmit" method="get">
				
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang quản trị trợ giúp</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						
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
												
											
											</div>
										</div>
									</div>
								</div>
								
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Tên người gửi</th>
														<th>Email</th>
														<th>Tình trạng</th>
														<th>Người xử lí</th>
														<th colspan="2">Thao tác</th>
														
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${help}">
														<tr>
																<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
															<td>${item.firstName}</td>
															<td>${item.email}</td>
															<td>${item.status}</td>
															<td >${item.admin}</td>
															
																
															<td>
															
																<c:url var="NewUrlEdit" value="/admin-help-edit">
																	<c:param name="id" value="${item.id }"/>
																</c:url>
																<a class="btn btn-success btn-circle btn-sm" data-toggle="tooltip"
																   title="Xử lí" href='${ NewUrlEdit}'><i class="fas fa-check" aria-hidden="true"></i>
																</a>
																
															</td>
															<td>
															<c:url var="NewUrlDetail" value="/admin-detail-help">
																<c:param name="id" value="${item.id }"/>
															</c:url>
																
																<a class="btn btn-info btn-circle btn-sm" data-toggle="tooltip"
																   title="Chi tiết" href='${ NewUrlDetail}'><i class="fas fa-info-circle" aria-hidden="true"></i>
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
			
			
		</script>			