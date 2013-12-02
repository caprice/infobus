<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="jsp/common.jsp"%>
<html>
<head>
<script type="text/javascript">
	function addNewUser() {
		var p_url = '${contextPath}' + '/user/register.do';
		var jsonuserinfo = $('#form').serializeObject();
		console.log(jsonuserinfo);
		doAjaxSubmit(p_url, jsonuserinfo, p_callback);
	}

	
	p_callback = function(response) {
		if (response.result == 0) {
			$('#info').html(
					"Plate has been added to the list successfully. -- "
							+ response.data.userDetail.plate);
			$('#error').hide('slow');
			$('#info').show('slow');

		} else {
			errorInfo = "";
			for (i = 0; i < response.data.length; i++) {
				errorInfo += "<br>" + (i + 1) + ". " + response.data[i].code;
			}
			$('#error').html("Please correct following errors: " + errorInfo);
			$('#info').hide('slow');
			$('#error').show('slow');

		}
	};

	function checkAccountExisted(obj) {
		var p_url = '${contextPath}' + '/user/verifyAccount.do';
		var data = {
			'userName' : obj.value,
			'token' : 'ed7be964f32bb873d091d6a059729f88'
		};
		doAjaxSubmit(p_url, data, function(obj) {
			if (obj.result == 0) {

			} else {
				alert(obj.msg);
			}
		});
	}
	
	$(document).ready(function(){
		  $("#uploadPic1").click(function(){
			  var url = '${contextPath}' + '/user/picUpload.do';
			  var data = $('#upload').serializeObject();
			  console.log("fiel",data);
				$.ajax({
					type : "POST",
					url : url,
					data:data,
					enctype: 'multipart/form-data',
					beforeSend : function(XMLHttpRequest) {
						// ShowLoading();
					},
					success : function(data) {
						alert(data);
					},
					complete : function(XMLHttpRequest, textStatus) {
						// HideLoading();
					},
					error : function() {
						// 请求出错处理
					}
				});
		  });
		});
</script>
<title>用户注册</title>
<body>
	<div>
		<h1>用户注册........</h1>
		<div align="center">
			<form action="user/addUser" method="post" id="form">
				<table>
					<tr>
						<td colspan="2"><div id="error" class="error"
								style="display: none"></div></td>
					</tr>
					<tr>
						<td>请输入你的用户名 :</td>
						<td><input type="text" id="userName" name="userName"
							onblur="checkAccountExisted(this)"><br />
						<input type="hidden" id="userDetail.userName" name="userDetail.userName"
							>	
							</td>
					</tr>
					<tr>
						<td>请填写一个昵称 :</td>
						<td><input type="text" id="userDetail.nickName" name="userDetail.nickName"><br /></td>
					</tr>
					<tr>
						<td>填写你的个性签名 :</td>
						<td><textarea id="userDetail.signature" name="userDetail.signature" rows="3"
								cols="20"></textarea><br /></td>
					</tr>
					<tr>
						<td>请选择你的性别 :</td>
						<td><input type="radio" id="sex0" name="userDetail.sex" value="0">男
							<input type="radio" id="sex1" name="userDetail.sex" value="1">女</td>
					</tr>
					<tr>
						<td>密码 :</td>
						<td><input type="password" id="password" name="password"><br /></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input type="password" id="rPassword" name="rPassword"><br /></td>
					</tr>
					<tr>
						<td>邮箱:</td>
						<td><input type="text" id="email" name="email"><br /></td>
					</tr>
					<tr>
						<td>手机:</td>
						<td><input type="text" id="userDetail.phone" name="userDetail.phone"><br /></td>
					</tr>
					<tr>
						<td>车牌:</td>
						<td><input type="text" id="userDetail.plate" name="userDetail.plate"><br /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="Save"
							onclick="addNewUser()"></td>
					</tr>
					<tr>
						<td colspan="2"><div id="info" class="success"></div></td>
					</tr>

				</table>
			</form>
		</div>
		<div>
		<form  action="${contextPath}/user/picUpload.do" method="POST" id="upload" enctype="multipart/form-data">  
   			 username: <input type="text" name="userName"/><br/>  
    		your photo: <input type="file" name="imgFile" id="imgFile"/><br/>  
    		<input type="submit" id="uploadPic" value="为用户添加图片"/>  
		</form>
		
		</div>
	</div>
</body>
</html>