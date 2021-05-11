<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${tovars.Size()>0}">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Название</th>

			<th>Тип</th>
			<th>ОЗУ</th>
			<th>HDD</th>
			<th>Количество ядер</th>
			<th>Цена</th>
			<th>Действие</th>
		</tr>
		<c:forEach begin="0" end="${tovars.Size()-1}" var="i">
			<tr>
				<td><c:out value="${tovars.get(i).getID()}" /></td>
				<td><c:out value="${tovars.get(i).getName()}" /></td>
				<td><c:out value="${tovars.get(i).getPctype().getName()}" /></td>
				<td><c:out value="${tovars.get(i).getRAM()}" /></td>
				<td><c:out value="${tovars.get(i).getHDD()}" /></td>
				<td><c:out value="${tovars.get(i).getCoresCount()}" /></td>
				<td><c:out value="${tovars.get(i).getPrice()}" /></td>
				<td>
					<form action="/pcshop/AddTovar?page=${currentPage}" method=post>
						<input type=hidden name=id value="${tovars.get(i).getID()}" /> <input
							id=Button1 type=submit value=Добавить>
					</form>
				</td>
			</tr>
		</c:forEach>
			</table>
		</c:if>
		<c:if test="${tovars.Size()==0}">
			<c:out value="Товары не найдены" />
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
							<td><a href="TovarItems?page=${i}">${i}</a></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</table>
	</c:if>