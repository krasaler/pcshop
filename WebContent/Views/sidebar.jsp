
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>
	<a href="index.jsp">Главная страница</a>
</p>
<c:if test="${sessionScope.atype ne 'admin'}">
	<p>
		<a href="/pcshop/TovarItems">Список товаров</a>
	</p>
	<p>
		<a href="Zakaz.jsp">Корзина</a>
	</p>
	<p>
		<a href="/pcshop/OrderItems">Список заказов</a>
	</p>
</c:if>
<c:if test="${sessionScope.atype eq 'admin'}">
	<p>
		<a href="/pcshop/OrderItemFull">Список заказов</a>
	</p>
</c:if>
<p>
	<a href="Kontakti.jsp">Контакты</a>
</p>
<p>
	<a href="Opisanie.jsp">О нас</a>
</p>
<c:if test="${sessionScope.name == null}">
	<p>

		<a href="Register.jsp">Регистрация</a>
	</p>
	<p>
		<a href="input.jsp">Вход</a>

	</p>
</c:if>
<c:if test="${sessionScope.name != null}">
	<p>
		<a href="/pcshop/exit">Выход</a>
	</p>
</c:if>