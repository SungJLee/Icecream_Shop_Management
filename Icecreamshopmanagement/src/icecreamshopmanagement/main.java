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
	   * @ 메소드명  : AddIcecream
	   * @ breif  : 아이스크림 상품을 추가시키는 기능
	   * @ detail : 아이스크림 상품항목을 jsonObject에 저장해서 return해준다
	   * @ 작성자   : 이성재
	   * @ 작성일자  : 2021 - 06 - 10
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
	* @ 작성일자  : 2021 - 06 - 10
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
	
	/*
	* @ 메소드명  : ShowProductsAll
	* @ breif  : 상품을 전체 조회하는 기능
	* @ detail : 상품명으로 검색해서 해당 상품명이 있으면 jsonArray를  그 상품에 id랑 상품명 사이즈 색 종류를 출력시켜준다
	* @ 작성자   : 이성재
	* @ 작성일자  : 2021 - 06 - 10
	* @ param  : 상품목록이 들어가있는 jsonArray객체를 조회하기 위해 받아옴(JSONArray jsonArray)
	* @ why    : 전체 jsonArray에 jsonObject값을 출력하기 위해 만들었습니다.
	*/
	
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
	 * @ 메소드명  : DeleteProducts
	 * @ breif  : 상품을 삭제하는 기능
	 * @ detail : 상품명으로 검색해서 해당 상품명이 있으면 jsonArray를 그 상품을 삭제한다
	 * @ 작성자   : 이성재
	 * @ 작성일자  : 2021 - 06 - 10
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
	* @ detail : 상품명을 입력해서 상품의 id값하고 일치하는 가격을 가져와서 리턴해줍니다.
	* @ 작성자   : 이성재
	* @ 작성일자  : 2021 - 06 -010
	* @ param  : 상품목록이 들어가있는 jsonArray객체를 조회하기 위해 받아옴(JSONArray jsonArray)
	* @ return : 상품의 가격입니다.
 	* @ why    : 계산할 떄 상품의 가격이 필요하기 때문에 그 해당 id값에 해당하는 물품의 가격을 찾는 과정이 필요해 만들었습니다.
	*/
	
	public int count(JSONArray jsonArray) {
		int count = 0;
		int price = 0;
		
		  
		Scanner scanf = new Scanner(System.in);
		String checkId = scanf.nextLine();
		Iterator it2 = jsonArray.iterator();
				  
		while(it2.hasNext()) {
				
			JSONObject o = (JSONObject)it2.next();
			if(o.get("id").equals(checkId)) {
				String tempPrice = o.get("price").toString();
				price += Integer.parseInt(tempPrice);
				break;
			}
			
			count++;
		}
		
		return price;
	}
	
	  /*
	   * @ 메소드명  : SaveJson
	   * @ breif  : Json파일을 저장하는 기능
	   * @ detail : jsonObject에 저장된 내용을 선언한 위치에 Json파일로 내보냅니다.
	   * @ 작성자   : 신희빈
	   * @ 작성일자  : 2021 - 06 -10
	   * @ why    : 상품목록들을 Json파일로 저장하기 위해서 만들었습니다.
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
	   * @ 메소드명  : ApplyJson
	   * @ breif  : 불러온 Json파일을 JsonArray에 적용시키기
	   * @ detail : jsonObject에 저장된 내용을 선언한 위치에 Json파일로 내보냅니다.
	   * @ param  : obj는 불러온 json 내용이 들어있습니다. 그리고 jsonArray는 아이스크림 정보들이 들어갈 곳입니다.
	   * @ 작성자   : 이성재
	   * @ 작성일자  : 2021 - 06 -10
	   * @ why    : 불러온 json 파일의 정보를 적용시켜서 편하게 사용하기 위해 만들었습니다.
	   */ 
	  
	 public void ApplyJson(Object obj ,JSONArray jsonArray) throws IOException, org.json.simple.parser.ParseException  {
		 	
			obj.toString();
			JSONObject t = (JSONObject)obj;
			JSONArray k = (JSONArray) t.get("Icecream");
			
			Iterator it2 = k.iterator();
			while(it2.hasNext()) {
		  		JSONObject o = (JSONObject)it2.next();
		  		String jsonId = o.get("id").toString();
	      		String jsonName = o.get("name").toString();
	      		String jsonPrice = o.get("price").toString();
	      		String jsonFlavor = o.get("flavor").toString();
	      		
	      		JSONObject temp = new JSONObject();
	      		
	      		temp.put("id", jsonId);
	      		temp.put("name", jsonName);
	      		temp.put("price", jsonPrice);
	      		temp.put("flavor", jsonFlavor);
	      		
	      		jsonArray.add(temp);
			}
			
			
			
	 }
	 
	   /*
	   * @ 메소드명  : GetJson
	   * @ breif  : Json파일을 불러오는기능
	   * @ detail : 선언한 위치에  Json파일로 불러옵니다.
	   * @ return : Obj 불러온 Json 내용이 들어있습니다.
	   * @ 작성자   : 신희빈
	   * @ 작성일자  : 2021 - 06 -10
	   * @ why    : 저장된 Json파일을 파싱하여 보여주기 위해서 만들었습니다.
	   */

	public Object GetJson() throws IOException, org.json.simple.parser.ParseException  {
		 	JSONParser parser = new JSONParser();		// json파일 파싱하기위해 선언
			Object obj = parser.parse(new FileReader("src/json/mydata.json"));	// 불러올 json 파일 위치선언
			System.out.println("적용됐습니다.");	// json 파일 호출
			return obj;
			
	 }
	 
	   /*
	   * @ 메소드명 : DryIceCount
	   * @ breif  : 도착시간에 따라 드라이아이스 수를 정하는 함수
	   * @ detail : 도착시간을 입력받아서 드라이아이스 수 정함
	   * @ 작성자   : 박현석
	   * @ 작성일자  : 2021 - 06 -10
	   * @ why    : 아이스크림을 포장해서 가져갈 때 녹지 않기 위해서 시간별 드라이아이스 갯수를 정해주기 위해서 만들었습니다.
	   */
	 public void DryIceCount() {
		 
		Scanner scan = new Scanner(System.in);
		int arrivalTime = scan.nextInt();
		
		if (arrivalTime < 60) {
			System.out.println("드라이아이스 1개를 넣었습니다.");
		} else if (arrivalTime < 120) {
			System.out.println("드라이아이스 2개를 넣었습니다.");
		} else if (arrivalTime < 180) {
			System.out.println("드라이아이스 3개를 넣었습니다.");
		} else {
			System.out.println("드라이아이스 4개를 넣었습니다.");
		}
		 
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
		    System.out.println("6. json 내보내기");
		    System.out.println("7. json 불러오기");
			System.out.println("8. 나가기");
	      
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
			        	Main.ShowProductsAll(jsonArray);
			        	System.out.println("제거할 상품 이름을 입력해주세요");
			        	Main.DeleteProducts(jsonArray);
			        	break;
	          
					case 3: 
						Main.ShowProductsAll(jsonArray);
						System.out.println("조회할 상품 이름을 입력하세요");
						Main.ShowProducts(jsonArray);
						
						break;
	
					case 4:
						Main.ShowProductsAll(jsonArray);
						break;
	          
					case 5:
	                	System.out.println("");
	                	
						int tempSum = 0;
						System.out.println("살 상품 id를 입력하세요");
						Main.ShowProductsAll(jsonArray);

						
						
						tempSum += Main.count(jsonArray);
						
						while(true) {
							System.out.println(" ");
							System.out.println("더 사시겠습니까? Y : 1 , N : 2");
							int buyingChoice = scanf.nextInt();
							System.out.println(" ");
							
							Main.ShowProductsAll(jsonArray);
							
							if(buyingChoice == 1) {
								System.out.println("추가할 상품 id를 입력하세요");
								tempSum += Main.count(jsonArray);
							}else if (buyingChoice == 2) {
								break;
							}
						}
						System.out.println("총 " + tempSum + "원 입니다.");
						System.out.println(" ");
						System.out.println("예상 도착 소요 시간을 알려주세요(분단위)");
						Main.DryIceCount();
						
						break;
	
					case 6: 
						
						Main.SaveJson(jsonArray);
						System.out.println("json으로 불러왔습니다.");
						break;
	
					case 7 : 
						
						Object jsonobj = Main.GetJson();
						Main.ApplyJson(jsonobj,jsonArray);
						System.out.println("json으로 불러왔습니다.");
						break;
						
					case 8 : 
						swi = false;
						break;
					default :
						System.out.println("잘못 입력하셨습니다.");
						break;
				}
		}
  	}
}
