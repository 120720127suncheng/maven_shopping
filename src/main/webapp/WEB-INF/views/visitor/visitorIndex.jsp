<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    <meta charset="utf-8">
    <title>欢迎</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/styles/bootstrap.css" rel="stylesheet">
    <link href="/styles/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <link href="/styles/style.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="/styles/iconic.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="/scripts/prefix-free.js"></script>
</head>
<script>
    //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });
</script>
<body>
<div class="wrap">

    <nav>
        <ul class="menu">
            <li><a href="/visitor/visitorViewMessage.do"><span class="glyphicon glyphicon-user"></span>个人信息</a>
            </li>
            <li><a href="#"><span class="glyphicon glyphicon-cog"></span>设置</a>
                <ul>
                    <li><a href="#">我的账号</a></li>
                    <li><a href="#">修改密码</a></li>
                    <li><a href="#">用户协议</a></li>
                    <li><a href="#">反馈和帮助</a></li>
                    <li><a href="#">退出</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="glyphicon glyphicon-envelope"></span>消息</a>
                <ul>
                    <li><a href="#">私信</a></li>
                    <li><a href="#">面试进程</a></li>
                    <li><a href="#">账号修改消息</a></li>
                    <li><a href="#">简历修改消息</a></li>
                    <li><a href="#">简历投递消息</a></li>
                    <li><a href="#">职位刷新通知</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="glyphicon glyphicon-zoom-in"></span>招聘信息</a>
                <ul>
                    <li><a href="#">最新职位</a></li>
                    <li><a href="#">招聘部门</a></li>
                    <li><a href="#">招聘职位</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="glyphicon glyphicon-file"></span>简历管理</a>
                <ul>
                    <li><a href="#">简历阅览</a></li>
                    <li><a href="#">基本简历管理</a></li>
                    <li><a href="#">附件管理</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span>求职状态</a>
                <ul>
                    <li><a href="#">目前状态</a></li>
                    <li><a href="#">求职意向</a></li>
                    <li><a href="#">关注职位</a></li>
                </ul>
            </li>
        </ul>
        <div class="clearfix"></div>
    </nav>
</div>
</body>

</html>