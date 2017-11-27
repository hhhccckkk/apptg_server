<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="h" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addJok.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<font color="red"><h:actionerror /></font>
		<h:fielderror cssStyle="color:red;font-size:14px"></h:fielderror>
	</center>
	<form action="addUser" method="post">
		<div align="center">
			<table width="981" border="0" cellpadding="0" cellspacing="0">
				<!--DWLayoutTable-->
				<tr>
					<td width="217" height="19">&nbsp;</td>
					<td width="81">&nbsp;</td>
					<td width="377">&nbsp;</td>
					<td width="104">&nbsp;</td>
					<td width="202">&nbsp;</td>
				</tr>
				<tr>
					
					<td height="20">&nbsp;</td>
					<td colspan="2" valign="top">增加用户&gt;&gt;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="47">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="36">&nbsp;</td>
					<td>昵称:</td>
					<td><input type="text" name="user.nicheng" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="36">&nbsp;</td>
					<td>头像:</td>
					<td><input type="text" name="user.touxiang" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td height="200">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>



				<tr>
					<td height="36">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input type="submit" name="Submit" value="增加"
						style="background:
			  #0099FF; color:#FFFFFF; border-color:#0099FF"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="84">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
