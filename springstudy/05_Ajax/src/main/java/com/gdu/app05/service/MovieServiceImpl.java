package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MovieServiceImpl implements MovieService {

	// field
	private final String key = "3812b33ce196899b278553da67d7d7b1";
	
	
	@Override
	public String getBoxOffice(String targetDt) {
		// API 요청 및 응답
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		
		String result = null;
		
		try {
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			
			con.setRequestProperty("key", key);
			con.setRequestProperty("targetDt", targetDt);
			
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			result = sb.toString();
			
			reader.close();
			con.disconnect();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
