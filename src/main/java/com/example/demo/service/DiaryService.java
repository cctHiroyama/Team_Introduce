package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Diary;
import com.example.demo.repository.DiaryRepository;

@Service
public class DiaryService {

	@Autowired
	DiaryRepository diaryRepository;

	// 全件取得
	public List<Diary> getDiaries() {
		return this.diaryRepository.findAll();
	}

	// 記事IDから記事を絞り込む
	public Diary getfindbyArticle(Integer articleId) {
		return diaryRepository.findbyArticle(articleId);
	}
	public Diary getfindbyId(Integer articleId) {
		return diaryRepository.findbyId(articleId);
	}

	// アカウントIDから記事を絞り込む
	public Diary getfindbyAccountId(Integer accountId) {
		return this.diaryRepository.findbyAccountId(accountId);
	}

	// 編集
	public void updateDiary(Integer articleId, String title, String text) {
		diaryRepository.updateDiary(articleId, title, text);
	}

	// 削除
	public void delete(Integer articleId) {
		diaryRepository.deletebyArticleId(articleId);
	}

	// 新規登録
	public void insert(Diary diary) {
		System.out.print(diary);
		diaryRepository.insert(diary);
	}
}
