<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer/customerLogin.do">
    用户名:<input type="text" name="customerName"><br>
    密码:  <input type="password" name="customerPassword"><br>
    <input type="submit" value="登录">
    <div>
        <a href="customerLogin.do">切换至用户登录界面</a>
        <span>管理员登录界面</span>
    </div>
</form>
</body>
</html>
