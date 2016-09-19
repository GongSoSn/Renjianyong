<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE HTML>
<html>
  <head>
    <title>易购——user_manage</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
      <script type="text/javascript" src="js/changeBGC.js"></script>
    <link type="text/css" href="css/user_manage.css" rel="stylesheet">
    <script type="text/javascript" src="js/check1.js" charset="utf-8"></script>
</head>
<body>
<main>
     <section class="right">
            <section class="right_top">
                <ul>
                    <li><img src="images/houtai1.png"></li>
                    <li><span>用户管理</span></li>
                </ul>
            </section>
            <div class="line"></div>
            <section class="right_middle">
                <table>
                    <tr class="title">
                        <th>用户编号</th>
                        <th>用户名</th>
                        <th>真实姓名</th>
                        <th>性别</th>
                        <th>Email</th>
                        <th>手机</th>
                        <th>冻结/解冻</th>
                        <th class="right_border">操作</th>
                    </tr>
                    
                    <c:forEach items="${list }" var="user">
                    
                        <tr class="neirong">
                            <td>${user.s_id }</td>
                            
                            <td>${user.s_username }</td>
                            
                            <td>${user.s_truename }</td>
                            
                            <c:if test="${user.s_sex==0}">
                                <td>男</td>
                            </c:if>
                            
                            <c:if test="${user.s_sex==1}">
                                <td>女</td>
                            </c:if>
                            
                            <td>${user.s_email }</td>
                            
                            <td>${user.s_phone }</td>
                            
                            <c:if test="${user.s_if ==0 }">
                                <td>
                                    <img src="images/jiedong.png"><a href="User_Unfreeze?id=16">解冻</a>
                                </td>
                            </c:if>
                            
                            <c:if test="${user.s_if ==1 }">
                                <td>
                                    <img src="images/dongjie.png"><a href="User_Freeze?id=16">冻结</a>
                                </td>
                            </c:if>
                            
                            <td class="right_border">
                                <img src="images/update1.png">
                                    <a href="userModify?id=16&page=1" target="center">修改</a>
                                <img src="images/delete.png">
                                    <a href="userDelete?id=16&page=1" onclick="return confirm('确认删除吗？')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    
                </table>

                    <div class="fanye">
                        [${PAGE } / ${PAGECOUNT }]
                        
                        <!-- 首页(上一页)显示时机 -->
                        <c:if test="${PAGE > 1}">
                            <a href="users?page=1">首页</a>&nbsp;
                            <a href="users?page=${PAGE-1 }">上一页</a>&nbsp;
                        </c:if>
                        
                        <!-- 尾页和下一页的显示时机 -->
                        <c:if test="${PAGECOUNT > PAGE }">
                            <a href="users?page=${PAGE+1 }">下一页</a>&nbsp;
                            <a href="users?page=${PAGECOUNT}">尾页</a>
                        </c:if>
                    </div>
        </section>
        </section>
</main>
</body>
</html>