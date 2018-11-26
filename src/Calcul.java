import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcal")
public class Calcul extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8"); 

      PrintWriter out = response.getWriter();

      String nbtn = request.getParameter("nbtn");

      RequestDispatcher dispatcher = request.getRequestDispatcher("calcal.jsp");
      request.setAttribute("nbtn", nbtn);

      dispatcher.forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");

      PrintWriter out = response.getWriter();

      String cmd = request.getParameter("cmd");
      String nbtn = request.getParameter("tbtn");
      String nbtn2 = request.getParameter("nbtn2");
      String nbtn3 = request.getParameter("tbtn1");
      String restotal=request.getParameter("restotal");
      
      switch(cmd){
      case "9":
         nbtn+="9";
         nbtn2=nbtn;
         nbtn3+=9;
         break;   

      case "8":
         nbtn+="8";
         nbtn2=nbtn;
         nbtn3+=8;
         break;      

      case "7":
         nbtn+="7";
         nbtn2=nbtn;
         nbtn3+=7;
         break;      

      case "6":
         nbtn+="6";
         nbtn2=nbtn;
         nbtn3+=6;
         break;      

      case "5":
         nbtn+="5";
         nbtn2=nbtn;
         nbtn3+=5;
         break;      

      case "4":
         nbtn+="4";
         nbtn2=nbtn;
         nbtn3+=4;
         break;      

      case "3":
         nbtn+="3";
         nbtn2=nbtn;
         nbtn3+=3;
         break;      

      case "2":
         nbtn+="2";
         nbtn2=nbtn;
         nbtn3+=2;
         break;      

      case "1":
         nbtn+="1";
         nbtn2=nbtn;
         nbtn3+=1;
         break;
      case "0":
         nbtn+="0";
         nbtn2=nbtn;
         nbtn3+=0;
         break;
      case ".":
         nbtn+=".";
         nbtn2=nbtn;
         nbtn3+=".";
         break;

      case "¡¾":
         nbtn+="¡¾";
         nbtn2=nbtn;
         break;
      
      case "+":
         nbtn+="+";
         nbtn2=nbtn;
         nbtn3+="+";
         break;
      case "=":
         
         if(nbtn.contains("+")) {
            String [] res=nbtn.split("\\+");
            restotal=(Integer.parseInt(res[0])+Integer.parseInt(res[1]))+"";
            nbtn2=Integer.parseInt(res[0])+Integer.parseInt(res[1])+"";
            nbtn=nbtn2;
         }else if(nbtn.contains("*")) {
            String [] res=nbtn.split("\\*");
            restotal=(Integer.parseInt(res[0])*Integer.parseInt(res[1]))+"";
         }else if(nbtn.contains("/")) {
            String [] res=nbtn.split("\\/");
            restotal=(Integer.parseInt(res[0])/Integer.parseInt(res[1]))+"";
         }else if(nbtn.contains("-")) {
            String [] res=nbtn.split("\\-");
            restotal=(Integer.parseInt(res[0])-Integer.parseInt(res[1]))+"";
         }
         
         break;
      case "/":
         nbtn+="/";
         nbtn2=nbtn;
         nbtn3+="/";
         break;
      case "*":
         nbtn+="*";
         nbtn2=nbtn;
         nbtn3+="*";
         break;
      case "C":
         nbtn="";
         nbtn2=nbtn;
         nbtn3="";
         restotal="";
         break;
      case "-":
         nbtn+="-";
         nbtn2=nbtn;
         nbtn3+="-";
         break;
      }

      /*HttpSession session = request.getSession();
      session.setAttribute("x",x); */
//      total.split("+");
//      response.sendRedirect("calcal?x="+total);
      RequestDispatcher dispatcher = request.getRequestDispatcher("calcal.jsp");
      request.setAttribute("nbtn", nbtn);
      request.setAttribute("nbtn2", nbtn2);
      request.setAttribute("nbtn3", nbtn3);
      request.setAttribute("restotal", restotal);

      dispatcher.forward(request, response);

   }

}