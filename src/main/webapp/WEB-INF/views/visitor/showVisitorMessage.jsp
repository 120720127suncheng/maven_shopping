<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人信息</title>
    <script src="/scripts/digit.js"></script>
    <script src="/scripts/time.js"></script>

    <link rel="stylesheet" type="text/css" href="/styles/cssBM/jquery.gridster.min.css">
    <link rel="stylesheet" href="/styles/cssBM/style.css">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.js/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>
    <script src="/scripts/elert.js"></script>
    <script>
        window.onload=function () {
            if(${requestScope.info eq null}){
                $("#alert").hide();
            }else {
                $("#alert").show();
                var alertId=document.getElementById("alert");
                hideAlert(alertId);
            }
        }
    </script>
</head>

<body>
<div id="alert" class="alert alert-warning">
    <c:out value="${requestScope.info}"></c:out>
</div>
    <section class="demo">
        <div class="gridster">
            <ul>
                <li data-row="1" data-col="1" data-sizex="2" data-sizey="1">
                    <canvas id="canvas" style="width: 300px;height: 140px"></canvas>
                </li>
                <li data-row="3" data-col="1" data-sizex="1" data-sizey="1">
                    <div>
                        <c:choose>
                            <c:when test="${sessionScope.visitor.visitorBaseMessage.photo eq null}">
                                <img src="/images/head.jpg" style="width: 140px;height: 140px">
                            </c:when>
                            <c:otherwise>
                                <h1>${sessionScope.visitor.visitorBaseMessage.photo}</h1>
                                <img  src='${sessionScope.visitor.visitorBaseMessage.photo}' style="width: 140px;height: 140px">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </li>
                <li data-row="3" data-col="2" data-sizex="2" data-sizey="1">
                    <div>个人信息:</div>
                    <h6>姓名:${sessionScope.visitor.visitorBaseMessage.visitorName}</h6>
                    <h6>年龄:${sessionScope.visitor.visitorBaseMessage.visitorAge}</h6>
                    <h6>性别:${sessionScope.visitor.visitorBaseMessage.visitorSex}</h6>
                    <h6>民族:${sessionScope.visitor.visitorBaseMessage.visitorNational}</h6>
                </li>
                <li data-row="1" data-col="2" data-sizex="2" data-sizey="2"></li>

                <li class="try" data-row="1" data-col="4" data-sizex="1" data-sizey="1">
                    <a href="/visitor/updateBaseMessage.view" class="btn bg-info">修改个人信息</a>
                </li>
                <li data-row="2" data-col="4" data-sizex="2" data-sizey="1">
                    <h6>账号信息:</h6>
                    <h6>最近登录时间:${sessionScope.visitor.visitorLoginTime}</h6>
                    <h6>注册时间:${sessionScope.visitor.visitorCreateTime}</h6>
                    <div>
                        <h6 style=" font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">账号修改时间:</h6>
                        <c:choose>
                            <c:when test="${sessionScope.visitor.visitorBaseMessage.visitorModifiedTime eq null}">
                                <c:out value="暂未修改"></c:out>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${sessionScope.visitor.visitorBaseMessage.visitorModifiedTime}"></c:out>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </li>
                <li data-row="3" data-col="4" data-sizex="1" data-sizey="1">
                    <h6>联系方式:</h6>
                    <h6>手机号:</h6>
                    <h6>${sessionScope.visitor.visitorPhone}</h6>
                    <h6>邮箱:</h6>
                    <h6>${sessionScope.visitor.visitorEmail}</h6>
                </li>
                <li data-row="1" data-col="5" data-sizex="1" data-sizey="1"></li>
                <li data-row="3" data-col="5" data-sizex="1" data-sizey="1">

                </li>
                <li data-row="1" data-col="6" data-sizex="1" data-sizey="1">
                    <h6>家庭住址:</h6>
                    &nbsp; <h6>${sessionScope.visitor.visitorBaseMessage.province}</h6>
                    &nbsp;<h6> ${sessionScope.visitor.visitorBaseMessage.city}</h6>
                    &nbsp;<h6>${sessionScope.visitor.visitorBaseMessage.country}</h6>
                    &nbsp;<h6>${sessionScope.visitor.visitorBaseMessage.street}</h6>
                </li>
                <li data-row="2" data-col="6" data-sizex="1" data-sizey="2"></li>
            </ul>
        </div>

    </section>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="/scripts/jsBM/jquery.gridster.js" type="text/javascript"></script>
<script type="text/javascript">
    var gridster;

    $(function(){

        gridster = $(".gridster > ul").gridster({
            widget_margins: [10, 10],
            widget_base_dimensions: [140, 140],
            min_cols: 6
        }).data('gridster');

    });

</script>

</body>
</html>
