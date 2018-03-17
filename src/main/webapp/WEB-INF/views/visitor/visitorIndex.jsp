<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    <meta charset="utf-8">
    <title>嘻嘻</title>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.js/bootstrap.min.js"></script>
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
            <li><a href="#"><span class="iconic home"></span>个人信息</a>
            <ul>
                <li><a href="/visitor/viewVisitorMessage.do">查看</a></li>
                <li><a href="">修改</a></li>
            </ul>
            </li>
            <li><a href="#"><span class="iconic plus-alt"></span> About</a>
                <ul>
                    <li><a href="#">Company History</a></li>
                    <li><a href="#">Meet the team</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="iconic magnifying-glass"></span> Services</a>
                <ul>
                    <li><a href="#">Web Design</a></li>
                    <li><a href="#">App Development</a></li>
                    <li><a href="#">Email Campaigns</a></li>
                    <li><a href="#">Copyrighting</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="iconic map-pin"></span> Products</a>
                <ul>
                    <li><a href="#">Widget One</a></li>
                    <li><a href="#">Widget Two</a></li>
                    <li><a href="#">Web App Three</a></li>
                    <li><a href="#">Web App Four</a></li>
                    <li><a href="#">Crazy Products</a></li>
                    <li><a href="#">iPhone Apps</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="iconic mail"></span> Contact</a>
                <ul>
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="#">Directions</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="iconic mail"></span> ${sessionScope.visitor.visitorBaseMessage.visitorName}</a>

            </li>
        </ul>
        <div class="clearfix"></div>
    </nav>
</div>
</body>

</html>