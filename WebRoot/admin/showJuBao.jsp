<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="com.hck.apptg.util.FenYe"%>
<%@ include file="session.jsp"%>
<%@ taglib prefix="h" uri="/struts-tags"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	int flag = FenYe.getFlag("jubaoPage");
	int maxnum = FenYe.getMaxnum("jubaoSize");
	int pagenum = FenYe.getnum("jubaoSize", 20);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>显示信息</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('tbody tr:odd').addClass("trLight");

		$(".select-all").click(function() {
			if ($(this).attr("checked")) {
				$(".checkBox input[type=checkbox]").each(function() {
					$(this).attr("checked", true);
				});
			} else {
				$(".checkBox input[type=checkbox]").each(function() {
					$(this).attr("checked", false);
				});
			}
		});

	})
</script>
<script language="javascript">
	function check(stype, na) {

		for (var i = 0; i < document.getElementsByName(na).length; i++) {
			if (stype == 'all')
				document.getElementsByName(na)[i].checked = true;
			else
				document.getElementsByName(na)[i].checked = false;
		}
	}
	function submit(na) {

		var str = '';
		for (var i = 0; i < document.getElementsByName(na).length; i++) {
			if (document.getElementsByName(na)[i].checked) {
				if (str == '')
					str += document.getElementsByName(na)[i].value;
				else
					str += ',' + document.getElementsByName(na)[i].value;
			}
		}
		if (str == '') {
			alert('你没选择任何内容！');
			return false;
		} else {
			location = "deleteUser?idString=" + str;
		}
	}
</script>
<style type="text/css">
body {
	background: #FFF
}
</style>
</head>

<body>
	<center>
		<font color="red"><h:actionerror /></font>
		<h:fielderror cssStyle="color:red;font-size:14px"></h:fielderror>
	</center>
	<div id="contentWrap">

		<!--表格控件 -->
		<div id="widget table-widget">
			<div class="pageTitle">用户信息</div>
			<div class="pageColumn">
				<div class="pageButton"></div>
				<table>
				
					<thead>
						<th width="25"><input class="select-all" name=""
							type="checkbox" value="" /></th>
						<th width="">id</th>
						<th width="">举报用户</th>
						<th width="">被举报用户</th>
						<th width="">帖子id</th>
						<th width="">内容</th>
						<th width="">时间</th>
						<th width="">操作</th>

					</thead>
					<tbody>
						<h:iterator value="jubaos" var="qd">
							<tr>
								<td class="checkBox"><input name="plid" type="checkbox"
									value="<h:property value="#u.id"/>" /></td>
								<td><h:property value="#qd.id" /></td>
								<td><a href="getOneUser?id=<h:property value="#qd.uid"/>"><h:property
											value="#qd.uid" /></a></td>

								<td><a href="getOneUser?id=<h:property value="#qd.buid"/>"><h:property
											value="#qd.bname" /></a></td>
											<td><a href="getOneUser?id=<h:property value="#qd.tid"/>"><h:property
											value="#qd.tid" /></a></td>
								<td><h:property value="#qd.bcontent" /></td>
								<td><h:property value="#qd.btime" /></td>
								<td>
								<a href="deleteJuBao?id=<h:property value="#qd.id"/>">
									删除<img src="images/icon/del.png" width="16" height="16" />
								</a>
								</td>
							</tr>
						</h:iterator>
						<tr class=" ">
							<td><label> <input type="button" value="删除"
									onclick="submit('plid')" />
							</label></td>
							<td colspan="7" class="checkBox">共找到 <%=maxnum%>
								条记录，每页20条记录,共<%=pagenum%>页 &lt; <a
								href="getJuBao?page=<%=flag - 1%>" class="STYLE6">上页</a> <a
								href="getJuBao?page=<%=1 >= pagenum ? pagenum : 1%>"
								class="STYLE6">1</a>&nbsp; <a
								href="getJuBao?page=<%=2 >= pagenum ? pagenum : 2%>"
								class="STYLE6">2</a>&nbsp; <a
								href="getJuBao?page=<%=3 >= pagenum ? pagenum : 3%>"
								class="STYLE6">3</a>&nbsp; <a
								href="getJuBao?page=<%=4 >= pagenum ? pagenum : 4%>"
								class="STYLE6">4</a>&nbsp; <a
								href="getJuBao?page=<%=5 >= pagenum ? pagenum : 5%>"
								class="STYLE6">5</a>&nbsp; <a
								href="getJuBao?page=<%=6 >= pagenum ? pagenum : 6%>"
								class="STYLE6">6</a>&nbsp; <a
								href="getJuBao?page=<%=7 >= pagenum ? pagenum : 7%>"
								class="STYLE6">7</a>&nbsp; <a
								href="getJuBao?page=<%=8 >= pagenum ? pagenum : 8%>"
								class="STYLE6">8</a>&nbsp; <a
								href="getJuBao?page=<%=9 >= pagenum ? pagenum : 9%>"
								class="STYLE6">9</a>&nbsp; <a
								href="getJuBao?page=<%=10 >= pagenum ? pagenum : 10%>"
								class="STYLE6">10</a>&nbsp; <a
								href="getJuBao?page=<%=(flag + 1) >= pagenum ? pagenum : (flag + 1)%>"
								class="STYLE6">下页&gt;</a>&nbsp;
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- #widget -->
	</div>
</body>
</html>
