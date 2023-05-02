package aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.anno.MemberService;
import spring.aop.anno.ProductService;

public class AopAppTest3 {

	public static void main(String[] args) {
		// DI 컨테이너 만들어봅니다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans/anno.xml");

		System.out.println("anno.xml");

		MemberService member = (MemberService) factory.getBean("member");
		ProductService product = (ProductService) factory.getBean("product");
		member.register("kbstart");
		member.findMember("kbstart");

		System.out.println("\n*************************\n");
		product.deleteProduct("aaa");
	}

}
