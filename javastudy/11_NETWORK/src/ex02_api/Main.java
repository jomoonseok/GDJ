package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

	// 요청 (어떤 데이터를 (처리)달라고 요청하는 것)
	// 1. Request
	// 2. 클라이언트가 서버측으로 보내는 데이터

	// 파라미터
	// 1. parameter
	// 2. 보내는 데이터(변수 개념)
	
	// 응답
	// 1. Response
	// 2. 서버가 클라이언트에게 보내는 데이터

	public static void m1() {

		// 전국종량제봉투가격표준데이터 

		
		// API 주소 (주소 + 요청 파라미터)
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			
			String serviceKey = "dZ+C+trrp/h5sp64qpJRy2EE1s5Q/MMdAuKD0lqlkVAVa4u359df0o8+xDpP8YN8TyLdf0aIsyCiKUnIIe8xUw==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("content-Type", "application/xml; charset=UTF-8"); // xml 데이터 요청
			                                     // text/html, application/json
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line=reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			// 스트림 종료
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		System.out.println(response);
		
		// 접속 종료
		con.disconnect();
		
		
		
	}

	public static void main(String[] args) {
		m1();

	}

}
