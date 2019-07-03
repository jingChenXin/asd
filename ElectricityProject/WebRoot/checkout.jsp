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
			<div class="ckeckout-top">
				<div class="cart-items">
					<h3>购物车 (${fn:length(cartList)})</h3>
					<h5>
						<input type="checkbox" id="allcheck" onclick="clickchk()" />全选/反选
					</h5>
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

						<c:forEach items="${cartList}" var="p">
							<ul class="cart-header">
								<!-- 	获取商品的名字 返回value 值为详细订单明细id -->
								<span style="position: absolute;left:2px;"><input
									type='checkbox' name='ids' value="${p.itemId}" /></span>&nbsp;&nbsp;
								<div class="close1"></div>
								<li class="ring-in"><a href="showPro?proId=${proId}"> <img
										src="${pageContext.request.contextPath}/${p.proPic}"
										class="img-responsive" alt="">
								</a></li>
								<div class="close1"></div>
								<li><span class="name">${p.proName}</span></li>
								<li><span class="cost">${p.proPrice}元</span></li>
								<li><span class="cost"><input type="number"
										onkeydown="return false;" name="proCount" id="proCount"
										onclick="sumTotal()" style="width: 50px" value="${p.proCount}"></span></li>
								<div class="clearfix"></div>
							</ul>
						</c:forEach>
							<script type="text/javascript">
								function sumTotal() {
									//商品价格跟数量变动
									var proCount = document.getElementsByName("proCount");
									for (var a = 0; a < proCount.length; a++) {
										if (proCount[a].value < 0) {
											//确认选择商品数量是否大于一 如果小于1 则默认值为1
											alert("购买商品数量不少于1件！");
											var pro = document.getElementsByName("proCount");
											pro[a].value = 1;
										} else {
										
										}
									}
								}
								//提交订单
							</script>
					</div>
					<center>
						<button onclick="buySure()" style="font-size: 30px">确认购买</button>
					</center>
				</div>
			</div>
		</div>
	</div>

	<!--end-ckeckout-->
	</script>
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>
	<script type="text/javascript">
		//商品选择按钮
		function clickchk() {
			var allchk = document.getElementById("allcheck").checked;
			var arrs = document.getElementsByName("ids");
			// 绝对是 !!
			if (!!allchk) {
				for (var i = 0; i < arrs.length; i++) {
					arrs[i].checked = true;
				}
			} else {
				for (var i = 0; i < arrs.length; i++) {
					arrs[i].checked = false;
				}
			}
		}

		function buySure() {
			var f = false;
			var itemids = "";
			var proCounts= "";
			var arrs = document.getElementsByName("ids");
			var proCount = document.getElementsByName("proCount");
			for (var i = 0; i < arrs.length ; i++) {
				if (!!arrs[i].checked) {
					f = true;
					itemids += arrs[i].value + ",";
					proCounts += proCount[i].value + ",";
				}
			}
			if (!f) {
				alert("最少选择一商品");
			} else {
				/*点击确认支付按钮时跳转路径 */
				/* alert(itemids); */
				window.location.href = "${pageContext.request.contextPath}/getCartOrd?ids=" + itemids+"&proCount="+proCounts;
			}
		}
	</script>
</body>
</html>