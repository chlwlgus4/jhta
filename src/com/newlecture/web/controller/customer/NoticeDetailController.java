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

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		int id= Integer.parseInt(request.getParameter("id"));
	
		String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		
		/*	String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		String sql2 = "select * from notice where id = (select min(id) from notice where r>"+id+")";
		String sql3 = "select * from notice where id = (select max(id) from notice where id<"+id+")";*/
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		

		
		
		//1. 사용자가 전달한 id 값을 읽어온다.
		// 2. 데이터베이스에서 id=?인 레코드를 얻어오는 jdbc 코드를 작성한다.
		rs.next();
	
		Notice n = new Notice(
				rs.getInt("id"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getString("writer_id"),
				rs.getDate("regdate"),
				rs.getInt("hit")
				);
		
		
		/*ResultSet rs2 = st.executeQuery(sql2);
		rs2.next();
		request.setAttribute("backtitle", rs2.getString("title"));*/
		
		/*ResultSet rs3 = st.executeQuery(sql3);
		rs3.next();
		request.setAttribute("nexttitle", rs3.getString("title"));*/
		
		
		/*rs3.close();
		rs2.close();*/
		rs.close();
	
		st.close();
		con.close();
		request.setAttribute("n", n);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/Detail.jsp");
	
		dispatcher.forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
