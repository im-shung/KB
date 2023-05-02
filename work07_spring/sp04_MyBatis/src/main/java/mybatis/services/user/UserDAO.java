package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;
// /sp04_MyBatis/src/main/resources/mapper/mybatis-userservice-mapping10.xml 참고

/*
 * ~mapping10.xml의 쿼리문 태그의 id 값은 함수(기능)의 이름이 된다.
 * parameter type은 함수의 인자값
 * resultType, resultMap 기능의 반환값으로 생각...
 */
public interface UserDAO {

	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser (String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception; 
	/*
	 * 보통 getUserList, showAll 등은 인자값을 주지 않지만 ... 
	 * 우리는 동적 쿼리를 썼기 때문에 인자를 줘야한다. 
	 * 
	 */
}
