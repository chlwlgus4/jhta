import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add") //설정이 잘못되면 실행에 오류가 생김
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		PrintWriter out = response.getWriter(); //문자로 자주출력하기위해 writer로 변환

		int x = 0, y=0;
		int sum = 0;

		String sum_ = request.getParameter("s");
		if(sum_ != null)
			sum = Integer.parseInt(sum_);

		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		request.setAttribute("sum", sum);

		dispatcher.forward(request, response);
		// 현재 서블릿에서 다른 서블릿을 요청하는 방법 두가지
		// Redirect -> 지금까지 처리한 내용과 상관없이 완전히 새로운 서블릿을 요청할 때
		// -> 지금 서블릿과 요청될 서블릿이 공유해야 할 것이 없는 경우.
		// Foward -> 지금 서블릿이 새로운 서블릿에게 처리한 것을 넘겨주면서 이어가야 할 때

		/*out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<table>");

		out.write("<tr>");
		out.write("<td>덧셈 계산?</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>x : </label>");
		out.write("<input type=\"text\" name=\"x\" value=\""+x+"\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>y : </label>");
		out.write("<input type=\"text\" name=\"y\" value=\""+y+"\" />");
		out.write("<input type=\"submit\" value=\"입력\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>합 : </label>"+sum);
		out.write("</td>");
		out.write("</tr>");

		out.write("</table>");
		out.write("</form>");
		out.write("<a href=\"mypage.jsp\">마이페이지</a>");  
		out.write("</body>");
		out.write("</html>");*/
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		PrintWriter out = response.getWriter(); //문자로 자주출력하기위해 writer로 변환
		
		String cmd = request.getParameter("cmd");
		
		int x = 0, y=0;
		int sum =0;

		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		switch(cmd) {
		case "덧셈":
			if(x_ != null && !x_.equals("")) 
				x = Integer.parseInt(x_);

			if(y_ != null && !y_.equals("")) 
				y = Integer.parseInt(y_);

			sum = x+y;
			break;

		case "session" :
			String sum1 = request.getParameter("sum");
			HttpSession session = request.getSession();
			session.setAttribute("sum",sum1);
			break;
		
		case "application":
			String sum2 = request.getParameter("sum");
			ServletContext application = request.getServletContext();
			application.setAttribute("sum", sum2);
			break;
		
		
		}

		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/add");

		/*request.setAttribute("sum", sum);
		dispatcher.forward(request, response);
		 */// post 처리 forward -> 다시 post를 요청하게 된다.

		response.sendRedirect("add?s="+sum); // GET 요청만 가능


		/*out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<table>");

		out.write("<tr>");
		out.write("<td>덧셈 계산?</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>x : </label>");
		out.write("<input type=\"text\" name=\"x\" value=\""+x+"\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>y : </label>");
		out.write("<input type=\"text\" name=\"y\" value=\""+y+"\" />");
		out.write("<input type=\"submit\" value=\"입력\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>합 : </label>"+sum);
		out.write("</td>");
		out.write("</tr>");

		out.write("</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");*/

	}

}