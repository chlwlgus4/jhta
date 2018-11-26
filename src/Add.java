import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add") //������ �߸��Ǹ� ���࿡ ������ ����
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		PrintWriter out = response.getWriter(); //���ڷ� ��������ϱ����� writer�� ��ȯ

		int x = 0, y=0;
		int sum = 0;

		String sum_ = request.getParameter("s");
		if(sum_ != null)
			sum = Integer.parseInt(sum_);

		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		request.setAttribute("sum", sum);

		dispatcher.forward(request, response);
		// ���� �������� �ٸ� ������ ��û�ϴ� ��� �ΰ���
		// Redirect -> ���ݱ��� ó���� ����� ������� ������ ���ο� ������ ��û�� ��
		// -> ���� ������ ��û�� ������ �����ؾ� �� ���� ���� ���.
		// Foward -> ���� ������ ���ο� �������� ó���� ���� �Ѱ��ָ鼭 �̾�� �� ��

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
		out.write("<td>���� ���?</td>");
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
		out.write("<input type=\"submit\" value=\"�Է�\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>�� : </label>"+sum);
		out.write("</td>");
		out.write("</tr>");

		out.write("</table>");
		out.write("</form>");
		out.write("<a href=\"mypage.jsp\">����������</a>");  
		out.write("</body>");
		out.write("</html>");*/
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		PrintWriter out = response.getWriter(); //���ڷ� ��������ϱ����� writer�� ��ȯ
		
		String cmd = request.getParameter("cmd");
		
		int x = 0, y=0;
		int sum =0;

		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		switch(cmd) {
		case "����":
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
		 */// post ó�� forward -> �ٽ� post�� ��û�ϰ� �ȴ�.

		response.sendRedirect("add?s="+sum); // GET ��û�� ����


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
		out.write("<td>���� ���?</td>");
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
		out.write("<input type=\"submit\" value=\"�Է�\" />");
		out.write("</td>");
		out.write("</tr>");

		out.write("<tr>");
		out.write("<td>");
		out.write("<label>�� : </label>"+sum);
		out.write("</td>");
		out.write("</tr>");

		out.write("</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");*/

	}

}