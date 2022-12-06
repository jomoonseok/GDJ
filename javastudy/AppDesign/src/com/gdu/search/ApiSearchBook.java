package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId = "ymBUOS66J0o3pUpDZezX";
		String clientSecret = "8toAWv3hNm";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			String query = sc.nextLine();
					
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + URLEncoder.encode(query, "UTF-8");
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			
			File dir = new File("C:/download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, query + ".html");
			
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>검색결과</title>");
			out.println("</head>");
			out.println("<body>");
			JSONArray items = obj.getJSONArray("items");
			for(int i=0; i<items.length(); i++) {
				String title = items.getJSONObject(i).get("title").toString().replace(query, "<strong>" + query + "</strong>");
				out.println("<div>");
				out.println("<a href='" + items.getJSONObject(i).get("link") + "'>" + title + "</a>");
				out.println("</div>");
				out.println("<div>");
				out.println("<img width='50px' src='" + items.getJSONObject(i).get("image") + "'>");
				out.println("</div>");
				out.println("<hr>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			System.out.println("성공");
			
		} catch(Exception e) {
			
			try {
				
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt ");
				PrintWriter out = new PrintWriter(file);
				long lastModifiedDate = file.lastModified();
				String lastModified = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss ").format(lastModifiedDate);
				out.println("예외메시지       " + e.getMessage());
				out.println("예외발생시간     " + lastModified);
				out.close();
				System.out.println("실패");
				
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
}
