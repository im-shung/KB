package servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;


@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다시 요청이 들어가면 새로운 세션이 생길 수 있지만 
		// 세션을 죽이지 않는 이상 쿠키를 통해서 
		// jsession ID 값이 다시 서버로 날아가며, 서버는 이 ID 값을 열어서 기존의 세션으로 요청을 유지한다.
		// 이러한 요청이 바로 로그인이다!! 
		HttpSession session =  request.getSession(); // 기존의 세션으로 연결 ;; 세션을 죽여야지만 새로운 세션으로 연결할 수 있다.
		if (session.getAttribute("vo") != null) { 
			// session.getAttribute("vo") != null과 같은 말! 로그인된 상태라면 세션이 기존 것이다.
			// MemberVO vo = (MemberVO) session.getAttribute("vo");
			System.out.println("JSESSIONID :: " + session.getId());
			session.setAttribute("pname", "book");
			// 네비게이션
			request.getRequestDispatcher("buy_result.jsp").forward(request, response);;
		} else {
			// session.getAttribute("vo") == null과 같은 말! 로그아웃 상태, 기존 세션이 죽은 것
			response.sendRedirect("login.html");
		}

	}



}
