package com.kb.cms;

import java.util.*;

public class CustManager implements ICustMgr {

	List<Customer> cs = new ArrayList<>();

	// 저장
	@Override
	public void save(Customer c) {
		cs.add(c);
	}

	// 검색
	@Override
	public void search() {
		for (Customer c : cs) {
			System.out.println(c); // c.toString()
		}
	}
	
	@Override
	public void sortedSearch(String base) {
		Collections.sort(cs, new MyComparator(base));
		for (Customer c : cs) {
			System.out.println(c); // c.toString()
		}
	}

	// 상세검색
	@Override
	public Customer search(int num) {
		Customer result = null;
		for (Customer c : cs) {
			if (c.num == num) {
				result = c;
				break;
			}
		}
		return result;
	}

	// 수정
	@Override
	public void update(int num, String address) {
		Customer c = search(num);
		if (c != null) {
			c.address = address;
		} else {
			System.out.println("수정 실패: 고객 번호가 잘못 되었습니다.");
		}
	}

	// 삭제
	@Override
	public void delete(int num) {
		Customer c = search(num);
		if (c != null) {
			cs.remove(c);
		} else {
			System.out.println("삭제 실패: 고객 번호가 잘못 되었습니다.");
		}
	}

}
