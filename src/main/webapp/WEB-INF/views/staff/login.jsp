<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/19
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html >
<head>
    <link rel="stylesheet" href="/TK/css/layer-animate.css"/>
    <meta charset="UTF-8">
    <title>工作人员登录界面</title>
    <link rel="stylesheet" href="/login/css/style.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/TK/js/method.js"></script>
    <script>
        function checkStaff() {
            if($("#staffEmail").val()==""||$("#staffPassword").val()==""){
                $(".btn_login").on("click",function(){
                    var obj={
                        type:"slideFromTop",
                        close:"true",
                        title:"弹框标题",
                        content:"<div>请输入账号或密码！",
                        btn:["取消","确认"],

                    };
                    method.msg_layer(obj);
                });
                return false;
            }else {
                return true;
            }
        }
        function checkAdmin() {
            if($("#adminName").val()==""||$("#adminPassword").val()==""){
                $(".btn_sign_up").on("click",function(){
                    var obj={
                        type:"slideFromTop",
                        close:"true",
                        title:"弹框标题",
                        content:"<div>请输入账号或密码！",
                        btn:["取消","确认"],
                    };
                    method.msg_layer(obj);
                });
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>

<body>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<body>
<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>STAFF LOGIN</h2>
                        <p>非管理员自觉这边登录!</p>
                        <button class="btn_login" onclick="cambiar_login()">CLICK HERE</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>ADMIN LOGIN</h2>
                        <p>管理员爸爸专用登录界面!</p>
                        <button class="btn_sign_up" onclick="cambiar_sign_up()">CLICK HERE</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"> <img src="/login/po.jpg" alt="" /> </div>
            </div>
            <%--工作人员登录界面--%>
            <div class="cont_forms" >
                <form action="/staff/staffLogin.do" method="post" onsubmit="return checkStaff()">
                <div class="cont_img_back_"> <img src="/login/po.jpg" alt="" /> </div>
                <div class="cont_form_login"> <a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
                    <h2>LOGIN VIEW</h2>
                    <input type="text" placeholder="Email" name="staffEmail" id="staffEmail"/>
                    <input type="password" placeholder="Password" name="staffPassword" id="staffPassword"/>
                    <button class="btn_login" onclick="checkStaff()" type="submit">LOGIN</button>
                </div>
                </form>
                <%--管理人员登录界面--%>
                <form action="/admin/adminLogin.do" method="post" onsubmit="return checkAdmin()">
                <div class="cont_form_sign_up"> <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    <h2>LOGIN VIEW</h2>
                    <input type="text" placeholder="Account" id="adminName" name="adminName"/>
                    <input type="text" placeholder="Password" id="adminPassword" name="adminPassword"/>
                    <input type="password" placeholder="Verification Code " />
                    <button class="btn_sign_up" onclick="checkAdmin()" type="submit">LOGIN</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/login/js/index.js"></script>
</body>

</body>
</html>
