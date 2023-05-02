package com.spring.service.user;

import java.util.List;

import com.spring.service.domain.MemberVO;


public interface MemberService {
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember()  throws Exception;
	
	String idExist(String id) throws Exception;
}
