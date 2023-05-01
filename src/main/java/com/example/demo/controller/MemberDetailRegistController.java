package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.TMember;
import com.example.demo.form.MemberDetailRegistForm;
import com.example.demo.service.MemberDetailRegistService;

@Controller
public class MemberDetailRegistController {
	
	@Autowired
	MemberDetailRegistService memberDetailRegistService;
	
	@GetMapping("/member_detailRegist/{accountId}")
	public String index(MemberDetailRegistForm memberDetailRegistForm, Model model) {
		model.addAttribute("memberDetailRegistForm", memberDetailRegistForm);
		return "detail_common";
	}
	
	@PostMapping("/member_detailRegist/{accountId}")
	public String index(@Validated MemberDetailRegistForm memberDetailRegistForm, BindingResult result, Model model, @PathVariable("accountId")Integer accountId) {
		if(result.hasErrors()) {
			return index(memberDetailRegistForm, model);
		}
		
		System.out.print(memberDetailRegistForm);
		
		TMember memberDetail = new TMember(memberDetailRegistForm);
		
		memberDetailRegistService.insert(memberDetail);
		
		return "redirect:/member_detail/{accountId}";
	}
}
