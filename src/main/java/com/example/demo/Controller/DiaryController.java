package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Diary;
import com.example.demo.form.DiaryForm;
import com.example.demo.service.DiaryService;

@Controller
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	// 記事ページ
	@GetMapping("/diary/{articleId}")
	public String article(@ModelAttribute DiaryForm diaryForm, Model model, @PathVariable("articleId") Integer articleId) {
		Diary diary = diaryService.getfindbyArticle(articleId);
		model.addAttribute("diary", diary);
		return "diary";
	}
	
	// 新規投稿
	@GetMapping("/diary_post")
	public String getAdd(DiaryForm diaryForm, Model model) {
		model.addAttribute("diaryForm", diaryForm);
		return "diary_common";
	}
	@PostMapping("/diary_post")
	public String postMember (@Validated DiaryForm diaryForm, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return getAdd(diaryForm, model);
		}
		
		System.out.print(diaryForm);
		
		Diary diary = new Diary(diaryForm);
		
		diaryService.insert(diary);
		
		return "diary";
	}
	
	// 削除
	@GetMapping("/diary/{airticleId}/delete")
	public String index(@PathVariable("airticleId") Integer airticletId, Model model) {
		diaryService.delete(airticletId);
		return "redirect:/";
	}
	
	// 更新
	@GetMapping("/diary_edit/{articleId}")
	public String updateArticle(DiaryForm diaryForm, Model model,
			@PathVariable("articleId") Integer articleId) {
		Diary diaryEdit = diaryService.getfindbyId(articleId);
		System.out.print(diaryEdit);
		model.addAttribute("diaryEdit", diaryEdit);
		return "diary_edit";
	}

	@PostMapping("/diary_edit/{articleId}")
	public String updateDiary(@ModelAttribute Diary diary, Model model) {
		diaryService.updateDiary(diary.getArticleId(), diary.getTitle(), diary.getText());
		return "redirect:/";
	}
}
