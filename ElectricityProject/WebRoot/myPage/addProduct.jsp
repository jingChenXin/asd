<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>添加商品</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<center>
		<form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
			<p style="color: red; font-size: 30px">${param.msg=='0'?"添加失败！":""}</p>
			<table style="background-color: yellow;">
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="proName" maxlength="50"></td>
				</tr>
				<tr>
					<td>图片:</td>
					<td><input type="file" name="proPic"></td>
				</tr>
				<tr>
					<td>类型:</td>
					<td><select name="proType">
							<option value="">-请选择-</option>
							<c:forEach items="${typeList}" var="type">
								<option value="${type.typeId}"
									${param.proType eq type.typeId?"selected='selected'":"" }>${type.typeName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>品牌:</td>
					<td><select name="proBrand">
							<option value="">-请选择-</option>
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.brandId}"
									${param.proBrand eq brand.brandId?"selected='selected'":"" }>${brand.brandName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>售价:</td>
					<td><input type="text" name="proSellprice"></td>
				</tr>
				<tr>
					<td>供货商:</td>
					<td><input type="text" name="proSupply"></td>
				</tr>
				<tr>
					<td>产地:</td>
					<td><input type="text" name="proAddress"></td>
				</tr>
				<tr>
					<td>库存:</td>
					<td><input type="text" name="inventory"></td>
				</tr>
				<tr>
					<td>有效期:</td>
					<td><input type="date" name="proEndDate"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="提交" /> 
						<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
