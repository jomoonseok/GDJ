package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
	
	public void findAllBbsList(HttpServletRequest request, Model model); // request, response, session, model의 선언은 controller에서만 가능하다.
	
	public int addBbs(HttpServletRequest request);
	
	public int addReply(HttpServletRequest request);
	
	public int removeBbs(int nnsNo);
	
}
