package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.answer.Answer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	//전체 question 목록 전체 조회
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	//id 값으로 question 상세 조회(단건)
	public Question getDetail(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}
		else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void getInsert(Question question) {
		question.setCreateDate(LocalDateTime.now());
		question.setDelYn("N");
		this.questionRepository.save(question);
	}
	
	public void getDeleteById(Integer qid) {
		this.questionRepository.deleteById(qid);
	}
}
