<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="mytags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<script type="text/javascript" src="jquery-2.1.1.js"></script>
<script type="text/javascript" src="jscript.js"></script>
<title>Каталог товаров</title>
</head>
<body>
	<div id="header"><c:import url="Header.jsp" charEncoding="UTF-8"></c:import></div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<table>

			<tr>
				<td width="100" valign="top"><form method="post"
						action="/pcshop/TovarFilter">
						Тип техники<br>
						<c:forEach items="${pctype}" var="item">
							<c:if test="${fn:contains(pcTypes,item.getId())}">
								<input type="checkbox" name="checkedRows" value="${item.getId()}" checked="checked" />${item.getName()}<br>
							</c:if>
							<c:if test="${not fn:contains(pcTypes,item.getId())}">
								<input type="checkbox" name="checkedRows" value="${item.getId()}" />${item.getName()}<br>
							</c:if>

						</c:forEach>
						Цена от <input type="text" name="priceStart" value="${priceStart}">
						Цена до<input type="text" name="priceEnd" value="${priceEnd}">
						Количество ядер<input type="text" name="CORE" value="${CORE}">
						ОЗУ<input type="text" name="RAM" value="${RAM}"> 
						HDD<input type="text" name="HDD" value="${HDD}"> 
						<input type="submit" value="Обновить" name="send">
					</form>
					<form action="/pcshop/ResetFilter" method="get">
						<input type="submit" value="Сбросить" name="reset">
					</form></td>
				<td valign="top"><mytags:Catalog /></td>
			</tr>
		</table>
	</div>
</body>
</html>