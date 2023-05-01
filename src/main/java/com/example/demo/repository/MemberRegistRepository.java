package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MMember;

@Mapper
public interface MemberRegistRepository {
	public int save(MMember mMember);
}
