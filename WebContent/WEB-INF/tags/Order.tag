<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${orders.Size() ne 0}">
	<table border=1>
		<tr>
			<th>Номер заказа</th>
			<th>Адрес доставки</th>
			<th>Дата заказа</th>
			<th>Сумма</th>
			<th>Статус</th>
			<th width="50">Список товаров</th>
		</tr>
		<c:forEach begin="0" end="${orders.Size()-1}" var="i">
			<tr>
				<td><c:out value="${orders.get(i).getId()}" /></td>
				<td><c:out value="${orders.get(i).getAddress()}" /></td>
				<td><c:out value="${orders.get(i).getDate()}" /></td>
				<td><c:out value="${orders.get(i).getSum()}" /></td>
				<td><c:out value="${orders.get(i).getStatus().getName()}" /></td>
				<td><form action="/pcshop/orderContent" method="post">
						<input type="hidden" name=id value="${orders.get(i).getId()}" />
						<input type="submit" name="send" value="Список товаров" />
					</form></td>
			</tr>
		</c:forEach>

		<c:if test="${orders.Size()==0}">
			<c:out value="Заказы не найдены" />
		</c:if>
	</table>
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
						<td><a href="OrderItems?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
</c:if>