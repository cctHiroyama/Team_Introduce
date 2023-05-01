package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.form.DiaryForm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "diary")
@AllArgsConstructor
public class Diary {
	public Diary() {}
	
	public Diary(DiaryForm diaryForm) {
		this.articleId = diaryForm.getArticleId();
		this.title = diaryForm.getTitle();
		this.text = diaryForm.getText();
		this.createTime = diaryForm.getCreateTime();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer articleId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String text;
	
	@Column(name = "create_time", nullable = false)
    private LocalDate createTime;
	
}
