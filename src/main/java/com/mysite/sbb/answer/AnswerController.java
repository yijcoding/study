package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
	
	private final AnswerService answerService;
	
	@GetMapping("/insert")
	public void insertQuestion() {
		Answer answer = new Answer();
		this.answerService.getInsert(answer);
	}
}
