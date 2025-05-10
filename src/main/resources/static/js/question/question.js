document.addEventListener('DOMContentLoaded', function(){
	fetch('/api/question/list?page=0')
		.then(response => {
			if(!response.ok){
				throw new Error('responst not ok');
			}
			
			return response.json();
		})
		.then(data => {
			const questionListDiv = document.getElementById('question-list');
			console.log("questionListDiv => ", questionListDiv);
			if(!questionListDiv) return;
			
			let html = '';
			
			data.content.forEach((arr, index) => {
				//날짜 포맷
				const date = new Date(arr.createDate);
				const yyyy = date.getFullYear();
				const MM = String(date.getMonth() + 1).padStart(2, '0');
				const dd = String(date.getDate()).padStart(2, '0');
				const HH = String(date.getHours()).padStart(2, '0');
				const mm = String(date.getMinutes()).padStart(2, '0');
				const ss = String(date.getSeconds()).padStart(2, '0');
				
				html += `
				    <tr>
				      <td>${data.totalElements - (data.number * data.size) - index}</td>
				      <td>${arr.questionSubject}</td>
				      <td>${yyyy}-${MM}-${dd} ${HH}:${mm}:${ss}</td>
				    </tr>
				  `;
			})
			
			questionListDiv.innerHTML = html;
		})
		.catch(error => {
			console.error("문제 발생: ", error);
		})
})
