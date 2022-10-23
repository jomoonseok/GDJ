package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		int result = BoardDAO.getInstance().updateBoard(board);
		
		
		return new ActionForward("board/updateResult.jsp?result=" + result + "&no=" + no, true);
	}

}
