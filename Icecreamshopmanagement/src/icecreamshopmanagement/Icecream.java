package icecreamshopmanagement;

/*   
 * @ 클래스명     : Icecream.java
 * @ brief       : 아이스크림 상품의 id, name, price, flavor의 저장할 공간 생성
 * @ details   : 아이스크림 추가하기 위해 공간 생성
 * @ 작성자      : 신희빈
 * @ 작성일자      : 2021-06-10
 * @ why       : 아이스크림 상품을 배열로 넣기 위해서 만들었습니다.
 * @ param     : 아이스크림 상품을 각각의 id, name, price, flavor 값을 지정
 */	

public class Icecream extends Product{

	
	public Icecream(String tempId, String tempName, String tempPrice, String tempFlavor) {
		
		this.id = tempId;
		this.name = tempName;
		this.price = tempPrice;
		this.flavor = tempFlavor;
		
	}

}
