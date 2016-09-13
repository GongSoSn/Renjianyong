<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.BKesayGo.bean.cn.Admin"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>

<html>
<head>
   <meta charset="utf-8">
    <title>易购-头部</title>
 <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <link type="text/css" href="css/index.css" rel="stylesheet">
    <script type="text/javascript">
    /*function getNow(){
            var date=new Date();
            var year=date.getFullYear();
            var month=date.getMonth()+1;
            var day=date.getDate();
            var hour=date.getHours();
            var minute=date.getMinutes();
            var second=date.getSeconds();
            var result=year+"年"+month+"月"+day+"日     "+hour+"点"+minute+"分"+second+"秒";
            document.getElementById("timeSpan").innerHTML=result;
            window.setTimeout("getNow()",1000);
        }*/
    </script>
</head>
<body>
<header>
    <div class="pic">
        <div>
            <ul>
                <li class="index"><a href="center.jsp" target="center">首页</a></li>
                <li class="index"><a href="userList?page=1" target="center">用户</a></li>
                <li class="index"><a href="categoryList?page=1" target="center">商品分类</a></li>
                <li class="index"><a href="Order_manage" target="center">订单</a></li>
                <li class="index"><a href="goodsList?page=1" target="center">商品详细</a></li>
                <li class="index"><a href="Announcement_manage" target="center">公告</a></li>
            </ul>
        </div>
    </div>
    
    <div class="TiShi">管理员 :
    <%
        Admin admin = (Admin)session.getAttribute("admin");
    %>
    <%= admin.getTruename() %>
    您好，今天是<span>

 <!-- 2015-12-28 下午 -->
        <% 
            Date nowDay = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String loginDate = format.format(nowDay);
        %>
        
        <%= loginDate %>

</span>，欢迎来到贝壳•易购商城后台管理系统。[<a href="exitServlet" target="_parent">注销</a>]</div>
    <div class="address">您现在的位置：<a href="../../yigoumanage" target="_parent" > 贝壳易购•商城</a> &gt; <span id="positio">后台管理</span></div>
</header>
</body>
<script type="text/javascript">
    $(function(){
        $("li").click(function(){
            $(this).prop("class","indexOn");
            $(this).prevAll().prop("class","index")
                    .end()
                    .nextAll().prop("class","index");
            $("#positio").html($(this).children().html());
        });
    });
    /*var conl=document.getElementsByTagName("li");
    for(var i=0;i<conl.length;i++){ 
        conl[i].onmouseout=function(){  
            this.className="index";
            
        };
        conl[i].onmouseover=function(){
        $("li:not(this)").attr("class","index");
            this.className="indexOn";
        };
    }*/
</script>
</html>