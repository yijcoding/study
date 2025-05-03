package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;

    @Column(columnDefinition = "TEXT")
    private String answerContent;

    private String createRegId; //답글 등록 id
	private String updateRegId; //답글 수정 id
	private LocalDateTime createDate; //답글 등록일시
	private LocalDateTime updateDate; //답글 수정일시
	private String delYn; //답글 삭제여부
    
	//질문 데이터를 참조하기 위해 속성 Question 속성 추가
	@ManyToOne
    private Question question;
}
