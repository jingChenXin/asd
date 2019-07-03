<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>商品信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<center>
		<form action="${pageContext.request.contextPath}/commodity" method="post">
	 		<p style="color: red; font-size: 30px">${param.msg=='1'?"操作成功！":""}</p>	
	 		<p style="font-size: 50px;color:aqua;">商品信息表</p>
			类型:<select name="proType">
				<option value="">-请选择-</option>
				<c:forEach items="${typeList}" var="type">
					<option value="${type.typeId}"  ${param.proType eq type.typeId?"selected='selected'":"" } >${type.typeName}</option>
				</c:forEach>
			</select> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			品牌:<select name="proBrand">
				<option value="">-请选择-</option>
				<c:forEach items="${brandList}" var="brand">
					<option value="${brand.brandId}" ${param.proBrand eq brand.brandId?"selected='selected'":"" }>${brand.brandName}</option>
				</c:forEach>
			</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 名称：<input type="text" name="proName"
				size="10" maxlength="20" value="${param.proName}" /> <input
				type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/myPage/addProduct.jsp">添加</a>
		</form>
	</center>

	<table bgcolor="yellow" border="1" cellpadding="15%" cellspacing="0"
		width="100%" style="text-align: center;">
		<tr>
			<td>ID</td>
			<td>图片</td>
			<td>类型</td>
			<td>品牌</td>
			<td>名称</td>
			<td>商品信息</td>
			<td>售价</td>
			<td>供货商</td>
			<td>产地</td>
			<td>库存</td>
			<td>上下架</td>
			<td>过期时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${proList}" var="pro">
			<tr>
				<td>${pro.proId}</td>
				<td><img src="${pageContext.request.contextPath}/${pro.proPic}" width="100px" height="100px" /></td>
				<td>${pro.typeName}</td>
				<td>${pro.brandName}</td>
				<td>${pro.proName}</td>
				<td>${pro.proInfo}</td>
				<td>${pro.proSellprice}</td>
				<td>${pro.proSupply}</td>
				<td>${pro.proAddress}</td>
				<td>${pro.inventory}</td>
				<td>${pro.proUpDown=='1'?"上架":"下架"}</td>
				<td>${fn:substring(pro.proEndDate,0,10)}</td>
				<td>
					<a href="${pageContext.request.contextPath}/findProduct?proId=${pro.proId}">修改</a>&nbsp;
					<a href="${pageContext.request.contextPath}/deletePro?proId=${pro.proId}">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
