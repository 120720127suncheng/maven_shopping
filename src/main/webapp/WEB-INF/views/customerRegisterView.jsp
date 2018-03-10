<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
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
        .mycenter{
            margin-top: 60px;
            margin-left: auto;
            margin-right: auto;
            height: 400px;
            width:800px;
            padding: 5%;
            padding-left: 5%;
            padding-right: 5%;
        }
        .form-control{
            width: 200px;
            margin-left: 30px;
        }
        .firstAdd{
            text-align: center;
            margin-left: 160px;
            width: 80px;
            height: 40px;
            display: inline-block;
            line-height: 35px;
        }
        .haha{
            height: 40px;
            display: inline-block;
            line-height: 35px;
            color: #761c19;
        }
    </style>
    <script>
        var v_name;
        var v_email;
        var v_phone;
        var  resultE;
        var resultN;
        var resultP;
        window.onload=function () {
            v_name=document.getElementById("checkUserName");
            v_email=document.getElementById("checkUserEmail");
            v_phone=document.getElementById("checkUserPhone");
            var alertId=document.getElementById("alert");
            if(alertId!=null) {
                hideAlert(alertId);
            }
        }
            function validateName(value1) {
                if (checkUserNameLength(value1)) {
                    $.ajax({
                        type: "get",
                        url: '/customer/checkCustomerName.do',
                        data: "customerName=" + $("input[name='customerName']").val(),
                        success: function (msg) {
                            if(msg.trim()=="is_exist"){
                                v_name.innerHTML="用户名已存在!";
                                resultN= false;
                            }else {
                                v_name.innerHTML="";
                                resultN= true;
                            }
                        }
                    });
                    return resultN;
                }
            }
        function validateEmail(value) {
            if(checkUserEmail(value)) {
                $.ajax({
                    type: "get",
                    url: '/customer/checkCustomerEmail.do',
                    data: "customerEmail=" + $("input[name='customerEmail']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            v_email.innerHTML="用户邮箱已存在!";
                            resultE=false;
                        }else {
                            v_email.innerHTML="";
                            resultE=true;
                        }
                    }
                });
                return resultE;
            }
        }
        function validatePhone(value) {
            if(checkUserPhone(value)) {
                $.ajax({
                    type: "get",
                    url: '/customer/checkCustomerPhone.do',
                    data: "customerPhone=" + $("input[name='customerPhone']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            v_phone.innerHTML="手机号已被注册!";
                            resultP= false;
                        }else {
                            v_phone.innerHTML="";
                            resultP= true;
                        }
                    }
                });
                return resultP;
            }
        }
        function checkUserNameLength(userName) {
            var checkUserName=document.getElementById("checkUserName");
            var reg = /^[0-9A-z_-]{8,16}$/;
            if(userName==""){
                checkUserName.innerHTML="请输入用户名";
            } else if(userName.length<8){
                checkUserName.innerHTML="用户名长度至少为8位";
            }else if(userName.length>16){
                checkUserName.innerHTML="用户名长度不得超过16位";
            }else if(!reg.test(userName)){
                checkUserName.innerHTML="用户名只能包含数字和字母";
            }else if (userName.toString().match(/\d/)==null){
                checkUserName.innerHTML="用户名中必须包含数字";
            }else if(userName.toString().match(/[A-z]/)==null){
                checkUserName.innerHTML="用户名中必须包含字母";
            }else {
                checkUserName.innerHTML=null;
                return true;
            }
            return false;
        }
        function checkUserPassword(userPassword) {
            var checkUserPassword=document.getElementById("checkUserPassword");
            var reg=/^[0-9A-z_-]{8,16}$/;
            if(userPassword==""){
                checkUserPassword.innerHTML="请输入密码";
            } else if(userPassword.length<8){
                checkUserPassword.innerHTML="用户密码长度至少为8位";
            }else if(userPassword.length>16){
                checkUserPassword.innerHTML="用户密码长度不得超过16位";
            }else if(!reg.test(userPassword)){
                checkUserPassword.innerHTML="用户密码只能包含数字和字母";
            }else if (userPassword.toString().match(/\d/)==null){
                checkUserPassword.innerHTML="用户密码中必须包含数字";
            }else if(userPassword.toString().match(/[A-z]/)==null){
                checkUserPassword.innerHTML="用户密码中必须包含字母";
            }else {
                checkUserPassword.innerHTML=null;
                return true;
            }
            return false;
        }
        function checkUserPassword2(userPassword2) {
            var checkUserPassword2=document.getElementById("checkUserPasswordAgain");
            var userPassword1=document.form1.customerPassword.value;
            if(userPassword2==""){
                checkUserPassword2.innerHTML="请确认密码";
            }else if(userPassword1==userPassword2){
                checkUserPassword2.innerHTML="";
                return true;
            }else {
                checkUserPassword2.innerHTML="密码输入错误";
            }
            return false;
        }
        function checkUserEmail(userEmail) {
            var checkUserEmail=document.getElementById("checkUserEmail");
            var reg=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(userEmail==""){
                checkUserEmail.innerHTML="请输入邮箱";
            }else if(!reg.test(userEmail)){
                checkUserEmail.innerHTML="请输入正确的邮箱地址";
            }else {
                checkUserEmail.innerHTML=null;
                return true;
            }
            return false;
        }
        function checkUserPhone(userPhone) {
            var checkUserPhone=document.getElementById("checkUserPhone");
            var reg = /^1[35678]{1}[0-9]{9}$/;
            if(userPhone==""){
                checkUserPhone.innerHTML="请输入手机号";
            }else if(!reg.test(userPhone)){
                checkUserPhone.innerHTML="请输入正确的手机号";
            }else {
                checkUserPhone.innerHTML="";
                return true;
            }
            return false;
        }
        function result() {
            var r1=document.form1.customerName.value;
            var r2=document.form1.customerPassword.value;
            var r3=document.form1.customerPassword2.value;
            var r4=document.form1.customerEmail.value;
            var r5=document.form1.customerPhone.value;
            return checkUserNameLength(r1)&checkUserPassword(r2)&checkUserPassword2(r3)&checkUserEmail(r4)&checkUserPhone(r5)&&validateName(r1)&&validateEmail(r4)&&validatePhone(r5);
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
<form method="post" action="/customer/customerRegister.do" name="form1" onsubmit="return result()">
    <div class="mycenter">
        <div class="text-center text-info ">
            <h2>账号注册</h2>
        </div>
        <div>
            <div style="float: left" class="firstAdd">用户名</div>
            <input style="float: left" class="form-control" placeholder="用户名" name="customerName" type="text" onblur="validateName(this.value)" required autofocus>
            <div id="checkUserName" class="haha"></div>
        </div>
        <div style="clear: left">
            <div style="float: left" class="firstAdd">密码</div>
            <input style="float: left" class="form-control" name="customerPassword" type="password" placeholder="密码" onblur="checkUserPassword(this.value)" required autofocus>
            <div class="haha" style="float: left" id="checkUserPassword"></div>
        </div>
        <div style="clear: left">
            <div style="float: left" class="firstAdd">确认密码</div>
            <input style="float: left" name="customerPassword2" type="password" onblur="checkUserPassword2(this.value)" class="form-control" placeholder="确认密码" required autofocus>
            <div class="haha" style="float: left" id="checkUserPasswordAgain"></div>
        </div>
        <div style="clear: left" >
            <div style="float: left" class="firstAdd">邮箱</div>
            <input style="float: left" name="customerEmail" type="email" onblur="validateEmail(this.value)" class="form-control" placeholder="邮箱" required autofocus>
            <div class="haha" style="float: left" id="checkUserEmail"></div>
        </div>
        <div style="clear: left" >
            <div style="float: left" class="firstAdd">手机号码</div>
            <input style="float: left" name="customerPhone" type="tel" onblur="validatePhone(this.value)" class="form-control" placeholder="手机号码" required autofocus>
            <div class="haha" style="float: left" id="checkUserPhone"></div>
        </div>
        <div style="clear: left">
            <input type="submit" value="注册" style="background-color: #0b90da;border-radius: 4px;width: 300px;height: 30px;margin-left: 170px" class="btn btn-primary btn-sm">
        </div>
    </div>
</form>
</body>
</html>
