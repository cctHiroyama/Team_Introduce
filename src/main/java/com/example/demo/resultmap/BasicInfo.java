package com.example.demo.resultmap;

import com.example.demo.entity.MMember;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BasicInfo extends MMember {
	/*
     * アカウントID
     */
	private Integer accountId;
	
	/*
     * 氏名
     */
	private String name;
	
	/*
     * 氏名（ふりがな）
     */
	private String furigana;
}
