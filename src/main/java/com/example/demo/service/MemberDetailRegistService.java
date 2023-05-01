package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TMember;
import com.example.demo.repository.MemberDetailRegistRepository;

@Service
@Transactional
public class MemberDetailRegistService {
	
	@Autowired
	MemberDetailRegistRepository memberDetailRegistRepository;
	
	public void insert(TMember tMember) {
		System.out.print(tMember);
		memberDetailRegistRepository.insert(tMember);
	}
	
	public TMember findbyAccountId(Integer accountId) {
		return memberDetailRegistRepository.findbyAccountId(accountId);
	}
	
	public void delete(Integer accountId) {
		memberDetailRegistRepository.deletebyAccountId(accountId);
	}
}
