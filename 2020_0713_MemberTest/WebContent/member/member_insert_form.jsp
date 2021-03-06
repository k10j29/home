<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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


<!-- 주소 검색 라이브러리 (자바스크립스) -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
#input_box {
	width: 600px;
	margin: auto;
	margin-top: 100px;
}
</style>

<script type="text/javascript">
	//ID 에 대한 정규식
	var regular_id = /^[a-zA-Z0-9]{4,8}$/;

	/* jQuery초기화 */
	$(document).ready(function() {
		/* 중복체크가 눌리면 */
		$("#btn_check_id").click(function() {

			var m_id = $("#m_id").val();
			//ID체크
			if (regular_id.test(m_id) == false) {
				alert('4~8자리 영문자(대,소)숫자조합으로 작성하세요');
				$("#m_id").val("");//값비우기
				$("#m_id").focus();//포커스
				return;
			}

			//Ajax을 이용한 id 체크
			$.ajax({
				url : "check_id.do", //MemberCheckIdAction
				data : {
					"m_id" : m_id
				},
				dataType : "json", //수신데이터 타입
				success : function(res_data) {
					//res_data ={"result": true}
					if (res_data.result == false) {
						alert('이미 사용중인 아이디 입니다');
						return;
					}

					alert('사용가능한 아이디 입니다');

					//1. 아이디 편집못하도록
					// <input id="m_id"
					$("#m_id").attr("readonly", true);

					//2. 회원가입 버튼 활성화 (비활성화의 반대)
					$("#btn_register").attr("disabled", false);

				}

			});

		}); //중복체크 클릭 끝나는 부분 

		//주소검색 클릭
		$("#btn_find_addr").click(function() {

			new daum.Postcode({
				theme : {
					bgColor : "#FBEC4B"
				},
				oncomplete : function(data) {
					// data = {'zonecode':12345 ,'address':'서울시 관악구',...}
					//alert('우편번호:' + data.zonecode);
					//alert('주소:' + data.address);

					$("#m_zipcode").val(data.zonecode);
					$("#m_addr").val(data.address);

				}
			}).open();

		});

	}); //document.ready 끝부분

	function send(f) {

		var m_name = f.m_name.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		var m_zipcode = f.m_zipcode.value.trim();
		var m_addr = f.m_addr.value.trim();

		//이름체크
		if (m_name == '') {
			alert('이름을 입력하세요');
			f.m_name.value = '';
			f.m_name.focus();
			return;
		}

		//비번체크
		if (m_pwd == '') {
			alert('비밀번호를 입력하세요');
			f.m_pwd.value = '';
			f.m_pwd.focus();
			return;
		}

		//우편번호 체크
		if (m_zipcode == '') {
			alert('우편번호를 입력하세요');
			f.m_zipcode.value = '';
			f.m_zipcode.focus();
			return;
		}

		//주소 체크
		if (m_addr == '') {
			alert('주소를 입력하세요');
			f.m_addr.value = '';
			f.m_addr.focus();
			return;
		}

		//전송
		f.action = "insert.do"; //MemberInsertAction

		f.submit();

	}
</script>

</head>
<body>

	<div id="input_box">

		<div class="panel panel-danger">
			<div class="panel-heading">회원가입</div>
			<div class="panel-body">
				<form>

					<!-- 회원 구분  -->

					<input type="hidden" name="m_grade" value="일반">

					<table class="table table-striped">
						<tr>
							<th>이름</th>
							<td><input name="m_name"></td>
						</tr>

						<tr>
							<th>아이디</th>
							<td><input name="m_id" id="m_id"> <input
								type="button" value="중복체크" id="btn_check_id"></td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="m_pwd"></td>
						</tr>

						<tr>
							<th>우편번호</th>
							<td><input name="m_zipcode" id="m_zipcode"> <input
								type="button" value="주소검색" id="btn_find_addr"></td>
						</tr>

						<tr>
							<th>주소</th>
							<td><input name="m_addr" id="m_addr" size="50"></td>
						</tr>



						<!-- 나중에 수정할때 넣어주면 사용하면됩니다 -->

						<!-- 	<tr>
							<th>등급</th>
							<td><input type="radio" name="m_grade" value="일반"
								checked="checked">일반 <input type="radio" name="m_grade"
								value="관리자">관리자
						</tr> -->


						<tr>
							<td colspan="2" align="center"><input id="btn_register"
								disabled="disabled" type="button" value="회원가입"
								onclick="send(this.form);"> <input type="button"
								value="목록보기" onclick="location.href='list.do'"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>