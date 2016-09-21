<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>易购——category_add.css</title>
    <meta charset="utf-8">
    <link type="text/css" href="css/category_add.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
</head>

<body>
    <main>
        <section class="right">
            <section class="right_top">
                <ul>
                    <li><img src="images/houtai1.png"></li>
                    <li><span>添加小分类</span></li>
                </ul>
            </section>
            <div class="line"></div>
            <section class="right_middle">
                <form action="subAddServlet" method="post">
                    <table style="width: 700px;">
                        <tr>
                            <td class="text">商品类别名称（*）：</td>
                            <td>
                                <input type="text" class="GG" name="smallClass" onblur="checkClass()">
                            </td>
                            <td id="result"></td>
                        </tr>
                        <tr>
                            <td class="text">所属大分类：</td>
                            <td>
                                <select name="bigClass">
                                    <option value="-1">请选择</option>
                                    <!-- 循环显示 -->
                                    <%-- <c:forEach var="i" begin="0" end="${requestScope.sups.size()-1 }" step="1">
                                    	<option value="${requestScope.sups.get(i).s_supid }">${requestScope.sups.get(i).s_supname }</option>
                                    </c:forEach> --%>
                                    
                                    <!-- 增强for循环 -->
                                    <c:forEach items="${requestScope.sups }" var="sup">
                            	        <option value="${sup.s_supid }">${sup.s_supname }</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td id="result1"></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="right_bottom">
                                <input type="image" src="images/submit.gif" onclick="return checkAll()">
                            </td>
                            <td style="width: 100px;"></td>
                        </tr>
                    </table>
                </form>
            </section>
        </section>
    </main>
</body>

</html>
