package com.example.demo.form;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class MemberDownloadForm {
	
	List<Integer> accountId;
	
	List<String> name;
	
	List<String> teamPosition;
	
	List<LocalDate> updateTime;
	
}
