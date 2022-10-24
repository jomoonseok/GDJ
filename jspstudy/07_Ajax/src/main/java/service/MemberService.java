package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// ajax : 페이지 이동이 없는 방식 / 페이지 이동이 있으면 MVC패턴으로 동작
}
