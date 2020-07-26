<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL사용하려면...  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap Library  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">

	function modify_form(m_idx){

		location.href = "modify_form.do?m_idx=" + m_idx;

	}
</script>


<style type="text/css">
#box {
	width: 800px;
	margin: auto;
	margin-top: 30px;
}

#title {
	text-align: center;
	font-size: 24pt;
	font-weight: bold;
	font-family: 휴먼엑스포, 굴림체;
	color: tomato;
	text-shadow: 1px 1px 1px black;
}
</style>
</head>
<body>
	<div id="box">
		<h1 id="title">ㅁ ㅁ 회원목록 ㅁ ㅁ</h1>
		<div align="right">
			<input class="btn btn-primary" type="button" value="회원가입"
				onclick="location.href = 'insert_form.do'">
		</div>
		<br>
		<!-- 목록출력 -->
		<div>
			<table class="table  table-striped">
				<!-- table title  -->
				<tr class="active">
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>IP</th>
					<th>가입일자</th>
					<th>회원구분</th>
					<th>편집</th>
				</tr>
				<!-- table data 출력하기 -->

				<!-- for(MemberVo vo : list) 와 동일한것임-->

				<c:forEach var="vo" items="${ list }">
					<tr class="warning">

						<td>${vo.m_idx}</td>
						<td>${vo.m_id}</td>
						<td>${vo.m_name}</td>
						<td>${vo.m_pwd}</td>
						<td>${vo.m_zipcode}</td>
						<td>${vo.m_addr}</td>
						<td>${vo.m_ip}</td>
						<td>${ fn:substring(vo.m_regdate,0,10) }</td>
						<td>${vo.m_grade}</td>

						<td><input class="btn btn-success" type="button" value="수정"
							onclick="modify_form(${vo.m_idx});"> <input
							class="btn btn-danger" type="button" value="삭제"></td>
					</tr>

				</c:forEach>


			</table>
		</div>

	</div>



</body>
</html>