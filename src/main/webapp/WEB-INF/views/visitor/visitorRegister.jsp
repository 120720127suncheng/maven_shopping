<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/15
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游客注册界面</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <style>
        body{
            background-image: url("/images/login1.png");
            background-repeat: no-repeat;
            position: fixed;
            width: 100%;
            height: 100%;
            background-size: cover;
        }
    </style>
    <script>

        var resultPhone;
        var resultEmail;
        window.onload=function () {
            if(${requestScope.info eq null}){
                $("#alert").hide();
            }else {
                $("#alert").show();
                var alertId=document.getElementById("alert");
                hideAlert(alertId);
            }
        }
        function checkVisitorPhone(value) {
            if(checkVisitorPhone2(value)){
                $.ajax({
                    type: "get",
                    url: '/visitor/checkVisitorPhone.do',
                    data: "visitorPhone=" + $("input[name='visitorPhone']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            $("#showVisitorPhone").text("手机号已被注册!").css("color","red");
                            resultPhone= false;
                        }else {
                            $("#showVisitorPhone").text("");
                            resultPhone= true;
                        }
                    }
                });
                return resultPhone;
            }
        }
        function checkVisitorEmail(value) {
            if(checkVisitorEmail2(value)){
                $.ajax({
                    type: "get",
                    url: '/visitor/checkVisitorEmail.do',
                    data: "visitorEmail=" + $("input[name='visitorEmail']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            $("#showVisitorEmail").text("邮箱被注册!").css("color","red");
                            resultEmail= false;
                        }else {
                            $("#showVisitorEmail").text("");
                            resultEmail= true;
                        }
                    }
                });
                return resultEmail;
            }
        }
        function checkVisitorPhone2(value) {
            var reg_phone=/^1[35678]{1}[0-9]{9}$/;
          if(value==""){
              $("#showVisitorPhone").text("手机号不能为空!").css("color","red");
          } else if(!reg_phone.test(value)){
              $("#showVisitorPhone").text("手机号格式错误!").css("color","red");
          }else {
              $("#showVisitorPhone").text("");
              return true;
          }
          return false;
        }
        function checkVisitorEmail2(value) {
            var reg_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(value==""){
                $("#showVisitorEmail").text("邮箱不能为空!").css("color","red");
            } else if(!reg_email.test(value)){
                $("#showVisitorEmail").text("邮箱格式错误!").css("color","red");
            }else {
                $("#showVisitorEmail").text("");
                return true;
            }
            return false;
        }
        function checkVisitorPassword(value) {
            var reg_password=/^[0-9A-z]{8,16}$/;/*密码的正则表达式8—16位，数字字母*/
            if(value==""){
                $("#showVisitorPassword").text("密码不能为空!").css("color","red");
            }  else if(value.length<8){
                $("#showVisitorPassword").text("密码不能少于8位!").css("color","red");
            }else if(value.length>16){
                $("#showVisitorPassword").text("密码不能长于16位!").css("color","red");
            }else if(!reg_password.test(value)){
                $("#showVisitorPassword").text("用户密码只能包含数字和字母!").css("color","red");
            }else if (value.toString().match(/\d/)==null){
                $("#showVisitorPassword").text("用户密码中必须包含数字!").css("color","red");
            }else if(value.toString().match(/[A-z]/)==null){
                $("#showVisitorPassword").text("用户密码中必须包含字母!").css("color","red");
            }else {
                $("#showVisitorPassword").text("");
                return true;
            }
            return false;
        }
        function checkVisitorPasswordRepeat(value) {
            if(value==""){
                $("#showPasswordRepeat").text("请确认密码!").css("color","red");
            } else if(value==$("#visitorPassword").val()){
                $("#showPasswordRepeat").text("");
                return true;
            }else {
                $("#showPasswordRepeat").text("密码错误!").css("color","red");
            }
            return false;
        }
        function checkAll() {
            if(checkVisitorPhone($("#visitorPhone").val())&&checkVisitorEmail($("#visitorEmail").val())&&checkVisitorPassword($("#visitorPassword").val())&&checkVisitorPasswordRepeat($("#visitorPasswordRepeat").val())){
                    return true;
            }else {
            return false;
            }
        }
    </script>
</head>
<body>
<%--注意提示信息--%>
    <div class="container">
        <div id="alert" class="alert alert-warning">
                <c:out value="${requestScope.info}"></c:out>
        </div>
        <div class="text-info">
            <h2>账号注册</h2>
        </div>
        <form method="post" action="/visitor/visitorRegister.do" onsubmit="return checkAll()">
            注册手机:<input type="text"    name="visitorPhone" id="visitorPhone" onblur="checkVisitorPhone(this.value)">
            <span id="showVisitorPhone"></span><br>
            注册邮箱:<input type="email"   name="visitorEmail" id="visitorEmail" onblur="checkVisitorEmail(this.value)">
            <span id="showVisitorEmail"></span><br>
            注册密码:<input type="password"  name="visitorPassword" id="visitorPassword" onblur="checkVisitorPassword(this.value)">
            <span id="showVisitorPassword"></span><br>
            确认密码:<input type="password"    id="visitorPasswordRepeat" onblur="checkVisitorPasswordRepeat(this.value)">
            <span id="showPasswordRepeat"></span><br>
            <input type="submit" value="提交" class="btn btn-primary btn-sm">
        </form>
    </div>
</body>
</html>
