package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionRestController {
	
	private final QuestionService questionService;
	
	@GetMapping("/list")
    public ResponseEntity<Page<Question>> list(@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Question> paging = questionService.getList(page);
        return ResponseEntity.ok(paging);
    }
	
	@GetMapping("/detail")
	public ResponseEntity<Question> detail(@RequestParam(value = "qid") Integer qid){
		Question question = this.questionService.getDetail(qid);
		return ResponseEntity.ok(question);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Void> createQuestion(Question question) {
		this.questionService.getInsert(question);
		return ResponseEntity.status(HttpStatus.FOUND)
							.header("Location", "/question/list")
							.build();
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Void> deleteQuestion(@RequestParam("qid") Integer qid) {
		if(qid != null) this.questionService.getDeleteById(qid);
		return ResponseEntity.status(HttpStatus.FOUND)
							.header("Location", "/question/list")
							.build();
	}
}
