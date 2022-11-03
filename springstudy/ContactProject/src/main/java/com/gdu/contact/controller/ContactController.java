package com.gdu.contact.controller;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.contact.domain.Contact;
import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("contacts", contactService.findAllContact());
		return "list";
	}
	
	
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	
	
	@GetMapping("add")
	public String add(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/insert?no=" + contact.getNo();
	}
	
	
	
	@RequestMapping("insert")
	public void insert(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("no"));
		Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		int no = Integer.parseInt(opt.orElse("1"));
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('연락처가 등록되었습니다.');");
			out.println("location.href='" + request.getContextPath() + "/edit?no=" + no + "';");
			out.println("</script>");
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@GetMapping("edit")
	public String edit(int no, Model model) {
		model.addAttribute("contact", contactService.findContactByNo(no));
		return "edit";
	}
	
	
	
	@GetMapping("modify")
	public String modify(Contact contact) {
		contactService.modifyContact(contact);
		return "redirect:/edit?no=" + contact.getNo();
	}
	
	@PostMapping("remove")
	public String remove(int no) {
		contactService.removeContact(no);
		return "redirect:/delete";
	}
	
	
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('연락처가 삭제되었습니다.');");
			out.println("location.href='" + request.getContextPath() + "'");
			out.println("</script>");
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
