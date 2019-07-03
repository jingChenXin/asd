<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'watchHead.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-6 top-header-left">
					<div class="drop">
						<div class="box">
							<c:if test="${not empty username.userName}">
								<span style="color: white">欢迎<br />${username.userSurname}${username.userName}</span>
							</c:if>
							<c:if test="${empty username.userName}">
								<span style="color: wihte"><a href="account.jsp">登陆 </a></span>
							</c:if>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-6 top-header-left">
					<div class="cart box_1">
						<c:if test="${not empty username.userName}">
							<a href="addCart">
								<div class="total">
								</div> <img src="images/cart-1.png" alt="" />
							</a>
						<p>
							<a href="addCart" class="simpleCart_empty">购物车</a>
						</p>
						</c:if>
						<c:if test="${not empty username.userName}">
							<div style="color: white;">
								<a href="${pageContext.request.contextPath}/secede">退出</a>
							</div>
						</c:if>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--top-header-->
	<!--start-logo-->
	<div class="logo">
		<a href="index.html"><h1>淘小宝</h1></a>
	</div>
	<!--start-logo-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="header">
				<div class="col-md-9 header-left">
					<div class="top-nav">
						<ul class="memenu skyblue">
							<li class="active"><a href="frontProlist">首页</a></li>
							<c:forEach items="${typeLists}" var="type">
								<li class="grid">
								<a href="${pageContext.request.contextPath}/frontProlist?proType==${type.typeId}">${type.typeName}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-3 header-right">
					<form action="${pageContext.request.contextPath}/frontProlist" method="post">
					<div class="search-bar">
							<input type="text" value="搜索" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Search';}" name="proName">
							<input type="submit" value="">
					</div>
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--bottom-header-->
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="frontProlist">首页</a></li>
					<li class="active">新产品</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
</body>
</html>
