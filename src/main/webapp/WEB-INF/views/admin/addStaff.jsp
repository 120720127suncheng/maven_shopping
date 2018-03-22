<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/22
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录用职员账号注册</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/styles/bootstrap.css" rel="stylesheet">
    <link href="/styles/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>

    <link rel="stylesheet" type="text/css" href="/tishikuang/zeroModal.css" />
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/tishikuang/zeroModal.min.js"></script>

    <script src='/ziLiao/js/jquery.js'></script>
    <script src="/ziLiao/js/index.js"></script>
    <link rel="stylesheet" href="/ziLiao/css/style.css" media="screen" type="text/css" />

    <script>
        var checkEmailNow=false;
        var checkPhoneNow=false;
        var checkSalaryNow=false;
        function showPosition() {
            if ($("#departmentName").val() == "") {
                zeroModal.alert("请选择部门!");
                $("#content").html("");
                $("#showAndHide").hide();
            } else {
                $.ajax({
                    type: "get",
                    url: '/position/showPosition.do',
                    data: "departmentName=" + $("select[name='departmentName']").val(),
                    /*Jason解析*/
                    success: function (msg) {
                        var arr = eval(msg);
                        if (arr.length == 0) {
                            $("#content").html("<h3>该部门暂无职位,请添加职位后再注册职员账号!<h3>");
                            $("#showAndHide").hide();
                        } else {
                            var c="<div>职位名称</div>";
                            c += "<select id='positionName' name='positionName' class='form-control'>" +
                                "<option value=''>选择职位</option>";
                            for (var i = 0; i < arr.length; i++) {
                                var con = arr[i].positionName;
                                c += "<option value='" + con + "'>" + con + "</option>";
                            }
                            $("#content").html(c);
                            $("#showAndHide").show();
                        }
                    }
                });
            }
        }
        function checkFirst() {
            if($("#departmentName").val()==""||$("#positionName").val()==""){
                zeroModal.alert("部门职位不能为空!");
            }
        }
        function checkPhone(value) {
            var reg_phone=/^1[35678]{1}[0-9]{9}$/;
            if(value==""){
                zeroModal.alert("手机号不能为空!");
                return false;
            }else if(!reg_phone.test(value)){
                zeroModal.alert("手机号格式错误!");
                return false;
            }else{
                $.ajax({
                    type: "post",
                    url: '/staff/checkStaffPhone.do',
                    data: "staffPhone=" + $("input[name='staffPhone']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            zeroModal.alert("手机被注册!");
                            checkPhoneNow= false;
                        }else {
                            checkPhoneNow= true;
                        }
                    }
                });
                return checkPhoneNow;
            }
        }
        function checkEmail(value) {
            var reg_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(value==""){
                zeroModal.alert("邮箱不能为空!");
                return false;
            }else if(!reg_email.test(value)){
                zeroModal.alert("邮箱格式错误!");
                return false;
            }else{
                $.ajax({
                    type: "post",
                    url: '/staff/checkStaffEmail.do',
                    data: "staffEmail=" + $("input[name='staffEmail']").val(),
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            zeroModal.alert("邮箱被注册!");
                            checkEmailNow= false;
                        }else {
                            checkEmailNow= true;
                        }
                    }
                });
                return checkEmailNow;
            }
        }
        function checkSalary(value) {
            var num_reg=/^[0-9]*$/;
            if(value==""){
                zeroModal.alert("基本薪资请勿为空!")
                return false;
            }else if(!num_reg.test(value)||value<=0){
                zeroModal.alert("请填正确的基本薪资!");
                return false;
            }else {
                return true;
            }
        }
        function checkAll() {
            if($("#departmentName").val()==""||$("#positionName").val()==""||$("#staffName").val()==""||$("#staffSex").val()==""||$("#staffPhone").val()==""||$("#staffEmail").val()==""||$("#staffBaseSalary").val()==""){
                zeroModal.alert("请将信息填写完整!");
                return false;
            }else if(checkEmail($("#staffEmail").val())&&checkPhone($("#staffPhone").val())&&checkSalary($("#staffBaseSalary").val())){
                return true;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>
<form action="/staff/addStaff.do" method="post" onsubmit="return checkAll()">
            <fieldset class='alpha'>
                <legend><b>1.</b>部门职位信息</legend>
                <div class='frow'>
                    <c:choose >
                        <c:when test="${requestScope.departmentList eq '暂无任何部门!'}">
                            <div class="item"><c:out value="${'连部门都没有,还不滚去添加部门!'}"></c:out></div>
                        <script>
                            $("#showAndHide").hide();
                        </script>
                        </c:when>
                        <c:otherwise>
                            <div>请选择部门</div>
                            <select id="departmentName" name="departmentName" onchange="showPosition()" class="form-control">
                                <option value="">请选择部门</option>
                                <c:forEach items="${requestScope.departmentList}" var="department">
                                    <option value="${department.getDepartmentName()}">${department.getDepartmentName()}</option>
                                </c:forEach>
                            </select>
                            <div id="content">
                                    <%--局部刷新展现部门下的职位--%>
                            </div>
                            <div class='frow' id="showAndHide" style="display: none"><a class='next-step' onclick="checkFirst();return false" id="alert1">Let's go!</a></div>

                        </c:otherwise>
                    </c:choose>
                </div>

            </fieldset>
            <!-- / Fieldset Beta -->
            <fieldset class='beta'>
                <legend><b>2.</b>个人信息</legend>
                <div class='frow'>
                    <input class='item' placeholder='姓名' required='required' type='text' id="staffName" name="staffName">
                </div>
                <div class='frow'>
                    <select class="form-control" id="staffSex" name="staffSex" >
                        <option value="">请选择性别</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
                <div class='frow'>
                    <input class='item' required='required' type='text' placeholder="手机号" id="staffPhone" name="staffPhone" onblur="checkPhone(this.value)">
                </div>
                <div class='frow'>
                    <input class='item' required='required' type='email' placeholder="邮箱号" id="staffEmail" name="staffEmail" onblur="checkEmail(this.value)">
                </div>
                <div class='frow'>
                    <input class='item' required='required' id="staffBaseSalary" name="staffBaseSalary" type="number" onblur="checkSalary(this.value)">
                </div>
                <div class='frow'>
                    <a class='prev-step' href='#'>Go back!</a>
                </div>
                <div class='frow'>
                    <button  type="submit" value="I'm all done!" class="btn btn-success form-control">提交</button>
                </div>
            </fieldset>
    </section>
</form>
</body>
</html>
