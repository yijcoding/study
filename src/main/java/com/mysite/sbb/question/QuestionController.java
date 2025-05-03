package com.mysite.sbb.question;

import java.util.List;

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
	
	@GetMapping("/detail/{questionId}")
	public String detailById(Model model, @PathVariable("questionId") Integer questionId) {
		
		//id 값으로 question 상세 조회
		Question questionDetail = this.questionService.getDetail(questionId);
		model.addAttribute("questionDetail", questionDetail);
		
		//Question에서 answerList 참조
		List<Answer> answerList = questionDetail.getAnswerList();
		model.addAttribute("answerList", answerList);
		model.addAttribute("answerTotalCount", answerList.size());
		
		return "question_detail";
	}
}
