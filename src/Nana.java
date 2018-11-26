import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hello") //설정이 잘못되면 실행에 오류가 생김
public class Nana extends HttpServlet
{	
	public void service(HttpServletRequest request
			,HttpServletResponse response)
					throws IOException, ServletException
	{

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		PrintWriter out = response.getWriter(); //문자로 자주출력하기위해 writer로 변환

		String cnt_ = request.getParameter("cnt");

		int cnt = 5;

		if(cnt_ != null && cnt_.equals(""))
			cnt = Integer.parseInt(request.getParameter("cnt"));

		for (int i = 0; i < cnt; i++) {

			out.println((i+1)+":"+"안녕 Suvlet<br/>");
		}
	
	}
}