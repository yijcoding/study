package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.answer.Answer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


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
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		
		//List<Question> questionList = this.questionService.getList();
		//model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping("/detail/{qid}")
	public String detailById(Model model, @PathVariable("qid") Integer qid) {
		
		//id 값으로 question 상세 조회
		Question questionDetail = this.questionService.getDetail(qid);
		model.addAttribute("question", questionDetail);
		
		//질문에서 답변을 참조
		List<Answer> answerList = questionDetail.getAnswerList();
		model.addAttribute("answerList", answerList);
		model.addAttribute("answerTotalCount", answerList.size());
		
		return "question_detail";
	}
	
	@GetMapping("/createFrom")
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


