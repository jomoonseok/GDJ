package api;

public class Accident {
	private String occrrncDt; // 발생월일시 (2019011622)

	private String occrrncDayCd; // 발생요일코드 (4)

	private int dthDnvCnt; // 사망자수 (0)

	private int injpsnCnt; // 부상자수 (1)

	public Accident(String occrrncDt, String occrrncDayCd, int dthDnvCnt, int injpsnCnt) {
		super();
		this.occrrncDt = occrrncDt;
		this.occrrncDayCd = occrrncDayCd;
		this.dthDnvCnt = dthDnvCnt;
		this.injpsnCnt = injpsnCnt;
		
		switch(occrrncDayCd) {
		case "1" : this.occrrncDayCd = "일"; break;
		case "2" : this.occrrncDayCd = "월"; break;
		case "3" : this.occrrncDayCd = "화"; break;
		case "4" : this.occrrncDayCd = "수"; break;
		case "5" : this.occrrncDayCd = "목"; break;
		case "6" : this.occrrncDayCd = "금"; break;
		case "7" : this.occrrncDayCd = "토"; break;
		}
	}

	//발생일자 a b요일, 사망자수 c명, 부상자수 d명
	
	public String toString() {
		return "발생일자 " + occrrncDt + " " +occrrncDayCd + "요일, 사망자수 " + dthDnvCnt + "명, 부상자수 " + injpsnCnt;
	}

}
