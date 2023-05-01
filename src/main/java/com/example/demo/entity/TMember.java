package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.form.MemberDetailRegistForm;

import lombok.Data;

@Data
public class TMember {
	
	public TMember() {
	}
	
	public TMember(MemberDetailRegistForm memberDetailRegistForm) {
		this.accountId = memberDetailRegistForm.getAccountId();
		this.teamPosition = memberDetailRegistForm.getTeamPosition();
		this.birthPlace = memberDetailRegistForm.getBirthPlace();
		this.hobby = memberDetailRegistForm.getHobby();
		this.statusMessage = memberDetailRegistForm.getStatusMessage();
		this.createTime = memberDetailRegistForm.getCreateTime();
	}
	
	private Integer accountId;
	private String teamPosition;
	private String birthPlace;
	private String hobby;
	private String statusMessage;
	private LocalDate createTime;
	
}
