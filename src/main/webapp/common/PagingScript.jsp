<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							
							$('#formSubmit').submit();
						}
					}
				});
			});
	
			</script>