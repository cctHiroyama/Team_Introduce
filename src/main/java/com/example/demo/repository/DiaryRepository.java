package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Diary;

@Repository
@Mapper
public interface DiaryRepository {
	
	// 全件取得
	List<Diary> findAll();
	
	// 記事IDから記事を絞り込む
	Diary findbyId(Integer articleId);
	
	Diary findbyArticle(Integer articleId);
	
	// アカウントIDから記事を絞り込む
	Diary findbyAccountId(Integer accountId);
	
	// 編集
	void updateDiary(@Param("articleId") Integer articleId,  @Param("title") String title, @Param("text") String text);
	
	// 削除
	void deletebyArticleId(Integer articleId);
	
	// 新規登録
	public int insert(Diary diary);
}
