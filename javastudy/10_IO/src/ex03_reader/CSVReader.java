package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static void main(String[] args) {
		
		File file = new File("C:\\storage", "product.csv");
		
		try( BufferedReader br = new BufferedReader( new FileReader(file))) {
			// 첫 행 읽어 버리기 - 그냥 읽기만 하고 저장은 하지 않는다.
			br.readLine(); // readLine() 실행할 때 마다 한 줄씩 읽어온다.
			
			// 한 줄 읽어서 Product 객체 생성하고ArrayList에 저장하기
			List<Product> products = new ArrayList<Product>();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Product product = new Product();
				product.setNumber(arr[0]);
				product.setName(arr[1]);
				product.setPrice(Integer.parseInt(arr[2]));
				products.add(product);
			}
			
			// ArrayList 확인
			for(Product product : products) {
				System.out.println(product);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
