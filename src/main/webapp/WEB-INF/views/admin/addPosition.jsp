<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/20
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增删职位</title>
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
    <script>
        function showPosition() {
            if($("#departmentName").val()==""){
                zeroModal.alert("请选择部门!");
                $("#content").html("");
            }else {
                $.ajax({
                    type: "get",
                    url: '/position/showPosition.do',
                    data: "departmentName="+$("select[name='departmentName']").val(),
                    /*Jason解析*/
                    success: function (msg) {
                        var arr=eval(msg);
                        if(arr.length==0){
                            $("#content").html("<h3>该部门暂无职位!<h3>");
                        }else {
                            var c="<table class='table table-bordered'>"+
                                "<tr class='success'> " +
                                "<th>职位名称</th>"+
                                "</tr>";
                            for(var i=0;i<arr.length;i++){
                                c+="<tr>";
                                c+="<td>"+arr[i].positionName+"</td>";
                                c+="</tr>";
                            }
                            c+="</table>";
                            c+="<input name='deletePositionName' class='form-control' id='position2' placeholder='职位名称'>";
                            c+="<button onclick='deletePosition()' class='btn btn-warning'>删除职位</button>";
                            $("#content").html(c);
                        }
                    }
                });
            }

        }

        function addPosition() {
            if($("#departmentName").val()==""){
                zeroModal.alert("请选择部门!");
            }else if($("#positionName").val()==""){
                zeroModal.alert("请填写职位!");
            }else {
                $.ajax({
                    type: "get",
                    url: '/position/addPosition.do',
                    data: {"positionName":$("input[name='addPositionName']").val(),
                        "departmentName":$("#departmentName").val()},
                    success: function (msg) {
                        if(msg.trim()=="is_exist"){
                            zeroModal.alert('该职位已存在请勿重复添加!');
                        }else if(msg.trim()=="false"){
                            zeroModal.alert('增加失败!');
                        }else {
                            location.reload();
                        }
                    }
                });
            }
        }
        function deletePosition() {
            if($("#departmentName").val()==""){
                zeroModal.alert("请选择部门!");
            }else if($("#position2").val()==""){
                zeroModal.alert("请填写职位!");
            }else {
                $.ajax({
                    type: "get",
                    url: '/position/deletePosition.do',
                    data: {"positionName":$("input[name='deletePositionName']").val(),
                        "departmentName":$("#departmentName").val()},
                    success: function (msg) {
                        if(msg.trim()=="is_not_exist"){
                            zeroModal.alert('该部门并不存在该职位,脑子不太好吧!');
                        }else if(msg.trim()=="false"){
                            zeroModal.alert('删除失败!');
                        }else if(msg.trim()=="staff_is_exist"){
                            zeroModal.alert('还有人担当这个职位呢!你说删就删了?');
                        }else {
                            location.reload();
                        }
                    }
                });
            }
        }
    </script>
</head>
<body>
<jsp:include page="adminIndex.jsp"></jsp:include>
<div style="margin-top: 150px;margin-left: 300px;">
    <c:choose >
        <c:when test="${requestScope.departmentList eq '暂无任何部门!'}">
            <div><c:out value="${'连部门都没有，怎么添加职位，还不滚去添加部门!'}"></c:out></div>
        </c:when>
        <c:otherwise>
            <div>请选择部门</div>
            <select id="departmentName" name="departmentName" onchange="showPosition()">
                <option value="">请选择部门</option>
                <c:forEach items="${requestScope.departmentList}" var="department">
                    <option value="${department.getDepartmentName()}">${department.getDepartmentName()}</option>
                </c:forEach>
            </select>
            <div id="content">
                <%--局部刷新展现部门下的职位--%>
            </div>
            <input class="form-control" name="addPositionName" id="positionName" placeholder="职位名称">
            <button onclick="addPosition()" class="btn btn-success">增加职位</button>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
