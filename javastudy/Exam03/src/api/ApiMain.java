package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApiMain {

	public static void main(String[] args) {
		/*
		- 상세구현

		- 1) 2021년 서울특별시 금천구의 사망교통사고정보를 모두 조회한다.

		- 2) 조회된 결과를 이용해서 accident.txt 파일을 생성한다. 파일의 경로는 작성하지 않는다. 예시 File file = new File("accident.txt");

		- 3) 다음 값을 저장할 수 있는 Accident 클래스를 생성한다.

		        String occrrncDt;  // 발생월일시 (2019011622) 

		        String occrrncDayCd;  // 발생요일코드 (4) 

		        int dthDnvCnt;  // 사망자수 (0) 

		        int injpsnCnt;  // 부상자수 (1) 

		- 4) 조회된 사고 1건의 정보는 Accident 객체에 저장한다. 조회된 사고 건수만큼 Accident 객체를 생성한다.

		- 5) 생성된 모든 Accident 객체를 컬렉션 ArrayList에 모두 저장한다.
		
		http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath?ServiceKey=서비스키&searc hYear=2019&siDo=1100&guGun=1116&numOfRows=20&pageNo=1
		*/
		
		String serviceKey = "dZ+C+trrp/h5sp64qpJRy2EE1s5Q/MMdAuKD0lqlkVAVa4u359df0o8+xDpP8YN8TyLdf0aIsyCiKUnIIe8xUw==";
		
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&numOfRows=20");
			urlBuilder.append("&pageNo=1");
					
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		
		File file = new File("accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		Accident accident = null;
		List<Accident> accidentList = new ArrayList<Accident>();
		
		// occrrnc_dt, occrrnc_day_cd, dth_dnv_cnt, injpsn_cnt
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			
			
			for(int i=0; i<items.getLength(); i++) {
				Element item = (Element) items.item(i);
				Node occrrncDt = item.getElementsByTagName("occrrnc_dt").item(0);
				Node occrrncDayCd = item.getElementsByTagName("occrrnc_day_cd").item(0);
				Node dthDnvCnt = item.getElementsByTagName("dth_dnv_cnt").item(0);
				Node injpsnCnt = item.getElementsByTagName("injpsn_cnt").item(0);
				
				String occrrncDtTc = occrrncDt.getTextContent();
				String occrrncDayCdTc = occrrncDayCd.getTextContent();
				int dthDnvCntTc = Integer.parseInt(dthDnvCnt.getTextContent());
				int injpsnCntTc = Integer.parseInt(injpsnCnt.getTextContent());
				
				accident = new Accident(occrrncDtTc, occrrncDayCdTc, dthDnvCntTc, injpsnCntTc);
				accidentList.add(accident);
			}
			for(int i=0; i<accidentList.size(); i++) {
				System.out.println(accidentList.get(i).toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
