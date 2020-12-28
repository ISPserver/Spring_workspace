<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
function regist() {
	var form = document.querySelector("form");
	form.action = "/emp/regist";
	form.method="post";
	form.submit();
}

</script>
</head>
<body>
	[ 입사등록 양식]
	<form>
		<input type="text" name="deptno" placeholder="부서번호" value="50"></input>
		<input type="text" name="dname" placeholder="부서명" value="MARKETING"></input>
		<input type="text" name="loc" placeholder="부서위치" value="KOREA"></input>
		
		<input type="text" name="empno" placeholder="사원번호" value="7777"></input>
		<input type="text" name="ename" placeholder="사원명" value="batman"></input>
		<input type="text" name="sal" placeholder="급여" value="8900"></input>
		<button type="button" onClick="regist()">사원등록</button>
	</form>
</body>
</html>