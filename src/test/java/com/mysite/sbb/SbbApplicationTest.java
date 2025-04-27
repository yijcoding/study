package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class SbbApplicationTest {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Test
	@Transactional
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("질문입니다.");
		q1.setContent("내용입니다.");
		q1.setCreateDate(LocalDateTime.now());
		q1.setDelYn("N");
		this.questionRepository.save(q1);
		
		/*
		List<Question> questionList = this.questionRepository.findAll();
		assertEquals(1, questionList.size());
		
		Question question = questionList.get(0);
		assertEquals("sbb가 무엇인가요?", question.getSubject());
		*/
		
		/*
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			System.out.println(oq.get());
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		*/
		
		/*
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
		*/
		
		/*
		Optional<Question> question = this.questionRepository.findById(1);
		assertTrue(question.isPresent());
		Question q = question.get();
		
		List<Answer> answerList = q.getAnswerList();
		assertEquals(1, answerList.size());
		*/
		
		/*
		Optional<Question> q1 = this.questionRepository.findById(1);
		assertTrue(q1.isPresent());
		Question question = q1.get();
		
		Answer answer = new Answer();
		answer.setContent("답글1입니다.");
		answer.setCreateDate(LocalDateTime.now());
		answer.setDelYn("N");
		answer.setQuestion(question);
		this.answerRepository.save(answer);
		*/
	}
}
