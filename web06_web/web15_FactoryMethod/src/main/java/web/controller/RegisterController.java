package web.controller;

public class RegisterController implements Controller {

	@Override
	public String handle() {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO리턴받고...register() 호출
		 * 4. 네비게이션
		 * 
		 */
		
		System.out.println("RegisterController :: 멤버 등록 완");
		return "register_result.jsp";
	}

	
}
