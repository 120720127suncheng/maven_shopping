<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/16
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册基本信息</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <script type="text/javascript" src="/scripts/address.js"></script>
    <script>
            //防止页面后退
            history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });

        window.onload=function () {
            if(${requestScope.info eq null}){
                $("#alert").hide();
            }else {
                $("#alert").show();
                var alertId=document.getElementById("alert");
                hideAlert(alertId);
            }
        }
            $(document).ready(function() {

                var nations = ["汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",
                    "哈尼族","哈萨克族","傣族","黎族","傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",
                    "土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族", "乌孜别克族",
                    "俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"];
                var nation = $("#visitorNational");
                for ( var i=0;i<nations.length;i++) {
                    var a=nations[i];
                    nation.append("<option value="+nations[i]+">"+a+"</option>");
                }

            });
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
                $("#showVisitorSex").text("性别不能为空").css("color","red");
            }else {
                $("#showVisitorSex").text("");
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
            if(value=="省份"){
                $("#showProvince").text("不能为空!").css("color","red");
            }else {
                $("#showProvince").text("");
                return true;
            }
            return false;
        }
        function checkCity(value) {
            if(value=="地级市"){
                $("#showCity").text("不能为空!").css("color","red");
            }else {
                $("#showCity").text("");
                return true;
            }
            return false;
        }
        function checkCountry(value) {
            if(value=="市、县级市、县"){
                $("#showCountry").text("不能为空!").css("color","red");
            }else {
                $("#showCountry").text("");
                return true;
            }
            return false;
        }
        function checkVisitorAddress(value) {
            if(value==""){
                $("#showVisitorAddress").text("不能为空").css("color","red");
            }else {
                $("#showVisitorAddress").text("");
                return true;
            }
            return false;
        }
        function checkAll() {
            if(checkVisitorName($("#visitorName").val())&&checkVisitorAge($("#visitorAge").val())&&checkVisitorSex($("#visitorSex").val())&&checkVisitorNational($("#visitorNational").val())&&checkProvince($("#province").val())&&checkCity($("#city").val())&&checkCountry($("#county").val())&&checkVisitorAddress($("#street").val())){
                return true;
            }
            return false;
        }
    </script>
</head>
<body>
<div class="container" style="height: 500px">
    <div id="alert" class="alert alert-warning">
        <c:out value="${requestScope.info}"></c:out>
    </div>
    <div class="text-info">
        <h2>个人信息填写</h2>
    </div>
    <form method="post" action="/visitorBaseMessage/visitorRegisterBaseMessage.do" onsubmit="return checkAll()">
        真实姓名:<input type="text" placeholder="请填写真实姓名，否则后果自负!"   name="visitorName" id="visitorName" onblur="checkVisitorName(this.value)" >
        <span id="showVisitorName"></span><br>
        年龄:<input type="text" placeholder="年龄"  name="visitorAge" id="visitorAge" onblur="checkVisitorAge(this.value)">
        <span id="showVisitorAge"></span><br>
        性别:<select name="visitorSex"  id="visitorSex" onblur="checkVisitorSex(this.value)">
            <option value="">性别</option>
            <option value="男">男</option>
            <option value="女">女</option>
            </select>
        <span id="showVisitorSex"></span><br>
        民族:<select class="form-control " name="visitorNational" id="visitorNational"><option value="">请选择</option></select>
        <span id="showVisitorNational"></span><br>
        家庭住址:<select id="province" runat="server" name="province" onblur="checkProvince(this.value)"></select><span id="showProvince"></span><br>
                <select id="city" runat="server" name="city" onblur="checkCity(this.value)"></select><span id="showCity"></span><br>
                <select id="county" runat="server" name="country" onblur="checkCountry(this.value)"></select><span id="showCountry"></span><br>
        <script type="text/javascript">
            setup();
        </script>
                <input type="text" name="street" id="street" placeholder="街道,小区具体地址" onblur="checkVisitorAddress(this.value)">
        <span id="showVisitorAddress"></span><br>
        <input type="text" class="hidden" name="visitorId" value="${requestScope.visitor.id}">
        <input type="submit" value="提交" class="btn btn-primary btn-sm">
    </form>
</div>
</body>
</html>
