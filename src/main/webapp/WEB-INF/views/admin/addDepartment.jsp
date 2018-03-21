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
    <title>增删部门</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/styles/bootstrap.css" rel="stylesheet">
    <link href="/styles/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.0.0.js"></script>

    <link rel="stylesheet" type="text/css" href="/tishikuang/zeroModal.css" />
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/tishikuang/zeroModal.min.js"></script>
    <script>
        var  dele;
        function addDepartment() {
            if($("#departmentName").val()==""||$("#departmentLocation").val()==""){
                zeroModal.alert('请填写部门信息!');
            }else{
            $.ajax({
                type: "get",
                url: '/department/addDepartment.do',
                data: {"departmentName":$("input[name='departmentName']").val(),
                      "departmentLocation":$("input[name='departmentLocation']").val()},
                success: function (msg) {
                    if(msg.trim()=="is_exist"){
                            zeroModal.alert('该部门已存在请勿重复添加!');
                    }else if(msg.trim()=="false"){
                        zeroModal.alert('增加失败!');
                    }else {
                        location.reload();
                    }
                }
            });
            }
        }
        function deleteDepartment(value,ele) {
            dele=ele;
            $.ajax({
                type: "get",
                url: '/department/deleteDepartment.do',
                data: "departmentName="+value,
                success: function (msg) {
                    if(msg.trim()=="false"){
                        zeroModal.alert('部门删除失败!');
                    }else if(msg.trim()=="true"){
                        var  tr1=dele.parentNode.parentNode;
                        var  tab=tr1.parentNode;
                        tab.removeChild(tr1);
                        location.reload();
                    }else{
                        zeroModal.alert('该部门不是空部门!');
                    }
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="adminIndex.jsp"></jsp:include>
<div style="margin-top: 100px;margin-left: 300px;">
<c:choose >
    <c:when test="${requestScope.departmentList eq '暂无任何部门!'}">
        <div><c:out value="${'暂无任何部门!'}"></c:out></div>
    </c:when>
    <c:otherwise>
        <table style="margin-top: 200px;">
            <tr class="success">
                <th style="width: 100px">部门编号</th>
                <th style="width: 100px">部门名称</th>
                <th style="width: 100px">部门地点</th>
                <th style="width: 100px">操作</th>
            </tr>
            <c:forEach items="${requestScope.departmentList}" var="department">
                <tr>
                    <td><c:out value="${department.getId()}"></c:out></td>
                    <td><c:out value="${department.getDepartmentName()}"></c:out></td>
                    <td><c:out value="${department.getDepartmentLocation()}"></c:out></td>
                    <td><button type="button" class="btn btn-warning" title="提示信息" id="showDeletedMessage"
                                data-container="body" data-toggle="popover" data-placement="right"
                                data-content="" onclick="deleteDepartment('${department.getDepartmentName()}',this)">
                        删除此部门
                    </button></td>
                </tr>
            </c:forEach>
        </table>

    </c:otherwise>
</c:choose>
    <table>
        <tr>
            <td></td>
            <td><input placeholder="部门名称" name="departmentName" id="departmentName" class="form-control"></td>
            <td><input placeholder="部门地点" name="departmentLocation" id="departmentLocation" class="form-control"></td>
            <td>
                <button onclick="addDepartment()" class="btn btn-success">增加此部门</button>
            </td>
        </tr>
    </table>
    </div>
</body>
</html>