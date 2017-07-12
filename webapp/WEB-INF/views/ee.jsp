<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ee.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function aa(id,name/* ,time */){
			var idd=document.getElementById(id).innerHTML;
			var names=document.getElementById(name).innerHTML;
			/* var times=document.getElementById(time).innerHTML;
			alert(times); */
			document.getElementById("aaa").value=idd;
			document.getElementById("bbb").value=names;
			/* document.getElementById("ccc").value=times; */
		}
	</script>
</head>

<body>
	<div>
	
		<table width="465" border="1">
			<tr>
				<td width="121" align="center">编号</td>
				<td width="235" align="center">名称</td>
				<td width="260" align="center">日期</td>
				<td width="150" align="center">操作</td>
			</tr>
			<%-- <s:iterator value="list">
					<tr id ='qq'>
					<td id="${id}" align="center">${id}</td>
					<td id="${id}1" align="center">${name}</td>
					<td id="${id}2" align="center">${time}</td>
					<td align="center"><a href="Delete?id=${id}">删除</a>
					<a  onclick="aa(${id},${id}1,${id}2)">修改</a></td>
				</tr>
			</s:iterator> --%>
			<c:forEach items="${list}" var="item">
				<tr id ='qq'>
					<td id="${item.id}" align="center">${item.id}</td>
					<td id="${item.id}1" align="center">${item.name}</td>
					<td id="${item.id}2" align="center">${item.time}</td>
					<td align="center">
					<a href="delete_${item.id}.html">删除</a>
					<a  onclick="aa(${item.id},${item.id}1,${item.id}2)">修改</a></td>
					
				</tr>
			</c:forEach>
		</table>
		<hr/>
		<form action="add.html" method="post">
			名称<input type="text" value="" name="name" />
			<input type="submit" value="添加"/>
		</form>
		<hr/>
		<form action="update.html" method="post">
			编号<input id="aaa" type="text" value="" readonly="readonly" name="id"/>
			名称<input id="bbb" type="text" value="" name="nn" />
			<!-- 时间<input id="ccc" type="text" value="" name="time" /> -->
			<input type="submit" value="修改"/>
		</form>
		
	</div>
</body>
</html>
