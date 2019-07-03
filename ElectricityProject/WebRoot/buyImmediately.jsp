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
			<div class="ckeck-top heading"></div>
			<form action="confirmSubmit">
				<div class="ckeckout-top">
					<div class="cart-items">

						<h3>
							收货地址：<select id="addrId" name="addrId">
								<c:forEach items="${addrList}" var="addr">
									<option value="${addr.addrId}">${addr.addrInfo}</option>
								</c:forEach>
							</select><br /> 购物车 (1)
						</h3>
						<script>
							$(document)
									.ready(
											function(c) {
												$('.close1')
														.on(
																'click',
																function(c) {
																	$(
																			'.cart-header')
																			.fadeOut(
																					'slow',
																					function(
																							c) {
																						$(
																								'.cart-header')
																								.remove();
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
							<ul class="cart-header">
								<li class="ring-in"><a href="showPro?proId=${proId}" > <img 
								src="${pageContext.request.contextPath}/${proPic}"
										class="img-responsive" alt="" ></a></li>
								<div class="close1"></div>
								<li><span class="name"><input type="hidden"
										class="name" name="proName" value="${proName}">${proName}</span></li>
								<li><span class="cost" id="proPrice"><input
										type="hidden" class="cost" name="proSellprice"
										value="${proSellprice}">${proSellprice}元</li>
								<li><span class="name"><input type="number"
										name="proCount" id="proCount" style="width: 50px"
										value="${proCount}" onchange="change()"></span></li>
								<div class="clearfix"></div>
							</ul>
						</div>
					</div>
					<input type="hidden" name="proId" value="${proId}">
					<input type="hidden" name="proPic" value="${proPic}"> 
				</div>
				<p style="color: red; font-size: 25px;" id="dato">总金额：${totalPrice}元</p>
				<input type="submit" value="确认提交" style="font-size: 20px">
			</form>
		</div>
	</div>

	<!--end-ckeckout-->
	</script>
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>
	<script type="text/javascript">
		function change() {
			var count = document.getElementById("proCount").value;
			if (count > 200) {
				alert("单次购买商品不能超过200");
				document.getElementById("proCount").value = 1;
			} else if (count > 0) {
				document.getElementById("dato").innerHTML = "总金额：" + count * ${proSellprice} + "元";
			} else {
				alert("购买商品数量不少于1件");
				document.getElementById("proCount").value = 1;
			}
		}
	</script>
</body>
</html>