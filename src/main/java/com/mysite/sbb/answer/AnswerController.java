package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
	
	private final QuestionService questionService;
	
	private final AnswerService answerService;
	
	@PostMapping("/create/{qid}")
	public String createAnswer(Answer answer, @PathVariable("qid") Integer qid) {
		
		//답글을 등록할 질문 조회
		Question question = this.questionService.getDetail(qid);
		
		//답변 등록
		this.answerService.createAnswer(question, answer.getAnswerContent());
		
		return String.format("redirect:/question/detail/%s", qid);
	}
}
