<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<jsp:include page="/WEB-INF/views/layout.jsp" />
	
	<div class="container">
	    <h5 class="my-3 border-bottom pb-2">질문등록</h5>
	    <form action="/api/question/create" method="post">
			<input type="hidden" name="_csrf" value="${_csrf.token}">
	        <div class="mb-3">
	            <label for="questionSubject" class="form-label">제목</label>
	            <input type="text" name="questionSubject" id="questionSubject" class="form-control">
	        </div>
	        <div class="mb-3">
	            <label for="questionContent" class="form-label">내용</label>
	            <textarea name="questionContent" id="questionContent" class="form-control" rows="10"></textarea>
	        </div>
	        <input type="submit" value="저장하기" class="btn btn-primary my-2">
	    </form>
		
		<a href="/question/list" class="btn btn-secondary">목록</a>
	</div>
</html>
