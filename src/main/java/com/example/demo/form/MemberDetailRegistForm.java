package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.TMember;

import lombok.Data;

@Data
public class MemberDetailRegistForm {
	
	private Integer accountId;
	
	@Size(max=50)
	private String teamPosition;
	
	@Size(min=1, max=100)
	private String birthPlace;
	
	@Size(max=50)
	private String hobby;
	
	@Size(max=200)
	private String statusMessage;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate createTime;
	
	public MemberDetailRegistForm() {}
	
	public MemberDetailRegistForm(TMember tMember) {
		this.accountId = tMember.getAccountId();
		this.teamPosition = tMember.getTeamPosition();
		this.birthPlace = tMember.getBirthPlace();
		this.hobby = tMember.getHobby();
		this.statusMessage = tMember.getStatusMessage();
		this.createTime = tMember.getCreateTime();
	}
}
