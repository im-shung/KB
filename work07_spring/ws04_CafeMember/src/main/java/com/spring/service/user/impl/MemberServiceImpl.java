package com.spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.service.domain.MemberVO;
import com.spring.service.user.MemberDAO;
import com.spring.service.user.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return memberDAO.showAllMember();
	}

	@Override
	public String idExist(String id) throws Exception {
		return memberDAO.idExist(id);
	}

}
