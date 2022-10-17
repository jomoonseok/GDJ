package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class RectangleService implements MyService{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		double width = Double.parseDouble(request.getParameter("width"));
		double height = Double.parseDouble(request.getParameter("height"));
		
		request.setAttribute("width", width);
		request.setAttribute("height", height);
		request.setAttribute("area", width*height);
		request.setAttribute("shape", "rectangle");
		
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false);
		
		
		return actionForward;
	}

}
