package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Diary;
import com.example.demo.entity.MMember;
import com.example.demo.entity.TMember;
import com.example.demo.form.DiaryForm;
import com.example.demo.form.MemberListForm;
import com.example.demo.resultmap.MemberDetail;
import com.example.demo.service.DiaryService;
import com.example.demo.service.MemberDetailRegistService;
import com.example.demo.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService memberListService;
	
	@Autowired
	DiaryService diaryService;

	@Autowired
	MemberDetailRegistService memberDetailRegistService;

	
	@GetMapping("/")
	public String index(MemberListForm memberListForm, DiaryForm diaryForm, Model model) {
		
		List<MMember> memberList = memberListService.getMemberList();
		List<Diary> diaries = diaryService.getDiaries();
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("diaries", diaries);
		return "team_introduce";
	}

	@GetMapping("/member_detail/{accountId}")
	public String index(@ModelAttribute MemberListForm memberListForm, Model model,
			@PathVariable("accountId") Integer accountId) {
		MemberDetail memberDetail = memberListService.findDetailbyAccountId(accountId);
		if (memberDetail != null) {
			System.out.print("登録あり");
			model.addAttribute("memberDetail", memberDetail);
			return "member_detail";
		} else {
			System.out.print("登録なし");
			return "redirect:/member_detailRegist/{accountId}";
		}
	}

	@GetMapping("/member_list/{accountId}/delete")
	public String index(@PathVariable("accountId") Integer accountId, Model model) {
		memberListService.delete(accountId);
		memberDetailRegistService.delete(accountId);
		return "redirect:/";
	}

	@GetMapping("/member_basicEdit/{accountId}")
	public String updateBasic(MemberListForm memberListForm, Model model,
			@PathVariable("accountId") Integer accountId) {
		MMember basicEdit = memberListService.getfindbyId(accountId);
		System.out.print(accountId);
		model.addAttribute("basicEdit", basicEdit);
		return "member_basicEdit";
	}

	@PostMapping("/member_basicEdit/{accountId}")
	public String updateMMember(@ModelAttribute MMember memberInfo, Model model) {
		memberListService.updateTMember(memberInfo.getAccountId(), memberInfo.getFurigana(), memberInfo.getName());
		return "redirect:/";
	}

	@GetMapping("/member_detailEdit/{accountId}")
	public String updateDetail(MemberListForm memberListForm, Model model,
			@PathVariable("accountId") Integer accountId) {
		TMember detailEdit = memberListService.getfindbyAccountId(accountId);
		System.out.print(detailEdit);
		model.addAttribute("detailEdit", detailEdit);
		return "member_detailEdit";
	}

	@PostMapping("/member_detailEdit/{accountId}")
	public String updateTMember(@ModelAttribute TMember memberDetail, Model model) {
		memberListService.updateTMember(memberDetail.getAccountId(), memberDetail.getTeamPosition(), memberDetail.getBirthPlace(),
				memberDetail.getHobby(), memberDetail.getStatusMessage());
		return "redirect:/member_detail/{accountId}";
	}
}
