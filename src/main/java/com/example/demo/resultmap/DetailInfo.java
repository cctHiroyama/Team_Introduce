package com.example.demo.resultmap;

import com.example.demo.entity.TMember;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DetailInfo extends TMember {
	
	/*
     * アカウントID
     */
	private Integer accountId;
	
	/*
     * チーム役割
     */
	private String teamPosition;
	
	/*
     * 出身地
     */
	private String birthPlace;
	
	/*
     * 趣味
     */
	private String hobby;
	
	/*
     * ひとこと
     */
	private String statusMessage;
}
