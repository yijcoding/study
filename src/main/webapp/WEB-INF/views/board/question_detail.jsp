<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<jsp:include page="/WEB-INF/views/layout.jsp" />
	<div class="container my-3">
	    <!-- 게시글 내용 -->
	    <h2 class="border-bottom py-2">
			<span id="question-detail-subject"></span>
		</h2>
	    <div class="card my-3">
	        <div class="card-body">
	            <div class="card-text" id="question-detail-content" style="white-space: pre-line;"></div>
	            <div class="d-flex justify-content-end">
	                <div class="badge bg-light text-dark p-2 text-start">
						<div id="question-detail-createDt"></div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!-- 답변의 갯수 표시 -->
<!--	    <h5 class="border-bottom my-3 py-2"></h5>-->
	    <!-- 답변 반복 시작 -->
		<!--
	    <div class="card my-3">
	        <div class="card-body">
	            <div class="card-text" style="white-space: pre-line;"></div>
	            <div class="d-flex justify-content-end">
	                <div class="badge bg-light text-dark p-2 text-start">
	                </div>
	            </div>
	        </div>
	    </div>
		-->
	    <!-- 답변 반복 끝  -->
	    <!-- 답변 작성 -->
		<!--
	    <form th:action="@{|/answer/create/${question.qid}|}" method="post" class="my-3">
	        <textarea name="answerContent" id="answerContent" rows="10" class="form-control"></textarea>
	        <input type="submit" value="답변등록" class="btn btn-primary my-2">
	    </form>
		-->
		<a href="/question/list" class="btn btn-secondary">목록</a>
		
		<form action="/api/question/delete" method="post" class="my-3">
			<input type="hidden" name="_csrf" value="${_csrf.token}">
			<input type="hidden" name="qid" id="delQid">
			<button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
		</form>
	</div>
</html>