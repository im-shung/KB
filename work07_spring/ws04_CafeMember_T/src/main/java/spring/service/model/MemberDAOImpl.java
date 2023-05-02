package spring.service.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	public static final String NS = "MemberMapper.";
	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		int result = sqlSession.insert(NS + "registerMember", vo);
		return result;
	}

	@Override
	public int deleteMember(String id) throws Exception {
		int result = sqlSession.delete(NS + "deleteMember", id);
		return result;
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		int result = sqlSession.update(NS + "updateMember", vo);
		return result;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		MemberVO vo = sqlSession.selectOne(NS + "getMember", id);
		return vo;
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		List<MemberVO> list = sqlSession.selectList(NS + "showAllMember");
		return list;
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		MemberVO rvo = sqlSession.selectOne(NS + "login", vo);
		return rvo;
	}

}
