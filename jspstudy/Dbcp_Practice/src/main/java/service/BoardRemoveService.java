package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		long no = Long.parseLong(opt.orElse("0"));
		
		int result = BoardDAO.getInstance().deleteBoard(no);
		
		return new ActionForward("board/deleteResult.jsp?result=" + result, true);
	}

}
