<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<meta charset="UTF-8">
<title>Главная страница</title>
</head>
<body>
	<div id="header"><c:import url="Header.jsp" charEncoding="UTF-8"></c:import></div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<form action="/pcshop/register" method="post">
			<table>
				<tr>
					<td>Логин</td>
					<td><input type="text" name="Login" value=""></td>
				</tr>
				<tr>
					<td>Пароль</td>
					<td><input type="password" name="Password" value=""></td>
				</tr>
				<tr>
					<td>Имя</td>
					<td><input type="text" name="fname" value=""></td>
				</tr>
				<tr>
					<td>Фамилия</td>
					<td><input type="text" name="lname" value=""></td>
				</tr>
				<tr>
					<td><input id="Button1" type="submit" value="Отправить"></td>
					<td><input id="Reset1" type="reset" value="Сброс"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>