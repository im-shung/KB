package kb.cms;

public interface ICustMgr {

	void save(Customer c);

	void search();

	void sortedSearch(String base);

	Customer search(int num);

	/**
	 * 주어진 고객번호를 검색하여 주소를 수정한다.
	 * 
	 * @param num     : 고객번호
	 * @param address : 수정된 주소
	 */
	void update(int num, String address);

	void delete(int num);

}