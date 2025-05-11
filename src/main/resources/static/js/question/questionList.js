
document.addEventListener('DOMContentLoaded', function(){
	fetch('/api/question/list')
		.then(response => {
			if(!response.ok){
				throw new Error('responst not ok');
			}
			return response.json();
		})
		.then(data => {
			const questionListDiv = document.getElementById('question-list');
			const questionListPagingDiv = document.getElementById('question-list-paging');
			
			renderingList(data, questionListDiv);
			renderingPaging(data, questionListPagingDiv);
		})
		.catch(error => {
			console.error("문제 발생: ", error);
		})
})


function renderingList(data, questionListDiv){
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
		      <td><a href="/question/detail?qid=${arr.qid}">${arr.questionSubject}</a></td>
		      <td>${yyyy}-${MM}-${dd} ${HH}:${mm}:${ss}</td>
		    </tr>
		  `;
	});
	
	questionListDiv.innerHTML = html;
}

function renderingPaging(data, questionListPagingDiv) {
    if (!questionListPagingDiv) return;

    const totalPages = data.totalPages;
    const currentPage = data.number;
    let html = '<ul class="pagination justify-content-center">';

    // << 이전 페이지
    if (currentPage > 0) {
        html += `<li class="page-item">
                    <a class="page-link" href="#" onclick="loadPage(${currentPage - 1})">이전</a>
                 </li>`;
    } else {
        html += `<li class="page-item disabled"><span class="page-link">이전</span></li>`;
    }

    // 페이지 번호 버튼 (예: 1, 2, 3, ...)
    for (let i = 0; i < totalPages; i++) {
        html += `<li class="page-item ${i === currentPage ? 'active' : ''}">
                    <a class="page-link" href="#" onclick="loadPage(${i})">${i + 1}</a>
                 </li>`;
    }

    // >> 다음 페이지
    if (currentPage < totalPages - 1) {
        html += `<li class="page-item">
                    <a class="page-link" href="#" onclick="loadPage(${currentPage + 1})">다음</a>
                 </li>`;
    } else {
        html += `<li class="page-item disabled"><span class="page-link">다음</span></li>`;
    }

    html += '</ul>';
    questionListPagingDiv.innerHTML = html;
}

function loadPage(page) {
    fetch(`/api/question/list?page=${page}`)
        .then(response => response.json())
        .then(data => {
            const questionListDiv = document.getElementById('question-list');
            const questionListPagingDiv = document.getElementById('question-list-paging');

            renderingList(data, questionListDiv);
            renderingPaging(data, questionListPagingDiv);
        })
        .catch(error => {
            console.error("페이지 로드 중 오류:", error);
        });
}








