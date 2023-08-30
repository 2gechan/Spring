<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230717-002" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차계부 기록 수정</title>
<link href="${rootPath}/resources/css/update.css?${version}"
	rel="stylesheet" />
<script type="text/javascript"
	src="${rootPath}/resources/js/update.js?${version}"></script>
</head>
<body>
	<form action="" method="POST" class="update-form">
		<div>
			<label>NO.</label> <input class="seq" value="${DATA.mc_seq}" name="mc_seq" readonly />
		</div>
		<div>
			<label>구분</label> <input value="${DATA.mc_div}" name="mc_div" />
		</div>
		<div>
			<label>출발일자</label> <input value="${DATA.mc_sdate}" name="mc_sdate" />
		</div>
		<div>
			<label>출발시간</label> <input value="${DATA.mc_stime}" name="mc_stime" />
		</div>
		<div>
			<label>출발거리</label> <input value="${DATA.mc_sdistance}"
				name="mc_sdistance" />
		</div>
		<div>
			<label>도착일자</label> <input value="${DATA.mc_edate}" name="mc_edate" />
		</div>
		<div>
			<label>도착시간</label><input value="${DATA.mc_etime}" name="mc_etime" />
		</div>
		<div>
			<label>도착거리</label> <input value="${DATA.mc_edistance}"
				name="mc_edistance" />
		</div>
		<div>
			<label>장소</label> <input value="${DATA.mc_place}" name="mc_place" />
		</div>
		<div>
			<label>비용</label> <input value="${DATA.mc_cost}" name="mc_cost" />
		</div>
		<button type="button" class="updateBtn">수정</button>
		<button type="button" class="deleteBtn">삭제</button>

	</form>
</body>
</html>