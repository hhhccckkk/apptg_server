<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="h" uri="/struts-tags"%>
<%@ include file="session.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理界面</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.yingcang').toggle();
		return false;
	});
</script>

<script type="text/javascript">
	$(function() {
		//setMenuHeight
		$('.menu').height($(window).height() - 51 - 27 - 26 - 5);
		$('.sidebar').height($(window).height() - 51 - 27 - 26 - 5);
		$('.page').height($(window).height() - 51 - 27 - 26 - 5);
		$('.page iframe').width($(window).width() - 15 - 168);

		//menu on and off
		$('.btn').click(function() {
			$('.menu').toggle();

			if ($(".menu").is(":hidden")) {
				$('.page iframe').width($(window).width() - 15 + 5);
			} else {
				$('.page iframe').width($(window).width() - 15 - 168);
			}
		});

		//
		$('.subMenu a[href="#"]').click(function() {
			$(this).next('ul').toggle();
			return false;
		});
	})
</script>

<style type="text/css">
<!--
.STYLE1 {
	font-weight: bold;
}
-->
</style>
</head>
<body style="overflow-y:hidden">
	<div id="wrap">
		<div id="header">
			<div class="logo fleft"></div>

			<div class="nav fleft">
				<ul>
					<div class="nav-left fleft"></div>
					<li><a href="getusers?page=1" target=right>用户</a></li>
					<li><a href="getZiYuans?page=1" target=right>资源</a></li>
					<li><a href="getQuDao?page=1" target=right>渠道</a></li>
					<li><a href="getHuiTie?page=1" target=right>回帖</a></li>
					<li><a href="getFanKui?" target=right>反馈信息</a></li>
					<div class="nav-right fleft"></div>
				</ul>
			</div>
			<a class="logout fright"
				onclick="if(confirm('确定退出吗'))window.location='tuichuok.jsp'"
				{window.opener=null;window.close();}"> </a>
			<div class="clear"></div>
			<div class="subnav">
				<div class="subnavLeft fleft"></div>
				<div class="fleft"></div>
				<div class="subnavRight fright"></div>
			</div>
		</div>
		<!--#header -->
		<div id="content">
			<div class="space"></div>
			<div class="menu fleft">
				<ul>
					<li class="subMenuTitle">功能列表</li>
					<li class="subMenu"><a href="#">用户管理</a>
						<ul class="yingcang">
						<li><a href="addUser.jsp" target="right">增加用户</a></li>
							<li><a href="searchUser.jsp" target="right">搜索用户</a></li>
							<li><a href="getUserSize?type=0" target="right">用户统计</a></li>
							<li><a href="getUserSize?type=1" target="right">今天新增用户</a></li>
							<li><a href="getUserSize?type=2" target="right">昨天新增用户</a></li>
						</ul></li>
					<li class="subMenu"><a href="#">资源管理</a>
						<ul class="yingcang">
							<li><a href="addzy.jsp" target="right">增加资源</a></li>
							<li><a href="searchZiYuan.jsp" target="right">搜索资源</a></li>
						</ul></li>
					<li class="subMenu"><a href="#">渠道管理</a>
						<ul class="yingcang">
							<li><a href="addqd.jsp" target="right">增加渠道</a></li>
						</ul></li>
					 
					<li class="subMenu"><a href="#">举报信息</a>
						<ul class="yingcang">
							<li><a href="getJuBao?page=1" target="right">举报信息</a></li>
						</ul></li>
					<li class="subMenu"><a href="#">信息管理</a>
						<ul class="yingcang">

							<li><a href="getTZ?page=1&type=1" target="right">信息列表</a></li>
							<li><a href="addMessage.jsp" target="right">增加短信息</a></li>
						</ul></li>

				</ul>
			</div>
			<div class="sidebar fleft">
				<div class="btn"></div>
			</div>
			<div class="page">
				<iframe width="100%" scrolling="auto" height="100%"
					frameborder="false" allowtransparency="true"
					style="border: medium none;" src="main.jsp" id="rightMain"
					name="right"></iframe>
			</div>
		</div>
		<!--#content -->
		<div class="clear"></div>
		<div id="footer">版权所有——蝌蚪笑话 ; 2012-10 www.hck.com</div>
		<!--#footer -->
	</div>
	<!--#wrap -->
</body>
</html>

