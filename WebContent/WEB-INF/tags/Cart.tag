<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="visibleOption" required="false"
	type="java.lang.Boolean"%>
<jsp:useBean id="cart" class="bean.CartList" scope="session" />
<table border="1">
	<tr>
		<th>ID</th>
		<th>Название</th>

		<th>Тип</th>
		<th>ОЗУ</th>
		<th>HDD</th>
		<th>Количество ядер</th>

		<th>Количество</th>
		<th>Цена</th>
		<th>Сумма</th>
		<c:if test="${visibleOption}">
			<th>Действие</th>
		</c:if>
	</tr>
	<c:if test="${cart.Size() ne 0}">
		<c:forEach begin="0" end="${cart.Size()-1}" var="i">
			<tr>
				<td><c:out value="${cart.get(i).getID()}" /></td>
				<td><c:out value="${cart.get(i).getName()}" /></td>
				<td><c:out value="${cart.get(i).getPctype().getName()}" /></td>
				<td><c:out value="${cart.get(i).getRAM()}" /></td>
				<td><c:out value="${cart.get(i).getHDD()}" /></td>
				<td><c:out value="${cart.get(i).getCoresCount()}" /></td>
				<td><c:out value="${cart.getCounts(i)}" /></td>
				<td><c:out value="${cart.get(i).getPrice()}" /></td>
				<td><c:out value="${cart.getSum(i)}" /></td>
				<c:if test="${visibleOption}">
					<td width=100>
						<table>
							<tr>
								<td>
									<form action=/pcshop/AddCart method=post>
										<input id=Button1 type=submit value=+> <input
											type=hidden name=id value="${cart.get(i).getID()}" />
									</form>
								</td>
								<td>
									<form action=/pcshop/MinusCart method=post>
										<input id=Button1 type=submit value=-> <input
											type=hidden name=id value="${cart.get(i).getID()}" />
									</form>
								</td>
								<td>
									<form action=/pcshop/RemCart method=post>
										<input id=Button1 type=submit value=x> <input
											type=hidden name=id value="${cart.get(i).getID()}" />
									</form>
								</td>
							</tr>
						</table>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</c:if>
	<tr>
		<td>Всего:</td>
		<c:if test="${visibleOption}">
			<td colspan=9><c:out value="${cart.getSum()}" /></td>
		</c:if>
		<c:if test="${not visibleOption}">
			<td colspan=8><c:out value="${cart.getSum()}" /></td>
		</c:if>
	</tr>
</table>