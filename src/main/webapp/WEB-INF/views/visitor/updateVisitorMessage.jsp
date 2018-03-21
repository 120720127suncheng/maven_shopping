<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/17
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Simple ideas for enhancing text input interactions" />
    <meta name="keywords" content="input, text, effect, focus, transition, interaction, inspiration, web design" />
    <meta name="author" content="Codrops" />
    <link rel="stylesheet" type="text/css" href="/styles/cssInput/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/fonts/fontsInput/font-awesome-4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="/styles/cssInput/demo.css" />
    <link rel="stylesheet" type="text/css" href="/styles/cssInput/component.css" />
    <title>修改个人信息</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>

    <script>
        var resultPhone=false;
        var resultEmail=false;
        function checkVisitorName(value) {
            if(value==""){
                $("#showVisitorName").text("姓名不能为空!").css("color","red");
            }else {
                $("#showVisitorName").text("");
                return true;
            }
            return false;
        }
        function checkVisitorAge(value) {
            var reg_age=/^[0-9]{2}$/
            if(value==""){
                $("#showVisitorAge").text("年龄不能为空!").css("color","red");
            }else if(!reg_age.test(value)){
                $("#showVisitorAge").text("请填写年龄!").css("color","red");
            }else if(value<18||value>70){
                $("#showVisitorAge").text("请填写符合条件的年龄!").css("color","red");
            } else {
                $("#showVisitorAge").text("");
                return true;
            }
            return false;
        }
        function checkVisitorSex(value) {
            if(value==""){
                $("#showVisitorSex").text("性别不能为空!").css("color","red");
            }else if(value.trim()!="男"&&value.trim()!="女"){
                $("#showVisitorSex").text("你知道什么是性别吗?").css("color","red");
            }else {
                $("#showVisitorSex").text("");
                return true;
            }
            return false;
        }

        function checkVisitorPhone(value) {
            if(checkVisitorPhone2(value)){
                $.ajax({
                    type: "post",
                    url: '/visitor/updateVisitorPhone.do',
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
                    type: "post",
                    url: '/visitor/updateVisitorEmail.do',
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
        function checkVisitorNational(value) {
            if(value==""){
                $("#showVisitorNational").text("民族不能为空").css("color","red");
            }else {
                $("#showVisitorNational").text("");
                return true;
            }
            return false;
        }
        function checkProvince(value) {
            if(value==""){
                $("#showVisitorProvince").text("不能为空!").css("color","red");
            }else {
                $("#showVisitorProvince").text("");
                return true;
            }
            return false;
        }
        function checkCity(value) {
            if(value==""){
                $("#showVisitorCity").text("不能为空!").css("color","red");
            }else {
                $("#showVisitorCity").text("");
                return true;
            }
            return false;
        }
        function checkCountry(value) {
            if(value==""){
                $("#showVisitorCountry").text("不能为空!").css("color","red");
            }else {
                $("#showVisitorCountry").text("");
                return true;
            }
            return false;
        }
        function checkVisitorAddress(value) {
            if(value==""){
                $("#showVisitorStreet").text("不能为空").css("color","red");
            }else {
                $("#showVisitorStreet").text("");
                return true;
            }
            return false;
        }
        function checkAll() {
            if(checkVisitorName($("#input-16").val())&&checkVisitorAge($("#input-17").val())&&checkVisitorSex($("#input-18").val())&&checkVisitorPhone($("#input-19").val())&&checkVisitorEmail($("#input-20").val())&&checkVisitorNational($("#input-21").val())&&checkProvince($("#input-22").val())&&checkCity($("#input-23").val())&&checkCountry($("#input-24").val())&&checkVisitorAddress($("#input-25").val())){
                return true;
            }
            return false;
        }
    </script>
</head>
<body>
<form action="/visitor/updateBaseMessage.do" method="post" onsubmit="return checkAll()" enctype="multipart/form-data">
<section class="content bgcolor-5">
    <div class="input input--akira">
					<input name="visitorName" class="input__field input__field--yoko" type="text" id="input-16" value="${sessionScope.visitor.visitorBaseMessage.visitorName}" onblur="checkVisitorName(this.value)"/>
					<label class="input__label input__label--yoko" for="input-16">
						<span class="input__label-content input__label-content--yoko">姓名</span>
					</label>
				</div>
    <span id="showVisitorName"></span>

    <input type="file" name="file_upload" value="上传头像">

    <br>
    <div class="input input--minoru">
					<input name="visitorAge" class="input__field input__field--yoko" type="text" id="input-17" value="${sessionScope.visitor.visitorBaseMessage.visitorAge}" onblur="checkVisitorAge(this.value)"/>
					<label class="input__label input__label--yoko" for="input-17">
						<span class="input__label-content input__label-content--yoko">年龄</span>
					</label>
				</div>
    <span id="showVisitorAge"></span>
    <br>
    <div class="input input--minoru">
					<input name="visitorSex" class="input__field input__field--yoko" type="text" id="input-18" value="${sessionScope.visitor.visitorBaseMessage.visitorSex}" onblur="checkVisitorSex(this.value)"/>
					<label class="input__label input__label--yoko" for="input-18">
						<span class="input__label-content input__label-content--yoko">性别</span>
					</label>
				</div>
    <span id="showVisitorSex"></span>
    <br>
    <div class="input input--minoru">
        <input name="visitorPhone" class="input__field input__field--yoko" type="text" id="input-19" value="${sessionScope.visitor.visitorPhone}" onkeyup="checkVisitorPhone(this.value)"/>
        <label class="input__label input__label--yoko" for="input-16">
            <span class="input__label-content input__label-content--yoko">手机号</span>
        </label>
    </div>
    <span id="showVisitorPhone"></span>
    <br>
    <div class="input input--minoru">
        <input name="visitorEmail" class="input__field input__field--yoko" type="text" id="input-20" value="${sessionScope.visitor.visitorEmail}" onkeyup="checkVisitorEmail(this.value)"/>
        <label class="input__label input__label--yoko" for="input-17">
            <span class="input__label-content input__label-content--yoko">邮箱</span>
        </label>
    </div>
    <span id="showVisitorEmail"></span>
    <br>
    <div class="input input--minoru">
        <input name="visitorNational" class="input__field input__field--yoko" type="text" id="input-21" value="${sessionScope.visitor.visitorBaseMessage.visitorNational}" onblur="checkVisitorNational(this.value)"/>
        <label class="input__label input__label--yoko" for="input-18">
            <span class="input__label-content input__label-content--yoko">民族</span>
        </label>
    </div>
    <span id="showVisitorNational"></span>
    <br>
    <div class="input input--minoru">
        <input name="province" class="input__field input__field--yoko" type="text" id="input-22" value="${sessionScope.visitor.visitorBaseMessage.province}" onblur="checkProvince(this.value)"/>
        <label class="input__label input__label--yoko" for="input-18">
            <span class="input__label-content input__label-content--yoko">省</span>
        </label>
    </div>
    <span id="showVisitorProvince"></span>
    <br>
    <div class="input input--minoru">
        <input name="city" class="input__field input__field--yoko" type="text" id="input-23" value="${sessionScope.visitor.visitorBaseMessage.city}" onblur="checkCity(this.value)"/>
        <label class="input__label input__label--yoko" for="input-18">
            <span class="input__label-content input__label-content--yoko">市</span>
        </label>
    </div>
    <span id="showVisitorCity"></span>
    <br>
    <div class="input input--minoru">
        <input name="country" class="input__field input__field--yoko" type="text" id="input-24" value="${sessionScope.visitor.visitorBaseMessage.country}" onblur="checkCountry(this.value)"/>
        <label class="input__label input__label--yoko" for="input-18">
            <span class="input__label-content input__label-content--yoko">县</span>
        </label>
    </div>
    <span id="showVisitorCountry"></span>
    <br>
    <div class="input input--minoru">
        <input name="street" class="input__field input__field--yoko" type="text" id="input-25" value="${sessionScope.visitor.visitorBaseMessage.street}" onblur="checkVisitorAddress(this.value)"/>
        <label class="input__label input__label--yoko" for="input-18">
            <span class="input__label-content input__label-content--yoko">具体住址</span>
        </label>
    </div>
    <span id="showVisitorStreet"></span>
    <br>
    <input type="submit" class="btn btn-success" value="提交">
</section>
</form>
</body>
</html>
