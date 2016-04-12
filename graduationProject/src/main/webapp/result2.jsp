<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
     function jump(){
       form1.submit();
     }
    </script>


  </head>
  
  <body>
   <br><br><br>显示所有用户<br/>
   
   
   <table width="400" border="1">
   
      <tr>
       <td>ID</td>
       <TD>用户名</TD>
       <td>密码</td>
      </tr>
      <c:forEach items="${users}" var="user">
      <tr>
       <td>${user.id }</td>
       <TD>${user.username }</TD>
       <td>${user.password }</td>
      </tr>
      </c:forEach>
      
   
   </table>
   
   
  </body>
</html>
