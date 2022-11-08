package com.gdu.app11.mapper;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public void findAllEmployees(HttpServletRequest request, Model model) {
		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		/*
			          rownum 기준
			page    begin    end    totalRecord    실제end
			1         1         10   <  54               10       
			2         11        20   <  54               20
			3         21        30   <  54               30
			4         31        40   <  54               40
			5         41        50   <  54               50
			5         51        60   <  54               54
		*/
		
		int totalRecord = empMapper.selectAllEmplyeesCount();
		
		int recordPerPage = 10;
		int begin = (page - 1) * recordPerPage + 1;
		int end = begin + recordPerPage - 1;
		if(end > totalRecord) {
			end = totalRecord;
		}
		
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(begin, end);
		
		model.addAttribute("employees", employees);
		
		

	}

}
