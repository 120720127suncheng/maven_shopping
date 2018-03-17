<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>总登录界面</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
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
                $("#showPassword").text("密码不能为空").css("color","red");
            }else {
                $("#showPassword").text("");
                return true;
            }
            return false;
        }
        function checkAll() {
            var visitorName=document.getElementById("visitorEmailOrPhone").value;
            var  visitorPassword=document.getElementById("visitorPassword");
            if(checkEmailOrPhone(visitorName)&&checkPassword(visitorPassword)){
                return true;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>
     <div class="container">
         <div id="alert" class="alert alert-warning">
                 <c:out value="${requestScope.info}"></c:out>
         </div>
         <form action="/visitor/visitorLogin.do" method="post" onsubmit="return checkAll()">
             <input type="text" name="visitorEmailOrPhone" id="visitorEmailOrPhone" onblur="checkEmailOrPhone(this.value)">
             <span id="showEmailOrPhone"></span><br>
             <input type="password" name="visitorPassword" id="visitorPassword" onblur="checkPassword(this.value)">
             <span id="showPassword"></span><br>
             <input type="checkbox" name="isRemember">记住密码<br>
             <input type="submit" value="登录">
             <a href="/jumpToVisitorRegisterView" class="btn btn-success">注册</a>
         </form>
         <span>游客登录界面</span>
         <a href="">切换至工作人员登录界面</a>
     </div>

</body>
</html>
