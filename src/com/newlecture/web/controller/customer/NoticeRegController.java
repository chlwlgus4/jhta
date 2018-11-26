package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/customer/notice/reg")
@MultipartConfig(
	      fileSizeThreshold = 1024*1024, // 
	      maxFileSize = 1024*1024*10,     //10메가
	      maxRequestSize = 1024*1024*10*5 //10메가 5개까지
	      )
public class NoticeRegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/Reg.jsp");


		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		String filePath = path + File.separator+"aa.jpg";
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part part = request.getPart("file");
		InputStream fis = part.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		
		int size = 1024;
		
		while((size = fis.read(buf)) >= 0)
			fos.write(buf, 0, size);
		
		System.out.println(title);

		String sql = "insert into notice(id, title, writer_id, content) values(NOTICE_SEQ.NEXTVAL, ?, ? , ?)";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, title);
			st.setString(2, "hyungho");
			st.setString(3, content);
			
			int affected = st.executeUpdate();
			
			response.sendRedirect("list");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		



	}
}
