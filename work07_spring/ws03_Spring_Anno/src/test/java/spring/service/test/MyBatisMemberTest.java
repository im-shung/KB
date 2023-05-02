package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;

public class MyBatisMemberTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "/beans/memberservice.xml" });
		MemberService memberService = (MemberService) context.getBean("memberServiceImpl");

		System.out.println("==================1. MemberService.getMember=============");
		MemberVO vo = memberService.getMember("1234");
		System.out.println(vo);
		System.out.println("==================2. MemberService.showAllMember()=============");
		List<MemberVO> list = memberService.showAllMember();
		for(MemberVO member : list) 
			System.out.println(member);
		System.out.println("==================3. MemberService.idExist(String id)=============");
		System.out.println(memberService.idExist("1234"));
	
	}

}
