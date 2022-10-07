package prac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Prac03A")
public class Prac03A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청
		request.setCharacterEncoding("UTF-8");
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String content = request.getParameter("content");

		// 파일명
		String filename = new Date(System.currentTimeMillis()) + "-" + from + ".txt";
		
		// 디렉터리 생성
		/*
		File dir = new File("../../webapp/storage"); // 예상경로와 다른곳에 폴더가 만들어짐 -> 잘못된 경로 
		if(dir.exists() == false) {                  // C:\GDJ\jspstudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01_Servlet\storage
			dir.mkdirs();                            // 톰켓에 만들어지는 진짜 경로
		}
		*/
		File dir = new File(request.getServletContext().getRealPath("storage")); // 진짜 경로를 찾아주는 코드 
		if(dir.exists() == false) {               
			dir.mkdirs();                            
		}
		
		// 파일 객체
		File file = new File(dir, filename);
		
		// 문자 출력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 출력
		bw.write("To. " + to + "\n");
		bw.write(content + "\n");
		bw.write("From. " + from + "\n");
		bw.close();
		
		// 이동
		response.sendRedirect("/01_Servlet/Prac03B?filename=" + URLEncoder.encode(filename, "UTF-8"));
		
		// 여기서 만들어진 파일은 아래의 서버탭에서 01_Servlet 지웠을 때 사라진다.(01_Servlet 자체가 사라짐)
		// 따라서 위 경로에 저장하는 것은 위험하다.

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
