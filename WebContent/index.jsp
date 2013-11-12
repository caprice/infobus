<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="jsp/common.jsp"%>
<html>
<head>
<script type="text/javascript">
	function addNewUser(){
		var p_url =  '${contextPath}'+'/user/register';
		var p_data = {"accountName":"","birth":"","email":"","id":0,"idCard":"","location":"","mobile":"","nickName":"","password":"","photo":"","plate":"","profession":"","sex":"","status":0,"userLog":""};
		doAjaxSubmit(p_url, p_data, p_callback);
	}
	
	p_callback = function(obj){
		alert(obj);
	};
</script>
<title>Insert title here</title>
<body>
<div>
 hello world!
<button id="register" onclick="addNewUser()">用户注册</button>
</body>
</html>