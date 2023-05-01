package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TMember;

@Mapper
public interface MemberDetailRegistRepository {
	
	
	public int insert(TMember tMember);
	
	TMember findbyAccountId(Integer accountId);
	
	void deletebyAccountId(Integer accountId);
}
