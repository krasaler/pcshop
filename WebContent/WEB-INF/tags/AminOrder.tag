<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${ordersall.Size()>0}">
	<table border="1">
		<tr>
			<th>User</th>
			<th>Номер заказа</th>
			<th>Дата заказа</th>
			<th>Адресс доставки</th>
			<th>Сумма</th>
			<th>Статус заказа</th>
			<th>Действия</th>
		</tr>
		<c:forEach begin="0" end="${ordersall.Size()-1}" var="i">
			<tr>
				<td><c:out value="${ordersall.getAccount(i).getLogin()}" /></td>
				<td><c:out value="${ordersall.getOrder(i).getId()}" /></td>
				<td><c:out value="${ordersall.getOrder(i).getDate()}" /></td>
				<td><c:out value="${ordersall.getOrder(i).getAddress()}" /></td>
				<td><c:out value="${ordersall.getOrder(i).getSum()}" /></td>
				<td><c:out
						value="${ordersall.getOrder(i).getStatus().getName()}" /></td>
				<td><c:if
						test="${ordersall.getOrder(i).getStatus().getName() eq 'Действителен'}">
						<form action="/pcshop/remorder" method=post>
							<input type=hidden name=id
								value="${ordersall.getOrder(i).getId()}" /> <input id=Button1
								type=submit value=Отменить>
						</form>
					</c:if> <c:if
						test="${ordersall.getOrder(i).getStatus().getName() 
							eq 'Отменен'}">
						<form action="/pcshop/remorder" method=post>
							<input id=Button1 type=submit value=Отменить disabled="disabled">
						</form>
					</c:if>
					<form action="/pcshop/orderContent" method=post>
						<input type=hidden name=id
							value="${ordersall.getOrder(i).getId()}" /> <input id=Button1
							type=submit value=Товары>
					</form></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${ordersall.Size()==0}">
	<td colspan="7"><c:out value="Заказы не найдены" /></td>
</c:if>

<c:if test="${noOfPages>0}">
	<table border="1">
		<tr>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="OrderItemFull?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
</c:if>