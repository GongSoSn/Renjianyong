<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				
				<tr class="neirong">
					<td>22</td>
					<td class="Title">床上用品</td>
					<td>家居家纺</td>
					<td class="right_border">
						<img src="images/update1.png">
							<a href="categorySecondOne?id=22" target="center">修改</a>
						<img src="images/delete.png">
							<a href="deleteCategorySecond?id=22" onclick="return confirm('删除小分类，对应的商品也会删除吗？')">删除</a>
					</td>
				</tr>
			</table>
			<div class="fanye">
				[1 / 3] <a href="categorySecondList?page=1">首页</a>&nbsp; <a
					href="categorySecondList?page=2">下一页</a>&nbsp; <a
					href="categorySecondList?page=3">尾页</a>
			</div>
		</section>
	</section>
	</main>
</body>

</html>
