<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" type="text/css" href="StyleCss.css" />
<title>Контакты</title>
</head>
<body>
	<div id="header"><c:import url="Header.jsp" charEncoding="UTF-8"></c:import></div>
	<div id="sidebar">
		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
	</div>
	<div id="content">
		<h2>Контактная информация</h2>
		<p>Магазин работает 24 часа в сутки, 7 дней в неделю, 365 дней в
			году!!!</p>
		<p>Адрес: Украина, г.Харьков,</p>
		<p>Место расположение магазина</p>
		<a
			href="https://www.google.com.ua/maps/place/49%C2%B059'51.9%22N+36%C2%B014'48.9%22E/@49.9976415,36.2468727,18z/data=!4m2!3m1!1s0x0:0x0?hl=ru"
			target="_blank">Как к нам доехать</a>
		<p>Возникли вопросы? Свяжитесь с нами...</p>
		<a href="mailto:dota@server.ru&Subject=Письмо администрации">Отправить
			письмо</a>
	</div>
</body>
</html>