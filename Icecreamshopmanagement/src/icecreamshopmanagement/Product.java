package icecreamshopmanagement;

/*	
@ 클래스명  	:  Product.java
@ brief 	: 아이스크림 상품을 저장할 변수
	@ details	: 변수를 String으로 선언 후 getter,setter를 설정 후 저장한 값 리턴
	@ 작성자		: 신희빈
	@ 작성일자		: 2021-06-10
	@ return 	(id   : 상품의 고유번호
			  	name : 상품의 이름
			  	price : 상품의 가격
			  	flavor : 상품의 맛
*/
public class Product {
	String id;
	String name;
	String price;
	String flavor;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	

}