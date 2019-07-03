<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Single</title>
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
<script type="text/javascript">
	$(function() {

		var menu_ul = $('.menu_drop > li > ul'), menu_a = $('.menu_drop > li > a');

		menu_ul.hide();

		menu_a.click(function(e) {
			e.preventDefault();
			if (!$(this).hasClass('active')) {
				menu_a.removeClass('active');
				menu_ul.filter(':visible').slideUp('normal');
				$(this).addClass('active').next().stop(true, true).slideDown(
						'normal');
			} else {
				$(this).removeClass('active');
				$(this).next().stop(true, true).slideUp('normal');
			}
		});

	});
</script>
</head>
<body>
	<jsp:include page="/watchPage/watchHead.jsp"></jsp:include>
	<!--start-single-->
	<div class="single contact">
		<div class="container">
			<div class="single-main">
				<div class="col-md-9 single-main-left">
					<div class="sngl-top">
						<div class="col-md-5 single-top-left">
							<div class="flexslider">
								<ul class="slides">
									<li
										data-thumb="${pageContext.request.contextPath}/${pt.proPic}">
										<div class="thumb-image">
											<img src="${pageContext.request.contextPath}/${pt.proPic}"
												data-imagezoom="true" class="img-responsive" alt="" />
										</div>
									</li>
								</ul>
							</div>
							<!-- FlexSlider -->
							<script src="js/imagezoom.js"></script>
							<script defer src="js/jquery.flexslider.js"></script>
							<link rel="stylesheet" href="css/flexslider.css" type="text/css"
								media="screen" />

							<script>
								// Can also be used with $(document).ready()
								$(window).load(function() {
									$('.flexslider').flexslider({
										animation : "slide",
										controlNav : "thumbnails"
									});
								});
							</script>
						</div>
						<div class="col-md-7 single-top-right">
							<div class="single-para simpleCart_shelfItem">
								<h2>${pt.proName}</h2>
								<div class="star-on">
									<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									<div class="review">
										<a href="#"> 1 条商品评论 </a>

									</div>
									<div class="clearfix"></div>
								</div>

								<h5 class="item_price">价格：${pt.proSellprice}元</h5>
								<br />数量：<input type="number" name="proCount" id="proCount"
									style="width: 50px" value="1">
								<p>商品详细信息。。。。。。。。。。。。。。。。</p>

								<!-- <div class="available">
								<ul>
									<li>颜色
										<select>
										<option>白色</option>
										<option>黑色</option>
										<option>深黑色</option>
										<option>红色</option>
									</select></li>
								<li class="size-in">鞋号<select>
									<option>L</option>
									<option>XL</option>
									<option>XXL</option>
									<option>S</option>
									<option>SL</option>
								</select></li>
								<div class="clearfix"> </div>
							</ul>
						</div>
							<ul class="tag-men">
								<li><span>标签</span>
								<span class="women1">: 女士,</span></li>
								<li><span>单位</span>
								<span class="women1">: 双</span></li>
							</ul> -->
								<c:if test="${pt.proUpDown eq '1'}">
									<a href="##" class="add-cart item_add" onclick="immediately()">立即购买</a>
									<br />
									<a href="##" class="add-cart item_add" onclick="valilogin()">添加到购物车</a>
								</c:if>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="tabs">
						<ul class="menu_drop">
							<li class="item1"><a href="#"><img
									src="images/arrow.png" alt="">商品详情</a>
								<ul>
									<li class="subitem1"><a href="#">你买我卖，天经地义，看上就买，看不上就算，呵呵</a></li>
								</ul></li>



						</ul>
					</div>
					<div class="latestproducts">
						<div class="product-one">
							<c:forEach items="${proList}" var="pro" varStatus="s">
								<div class="col-md-4 product-left p-left">
									<div class="product-main simpleCart_shelfItem">
										<a
											href="${pageContext.request.contextPath}/showPro?proId=${pro.proId}"
											class="mask"><img class="img-responsive zoom-img"
											src="${pageContext.request.contextPath}${pro.proPic}" alt="" /></a>
										<div class="product-bottom">
											<h3>${pro.proName}</h3>
											<a
												href="${pageContext.request.contextPath}/showPro?proId=${pro.proId}">点击查看</a>
											<h4>
												<a class="item_add"
													href="${pageContext.request.contextPath}/showPro?proId=${pro.proId}"><i></i></a>
												<span class=" item_price">价格： ${pro.proSellprice} </span>
											</h4>
										</div>
										<div class="srch">
											<span>-50%</span>
										</div>
									</div>
								</div>
							</c:forEach>


							<div class="clearfix"></div>
						</div>
					</div>
				</div>


				<jsp:include page="/watchPage/watchRight .jsp"></jsp:include>



				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--end-single-->
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>

	<script type="text/javascript">
		var userName = "${username.userSurname}" + "${username.userName}";
		function valilogin() {
			if (!userName) {
				alert("请登陆！");
				window.location.href = "${pageContext.request.contextPath}/account.jsp";
			} else {
				/*js拿取商品数量的值 */
				var proCount = document.getElementById("proCount").value;
				if (proCount > 0) {
					window.location.href = "${pageContext.request.contextPath}/addCart?proId=${pt.proId}&proName=${pt.proName}&proSellprice=${pt.proSellprice}&proCount="
							+ proCount + "&proPic=${pt.proPic}";
				} else {
					alert("购买商品数量不少于1件");
					document.getElementById("proCount").value = 1;
				}
			}
		}

		function immediately() {
			if (!userName) {
				alert("请登陆！");
				window.location.href = "${pageContext.request.contextPath}/account.jsp";
			} else {
				/*js拿取商品数量的值 */
				var proCount = document.getElementById("proCount").value;
				if (proCount > ${pt.inventory}) {
					alert("对不起，您购买商品数量大于库存了，亲！");
					document.getElementById("proCount").value = 1;
				} else if (proCount > 0) {
					window.location.href = "${pageContext.request.contextPath}/buyImmediately?proId=${pt.proId}&proName=${pt.proName}&proSellprice=${pt.proSellprice}&proCount="
							+ proCount + "&proPic=${pt.proPic}";
				} else {
					alert("购买商品数量不少于1件");
					document.getElementById("proCount").value = 1;
				}
			}
		}
	</script>

</body>
</html>