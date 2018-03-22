<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh" class="no-js">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员工作界面</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/styles/bootstrap.css" rel="stylesheet">
    <link href="/styles/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <link rel="stylesheet" href="/stafffont/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" type="/text/css" href="/stafffont/css/default.css">
    <link rel="stylesheet" href="/stafffont/css/style.css"> <!-- Resource style -->
    <script src="/stafffont/js/modernizr.js"></script> <!-- Modernizr -->
    <link rel="stylesheet" type="text/css" href="/tishikuang/zeroModal.css" />
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/tishikuang/zeroModal.min.js"></script>
    <script>
        window.onload=function () {
            if(${!empty requestScope.info }){
                zeroModal.alert("${requestScope.info}");
            }
        }
    </script>
</head>
<body>
<header class="cd-main-header">
    <a href="#0" class="cd-logo"><img src="/stafffont/img/cd-logo.svg" alt="Logo"></a>

    <div class="cd-search is-hidden">
        <form action="#0">
            <input type="search" placeholder="Search...">
        </form>
    </div> <!-- cd-search -->

    <a href="#0" class="cd-nav-trigger">Menu<span></span></a>

    <nav class="cd-nav">
        <ul class="cd-top-nav">
            <li><a href="#0">Tour</a></li>
            <li><a href="#0">Support</a></li>
            <li class="has-children account">
                <a href="#0">
                    <%--这里可以添加客户的图片--%>
                    <img src="/stafffont/img/cd-avatar.png" alt="avatar">
                    Account
                </a>
                <ul>
                    <li><a href="#0">My Account</a></li>
                    <li><a href="#0">Edit Account</a></li>
                    <li><a href="#0">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header> <!-- .cd-main-header -->

<main class="cd-main-content">
    <nav class="cd-side-nav">
        <ul>
            <li class="cd-label">导航栏</li>
            <li class="has-children overview">
                <a href="#0">部门管理</a>
                <ul>
                    <li><a href="#0">部门信息</a></li>
                    <li><a href="#0">删除部门信息</a></li>
                    <li><a href="/admin/jumpToAddDepartView">增删部门</a></li>
                </ul>
            </li>
            <li class="has-children notifications active">
                <a href="#0">消息<span class="count">3</span></a>

                <ul>
                    <li><a href="#0">发送消息</a></li>
                    <li><a href="#0">接收消息</a></li>
                    <li><a href="#0">Other</a></li>
                </ul>
            </li>

            <li class="has-children comments">
                <a href="#0">职位管理</a>

                <ul>
                    <li><a href="#0">已存职位信息</a></li>
                    <li><a href="#0">已删职位信息</a></li>
                    <li><a href="/position/jumpToAddPositionView">增删职位</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li class="cd-label">Secondary</li>
            <li class="has-children bookmarks">
                <a href="#0">职员管理</a>

                <ul>
                    <li><a href="/admin/jumpToAddStaffView">职员账号注册</a></li>
                    <li><a href="#0">职员信息</a></li>
                    <li><a href="#0">职员离职确认</a></li>
                </ul>
            </li>
            <li class="has-children images">
                <a href="#0">考勤信息</a>

                <ul>
                    <li><a href="#0">每日考勤</a></li>
                    <li><a href="#0">历史考勤</a></li>
                    <li><a href="#0">每月考勤排名</a></li>
                </ul>
            </li>

            <li class="has-children users">
                <a href="#0">培训</a>
                <ul>
                    <li><a href="#0">发布培训</a></li>
                    <li><a href="#0">培训人员名单</a></li>
                    <li><a href="#0">历史培训记录</a></li>
                    <li><a href="#0">终止培训</a></li>
                </ul>
            </li>
            <li class="has-children users">
                <a href="#0">加班信息</a>
                <ul>
                    <li><a href="#0">每日加班信息</a></li>
                    <li><a href="#0">每月加班排名</a></li>
                    <li><a href="#0">历史加班记录</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li class="cd-label">薪资查询</li>
            <li class="action-btn"><a href="#0">+ Button</a></li>
        </ul>
    </nav>
</main> <!-- .cd-main-content -->

<script src="http://www.jq22.com/jquery/2.1.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="/stafffont/js/jquery-2.1.1.min.js"><\/script>')</script>
<script src="/stafffont/js/jquery.menu-aim.js"></script>
<script src="/stafffont/js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>
