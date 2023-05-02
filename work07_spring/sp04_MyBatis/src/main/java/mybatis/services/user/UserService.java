package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

/*
 * 데이터 가공 레이어
 */
public interface UserService {
//	int addUser(User user) throws Exception;
//	int updateUser(User user) throws Exception;
	// service는 void로 갑니다.
	
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception; 
}
