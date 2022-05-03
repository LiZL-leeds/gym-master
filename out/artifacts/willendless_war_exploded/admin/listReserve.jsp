<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/27
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>
<title>预约审核</title>
<div class="workingArea">
    <div style="padding: 12px;">
        <div >
            <!--总表头部-->
            <table class="orderListItemTable">
                <tr>
                    <td width="80px">用户</td>
                    <td width="150px">场地</td>
                    <td width="150px">预约时间</td>

                </tr>
            </table>


            <c:forEach items="${reserveList}" var="r">
                <table class="orderListItemTable" >

                    <!--订单头-->
                    <tr class="orderListItemFirstTR">
                        <td colspan="2" style="text-align: left; padding-left: 20px; box-sizing: border-box">
                            <b><fmt:formatDate value="${r.time}" pattern="yyyy-MM-dd HH:mm:ss" /> </b>

                        </td>
                        <td colspan="3"></td>
                    </tr>

                    <!--订单内容-->

                    <c:forEach items="${r.reserveItemList}" var="reserveItem" varStatus="st">
                        <tr class="orderItemTR">
                            <!--用户名-->
                            <c:if test="${st.count == 1}">
                                <td valign="center" rowspan="${fn:length(r.reserveItemList)}" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="150px" >
                                    <span class="orderListItemNumber">${r.user.name}</span>
                                </td>
                            </c:if>
                            <!--场地名-->
                            <td class="orderItemProductInfoPartTD" width="350px">${reserveItem.stadiumPlanItem.name}</td>
                            <!--时间-->
                            <td class="orderItemProductInfoPartTD" width="250px">${reserveItem.stadiumPlanItem.beg}~${reserveItem.stadiumPlanItem.end}</td>
                            <!--状态和操作-->

                        </tr>
                    </c:forEach>

                </table>
            </c:forEach>

        </div>
    </div>
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>
</div>

<%@include file="../include/admin/adminFooter.jsp"%>

