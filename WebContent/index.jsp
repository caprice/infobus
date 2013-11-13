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
		var p_data = {"accountName":"liumeng01","email":"meng.liu@gm.com","id":0,"idCard":"","location":"上海","mobile":"","nickName":"dale.liu","password":"123456","photo":"","plate":"test1212","profession":"","sex":"1","status":0,"userLog":""};
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