package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.MemberRegistForm;
import com.example.demo.service.MemberRegistService;
import com.example.demo.entity.MMember;

@Controller
public class MemberRegistController {
	
	@Autowired
	MemberRegistService memberRegistService;
	
	@GetMapping("/member_regist")
	public String getAdd(MemberRegistForm memberRegistForm, Model model) {
		model.addAttribute("memberRegistForm", memberRegistForm);
		return "common";
	}
	
	@PostMapping("/member_regist")
	public String postMember (@Validated MemberRegistForm memberRegistForm, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return getAdd(memberRegistForm, model);
		}
		
		System.out.print(memberRegistForm);
		
		MMember member = new MMember(memberRegistForm);
		
		memberRegistService.save(member);
		
		return "redirect:/";
	}
}
