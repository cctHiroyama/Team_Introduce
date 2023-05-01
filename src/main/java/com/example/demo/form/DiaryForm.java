package com.example.demo.form;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Diary;

import lombok.Data;

@Data
public class DiaryForm {

	// 記事一覧
	private List<Diary> diaries;

	private Integer articleId;

	@NotNull
	@Size(min = 1, max = 500)
	private String title;

	@NotNull
	@Size(min = 1, max = 2500)
	private String text;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate createTime;

	public DiaryForm() {}

	public DiaryForm(Diary diary) {
		this.articleId = diary.getArticleId();
		this.title = diary.getTitle();
		this.text = diary.getText();
		this.createTime = diary.getCreateTime();
	}
}
