<%@page import="com.koreait.mvclegacy.model.domain.Notice"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("content");//textarea의 id가 content인것에 ckEditor 설정	
});

//글수정 요청
function edit(){
	if(confirm("수정 하시겠습니까?")){
		var form = document.querySelector("form");	
		form.action="/client/notice/edit";
		form.method="post";
		form.submit();
	}
}

//글삭제 요청
function del(){	
	if(confirm("삭제 하시겠습니까?")){
		var form = document.querySelector("form");	
		form.action="/client/notice/del";
		form.method="post";
		form.submit();
	}
}

</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>    
  	<input type="hidden" name="notice_id" value="<%=notice.getNotice_id()%>">
    <input type="text" name="title" placeholder="Your title.." value="<%=notice.getTitle()%>">
    <input type="text" name="writer" placeholder="Your name name.." value="<%=notice.getWriter()%>">
    <textarea id="content" name="content" placeholder="Write something.." style="height:200px"><%=notice.getContent() %></textarea>

    <input type="button" value="글수정" onClick="edit()">
    <input type="button" value="글삭제" onClick="del()">
    <input type="button" value="목록보기" onClick="location.href='/client/notice/list'">
  </form>
</div>

</body>
</html>