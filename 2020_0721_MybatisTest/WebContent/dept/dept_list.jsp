<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>tj

	<hr>
	부서별 사원목록
	<hr>
	<ul>
		<!--  for(DeptVo dept : list)  -->
		<c:forEach var="dept" items="${ list }">
			<li>${ dept.deptno }:${ dept.dname }</li>
			<ul>
				<!-- for(SawonVo sawon : dept.sa_list) -->
				<c:forEach var="sawon" items="${ dept.sa_list }">
					<li>${ sawon.sabun }:${ sawon.saname }</li>
					<ul>
						<!-- for(GogekVo gogek : sawon.go_list) -->
						<c:forEach var="gogek" items="${ sawon.go_list }">
							<li>${ gogek.gobun }:${ gogek.goname }</li>
						</c:forEach>
					</ul>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>




</body>
</html>