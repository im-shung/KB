package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로직은 여기서 작성
		/*
		 * Servlet이 하는 일
		 * 1. 양방향 한글 처리
		 * 2. 폼값 받는다.
		 * 3. (폼값 받을 시 - VO 객체 생성)
		 * 4. DAO 리턴받아서 비즈니스 로직 호출 🤩(요청과 DAO의 method 관계는 1:1)
		 * 5. (반환값 있을 시 - Attribute 바인딩)
		 * 6. Page Navigation
		 */
		
		// 1. 양방향 한글 처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /*
			2. 폼값 받는다.
			3. 폼값 받을 시 - VO 객체 생성한다.
			4. DAO 리턴받아서 비즈니스 로직 호출 - 반환값 있음
			5. 세션 받아와서 바인딩 (request, session, context)
			6. 네비게이션
         */
        
        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        String path = "index.html";
        try { // 비즈니스 로직 실행 시 try-catch문
        	MemberVO rvo = MemberDAOImpl.getInstance().login(id, pass);
        	HttpSession session = request.getSession();
        	
        	if (rvo != null) {// null 인 경우 바인딩 진행 안하도록...
        		session.setAttribute("vo", rvo);
        		System.out.println("JSESSIONID : " + session.getId());
        	}
        	path = "login_result.jsp";
        	
        } catch (Exception e) {		
        	path = "login_fail.jsp";
        	System.out.println(e);
        }
        request.getRequestDispatcher(path).forward(request, response);
        
	}


}
