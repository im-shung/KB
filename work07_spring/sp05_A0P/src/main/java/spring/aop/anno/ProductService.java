package spring.aop.anno;

// Target
public class ProductService {

	
	public String deleteProduct(String id) {
		System.out.println(id + "register....logic...삭제 성공");
		return "삭제된 상품 ID: " + id;
	}
	
	public void findMember(String id) {
		System.out.println("find Member....logic 회원검색 성공");
	}
	
	
}
