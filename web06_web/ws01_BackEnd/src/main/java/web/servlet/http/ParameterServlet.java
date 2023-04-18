package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h2>Get 방식 요청입니다.</h2>");
        

        String job = request.getParameter("job");
        String pageNo = request.getParameter("pageNo");
        String searchWord = request.getParameter("searchWord");
        
        out.print("<li>" + job + "</li>");
        out.print("<li>" + pageNo + "</li>");
        out.print("<li>" + searchWord + "</li>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");

		
		out.println("<h2>name: " + name + "</h2>");
		out.println("<h2>email: " + email + "</h2>");
		out.println("<h2>gender: " + gender + "</h2>");
		
		String hobby = "";
		for (int i = 0; i < hobbys.length; i++) {
			if (i == hobbys.length - 1) {
				hobby += hobbys[i];
			} else {
				hobby += hobbys[i] + ", ";
			}
		}
		
		out.println("<h2>hobby: " + hobby + "</h2>");
		out.println("<h2>favorite: " + favorite + "</h2>");
		out.println("<h2>desc: " + desc + "</h2>");
	}
}
