package spring.aop.anno;

//Target :: Core concern 모임
public class MemberService {
	
	public void register(String id) {
		System.out.println(id + "register....logic...회원등록 성공");
	}
	
	public void findMember(String id) {
		System.out.println("find Member....logic 회원검색 성공");
	}
	
	
}
