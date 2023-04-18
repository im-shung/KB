package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *	Servlet API와 
 *  컨테이너가 어떻게 CALLBACK 메소드를 호출하는지에 대한 순서
 *  어노테이션 @WebServlet("/Life") 주석 처리 하니 -> HTTP 상태 404 – 찾을 수 없음 
 *  선택: 어노테이션 or web.xml
 *  
 *  1. 컨테이너에 의해서 서블릿 객체 생성
 *  2. 컨테이너에 의해서 init() 호출
 *  -----------------------------------Ready On 상태 (한번만 호출)----------------------------------
 *  3. 컨테이너에 의해서 doGet 호출(요청 시 계속 호출)
	...
 *  새로 고침할때마다 계속 요청
 *  
 *  Ready On 상태는 첫번째 client가 최초의 요청 시 한번만 진행된다 
 *  최초로 접근하는 client는 로딩하는데 느려짐 ! 이 방식의 로딩을 "lazy loading"이라고 한다.
 *  따라서, 이것을 Preloading방식으로 바꿔줘야한다. (*Preloading: 클라이언트가 요청전에 미리 Ready on상태를 만들어놓는것)

	※ xml
    <servlet>
        <servlet-name>ServletLifeTest</servlet-name>
        <servlet-class>web.servlet.life.ServletLifeTest</servlet-class>
        <load-on-startup>1</load-on-startup> // Preloading
    </servlet>
    
    field 값을 초기화 하려면 서버를 껐다가 켜야함.
    
    ※ 어노테이션
    @WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1)
    
 *   
 */
@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1)
public class ServletLifeTest extends HttpServlet {

	/**
	 * class ServletLifeTest extends HttpServlet {
	 * public 없앴더니 에러발생!
	 * java.lang.IllegalAccessException: 
	 * class org.apache.catalina.core.DefaultInstanceManager cannot access a member of class web.servlet.life.ServletLifeTest with modifiers "public"
	 * 외부에 있는 컨테이너를 접근하려면 public으로 해야함
	 * 다른데서 접근하는 것이 막혀짐
	 * 즉, 내가 객체를 직접 생성하는 것이 아닌 컨테이너를 통해 만든다는 뜻!
	 */
	private static final long serialVersionUID = 1L;
    private int count = 0; // 필드 추가
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLifeTest() {
    	System.out.println("1. 컨테이너에 의해서 서블릿 객체 생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("2. 컨테이너에 의해서 init() 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4. destroy() 호출");
	}

	// doGet or doPost 둘 중 선택해서 호출
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 컨테이너에 의해서 doGet 호출(요청 시 계속 호출)");
		
		// 클라이언트의 요청을 처리
		PrintWriter out = response.getWriter();
		
		// 브라우저로 바로 출력
		out.println("<body bgcolor='yellow'>");
        out.println("<h3>LifeCycle CallBack Method...</h3>");
        out.println("<b>Count :: "+(++count)+"</b>");
        out.println("</body>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 컨테이너에 의해서 doPost 호출(요청 시 계속 호출)");
	}

}
