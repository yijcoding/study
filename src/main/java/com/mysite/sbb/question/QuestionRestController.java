package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
