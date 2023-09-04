<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<h1>구장 예약</h1>

<div>
	<c:forEach items="${FIELDS}" var="FIELD">

		<div>
			<img alt="" src="${rootPath}/files/${FIELD.f_main_image}" width="100px">
			<div>${FIELD.f_name}</div>
		</div>
	</c:forEach>
</div>