package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/list")
public class NoticeListController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setCharacterEncoding("UTF-8");
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      //한글 깨짐을 방지

      String page_= request.getParameter("p");
      //클라이언트에게 요청한 파라미터 p 값을 얻기 위한 메소드
      int page = 1;
      // 시작하는 페이지 기본값
      if(page_ != null && page_.equals(""))
         page = Integer.parseInt(page_); // 클라이언트가 요청한 파라미터 값을 정수화
         
      String sql = "SELECT * FROM (SELECT ROWNUM NUM, NN.* FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) NN) WHERE NUM BETWEEN ? AND ?";
      //노티스 테이블에서 등록일자순으로 역정렬하고 로우넘버를 이용해 번호를 붙여 원하는 부분부터 원하는 부분까지 조회하는 쿼리문
      String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
      
      try {
      int start = (page-1)*10+1;
      // 등차수열 페이지를 넘길 때마다 시작페이지를 구하기 위해 등차수열 사용
      int end = page*10;
      //페이지의 끝부분을 구함
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         //DB와 연결하기 위함
         PreparedStatement st = con.prepareStatement(sql);
         //쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있는 것
         st.setInt(1, start);
         //1번째 위치에 start변수를 할당
         st.setInt(2, end);
         //2번째 위치에 end변수를 할당
         ResultSet rs = st.executeQuery();
         //쿼리 실행한것을 받아들이기 위해 사용
         List<Notice> list = new ArrayList<>();
         //DB에서 여러줄을 한번에 가져오려고 리스트 컬렉션으로 객체를 저장하기위해 사용
         while(rs.next()) { //받아온 데이터를 한줄씩 읽어들임 if문도 가능
            Notice n = new Notice(
                  rs.getInt("id"), //rs.get??을 이용해서 값을 가져와 변수에 객체를 저장
                  rs.getString("title"),
                  rs.getString("content"),
                  rs.getString("writer_id"),
                  rs.getDate("regdate"),
                  rs.getInt("hit")
                  );
            list.add(n);//노티스 클래스에서 가져온 객체들을 n에 담아서 list 컬렉션에 저장
         }
         rs.close(); //오픈을하면 닫아주어야함
         st.close();
         con.close();
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
      // 현재의 요청을 다른 서블릿으로 보내주기 위한 인스턴스 
      request.setAttribute("list", list);
      //속성의 이름과 속성값을 jsp에 보냄
      dispatcher.forward(request, response);
      //페이지를 이동 할 때 지금 실행중인 페이지와 다음 페이지사이에request, response에 담은 객체를 공유
      } catch (Exception e) { 
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}