package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {
	public static void main (String[] args) throws Exception {
		SqlSessionFactory factory = FactoryService.getFactory();
		// 3. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession Creating...");
		
		List<MySawon> list = session.selectList("sawonMapper.sawonList"); // 기억~!!
		for (MySawon mySawon : list) {
			System.out.println(mySawon);
		}
	}
}
