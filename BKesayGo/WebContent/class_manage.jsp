<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE HTML>
<html>
  <head>

    
    <title>易购——Category</title>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
      <script type="text/javascript" src="js/changeBGC.js"></script>
    <link type="text/css" href="css/class_manage.css" rel="stylesheet">
 </head>
  
  <body>
    <main>
        <section class="right">
            <section class="right_top">
                <ul>
                    <li><img src="images/houtai1.png"></li>
                    <li><span>大分类管理</span></li>
                </ul>
            </section>
            <div class="line"></div>
            <section class="right_middle">
                <table id="result">
                    <tr class="title">
                        <th>编号</th>
                        <th>分类名称</th>
                        <th class="right_border">操作</th>
                    </tr>
                    <c:forEach items="${list }" var="sup">
                        <tr class="neirong">
                        <td>${sup.s_supid }</td>
                        <td class="Titl">${sup.s_supname }</td>
                        <td class="right_border"><img src="images/update1.png"><a href="categoryOne?id=28&page=1" target="center">修改</a><img src="images/delete.png"><a href="deleteCategory?id=28&page=1" onclick="return confirm('删除大分类，对应小分类也会删除，以及所属小分类的商品，确认删除吗？')">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>

			<div class="fanye">
				[${PAGE } / ${COUNT }]
				
				<c:if test="${PAGE > 1 }">
					<a href="supServlet?page=1">首页</a>&nbsp; 
					<a href="supServlet?page=${PAGE - 1 }">上一页</a>&nbsp; 
				</c:if>
				
				<c:if test="${PAGE < COUNT }">
					<a href="supServlet?page=${PAGE + 1 }">下一页</a>&nbsp; 
					<a href="supServlet?page=${COUNT }">尾页</a>
				</c:if>
			</div>
		</section>
        </section>
</main>
  </body>
</html>
