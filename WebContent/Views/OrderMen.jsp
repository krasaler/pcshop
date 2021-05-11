<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="mytags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Подтверждение заказа</title>
</head>
<body>
	<div id="header">
		<c:import url="Header.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<h2>Благодарим вас за прокупку!</h2>
		<h3><c:out value="Номер вашего заказа:${orderid}"></c:out></h3>
	</div>
</body>
</html>