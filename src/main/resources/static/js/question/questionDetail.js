
document.addEventListener('DOMContentLoaded', function() {
	const urlParams = new URLSearchParams(window.location.search);
	const qid = urlParams.get('qid');
	
	fetch(`/api/question/detail?qid=${qid}`)
		.then(response => {
			if(!response.ok){
				throw new Error('response not ok');
			}
			return response.json();
		})
		.then(data => {
			const qDetailSubject = document.getElementById("question-detail-subject");
			const qDetailContent = document.getElementById("question-detail-content");
			const qDetailCreateDt = document.getElementById("question-detail-createDt");
			
			//날짜 포맷
			const date = new Date(data.createDate);
			const yyyy = date.getFullYear();
			const MM = String(date.getMonth() + 1).padStart(2, '0');
			const dd = String(date.getDate()).padStart(2, '0');
			const HH = String(date.getHours()).padStart(2, '0');
			const mm = String(date.getMinutes()).padStart(2, '0');
			const ss = String(date.getSeconds()).padStart(2, '0');
			
			if(!qDetailSubject) return;
			if(!qDetailContent) return;
			
			html_subject = `${data.questionSubject}`;
			html_content = `${data.questionContent}`;
			html_createDt = `${yyyy}-${MM}-${dd} ${HH}:${mm}:${ss}`;
			
			qDetailSubject.innerHTML = html_subject;
			qDetailContent.innerHTML = html_content;
			qDetailCreateDt.innerHTML = html_createDt;
		})
})