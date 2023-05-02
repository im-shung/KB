package aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.prob.MemberService;
import spring.aop.prob.ProductService;

public class AopAppTest1 {

	public static void main(String[] args) {
		// DI 컨테이너 만들어봅니다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans/prob.xml");
		
		System.out.println("prob.xml");
		
		MemberService member = (MemberService)factory.getBean("member");
		ProductService product = (ProductService)factory.getBean("product");
		member.register("kbstart");
		member.findMember("kbstart");
		
		System.out.println("\n*************************\n");
		product.deleteProduct("aaa");
	}

}
