package icecreamshopmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class main {

  public static void main(String[] args) throws IOException {


  	JSONArray jsonArray = new JSONArray();
    boolean swi = true; 
		while(swi){
    System.out.println("-------------------------------------");
	System.out.println("1. ");
	System.out.println("2. ");
	System.out.println("3. ");
	System.out.println("4. json으로 정보보기");
	System.out.println("5. json으로 내보내기");
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
