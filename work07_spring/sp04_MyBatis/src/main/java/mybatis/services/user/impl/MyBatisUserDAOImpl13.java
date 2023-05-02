package mybatis.services.user.impl;


/*
 * 
 * annotation 기반으로 설정
 * xml 설정문서에서 bean 태그를 생략할 수 있다.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO {

	// 생성자나 setter를 통해 주입을 해야
	// 진짜 연결이 된다. (DI)
	// 현업에서는 setter를 사용한다.
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10."; // TODO: 빠트리기 쉬운 요소2

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = 0;
		result = sqlSession.insert(MAPPER_NAME + "addUser", user);
		//sqlSession.commit(); // TODO: 빠트리기 쉬운 요소1
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = 0;
		result = sqlSession.update(MAPPER_NAME + "updateUser", user);
		return 0;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = 0;
		result = sqlSession.update(MAPPER_NAME + "removeUser", userId);
		return 0;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User u = null;
		u = sqlSession.selectOne(MAPPER_NAME + "getUser", userId);
		return u;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> list = new ArrayList<User>();
		list = sqlSession.selectList(MAPPER_NAME + "getUserList", user);
		return list;
	}


}
