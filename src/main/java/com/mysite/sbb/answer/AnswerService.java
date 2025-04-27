package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	private final QuestionRepository quesionRepository;
	
	public void getInsert(Answer answer) {
		Optional<Question> oq = this.quesionRepository.findById(1);
		Question quesion = new Question();
		if(oq.isPresent()) {
			quesion = oq.get();
		}
		
		answer.setContent("답글입니다");
		answer.setCreateDate(LocalDateTime.now());
		answer.setDelYn("N");
		answer.setQuestion(quesion);
		
		this.answerRepository.save(answer);
	}
}
