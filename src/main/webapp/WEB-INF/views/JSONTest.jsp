<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Home</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function() {
		$("#checkJson").click(function() {
			
		// 회원 정보를 JSON으로 생성
		var member = {
			id : "park",
			name : "박지성",
			pwd : "1234",
			email : "park@test.com"
		};
		
		$.ajax({
			type : "post",
			url : "${contextPath}/test/info", // 1. 요청
			contentType : "application/json",
			data : JSON.stringify(member),// 2. JSON을 문자열로 변환
	
			success : function(data, textStatus) {
				
			},
			error : function(data, textStatus) {
				alert("애러가 발생");
			},
			complete : function(data, textStatus){
			}
			}); // end ajax
		
		});
	});
</script>
</head>
<body>
<input type="button" id="checkJson" value="회원 정보 보내기"/><br><br>
<div id = "output"></div>
</body>
</html>