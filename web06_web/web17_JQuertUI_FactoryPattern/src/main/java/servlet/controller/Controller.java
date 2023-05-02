package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 결과페이지 이름 & 페이지 이동 방식을 동시에 리턴하기
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response);
	
	
}
