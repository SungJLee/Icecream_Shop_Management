package icecreamshopmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class main {
	
	/*
	   * @ 메소드명 : AddIcecream
	   * @ breif  : 아이스크림 상품을 추가시키는 기능
	   * @ detail : 아이스크림 상품항목을 jsonObject에 저장해서 return해준다
	   * @ 작성자   : 이성재
	   * @ 작성일자 :2021 - 06 - 10
	   * @ return : (JSONObject (상품id , name(이름) , price(가격) , flavor(맛) ))
	   * @ why    : Icecream클래스 생성자를 이용해서 JSONObject 객체에 저장해 리턴해서 그걸 JSONArray에 넣기 위해 이렇게 만들었습니다. 
	*/
	
	public JSONObject AddIcecream() {
		Scanner scanf = new Scanner(System.in);
		String tempId = scanf.nextLine();
		String tempName = scanf.nextLine();
		String tempPrice = scanf.nextLine();
		String tempFlavor = scanf.nextLine();
		
		Icecream icecream = new Icecream(tempId,tempName, tempPrice,tempFlavor);
		
		JSONObject obj1 = new JSONObject();
	  	obj1.put("id",tempId);
	  	obj1.put("name",tempName);
	  	obj1.put("price",tempPrice);
	  	obj1.put("flavor",tempFlavor);
	  	
	  	return obj1;
	}

	/*
	* @ 메소드명  : ShowProducts
	* @ breif  : 상품을 조회하는 기능
	* @ detail : 상품명으로 검색해서 해당 상품명이 있으면 jsonArray를  그 상품에 id랑 상품명 사이즈 색 종류를 출력시켜준다
	* @ 작성자   : 이성재
	* @ 작성일자 : 2021 - 06 - 10
	* @ param  : 상품목록이 들어가있는 jsonArray객체를 조회하기 위해 받아옴(JSONArray jsonArray)
	* @ why    : 상품명이 어디 인덱스에 있는지 잘 모르기 때문에 전체를 돌아서 해당 값을 찾아서 그 jsonObject에 해당 값들을 출력하기 위해 이렇게 만들었습니다.
	*/
	
	public void ShowProducts(JSONArray jsonArray) {
		  Scanner scanf = new Scanner(System.in);
		  String checkName = scanf.nextLine();
		  Iterator it2 = jsonArray.iterator();
			while(it2.hasNext()) {
		  		JSONObject o = (JSONObject)it2.next();
		  		if(o.get("name").equals(checkName)) {
		  			String jsonId = o.get("id").toString();
		      		String jsonName = o.get("name").toString();
		      		String jsonPrice = o.get("price").toString();
		      		String jsonFlavor = o.get("flavor").toString();
		      		System.out.println("상품id : " + jsonId + " 상품명 : " + jsonName + " 가격 : " + jsonPrice + " 맛 : " + jsonFlavor);
		      		break;
		  		}
			}
    }
	
	
	public void ShowProductsAll(JSONArray jsonArray) {
		  
		  Iterator it2 = jsonArray.iterator();
			while(it2.hasNext()) {
		  		JSONObject o = (JSONObject)it2.next();
		  		String jsonId = o.get("id").toString();
	      		String jsonName = o.get("name").toString();
	      		String jsonPrice = o.get("price").toString();
	      		String jsonFlavor = o.get("flavor").toString();
	      		System.out.println("상품id : " + jsonId + " 상품명 : " + jsonName + " 가격 : " + jsonPrice + " 맛 : " + jsonFlavor);
			}
  }
		
	/*
	 * @ 메소드명 : DeleteProducts
	 * @ breif  : 상품을 삭제하는 기능
	 * @ detail : 상품명으로 검색해서 해당 상품명이 있으면 jsonArray를 그 상품을 삭제한다
	 * @ 작성자   : 이성재
	 * @ 작성일자 : 2021 - 06 - 10
	 * @ param  : 상품목록이 들어가있는 jsonArray객체를 조회하기 위해 받아옴(JSONArray jsonArray)
	 * @ why    : 상품명이 어디 인덱스에 있는지 잘 모르기 때문에 전체를 돌아서 해당 값을 찾아서 그 jsonObject에 해당하는 걸 삭제하기 위해서 이렇게 만들었습니다.
	 */
			
	public void DeleteProducts(JSONArray jsonArray) {
		int sum = 0;
		int count = 0;
			  
		Scanner scanf = new Scanner(System.in);
		String checkName = scanf.nextLine();
		Iterator it2 = jsonArray.iterator();
				  
		while(it2.hasNext()) {
				
			JSONObject o = (JSONObject)it2.next();
			if(o.get("name").equals(checkName)) {
		 	
				jsonArray.remove(count);
			  	break;
		
			}
			
			count++;
		}
	}
			


	/*
	* @ 메소드명  : count
	* @ breif  : 상품을 계산하는 함수
	* @ detail : 
	* @ 작성자   : 이성재
	* @ 작성일자 :  2021 - 06 -010
	* @ return : (JSONObject (상품id , name , size , color , type))
	* @ why    : Top클래스 생성자를 이용해서 JSONObject 객체에 저장해 리턴해서 그걸 JSONArray에 넣기 위해 이렇게 만들었습니다. 
	*/
	
	public int count(JSONArray jsonArray) {
		int count = 0;
		int sum = 0;
		
		  
		Scanner scanf = new Scanner(System.in);
		String checkId = scanf.nextLine();
		Iterator it2 = jsonArray.iterator();
				  
		while(it2.hasNext()) {
				
			JSONObject o = (JSONObject)it2.next();
			if(o.get("id").equals(checkId)) {
				String tempPrice = o.get("price").toString();
				sum += Integer.parseInt(tempPrice);
				break;
			}
			
			count++;
		}
		
		return sum;
	}
	
	/*
	   * @ 메소드명 	: SaveJson
	   * @ breif  	: Json파일을 저장하는 기능
	   * @ detail 	: jsonObject에 저장된 내용을 선언한 위치에 Json파일로 내보냅니다.
	   * @ 작성자   	: 신희빈
	   * @ param  	: 상품목록이 들어가있는 jsonArray객체를 저장하기 위해 받아옴(JSONArray jsonArray)
	   * @ why   	: JSONArray에 저장되어있는 값을 Json파일로 저장하기 위해 만들었습니다.
	   * @ 작성일자 	: 2021 - 06 -10
	   */
	  
	  public void SaveJson(JSONArray jsonArray) throws IOException {
		  JSONObject jObj = new JSONObject();			// json오브젝트 저장하기위해 선언
			jObj.put("Icecream", jsonArray);				// 출력 할때 앞에 "Dress"가 붙도록
			FileWriter writer = new FileWriter("src/json/mydata.json");	// json파일 저장할 위치
			writer.write(jObj.toJSONString());	//String 형태로 저장
			writer.flush();
			writer.close();
	  }
	  
	  /*
	   * @ 메소드명 	: GetJson
	   * @ breif  	: Json파일을 불러오는기능
	   * @ detail 	: 선언한 위치에  Json파일로 불러옵니다.
	   * @ 작성자   	: 신희빈
	   * @ param  	: 상품목록이 들어가있는 jsonArray객체를 불러오기 위해 받아옴(JSONArray jsonArray)
	   * @ why   	: Json파일에 저장되어있는 JsonArray 값을 불러오기 위해 만들었습니다.
	   * @ 작성일자 	: 2021 - 06 -10
	   */
	  
	 public void GetJson(JSONArray jsonArray) throws IOException, org.json.simple.parser.ParseException  {
		 	JSONParser parser = new JSONParser();		// json파일 파싱하기위해 선언
			Object obj = parser.parse(new FileReader("src/json/mydata.json"));	// 불러올 json 파일 위치선언
			System.out.println(obj);	// json 파일 호출
	 }
	
  public static void main(String[] args) throws IOException,org.json.simple.parser.ParseException {

	main Main = new main();
  	JSONArray jsonArray = new JSONArray();
    boolean swi = true; 
    
		while(swi){
		    System.out.println("-------------------------------------");
			System.out.println("1. 상품 추가 ");
			System.out.println("2. 상품 제거");
			System.out.println("3. 상품 부분조회");
			System.out.println("4. 메뉴 보기");
			System.out.println("5. 계산");
		    System.out.println("6. 포장");
		    System.out.println("7. json 내보내기");
		    System.out.println("8. json 불러오기");
				
	      
			Scanner scan = new Scanner(System.in); 
	
			Scanner scanf = new Scanner(System.in); 
			System.out.print("> ");
			int choice = scan.nextInt();
		
	        switch(choice){
	                case 1:
	                	System.out.println("아이스크림 항목을 추가합니다.");
	                	System.out.println("Id , 이름 ,  가격 , 맛");           
	                	jsonArray.add(Main.AddIcecream());
	                	break;
			        case 2:
			        	System.out.println("항목을 제거합니다.");
			        	System.out.println("상품 Id값을 입력해주세요");
			        	Main.DeleteProducts(jsonArray);
			        	break;
	          
					case 3: 
						System.out.println("조회할 상품 이름을 입력하세요");
						Main.ShowProducts(jsonArray);
						break;
	
					case 4:
						Main.ShowProductsAll(jsonArray);
						break;
	          
					case 5:
						int tempSum = 0;
						
						Main.ShowProductsAll(jsonArray);
						tempSum += Main.count(jsonArray);
						System.out.println("살 상품 id를 입력하세요");
						
						while(true) {
							System.out.println("더 사시겠습니까? Y : 1 , N : 2");
							Main.ShowProductsAll(jsonArray);
							int buyingChoice = scanf.nextInt();
							
							if(buyingChoice == 1) {
								tempSum += Main.count(jsonArray);
							}else if (buyingChoice == 2) {
								break;
							}
						}
						System.out.println("총 " + tempSum + "원 입니다.");
						break;
	
					case 6: 
						Main.SaveJson(jsonArray);
						break;
	
					case 7 : // 나가기
						Main.GetJson(jsonArray);
						break;
					default :
						System.out.println("잘못 입력하셨습니다.");
						break;
				}
		}
  	}
}
