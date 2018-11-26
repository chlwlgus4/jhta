package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/delete")
public class NoticeDellController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		int id= Integer.parseInt(request.getParameter("id"));
	
		String sql = "delete notice where id='"+id+"'";

		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
	
		int rs = st.executeUpdate(sql);
		
		
		st.close();
		con.close();

		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
	
		dispatcher.forward(request, response);*/
		response.sendRedirect("list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
