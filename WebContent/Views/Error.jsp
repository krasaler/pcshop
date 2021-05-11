<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Произошла ошибка</title>
</head>
<body>
	<div id="header"><c:import url="Header.jsp" charEncoding="UTF-8"></c:import></div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<p>Произошла ошибка!!</p>
	<table>
	<tr>
	<td align="center"></td>
	</tr>
	</table>
	</div>
</body>
</html>