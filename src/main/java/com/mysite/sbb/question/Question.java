package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questonId; //고유번호
	
	@Column(length = 200)
	private String questionSubject; //게시글 제목
	
	@Column(columnDefinition = "TEXT")
	private String questionContent; //게시글 내용
	
	private String createRegId; //게시글 등록 id
	private String updateRegId; //게시글 수정 id
	private LocalDateTime createDate; //게시글 등록일시
	private LocalDateTime updateDate; //게시글 수정일시
	private String delYn; //게시글 삭제여부
	
	//질문에서 답변 데이터를 참조
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
}
