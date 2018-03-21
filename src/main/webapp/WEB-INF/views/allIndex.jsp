<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>游客登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="/styles/css/reset.css">
    <link rel="stylesheet" href="/styles/css/supersized.css">
    <link rel="stylesheet" href="/styles/css/style.css">

    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script>
        window.onload=function () {
            if(${requestScope.info eq null}){
                $("#alert").hide();
            }else {
                $("#alert").show();
                var alertId=document.getElementById("alert");
                hideAlert(alertId);
            }
        }
       function checkEmailOrPhone(value) {
            var reg_phone=/^1[35678]{1}[0-9]{9}$/;
            var reg_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(value==""){
                $("#showEmailOrPhone").text("账号不能为空!").css("color","red");
            }else if(!reg_phone.test(value)&&!reg_email.test(value)){
                $("#showEmailOrPhone").text("账号格式错误!").css("color","red");
            }else {
                $("#showEmailOrPhone").text("");
                return true;
            }
            return false;
        }
        function checkPassword(value) {
            if(value==""){
                $("#showPassword").text("密码不能为空!").css("color","red");
            }else {
                $("#showPassword").text("");
                return true;
            }
            return false;
        }
        function checkAll() {
            var visitorName=document.getElementById("visitorEmailOrPhone").value;
            var  visitorPassword=document.getElementById("visitorPassword").value;
            if(checkEmailOrPhone(visitorName)&&checkPassword(visitorPassword)){
                return true;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>
<div oncontextmenu="return false">

<div class="page-container" style="width: 1000px;z-index: 0" >
    <div id="alert" class="alert alert-warning" style="z-index: 9999">
        <c:out value="${requestScope.info}"></c:out>
    </div>
    <h1>Login</h1>
    <form action="/visitor/visitorLogin.do" method="post" onsubmit="return checkAll()" style="width: 800px">
        <div style="padding: 1px">
            <input type="text"  class="username" placeholder="Email Or Phone" autocomplete="off" name="visitorEmailOrPhone" id="visitorEmailOrPhone" onblur="checkEmailOrPhone(this.value)"/><br>
            <span id="showEmailOrPhone"></span><br>
        </div>
        <div style="padding: 1px">
            <input type="password"  class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" name="visitorPassword" id="visitorPassword" onblur="checkPassword(this.value)"/><br>
            <span id="showPassword"></span><br>
        </div>
        <div>
            <input type="checkbox" name="isRemember" style="width: 20px;height: 20px;border-radius: 2px;margin-left: -180px"><span>记住密码</span><br>
        </div>
            <input  type="submit" style="width: 200px" value="登录" class="btn-warning" style="margin-left: -20px">
            <a href="/jumpToVisitorRegisterView" class="btn btn-success">注册</a>
    </form>
    <a href="/jumpToStaffLoginView">切换至工作人员登录界面</a>
</div>
</div>
<!-- Javascript -->
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="/scripts/js/supersized.3.2.7.min.js"></script>
<script src="/scripts/js/supersized-init.js"></script>
</body>
</html>

