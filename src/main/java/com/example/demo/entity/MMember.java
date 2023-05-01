package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.form.MemberRegistForm;

import lombok.Data;

@Data
public class MMember {

	public MMember() {
	}
	
	public MMember(MemberRegistForm memberRegistForm) {
		this.accountId = memberRegistForm.getAccountId();
		this.name = memberRegistForm.getName();
		this.furigana = memberRegistForm.getFurigana();
		this.updateTime = memberRegistForm.getUpdateTime();
	}

	private Integer accountId;
	private String name;
	private String furigana;
	private LocalDate updateTime;
    private LocalDate deleteDate;
    
    private TMember tMember;
}
