package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	
	
	@ResponseBody
	@GetMapping(value="/list.json", produces="application/json; charset=UTF-8")
	public List<StaffDTO> list(){
		return staffService.getStaffList();
	}
	
	
	
	@ResponseBody
	@PostMapping(value="/add", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add(HttpServletRequest request){
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		
		StaffDTO staff = new StaffDTO(sno, name, dept, 0);
		
		return staffService.addStaff(staff);
	}
	/*
		다른 방법
		1.
		public ResponseEntity<String> add(@RequestParam(value="sno") String sno
			                        , @RequestParam(value="name", required=false) String name
			                        , @RequestParam(value="dept") String dept){
		StaffDTO staff = new StaffDTO(sno, name, dept, 0);
		return staffService.addStaff(staff);
		}
		
		2.
		public ResponseEntity<String> add(StaffDTO staff){
			return staffService.addStaff(staff);
		}
		
		HttpServletRequest가 범용성이 제일 좋다.
	 */
	
	
	
	@ResponseBody
	@GetMapping(value="/select", produces="application/json; charset=UTF-8")
	public ResponseEntity<Object> select(HttpServletRequest request) {
		String query = request.getParameter("query");
		return staffService.getStaff(query);
	}
	
	
	
}
