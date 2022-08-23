package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;


public class Main {

	public static void main(String[] args) {
		
		// XML 파싱
		// API응답(XML) -> XML파일 -> Document
		
		// JSON
		// API응답(JSON) -> JSONObject / 파일 생성 과정이 필요없다.
		
		// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000

		try {
			
			String APIurl = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL url = new URL(APIurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//con.setRequestMethod("GET"); // 안 적어도 GET 방식으로 실행
			//con.setRequestProperty("content-Type", "application/xml; UTF-8"); // 안 적어도 실행 됨
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			File file = new File("text.txt"); // 경로없이 사용하면 프로젝트에 생긴다.
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// StringBuilder에 저장된 응답(XML)을 JSON으로 변경하기
			/*
			JSONObject obj = XML.toJSONObject(sb.toString());
			JSONObject rss = obj.getJSONObject("rss");
			JSONObject channel = rss.getJSONObject("channel");
			*/
			JSONObject channel = XML.toJSONObject(sb.toString()).getJSONObject("rss").getJSONObject("channel");
			
			// channel에 있는 데이터
			String link = channel.getString("link");
			String description = channel.getString("description");
			String generator = channel.getString("generator");
			String language = channel.getString("language");
			String title = channel.getString("title");
			String pubDate = channel.getString("pubDate");
			//System.out.println(link + description + generator + language + title + pubDate);
			JSONObject item = channel.getJSONObject("item");
			
			String author = item.getString("author");
			String link2 = item.getString("link");
			String category = item.getString("category");
			String title2 = item.getString("title");
			JSONObject description2 = item.getJSONObject("description");
			
			JSONObject body = description2.getJSONObject("body");
			
			JSONArray dataList = body.getJSONArray("data");
			
			bw.write(pubDate + "\n");
			bw.write(category + "\n");
			for(int i=0; i<dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				int sky = data.getInt("sky");
				int temp = data.getInt("temp");
				String wfKor = data.getString("wfKor");
				int wd = data.getInt("wd");
				int hour = data.getInt("hour");
				bw.write(hour + "시, " +temp + "도, " + wfKor + "\n");
				
			}
			
			
			
			// 메소드 체이닝하는게 좋다. 실제 개발은 위에 코드처럼 쓰지 않는다.
						
			bw.close();
			br.close();
			con.disconnect();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
