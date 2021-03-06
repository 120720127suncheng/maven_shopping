<!doctype html>
<html lang="zh" class="no-js">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>工作界面</title>
    <link rel="stylesheet" href="/stafffont/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" type="/text/css" href="/stafffont/css/default.css">
    <link rel="stylesheet" href="/stafffont/css/style.css"> <!-- Resource style -->
    <script src="/stafffont/js/modernizr.js"></script> <!-- Modernizr -->
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
                <a href="#0">招聘管理</a>
                <ul>
                    <li><a href="#0">面试库</a></li>
                    <li><a href="#0">录取库</a></li>
                    <li><a href="#0">新简历</a></li>
                    <li><a href="#0">历史招聘职位</a></li>
                    <li><a href="/advertiseFor/jumpToAddAdvertiseFor">增加招聘职位</a></li>
                </ul>
            </li>
            <li class="has-children notifications active">
                <a href="#0">Notifications<span class="count">3</span></a>

                <ul>
                    <li><a href="#0">All Notifications</a></li>
                    <li><a href="#0">Friends</a></li>
                    <li><a href="#0">Other</a></li>
                </ul>
            </li>

            <li class="has-children comments">
                <a href="#0">Comments</a>

                <ul>
                    <li><a href="#0">All Comments</a></li>
                    <li><a href="#0">Edit Comment</a></li>
                    <li><a href="#0">Delete Comment</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li class="cd-label">Secondary</li>
            <li class="has-children bookmarks">
                <a href="#0">Bookmarks</a>

                <ul>
                    <li><a href="#0">All Bookmarks</a></li>
                    <li><a href="#0">Edit Bookmark</a></li>
                    <li><a href="#0">Import Bookmark</a></li>
                </ul>
            </li>
            <li class="has-children images">
                <a href="#0">Images</a>

                <ul>
                    <li><a href="#0">All Images</a></li>
                    <li><a href="#0">Edit Image</a></li>
                </ul>
            </li>

            <li class="has-children users">
                <a href="#0">Users</a>

                <ul>
                    <li><a href="#0">All Users</a></li>
                    <li><a href="#0">Edit User</a></li>
                    <li><a href="#0">Add User</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li class="cd-label">Action</li>
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
