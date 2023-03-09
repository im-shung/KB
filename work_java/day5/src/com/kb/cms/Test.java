package com.kb.cms;

public class Test {

	public static void main(String[] args) {
		ICustMgr mgr = new CustManager();
		mgr.save(new Customer(1001, "kim", "seoul"));
		mgr.save(new Customer(1002, "jung", "incheon"));
		mgr.save(new Customer(1003, "yoom", "daegu"));
		mgr.save(new VipCustomer(1004, "min", "seoul", "11가1234"));
		mgr.save(new VipCustomer(1005, "arin", "busan", "11가1234"));

		String base = "주소";
		System.out.println("=== 전체 검색 " + "(" + base +" 기준)" + "===");
		mgr.sortedSearch(base);

		System.out.println("=== 1003 검색 ===");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 수정 주소: seoul ===");
		mgr.update(1003, "seoul");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 삭제 ===");
		mgr.delete(1003);
		System.out.println(mgr.search(1003));
		
		
	}

}
