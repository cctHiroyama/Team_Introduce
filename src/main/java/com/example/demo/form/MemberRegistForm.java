package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.MMember;

import lombok.Data;

@Data
public class MemberRegistForm {
	
	private Integer accountId;
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	@Size(min=1, max=50)
	private String furigana;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate updateTime;
	
	public MemberRegistForm() {}
	
	public MemberRegistForm(MMember mMember) {
		this.accountId = mMember.getAccountId();
		this.name = mMember.getName();
		this.furigana = mMember.getFurigana();
		this.updateTime = mMember.getUpdateTime();
	}

}
