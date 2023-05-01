package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MMember;
import com.example.demo.entity.TMember;
import com.example.demo.repository.MemberListRepository;
import com.example.demo.resultmap.MemberDetail;

@Service
public class MemberListService {

	@Autowired
	MemberListRepository memberListRepository;

	// 全件検索
	public List<MMember> getMemberList() {
		return this.memberListRepository.findAll();
	}

	// 1件検索
	public MMember getfindbyId(Integer accountId) {
		return memberListRepository.findbyId(accountId);
	}

	public TMember getfindbyAccountId(Integer accountId) {
		return memberListRepository.findbyAccountId(accountId);
	}

	// 詳細情報
	public MemberDetail findDetailbyAccountId(Integer accountId) {
		return memberListRepository.findDetailbyAccountId(accountId);
	}

	// 削除
	public void delete(Integer accountId) {
		memberListRepository.deletebyAccountId(accountId);
	}

	// 更新
	public void updateTMember(Integer accountId, String name, String teamPotision) {
		memberListRepository.updateMMember(accountId, name, teamPotision);
	}

	public void updateTMember(Integer accountId, String teamPosition, String birthPalce, String hobby,
			String statusMessage) {
		memberListRepository.updateTMember(accountId, teamPosition, birthPalce, hobby, statusMessage);
	}
}
