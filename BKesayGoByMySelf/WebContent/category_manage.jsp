<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<title>易购——CategorySecond</title>
<meta charset="utf-8">
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link type="text/css" href="css/category_manage.css" rel="stylesheet">
<script type="text/javascript" src="js/changeBGC.js"></script>
</head>

<body>
	<main>
	<section class="right">
		<section class="right_top">
			<ul>
				<li><img src="images/houtai1.png"></li>
				<li><span>小分类管理</span></li>
			</ul>
		</section>
		<div class="line"></div>
		<section class="right_middle">
			<table>
				<tr class="title">
					<th>编号</th>
					<th>商品小分类</th>
					<th>所属类别</th>
					<th class="right_border">操作</th>
				</tr>
				
				<!-- 循环 -->
				<c:forEach items="${requestScope.list }" var="sub">
						<tr class="neirong">
							<!-- 编号 -->
							<td>${sub.s_id }</td>
							<!-- 商品小分类 -->
							<td class="Title">${sub.s_name }</td>
							<!-- 所属类别 -->
							<c:forEach items="${requestScope.listSup }" var="sup">
								<c:if test="${sub.s_supid == sup.s_supid }">
									<td>${sup.s_supname }</td>
								</c:if>
							</c:forEach>
							<td class="right_border">
								<img src="images/update1.png">
									<a href="categorySecondOne?id=22" target="center">修改</a>
								<img src="images/delete.png">
									<a href="deleteCategorySecond?id=22" onclick="return confirm('删除小分类，对应的商品也会删除吗？')">删除</a>
							</td>
						</tr>
				</c:forEach>
			</table>
			<div class="fanye">
				[${requestScope.PAGE } / ${requestScope.COUNT }] 
				<c:if test="${requestScope.PAGE > 1 }">
					<a href="subServlet?page=1">首页</a>&nbsp; 
					<a href="subServlet?page=${PAGE - 1 }">上一页</a>&nbsp; 
				</c:if>
				<c:if test="${requestScope.PAGE < COUNT }">
					<a href="subServlet?page=${PAGE + 1 }">下一页</a>&nbsp; 
					<a href="subServlet?page=${COUNT }">尾页</a>
				</c:if>
			</div>
		</section>
	</section>
	</main>
</body>

</html>
