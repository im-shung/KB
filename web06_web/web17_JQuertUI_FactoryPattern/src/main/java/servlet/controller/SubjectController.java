package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("handleRequest 진입..");
	    
	    // DB 갔다옴
	    String result = "Algorithm | Java | Back-End | Front-End | Framework| AI";
	    request.setAttribute("result", result);

	    return new ModelAndView("Result.jsp");
	}

}
