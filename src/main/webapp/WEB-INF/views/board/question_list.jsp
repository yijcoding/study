<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<jsp:include page="/WEB-INF/views/layout.jsp" />
	<div class="container my-3">
	    <table class="table">
	        <thead class="table-dark">
	            <tr>
	                <th>번호</th>
	                <th>제목</th>
	                <th>작성일시</th>
	            </tr>
	        </thead>
	        <tbody id="question-list">
	        </tbody>
	    </table>
		
		<div id="question-list-paging">
		</div>
		
		<a href="/question/createForm" class="btn btn-primary">질문등록</a>
	</div>
</html>