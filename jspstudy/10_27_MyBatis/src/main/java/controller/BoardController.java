package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardAddService;
import service.BoardDetailService;
import service.BoardEditService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardDeleteService;
import service.BoardService;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());

		// BoardService 객체
		BoardService service = null;

		// ActionForward 객체
		ActionForward af = null;

		// 요청에 따른 Service 선택
		switch (urlMapping) {
		case "/board/list.do":
			service = new BoardListService();
			break;
		case "/board/add.do":
			service = new BoardAddService();
			break;
		case "/board/detail.do":
			service = new BoardDetailService();
			break;
		case "/board/edit.do":
			service = new BoardEditService();
			break;
		case "/board/modify.do":
			service = new BoardModifyService();
			break;
		case "/board/delete.do":
			service = new BoardDeleteService();
			break;
			
		case "/board/write.do":
			af = new ActionForward("/board/write.jsp", false);
			break;
		}

		// 선택된 Service 실행
		try {
			if (service != null) {
				af = service.execute(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 어디로 / 어떻게
		if (af != null) {
			if (af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
