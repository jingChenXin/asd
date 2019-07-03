<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="js/jquery-1.11.0.min.js"></script>
<!--Custom Theme files-->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>	
<!--start-menu-->
<script src="js/simpleCart.min.js"> </script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="js/jquery.easydropdown.js"></script>			
</head>
<body> 
	<jsp:include page="/watchPage/watchHead.jsp"></jsp:include>
	<!--register-starts-->
	<div class="register">
		<div class="container">
			<div class="register-top heading">
				<h2>注册账户</h2>
			</div>
				<h2 style="color: red">${param.msg=='0'?"注册失败!":"" }</h2>
				<h2 style="color: red">${param.msg=='2'?"你们输入的两次密码不一致!":"" }</h2>
				<h2 style="color: red">${param.msg=='3'?"此用户已存在，请重新输入！":"" }</h2>
			<form action="${pageContext.request.contextPath}/register" method="post">
			<div class="register-main">
				<div class="col-md-6 account-left">
					<input placeholder="名字" type="text" name = "userName" tabindex="1" required>
						<input placeholder="姓" type="text" name = "userSurname" tabindex="2" required>
						<input placeholder="邮箱地址" type="text" name = "postCode" tabindex="3" required>
						<input placeholder="移动电话" type="text" name = "phone" tabindex="3" required>
						<ul>
							<li><label class="radio left"><input type="radio" name="userSex" value="0" checked=""><i></i>男性</label></li>
							<li><label class="radio"><input type="radio" name="userSex" value="1"><i></i>女士</label></li>
							<div class="clearfix"></div>
						</ul>
				</div>
				<div class="col-md-6 account-left">
					<input placeholder="密码" type="password" name="passWord" tabindex="4" required>
						<input placeholder="输入确认密码" type="password" name="passwordPawd" tabindex="4" required>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<div class="address submit">
							<input type="submit" value="提交">
						</div>
						</form>
		</div>
	</div>
	<!--register-end-->
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>
</body>
</html>