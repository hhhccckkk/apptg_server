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

<title>My JSP 'showOneUser.jsp' starting page</title>

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
	<form action="updateState" method="post">
		<div align="center">
			<br>
			<table width="898" border="0" cellpadding="0" cellspacing="0">
				<!--DWLayoutTable-->
				<tr>

					<td height="38" colspan="3" valign="top">用户详细信息</td>
					<td width="95" valign="top"><a
						href="admin/getUserTieZi?page=1&id=<h:property value="user.id"/>">发的资源信息</a></td>
					<td width="95" valign="top"><a
						href="admin/getUserQuDao?page=1&id=<h:property value="user.id"/>">发的渠道信息</a></td>
					<td width="233"><a
						href="admin/getUserPl?id=<h:property value="user.id"/>&page=1">评论信息</a></td>

				</tr>
				<tr>
					<td width="135" height="54">&nbsp;</td>
					<td colspan="4">id号：<input name="id"
						value="<h:property value="user.id"/>" type="hidden" /></td>

					<td><h:property value="user.id" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">头像:</td>
					<td><img src="<h:property value="user.touxiang"/>" width="40"
						height="40"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">昵称:</td>
					<td><h:property value="user.nicheng" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">QQ：</td>
					<td><h:property value="user.qq" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">微信：</td>
					<td><h:property value="user.weixin" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">电话：</td>
					<td><h:property value="user.phone" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="34">&nbsp;</td>
					<td colspan="4">介绍：</td>
					<td><h:property value="user.jieshao" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>


				<tr>
					<td height="38">&nbsp;</td>
					<td colspan="4">是否正常：</td>
					<td><input name="isok" value="<h:property value="user.isok"/>"
						type="text" /></td>
					<td><input type="submit" name="Submit" value="修改"
						style="background:
			  #0099FF; color:#FFFFFF; border-color:#0099FF"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="37">&nbsp;</td>
					<td colspan="4">mac：</td>
					<td><h:property value="user.imei" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>


				<tr>
					<td height="34">&nbsp;</td>
					<td colspan="4">型号：</td>
					<td><h:property value="user.xinghao" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td height="31">&nbsp;</td>
					<td colspan="4">时间：</td>
					<td><h:property value="user.registertime" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td height="1"></td>
					<td width="10"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
