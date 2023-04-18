package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 클라이언트의 요청을 처리
     * get -> doGet() 호출
     * post -> doPost() 호출
     * 
     * get -> doPost() 호출 :: Error Status Code 405
     * 요청 방식과 서블릿 코드가 안맞을 때 생기는 에러 
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
  
     * 요청방식
     1. Get
	    - 페이지 연결이 주 목적 ex) 단순 페이지 링크
	    - 특징
	        1. 만약에 데이터를 전송할 시, 주소창에 전달되는 데이터가 QueryString 형식으로 부착
	        2. 전달되는 데이터의 크기가 길이에 제약
	        3. url?name=value&name1=value
	 2. Post
	    - 데이터 전달이 주목적
	    - 데이터를 서버에 전송하니 서버는 그 데이터를 처리한 결과를 다시 응답해주는 것 ex) 회원가입/로그인
	    - 특징
	        1. 많은 양의 데이터 전달 가능. 주소창에 노출되지 않는다.
	        2. Servlet 객체에 담겨서 서버로 데이터 전송
	        3. 데이터의 크기나 길이에 제약 X
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h2>Get 방식 요청입니다.</h2>");
        
        // url에 적은 값 가져오기
        // <a href="form?id=bank&name=kbstar">
        // get 방식은 url에 다보이기 떄문에 보안상 우려가 있는 데이터는 사용하면 안된다!
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        out.print("<li>" + id + "</li>");
        out.print("<li>" + name + "</li>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식의 요청은 여기서 로직을 작성한다.
		// 한글처리(요청시, 응답시 따로따로)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 폼 값 받는다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String gender = request.getParameter("gender");
		// 폼의 체크박스는 여러개이므로
		String[] techs = request.getParameterValues("tech");
		
		// 방법1: 받은 값을 브라우저로 출력
		out.println("<h2>폼 값에 입력된 정보들 입니다.</h2>");
		out.println("<li>아이디: " + id + "</li>");
		out.println("<li>패스워드: " + password + "</li>");
		out.println("<li>성별: " + gender + "</li>");
		out.println("<b>사용기술입니다. </b><br>");
		
		String tech = "";
		for (String t: techs) {
			tech += t + " ";
		}
		
		out.println(tech);
		
		// 방법2: 받은 값을 브라우저로 출력2
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>ID: ").append(id).append("</h2>");
		sb.append("<h2>PASSWORD: ").append(password).append("</h2>");
		sb.append("<h2>GENDER: ").append(gender).append("</h2>");
		
		StringBuffer sb2 = new StringBuffer();
		for(String t: techs) {
			sb2.append(t).append(", ");
		}
		sb2.setLength(sb2.length() - 2);
		sb.append("<h2>TECH: ").append(sb2).append("</h2>");
		
		out.println(sb);
	}	

}
