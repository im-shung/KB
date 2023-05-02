package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	public static final String NS = "ns.sql.ItemMapper."; // TODO: 빠트리기 쉬운 요소2
	
	// 생성자나 setter를 통해 주입을 해야
	// 진짜 연결이 된다. (DI)
	// 현업에서는 setter를 사용한다.
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Item> getItemList() throws Exception {
		return sqlSession.selectList(NS + "getItemList");
	}

	@Override
	public Item getItem(Integer itemId) throws Exception {
		return sqlSession.selectOne(NS + "getItem",itemId);
	}

}
