package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.answer.Answer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/")
	public String rootPage() {
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detailById(Model model, @PathVariable("id") Integer id) {
		
		//id 값으로 question 상세 조회
		Question questionDetail = this.questionService.getDetail(id);
		model.addAttribute("questionDetail", questionDetail);
		
		//id 값으로 qusetion의 답글 목록 전체 조회
		List<Answer> answerList = questionDetail.getAnswerList();
		model.addAttribute("answerList", answerList);
		model.addAttribute("answerTotalCount", answerList.size());
		
		return "question_detail";
	}
}
