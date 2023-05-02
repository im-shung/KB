package spring.service.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;


public class MyBatisMemberTestApp {

	public static void main(String[] args) throws Exception{
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//
		System.out.println(":: 0. getMemberList(SELECT)  ? ");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		

// registerMember
		MemberVO memberVO = new MemberVO("test01","pw01","주몽","address01");
		/*
		Object obj = session.insert("MemberMapper.registerMember", memberVO);
		session.commit(); 
		System.out.println(":: 1. registerMember(INSERT)  result ? "+obj); //1
		System.out.println("\n");
		*/
		
		
// deleteMember
		/*
		int deleteResult = session.delete("MemberMapper.deleteMember", memberVO.getId());
		session.commit(); 
		System.out.println(":: 2. deleteMember(DELETE) result ? "+ deleteResult);
		System.out.println("\n");
		
		// test
		System.out.println(":: 0. getMemberList(SELECT)  ? ");
		list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		*/

// updateMember
		/*
		memberVO.setName("장보고");
		int updateResult = session.update("MemberMapper.updateMember", memberVO);
		session.commit(); 
		System.out.println(":: 3. updateMember(UPDATE) result ? "+updateResult);//1
		System.out.println("\n");
		
		// test
		System.out.println(":: 0. getMemberList(SELECT)  ? ");
		list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		*/

// getMember
		/*
		MemberVO result = session.selectOne("MemberMapper.getMember", memberVO);
		System.out.println(":: 2. findUserId(SELECT)  ? " + result);
		System.out.println("\n");
		*/
		

// idExist		
		/*
		String name = (String)session.selectOne("MemberMapper.idExist", memberVO.getId());
		System.out.println(":: 4. findUserId(SELECT)  ? "+name);
		System.out.println("\n");
		*/

// login
		memberVO.setId("test01");
		memberVO.setPassword("pw01");
		System.out.println(memberVO);
		String name = (String) session.selectOne("MemberMapper.login", memberVO);
		System.out.println(":: login(SELECT)  ? "+ name);
		
	}//end of main
}//end of class




















