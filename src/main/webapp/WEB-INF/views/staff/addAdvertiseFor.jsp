<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/21
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招聘发布</title>
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
                            $("#content").html("<h3>该部门暂无职位,请添加职位后再发布招聘信息!<h3>");
                            $("#showAndHide").hide();
                        } else {
                            $("#showAndHide").show();
                            var c = "<select id='positionName' name='positionName'>" +
                                "<option value=''>职位名称</option>";
                            for (var i = 0; i < arr.length; i++) {
                                var con = arr[i].positionName;
                                c += "<option value='" + con + "'>" + con + "</option>";
                            }
                            $("#content").html(c);
                        }
                    }
                });
            }
        }
            function submitAdvertiseFor() {
                var num_reg=/^[0-9]*$/;
                if($("#departmentName").val()==""){
                    zeroModal.alert("请选择部门!");
                }else if($("#positionName").val()==""){
                    zeroModal.alert("请填写职位!");
                }else if($("#location").val()==""||$("#positionDescribe").val()==""||$("#positionAbility").val()==""
                    ||$("#salary").val()==""||$("#advertiseForPerson").val()==""){
                    zeroModal.alert("请将招聘信息填写完整!");
                }else if(!num_reg.test($("#advertiseForPerson").val())||$("#advertiseForPerson").val()<=0){
                        zeroModal.alert("请输入正确的人数!");
                }else {
                    $.ajax({
                        type: "post",
                        url: '/advertiseFor/addAdvertiseFor.do',
                        data: {"positionName":$("select[name='positionName']").val(),
                               "departmentName":$("select[name='departmentName']").val(),
                               "location":$("input[name='location']").val(),
                               "positionDescribe":$("textarea[name='positionDescribe']").val(),
                               "positionAbility":$("textarea[name='positionAbility']").val(),
                               "salary":$("#salary").val(),
                                "advertiseForPerson":$("#advertiseForPerson").val()},
                        success: function (msg) {
                            if(msg.trim()=="false"){
                                zeroModal.alert('发布失败!');
                            }else {
                                zeroModal.alert("发布成功!");
                            }
                        }
                    });
                }
            }
    </script>
</head>
<body>
<jsp:include page="staffIndex.jsp"></jsp:include>
<div style="margin-top: 150px;margin-left: 300px;">
    <c:choose >
        <c:when test="${requestScope.departmentList eq '暂无任何部门!'}">
            <div><c:out value="${'连部门都没有，怎么招聘，让管理员增加部门去!'}"></c:out></div>
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
            <%--将元素连样式都隐藏起来--%>
            <div style="display: none" id="showAndHide">
                工作地点:<input type="text" id="location" name="location" class="form-control">
                职位描述:<textarea id="positionDescribe" name="positionDescribe" class="form-control"></textarea>
                职位要求:<textarea id="positionAbility" name="positionAbility" class="form-control"></textarea>
                薪资待遇:<select id="salary" name="salary">
                            <option value="3000--5000">3000--4000</option>
                            <option value="5000--7000">5000--7000</option>
                            <option value="7000--9000">7000--9000</option>
                            <option value="9000--11000">9000--11000</option>
                            <option value="再高没有了">再高没有了!</option>
                        </select>
                招聘人数:<input type="number" id="advertiseForPerson" name="advertiseForPerson">
                <button onclick="submitAdvertiseFor()">提交</button>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
