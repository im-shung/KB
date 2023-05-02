package web.controller;

public class FindController implements Controller {

	@Override
	public String handle() {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO리턴받고...register() 호출
		 * 4. 네비게이션
		 * 
		 */
		
		System.out.println("FindController :: 멤버 등록 완");
		return "find_result.jsp";
	}

	
}
