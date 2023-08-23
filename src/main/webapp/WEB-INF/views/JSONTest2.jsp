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
		$("#checkJson1").click(function() {
			
		// 회원 정보를 JSON으로 생성
		var article = {
			articleNo : "555",
			writer : "stephen",
			title : "jj's golf",
			content : "he also likes ripple"
		};
		
		$.ajax({
			type : "get",
			url : "${contextPath}/boards/all", // 1. 요청

			contentType : "application/json",
			data : JSON.stringify(article),// 2. JSON을 문자열로 변환
	
			success : function(data, textStatus) {
				alert(data);
			},
			error : function(data, textStatus) {
				alert("애러가 발생");
			},
			complete : function(data, textStatus){
			}
			}); // end ajax
		
		});
	});
$(function() {
	$("#checkJson2").click(function() {
		
	// 회원 정보를 JSON으로 생성
	var article = {
		articleNo : "555",
		writer : "stephen",
		title : "jj's golf",
		content : "he also likes ripple"
	};
	
	$.ajax({
		type : "post",
		url : "${contextPath}/boards", // 1. 요청

		contentType : "application/json",
		data : JSON.stringify(article),// 2. JSON을 문자열로 변환

		success : function(data, textStatus) {
			alert(data);
		},
		error : function(data, textStatus) {
			alert("애러가 발생");
		},
		complete : function(data, textStatus){
		}
		}); // end ajax
	
	});
});
$(function() {
	$("#checkJson3").click(function() {
		
	var article = {
		articleNo : "555",
		writer : "stephen",
		title : "jj's golf",
		content : "he also likes ripple"
	};
	
	$.ajax({
		type : "get",
		url : "${contextPath}/boards/555", // 1. 요청

		contentType : "application/json",
		data : JSON.stringify(article),// 2. JSON을 문자열로 변환

		success : function(data, textStatus) {
			alert(data);
		},
		error : function(data, textStatus) {
			alert("애러가 발생");
		},
		complete : function(data, textStatus){
		}
		}); // end ajax
	
	});
});
$(function() {
	$("#checkJson4").click(function() {
		
	// 회원 정보를 JSON으로 생성
	var article = {
		articleNo : "555",
		writer : "stephen",
		title : "jj's golf",
		content : "he also likes ripple"
	};
	
	$.ajax({
		type : "put",
		url : "${contextPath}/boards/555", // 1. 요청
	

		contentType : "application/json",
		data : JSON.stringify(article),// 2. JSON을 문자열로 변환

		success : function(data, textStatus) {
			alert(data);
		},
		error : function(data, textStatus) {
			alert("애러가 발생");
		},
		complete : function(data, textStatus){
		}
		}); // end ajax
	
	});
});
$(function() {
	$("#checkJson5").click(function() {
		
	// 회원 정보를 JSON으로 생성
	var article = {
		articleNo : "555",
		writer : "stephen",
		title : "jj's golf",
		content : "he also likes ripple"
	};
	
	$.ajax({
		type : "delete",
		url : "${contextPath}/boards/555", // 1. 요청

		contentType : "application/json",
		data : JSON.stringify(article),// 2. JSON을 문자열로 변환

		success : function(data, textStatus) {
			alert(data);
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
<input type="button" id="checkJson1" value="목록 보기"/><br><br>
<input type="button" id="checkJson2" value="새글 쓰기"/><br><br>
<input type="button" id="checkJson3" value="조회 하기"/><br><br>
<input type="button" id="checkJson4" value="수정 하기"/><br><br>
<input type="button" id="checkJson5" value="삭제 하기"/><br><br>
<div id = "output"></div>
</body>
</html>