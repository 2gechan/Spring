<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 홈페이지</title>
<link rel="stylesheet" href="${rootPath}/resources/css/ceopage.css" />
<script type="text/javascript" src="${rootPath}/resources/js/ceopage.js"></script>
<script type="text/javascript">
	var rootPath = "${rootPath}"
</script>
</head>
<body>
	<div class="container">
		<header>
			<h1>구장을 등록해주세요</h1>
		</header>
		<div class="subtitle">
			<span class="ceoname">${CEO.u_name}</span> <span class="todaymoeny">오늘
				매출</span>
		</div>
		<div class="main-wrapper">
			<c:if test="${empty CEOBODY}">

				<div class="admin field">
					<div class="dashboard title">
						<span class="field-admin">구장관리</span>
						<img alt="" src="">
					</div>
				</div>
				<div class="admin review">
					<div class="dashboard title">
						<span class="review-admin">후기 관리</span>
					</div>
				</div>
				<div class="admin reservation">
					<div class="dashboard title">
						<span class="reservation-admin">예약 현황</span>
					</div>
				</div>
			</c:if>
			<c:if test="${CEOBODY == 'REG'}">
				<%@ include file="/WEB-INF/views/jsp/futsal/field-registration.jsp"%>
			</c:if>
		</div>
	</div>
</body>
</html>
