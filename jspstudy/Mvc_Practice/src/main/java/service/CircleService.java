package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class CircleService implements MyService{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		double radius = Double.parseDouble(request.getParameter("radius"));
		
		request.setAttribute("radius", radius);
		request.setAttribute("area", radius*radius*3.14);
		request.setAttribute("shape", "circle");
		
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false);
		
		
		return actionForward;
	}

}
