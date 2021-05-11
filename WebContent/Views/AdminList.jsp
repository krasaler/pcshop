<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="mytags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<title>Список заказов</title>
</head>
<body>
	<div id="header"><c:import url="Header.jsp" charEncoding="UTF-8"></c:import></div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<table>
			<tr>
				<td width="50" valign="top"><form method="post"
						action="/pcshop/orderFilter">
						Номер заказа <input type="text" name="idorder" value="${idorder}">
						Сумма от <input type="text" name="priceStart" value="${priceStart}">
						Сумма до<input type="text" name="priceEnd" value="${priceEnd}">
						Пользователь<input type="text" name="userFilter" value="${userFilter}">
						Дата от <input type=date name="dateStart" value="${dateStart}">
						Дата до<input type="date" name="dateEnd" value="${dateEnd}">
						<input type="submit" value="Обновить" name="send">

					</form>
					<form action="/pcshop/ResetOrderItems" method="get">
						<input type="submit" value="Сбросить" name="reset">
					</form></td>
				<td valign="top"><mytags:AminOrder /></td>
			</tr>
		</table>

	</div>
</body>
</html>