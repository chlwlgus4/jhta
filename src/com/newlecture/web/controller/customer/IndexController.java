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

@WebServlet("/index")
public class IndexController extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8"); 
			// TODO Auto-generated method stub
			/*int id= Integer.parseInt(request.getParameter("id"));
			String sql = "SELECT * FROM NOTICE WHERE ID="+id;
	
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();
		
			Notice n = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
					);
	
			rs.close();
			st.close();
			con.close();
			request.setAttribute("n", n);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");

dispatcher.forward(request, response);
		}
}


