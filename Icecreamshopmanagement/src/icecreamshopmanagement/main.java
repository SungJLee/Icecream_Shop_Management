package icecreamshopmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class main {
	/*
	   * @ 메소드명 : SaveJson
	   * @ breif  : Json파일을 저장하는 기능
	   * @ detail : jsonObject에 저장된 내용을 선언한 위치에 Json파일로 내보냅니다.
	   * @ 작성자   : 신희빈
	   * @ 작성일자 : 2021 - 06 -10
	   */
	  
	  public void SaveJson(JSONArray jsonArray) throws IOException {
		  JSONObject jObj = new JSONObject();			// json오브젝트 저장하기위해 선언
			jObj.put("Dress", jsonArray);				// 출력 할때 앞에 "Dress"가 붙도록
			FileWriter writer = new FileWriter("src/json/mydata.json");	// json파일 저장할 위치
			writer.write(jObj.toJSONString());	//String 형태로 저장
			writer.flush();
			writer.close();
	  }
	  
	  
		  
  public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException{

	main Main = new main();
  	JSONArray jsonArray = new JSONArray();
    boolean swi = true; 
		while(swi){
    System.out.println("-------------------------------------");
	System.out.println("1. ");
	System.out.println("2. ");
	System.out.println("3. ");
	System.out.println("4. json으로 파일 저장하기");
	System.out.println("5. ");
    System.out.println("7. 나가기");
			
      
		Scanner scan = new Scanner(System.in); 

		Scanner scanf = new Scanner(System.in); 
		System.out.print("> ");
		int choice = scan.nextInt();
		
        switch(choice){
                case 1:
                	
                	break;
		        case 2:
		        	
		        	break;
          
				case 3: 
				
					break;

				case 4:
					System.out.println("파일을 내보냅니다.");
					Main.SaveJson(jsonArray);
					break;
          
				case 5:
					break;

				case 6: 
					break;

				case 7 : // 나가기
					swi = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
    }
  }
}
