<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ include file="session.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="script/validation-framework.js" charset="GBK"></script>
  </head>
  
  <body>
    
  <div align="center">
  <form action="searchUser" method="post" >
    <table width="588" border="0" cellpadding="0" cellspacing="0">
      <!--DWLayoutTable-->
      <tr>
        <td width="86" height="127">&nbsp;</td>
        <td width="282">&nbsp;</td>
        <td width="220">&nbsp;</td>
      </tr>
      <tr>
        <td height="45">&nbsp;</td>
        <td >关键字：
          <label>
          <input name="key" type="text" size="20">
          </label>
          <label>
          <input type="submit" name="Submit" value="搜索">
          </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="195">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></form>
  </div>
  </body>
</html>
