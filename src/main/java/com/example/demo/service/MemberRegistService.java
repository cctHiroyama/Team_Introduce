package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MMember;
import com.example.demo.repository.MemberRegistRepository;

@Service
@Transactional
public class MemberRegistService {
	
	@Autowired
	MemberRegistRepository memberRegistRepository;
	
	public void save(MMember mMember) {
		System.out.print(mMember);
		memberRegistRepository.save(mMember);
	}
}
