<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
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
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js">
	
</script>
<link href="${pageContext.request.contextPath}/css/memenu.css"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<!--dropdown-->
<script
	src="${pageContext.request.contextPath}/js/jquery.easydropdown.js"></script>
</head>
<body>

	<jsp:include page="/watchPage/watchHead.jsp"></jsp:include>

	<!--prdt-starts-->
	<div class="prdt">
		<div class="container">
			<div class="prdt-top">
				<div class="col-md-9 prdt-left">
					<c:forEach items="${proList}" var="pro" varStatus="s">
						<div class="product-one">
							<div class="col-md-4 product-left p-left">
								<div class="product-main simpleCart_shelfItem">
									<a
										href="${pageContext.request.contextPath}/showPro?proId=${pro.proId}"
										class="mask"><img class="img-responsive zoom-img"
										src="${pageContext.request.contextPath}${pro.proPic}" alt=""
										 /></a>
									<div class="product-bottom">
										<h3>${pro.proName}</h3>
										<a
											href="${pageContext.request.contextPath}/showPro?proId=${pro.proId}">马上查看</a>
										<h4>
											<a class="item_add"
												href="${pageContext.request.contextPath}/single.jsp"><i></i></a>
											<span class=" item_price">价格：${pro.proSellprice}</span>
										</h4>
									</div>
									<div class="srch srch1">
										<span>-50%</span>
									</div>
								</div>
							</div>
							<c:if test="${s.count%3==0}">
								<div class="clearfix"></div>
							</c:if>
						</div>
					</c:forEach>
					<div class="product-one">
						<div class="clearfix"></div>
					</div>
				</div>
				<jsp:include page="/watchPage/watchRight .jsp"></jsp:include>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	</div>
	<jsp:include page="/watchPage/watchBottom.jsp"></jsp:include>
</body>
</html>