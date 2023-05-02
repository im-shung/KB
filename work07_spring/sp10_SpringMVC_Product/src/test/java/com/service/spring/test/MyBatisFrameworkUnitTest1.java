package com.service.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkUnitTest1 {

	public static void main(String[] args) throws IOException {
		// MyBatis 프레임워크를 단위 테스트합니다.
		// 1. 설정 문서를 읽어옵니다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml"); // 2. 경로를 적습니다.

		// 3. Factory가 만들어집니다. -> 실제 클래스 이름은 SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r); 
		
		// 4. 팩토리로부터 SqlSession을 만듭니다. -> 실제 클래스 이름은 SqlSessionTem
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 실행 
		// config/SqlMapConfig.xml에 있는 쿼리문이 돌아갑니다.
		MyProduct vo = new MyProduct("공기방울 세탁기", "대우", 500000);
		//session.insert("MyProductMapper.addProduct", vo); 
		session.commit();
		System.out.println("\n=========== 1. addProduct ===============\n");
		System.out.println(vo);
		
		vo = new MyProduct("공기방울 로봇청소기", "대우", 1000000);
		//session.insert("MyProductMapper.addProduct", vo); 
		session.commit();
		System.out.println("\n=========== 2. addProduct ===============\n");
		System.out.println(vo);
		
		
		System.out.println("\n=========== 3. findProducts ===============\n");
		List<MyProduct> list = session.selectList("MyProductMapper.findProducts");
		for(MyProduct product : list)
			System.out.println(product);
		
		System.out.println("\n=========== 4. findProductByName ===============\n");
		list = session.selectList("MyProductMapper.findProductByName", "공기방울");
		for(MyProduct product : list)
			System.out.println(product);
		
		System.out.println("\n=========== 5. findProductByMaker ===============\n");
		list = session.selectList("MyProductMapper.findProductByMaker", "대우");
		for(MyProduct product : list)
			System.out.println(product);
	}

}
