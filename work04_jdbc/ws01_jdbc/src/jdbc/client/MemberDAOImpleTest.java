package jdbc.client;

import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dto.Member;
import jdbc.exception.RecordNotFoundException;

public class MemberDAOImpleTest {

	public static void main(String[] args) throws SQLException, RecordNotFoundException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
//		System.out.println("========INSERT==========");
//		dao.insertMember(new Member("JAMES", "111@email.com", "111-111"));
//		dao.insertMember(new Member("TOM", "222@email.com", "111-112"));
//		dao.insertMember(new Member("BRUK", "333@email.com", "111-113"));
//		dao.insertMember(new Member("BRUK", "444@email.com", "111-114"));
		
//		System.out.println("========UPDATE==========");
//		dao.updateMember(new Member(1, "JAMES_GAEMYUNG", "111@email.com", "111-111"));
	
//		System.out.println("========DELETE==========");
//		dao.deleteMember(1);

		
//		System.out.println("========SELECT 1 MEMBER==========");
//		System.out.println(dao.getMember(2));
		
		
//		System.out.println("========SELECT ALL MEMBER==========");
//		System.out.println(dao.getMember());
		
		
		System.out.println("========SELECT 이름 같은 MEMBER==========");
		System.out.println(dao.getMember("BRUK"));
	}

	static {
		//드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 결과 >>> 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 결과 >>> 실패");
		}
	}
}
