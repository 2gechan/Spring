<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230715-002" var="version" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 차계부 2023</title>
<link rel="stylesheet"
	href="${rootPath}/resources/css/index.css?${version}" />
<script src="${rootPath}/resources/js/index.js?${version}"></script>
<script>
	// JSP 에서 사용하는 rootPath 변수를
	// JS 코드에서 사용하기 위한 rootPath 변수로 재 설정
	var rootPath = "${rootPath}"
</script>
</head>
<body>
	<header>
		<h1>MY CAR MANAGER</h1>
	</header>
	<form action="" class="form-input" method="POST">
		<div>
			<label for="">운행등록</label>
			<input type="text" class="div" placeholder="구분" name="mc_div" /> 
			<input type="text" class="start" 	placeholder="시작거리" name="mc_sdistance" /> 
			<input type="text" 	class="place" placeholder="장소" name="mc_place" />
		</div>
		<div>
			<input type="text" placeholder="종료거리" name="mc_edistance" /> 
			<input	type="text" placeholder="소요비용" name="mc_cost" />
			<button type="button">저장</button>
		</div>
	</form>
	<table class="main-table">
		<tr>
			<th>No.</th>
			<th>구분</th>
			<th>출발일자</th>
			<th>출발시간</th>
			<th>출발거리(Km)</th>
			<th>도착일자</th>
			<th>도착시간</th>
			<th>도착거리</th>
			<th>장소</th>
			<th>소요비용</th>
		</tr>
		<c:forEach items="${LIST}" var="CAR">
			<tr data-id="${CAR.mc_seq}">
				<td>${CAR.mc_seq}</td>
				<td>${CAR.mc_div}</td>
				<td>${CAR.mc_sdate}</td>
				<td>${CAR.mc_stime}</td>
				<td>${CAR.mc_sdistance}</td>
				<td>${CAR.mc_edate}</td>
				<td>${CAR.mc_etime}</td>
				<td>${CAR.mc_edistance}</td>
				<td>${CAR.mc_place}</td>
				<td>${CAR.mc_cost}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
