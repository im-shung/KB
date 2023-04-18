package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/Life")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
    	System.out.println("1. 컨테이너에 의해서 서블릿 객체 생성");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
		System.out.println("2. 컨테이너에 의해서 init() 호출");

    }
    
    @Override
    public void destroy() {
		System.out.println("4. destroy() 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 컨테이너에 의해서 doGet 호출(요청 시 계속 호출)");
		PrintWriter out = response.getWriter();
        out.println("<h2>안녕하세요, LifeCycleServlet.</h2>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 컨테이너에 의해서 doPost 호출(요청 시 계속 호출)");
	}

}
