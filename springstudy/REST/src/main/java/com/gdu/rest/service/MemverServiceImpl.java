package com.gdu.rest.service;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;
import com.gdu.rest.util.PageUtil;

@Service
public class MemverServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		// 어떤 예외가 오는지 확인하기 1. unique가 아닐 때 2. byte를 초과했을 때 3. not null인데 null값이 왔을 때
		try {
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("insertResult", memberMapper.insertMember(member));
			return result;
		} catch(DuplicateKeyException e) { // 아이디 중복
			try {
				response.setContentType("text/html charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(501); // 응답 코드 501
				out.println("이미 사용 중인 아이디 입니다.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		} catch(DataIntegrityViolationException e) { //DataIntegrityViolationException
			try {
				response.setContentType("text/html charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(502); // 응답 코드 502
				out.println("필수 정보가 누락되었습니다.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		} catch(Exception e) {
			try {
				response.setContentType("text/html charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(503); // 응답 코드 503
				out.println("입력 정보를 확인하세요.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	@Override
	public Map<String, Object> getMemberList(int page) {
		
		int totalRecord = memberMapper.selectMemberCount();
		pageUtil.setPageUtil(page, totalRecord);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("memberList", memberMapper.selectMemberListByMap(map));
		result.put("pageUtil", pageUtil);
		
		return result;
	}
	
	
	
	@Override
	public Map<String, Object> getMemberByNo(int memberNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("member", memberMapper.selectMemberByNo(memberNo));
		return result;
	}
	
	
	
	@Override
	public Map<String, Object> modifyMember(Map<String, Object> map, HttpServletResponse response) {
		
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("updateResult", memberMapper.updateMember(map));
			return result;
		} catch(DataIntegrityViolationException e) {
			try {
				response.setContentType("text/plain; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(501); // 응답코드
				out.println("필수 정보가 누락되었습니다.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		} catch(Exception e) {
			try {
				response.setContentType("text/html charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(502); // 응답 코드 502
				out.println("입력 정보를 확인하세요.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	
	@Override
	public Map<String, Object> removeMemberList(String memberNoList) {
		List<String> list = Arrays.asList(memberNoList.split(","));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("deleteResult", memberMapper.deleteMemberList(list));
		return result;
	}
	
}
