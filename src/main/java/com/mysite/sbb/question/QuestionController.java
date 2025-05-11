package com.mysite.sbb.question;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.Answer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/")
	public String rootPage() {
		return "redirect:/main";
	}
	
	@GetMapping("/list")
	public String list() {
		return "question_list";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "question_detail";
	}
	
	@GetMapping("/createForm")
	public String create() {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String createQuestion(Question question) {
		this.questionService.getInsert(question);
		return "redirect:/question/list";
	}
	
	@PostMapping("/delete/{qid}")
	public String deleteQuestion(@PathVariable("qid") Integer id) {
		
		this.questionService.getDeleteById(id);
		
		return "redirect:/question/list";
	}
}


