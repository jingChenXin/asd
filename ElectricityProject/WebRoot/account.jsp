<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
<script src="js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
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
	
	<!--account-starts-->
	<div class="account">
		<div class="container">
		<div class="account-top heading">
				<h2>账户</h2>
			</div>
			<div class="account-main">
				<div class="col-md-6 account-left">
					<h3>当前账户</h3>
					<h2>${param.msg=='1'?"操作成功，请重新登陆!":"" }</h2>
					<h3 style="color: red;">${msg==0?"用户名或密码错误":""}</h3>
					<form action="${pageContext.request.contextPath}/login" method="post">
					<div class="account-bottom">
						<input placeholder="用户名" type="text" name="userName" tabindex="3" required>
						<input placeholder="密码" type="password" name="passWord" tabindex="4" required>
						<div class="address">
							<a class="forgot" href="account01.jsp">忘记密码？</a>
							<input type="submit" value="登录">
						</div>
					</div>
					</form>
				</div>
				<div class="col-md-6 account-right account-left">
					<h3>新用户/创建一个新用户</h3>
					<p>通过创建一个帐户与我们的商店,你将能够完成结帐过程更快,移动存储多个航运地址,查看和跟踪你的订单在你的帐户和更多。</p>
					<a href="register.jsp">创建一个新的账户</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--account-end-->
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>
</body>
</html>