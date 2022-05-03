<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/10
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>用户管理</title>

<div class="workingArea">
    <h1 class="label label-info">用户管理</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
                <tr class="success">
                    <th>用户名称</th>

                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${us}" var="u">
                <tr>
                    <td>${u.name}</td>

                    <td><a deleteLink="true" href="admin_placeStadium_delete?id=${ps.id}&pid=${place.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>


</div>
<%@include file="../include/admin/adminFooter.jsp"%>