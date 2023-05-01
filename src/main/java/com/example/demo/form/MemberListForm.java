package com.example.demo.form;

import java.util.List;

import com.example.demo.entity.MMember;
import com.example.demo.resultmap.MemberDetail;

import lombok.Data;

@Data
public class MemberListForm {
	// メンバー一覧
    private List<MMember> memberList;
    
    // メンバー詳細情報
 	private MemberDetail memberDetail;
}
