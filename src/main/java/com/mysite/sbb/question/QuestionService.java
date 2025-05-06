package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public void createTest(String questionSubject, String questionContent) {
		Question question = new Question();
		question.setQuestionSubject(questionSubject);
		question.setQuestionContent(questionContent);
		question.setCreateDate(LocalDateTime.now());
		question.setDelYn("N");
		this.questionRepository.save(question);
	}
	
	public Page<Question> getList(int page) {
		//최신 등록순으로 정렬
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		
		//10 => 한 페이지에 보여줄 데이터 개수
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
}
