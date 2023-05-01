package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MMember;
import com.example.demo.entity.TMember;
import com.example.demo.resultmap.MemberDetail;

@Repository
@Mapper
public interface MemberListRepository {

	// 全件取得
	List<MMember> findAll();

	// ユーザー情報を削除
	void deletebyAccountId(Integer accountId);

	// ユーザー情報を1件取得
	MMember findbyId(Integer accountId);

	TMember findbyAccountId(Integer accountId);

	// 詳細情報
	MemberDetail findDetailbyAccountId(@Param("accountId") int accountId);

	// 基本情報更新
	void updateMMember(@Param("accountId") Integer accountId, @Param("name") String name,
			@Param("furigana") String furigana);

	// 詳細情報登録
	void insert(TMember tMember);

	// 詳細情報更新
	void updateTMember(@Param("accountId") Integer accountId, @Param("teamPosition") String teamPosition,
			@Param("birthPlace") String birthPlace, @Param("hobby") String hobby,
			@Param("statusMessage") String statusMessage);

}
