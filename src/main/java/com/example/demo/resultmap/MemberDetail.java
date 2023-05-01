package com.example.demo.resultmap;

import com.example.demo.entity.MMember;
import com.example.demo.entity.TMember;

import lombok.Data;

@Data
public class MemberDetail {
	
	/**
     * 基本情報
     */
    private MMember basicInfo;
    
    /**
     * 詳細情報
     */
    private TMember detailInfo;


}
