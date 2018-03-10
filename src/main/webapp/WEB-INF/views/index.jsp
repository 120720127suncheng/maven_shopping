<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页面</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <script>
        window.onload=function () {
            var alertId=document.getElementById("alert");
            if(alertId!=null) {
                hideAlert(alertId);
            }
        }
    </script>
</head>
<body>
<div id="alert">
    <%
        String info=(String) request.getAttribute("info");
        if(info!=null){
            if(info.equals("注册成功")){
    %>
    <div class="alert alert-success" >
        <%
            out.print(info);
        %>
    </div>
    <%
    }else {
    %>
    <div class="alert alert-danger">
        <%
            out.print(info);
        %>
    </div>
    <%
            }
        }
    %>
</div>
    <form method="post" action="/customer/customerLogin.do">
        用户名:<input type="text" name="customerName"><br>
        密码:  <input type="password" name="customerPassword"><br>
        <input type="checkbox" name="isRemember" >记住密码<br>
        <input type="submit" value="提交">
        <a href="/customerRegisterFirst.view">注册</a>
        <div>
            <span>用户登录界面</span>
            <a href="/adminLoginFirst.view">切换至管理员登录界面</a>
        </div>
    </form>
</body>
</html>
