package com.service.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

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
		List<Item> list = session.selectList("ns.sql.ItemMapper.getItemList"); 
		for(Item vo : list)
			System.out.println(vo);
		
		System.out.println("\n==========================\n");
		// <select id="getItem" resultMap="selectItemRM" parameterType="int">
		// parameterType이 있으니까 넣어줍니다. 
		Item item = session.selectOne("ns.sql.ItemMapper.getItem", 1111); 
		System.out.println(item);
		
		
	}

}
