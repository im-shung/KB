package web.controller;

public class UpdateController implements Controller {

	@Override
	public String handle() {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO리턴받고...register() 호출
		 * 4. 네비게이션
		 * 
		 */
		
		System.out.println("UpdateController :: 멤버 등록 완");
		return "update_result.jsp";
	}

	
}
