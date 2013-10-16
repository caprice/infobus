<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='validate'/>" method="post">
<div>
<span>用户名<span>
<span>
<select name="id">
<c:forEach items="${equipNames}" var="equipNames"> 
<option value="${equipNames.id}">${equipNames.name}</option> 
</c:forEach> 
</select>
<span>
</div>
<div>
<span>密码<span>
<span><input type="text" name="password"><span>
</div>
<input type="submit" name="submit" value="登录"/>
</form>
</body>
</html>