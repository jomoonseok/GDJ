package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {
	
	public void findAllEmployees(HttpServletRequest request, Model model); // request, response, session, model의 선언은 controller에서만 가능하다.
	
	public void findEmployees(HttpServletRequest request, Model model);
	
	public Map<String, Object> findAutoCompleteList(HttpServletRequest request);
}
