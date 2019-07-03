<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'watchRight .jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<div class="col-md-3 prdt-right">
		<div class="w_sidebar">
			<section class="sky-form">
			<h4>品牌</h4>
			<div class="row1 row2 scroll-pane">
				<c:forEach items="${brandLists}" var="brand">
					<div class="col col-4">
						<label class="checkbox"><input type="checkbox" name="proBrand" ><i></i>${brand.brandName} </label>
					</div>
				</c:forEach>
			</div>
			</section>
		</div>
	</div>
</body>
</html>
