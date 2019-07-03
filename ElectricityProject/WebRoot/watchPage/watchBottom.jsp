<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'watchBottom.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<!--information-starts-->
	<div class="information">
		<div class="container">
			<div class="infor-top">
				<div class="col-md-3 infor-left">
					<h3>关于我们</h3>
					<ul>
						<li><a href="#"><span class="fb"></span>
								<h6>脸盆网</h6></a></li>
						<li><a href="#"><span class="twit"></span>
								<h6>京小东</h6></a></li>
						<li><a href="#"><span class="google"></span>
								<h6>唯品会</h6></a></li>
					</ul>
				</div>
				<div class="col-md-3 infor-left">
					<h3>信息</h3>
					<ul>
						<li><a href="#"><p>特色</p></a></li>
						<li><a href="#"><p>特色</p></a></li>
						<li><a href="#"><p>特色</p></a></li>
						<li><a href="contact.html"><p>特色</p></a></li>
						<li><a href="#"><p>特色</p></a></li>
					</ul>
				</div>
				<c:if test="${not empty username.userName}">
					<div class="col-md-3 infor-left">
						<h3>我的账户</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/getAccount?userId=${username.userId}"><p>我的账户</p></a></li>
							<li><a href="#"><p>我的信用记录</p></a></li>
							<li><a href="addCart"><p>我的商品</p></a></li>
							<li><a href="addCart"><p>我的商品</p></a></li>
							<li><a href="addCart"><p>我的商品</p></a></li>
						</ul>
					</div>
				</c:if>
				<div class="col-md-3 infor-left">
					<h3>网站信息</h3>
					<h4>
						公司名称, <span>信管141班有限公司,</span> 1995.03.27
					</h4>
					<h5>+18434393642</h5>
					<p>
						<a href="mailto:example@email.com">1092286105@qq.com</a>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--information-end-->
	<!--footer-starts-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-6 footer-left">
					<form>
						<input type="text" value="发送邮件" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Enter Your Email';}">
						<input type="submit" value="订阅我们">
					</form>
				</div>
				<div class="col-md-6 footer-right">
					<p>
						Copy &copy; 2016.信管141班有限公司.<a target="_blank"
							href="http://www.sxyunji.com"></a>信管141班有限公司
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--footer-end-->
</body>
</html>
