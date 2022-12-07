package com.gdu.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;

@Service
public class MemverServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		// 어떤 예외가 오는지 확인하기 1. unique가 아닐 때 2. byte를 초과했을 때 3. not null인데 null값이 왔을 때
		try {
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("insertREsult", memberMapper.insertMember(member));
			return result;
		} catch(DuplicateKeyException e) {
			
		} catch(Exception e) {
			System.out.println(e.getClass().getName());
		}
		return null;
	}
	
}
