<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.yedam.board.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard.jps</title>
</head>
<body>
   <%
      //JSP안에서 자바스크립트를 쓸 수 있게 해주는 문자.
      String bNo = request.getParameter("boardNo");
      BoardDAO dao = new BoardDAO();
      Board b = dao.getBoardInfo(Integer.parseInt(bNo));
   %>
   <h1>
      <a href="getBoardList.html">Board List</a>
   </h1>
   <table border=1>
      <tr>
         <td>BoardNo</td>
         <td><%=bNo%></td>
      </tr>
      <tr>
         <td>Content</td>
         <td><%=b.getContent()%></td>
      </tr>
      <tr>
         <td>Writer</td>
         <td><%=b.getWriter()%></td>
      </tr>
      <tr>
         <td>CreateDate</td>
         <td><%=b.getDate()%></td>
      </tr>
   </table>
</body>
</html>