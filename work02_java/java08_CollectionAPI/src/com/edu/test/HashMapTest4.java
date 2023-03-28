package com.edu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest4 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("강호x", 85);
		map.put("강x동", 90);
		map.put("x호동", 64);
		map.put("이수x", 75);
		map.put("이x근", 45);
		map.put("x수근", 53);
		
		//1. map에 담겨있는 모든 키값을 받아온다
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		
		//2. key에 매핑된 점수를 받아서 모든 성적의 total 점수를 출력
		int total = 0;
		for (String name : keySet) {
			total += map.get(name);
		}
		System.out.println(total);
		
		//3. 아는형님 멤버들의 평균점수를 출력
		System.out.println((double)total / keySet.size());
	}

}
