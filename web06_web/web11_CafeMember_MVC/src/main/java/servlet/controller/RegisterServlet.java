package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
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

        // 2. 폼값 받는다.
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
		
        // 3. (폼값 받을 시 - VO 객체 생성)
        MemberVO pvo = new MemberVO(id, password, name, address); // parameter vo
        
        // 4. DAO 리턴받아서 비즈니스 로직 호출
        try {
			MemberDAOImpl.getInstance().registerMember(pvo);
		} catch (SQLException e) {
			
		}
        
        // 6. Page Navigation
//        request.getRequestDispatcher("allView.jsp").forward(request, response); // servlet이 돌지 않아서 오류가 발생한다.
        response.sendRedirect("AllMember");
        
        
	}

}
