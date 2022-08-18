package ex02_api;

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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
			con.setRequestMethod("GET"); // 생략가능
			con.setRequestProperty("content-Type", "application/xml; charset=UTF-8"); // xml 데이터 요청 / charset=UTF-8 생략가능
			// text/html, application/json
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 주소 접속 실패");
		}

		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			// 스트림 종료
			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		// API로부터 전달받은 xml 데이터
		String response = sb.toString();

		// File 생성
		File file = new File("C:\\storage", "api1.xml");
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// xml 분석
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			Element root = doc.getDocumentElement(); // <response> (최상위 태그)
			System.out.println(root.getNodeName());

			NodeList nodeList = root.getChildNodes(); // <response>의 자식 태그 <header>, <body>
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i); // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes(); // <header>의 자식태그 <resultCode>, <resultMsg>
															// <body>의 자식태그 <items>, <numOfRows>, <pageNo>, <totalCount>
				for (int j = 0; j < nodeList.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					if (node2.getNodeName().equals("items")) { // <items> 태그 대상
						NodeList items = node2.getChildNodes(); // <items>의 자식 태그<item>
						for (int k = 0; 0 < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChilren = item.getChildNodes(); // <item>의 자식 태그
							for (int l = 0; l < itemChilren.getLength(); l++) {
								Node itemChild = itemChilren.item(i);
								System.out.println(
										"        " + itemChild.getNodeName() + "," + itemChild.getTextContent());
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 접속 종료
		con.disconnect();
	}

	public static void m2() {
		
		String serviceKey = "dZ+C+trrp/h5sp64qpJRy2EE1s5Q/MMdAuKD0lqlkVAVa4u359df0o8+xDpP8YN8TyLdf0aIsyCiKUnIIe8xUw==";
		
		// API 주소 (주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=").append(URLEncoder.encode("20220808", "UTF-8"));
			urlBuilder.append("&endCreateDt=").append(URLEncoder.encode("20220812", "UTF-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();

		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
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
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		

		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		// File 생성
		File file = new File("C:\\storage", "api2.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m3() {
		// xml 파싱 이 과정 연습하기
		File file = new File("C:\\storage", "api2.xml");
		
		try {
			
			// api2.xml 문서 -> doc 객체로 만드는 과정
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			// api2.xml 문서의 최상위 태그 -> root
			Element root = doc.getDocumentElement();
			
			// <item>...</item> 태그 하나 == 특정 날짜의 데이터
			NodeList items = root.getElementsByTagName("item"); // 태그 이름으로 찾기 
			                    //getElements : 반환타입이 List이다. getElement는 하나 나온다.
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<items.getLength(); i++) {
				Node item = items.item(i);
				//System.out.println(item.getNodeName());
				NodeList itemChildren = item.getChildNodes();
				for(int j=0; j<itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					if(itemChild.getNodeName().equals("stateDt")) { // Node의 이름이 stateDT이냐
						sb.append(" 날짜 : ").append(itemChild.getTextContent());
					} else if(itemChild.getNodeName().equals("decideCnt")) {
						sb.append(" 확진자수 : ").append(itemChild.getTextContent());
					} else if(itemChild.getNodeName().equals("deathCnt")) {
						sb.append(" 사망자수 : ").append(itemChild.getTextContent());
					}
				}
				sb.append("\n");
				
				// Node stateDt             == <stateDt>20220812</stateDt>
				// stateDt.getNodeName()    == stateDt  (태그 이름)
				// stateDt.getTextContent() == 20220818 (태그 내부 텍스트)
				//Node stateDt = itemChildren.item(4); // 5번째 노드 / 이 방법은 내가 원하는 내용이 아닐 수도 있다.
				// 파일을 열고 엔터를 입력하면 내용이 바뀐다. / node의 이름으로 찾는게 좋다.
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void m4() {
		
		String serviceKey = "dZ+C+trrp/h5sp64qpJRy2EE1s5Q/MMdAuKD0lqlkVAVa4u359df0o8+xDpP8YN8TyLdf0aIsyCiKUnIIe8xUw==";
		
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&dataType=").append(URLEncoder.encode("XML", "UTF-8"));
			urlBuilder.append("&base_date=20220818");
			urlBuilder.append("&base_time=1100");
			urlBuilder.append("&nx=58");
			urlBuilder.append("&ny=125");
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
		
		File file = new File("C:\\storage", "api3.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m5() {
		
		File file = new File("C:\\storage", "api3.xml");
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for(int i=0; i<items.getLength(); i++) {
				//Node item = items.item(i);
				
				// Node(상위) - 태그, 줄 바꿈, ...
				//   Element(하위) - 태그 / getElementByTagName("category") - Element에서 지원
				// Node -> Element
				// 부모 -> 자식 (다운캐스팅)
				
				Element item = (Element)items.item(i); // Node -> Element 타입으로 다운캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T1H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				}
				System.out.println(strCategory + " : " + obsrValue.getTextContent());
				
				/*
				NodeList itemChildren = item.getChildNodes();
				for(int j=0; j<itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					if(itemChild.getNodeName().equals("category")) {
						//System.out.println(itemChild.getTextContent());
						if(itemChild.getTextContent().equals("PTY")) {
							System.out.println(itemChild.getTextContent());
						}
					}
				}
				*/
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m6() {
		
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
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
		
		File file = new File("C:\\storage", "api4.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m7() {
		
		File file = new File("C:\\storage", "api4.xml");
		StringBuilder sb = new StringBuilder();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			Node title = root.getElementsByTagName("title").item(0);
			sb.append(title.getTextContent() + "\n");
			
			Node pubDate = root.getElementsByTagName("pubDate").item(0);
			sb.append(pubDate.getTextContent() + "\n");
			
			NodeList data = root.getElementsByTagName("data");
			for(int i=0; i<data.getLength(); i++) {
				Element item = (Element)data.item(i);
				Node hour = item.getElementsByTagName("hour").item(0);
				sb.append(hour.getTextContent() + "시 ");
				
				Node temp = item.getElementsByTagName("temp").item(0);
				sb.append(temp.getTextContent() + "도 ");
				
				Node wfKor = item.getElementsByTagName("wfKor").item(0);
				sb.append(wfKor.getTextContent() + "\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
				
	}

	public static void m8() {
		// 태그의 속성값 꺼내는 법
		// 태그.getAttibute("속성") - 속성값을 준다.
		// 태그.getNodeName() 태그이름
		// 태그.getTextContent(); 내용
		File file = new File("C:\\storage", "sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();  // <current xmlns="current"> 태그
			//System.out.println(root.getNodeName());          태그 이름
			//System.out.println(root.getAttribute("xmlns"));  속성 값
			
			Element weather = (Element)root.getElementsByTagName("weather").item(0);
			sb.append(weather.getAttribute("year") + "년 ");
			sb.append(weather.getAttribute("month") + "월 ");
			sb.append(weather.getAttribute("day") + "일 ");
			sb.append(weather.getAttribute("hour") + "시\n");
			
			NodeList locals = root.getElementsByTagName("local");
			for(int i=0; i<locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent() + " ");
				sb.append(local.getAttribute("ta") + "℃ ");
				sb.append(local.getAttribute("desc") + "\n");
			}
			
			System.out.println(sb.toString());
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		m8();

	}

}
