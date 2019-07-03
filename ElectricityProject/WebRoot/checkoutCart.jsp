<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--start-menu-->
<script src="js/simpleCart.min.js">
	
</script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<!--dropdown-->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
	<jsp:include page="/watchPage/watchHead.jsp"></jsp:include>
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
		<form action="accomplish">
			<div class="ckeck-top heading"></div>
			<div class="ckeckout-top">
				<div class="cart-items">
					<h3>
						收货地址：<select id="addrId" name="addrId">
							<c:forEach items="${addrList}" var="addr">
								<option value="${addr.addrId}">${addr.addrInfo}</option>
							</c:forEach>
						</select>
					</h3>
					<script>
						$(document).ready(function(c) {
							$('.close1').on('click', function(c) {
								$('.cart-header').fadeOut('slow', function(c) {
									$('.cart-header').remove();
								});
							});
						});
					</script>

					<div class="in-check">
						<ul class="unit">
							<li><span>产品</span></li>
							<li><span>产品名称</span></li>
							<li><span>价格</span></li>
							<li><span>数量</span></li>
							<li></li>
							<div class="clearfix"></div>
						</ul>

						<c:forEach items="${items}" var="item">
							<ul class="cart-header">
								<div class="close1"></div>
								<li class="ring-in"><a href="showPro?proId=${item.proId}"> <img
										src="${pageContext.request.contextPath}/${item.proPic}"
										class="img-responsive" alt="">
								</a></li>
								<div class="close1"></div>
								<li><span class="name">${item.proName}</span></li>
								<li><span class="cost">${item.proPrice}元</span></li>
								<li><span class="cost">${item.proCount}</span></li>
								<div class="clearfix"></div>
							</ul>
						</c:forEach>
					</div>
					<input type="hidden" name="orderId" value="${orderId}">
					<p style="color: red; font-size: 25px;" id="dato">总金额：${cartTotals}元</p>
					<input type="submit" value="确认提交" style="font-size: 20px">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--end-ckeckout-->
	</script>
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>

</body>
</html>