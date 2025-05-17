package com.mysite.sbb.question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@GetMapping("/")
	public String rootPage() {
		return "redirect:/question/list";
	}
	
	@GetMapping("/list")
	public String list() {
		return "board/question_list";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "board/question_detail";
	}
	
	@GetMapping("/createForm")
	public String create() {
		return "board/question_form";
	}
}


