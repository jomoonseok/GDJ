package ex03_parameter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 10/7

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		// 변수(파라미터)
		String id = request.getParameter("id");
		if(id == null || id.isEmpty()) { // id가 null값을 가진다면 id.isEmpty()는 null.isEmpty()가 되고 NullPointException이 된다. 그래서 Null 체크를 먼저 해야된다. 
			id = "빈아이디";
		}
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		String gender = request.getParameter("gender"); // redio, checkbox는 체크하지 않으면 가지 않는다.(null)
		if(gender == null) {
			gender = "빈 성별";
		}
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "빈 도시";
		}
		
		// 배열(파라미터)
		String[] phone = request.getParameterValues("phone");
		if(phone[0].isEmpty()) {
			phone[0] = "빈 전화1";
		}
		if(phone[1].isEmpty()) {
			phone[1] = "빈 전화2";
		}
		if(phone[2].isEmpty()) {
			phone[2] = "빈 전화3";
		}
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];
			agree[0] = "빈 동의";
		}
		
		// 데이터를 전송할 때 입력하지 않았거나 체크하지 않은 데이터를 처리할 때는 front와 back 둘 다하는 게 좋다.
		
		// 이메일
		String emailId = request.getParameter("email_id");
		String domain = request.getParameter("domain");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>아이디 : " + id + "</h3>");
		out.println("<h3>비밀번호 : " + pwd + "</h3>");
		out.println("<h3>성별 : " + gender + "</h3>");
		out.println("<h3>도시 : " + city + "</h3>");
		out.println("<h3>연락처 : " + strPhone + "</h3>");
		out.println("<h3>동의여부 : " + Arrays.toString(agree) + "</h3>");
		out.println("<h3>이메일 : " + emailId + "@" + domain + "</h3>");
		List<String> list = Arrays.asList(agree);
		if(list.contains("marketing")) {
			out.println("<h3>마케팅 동의한 회원</h3>");
		}
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
