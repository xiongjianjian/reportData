<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/css.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/user/common.css"/>

    <script src="${pageContext.request.contextPath }/resource/js/public/jquery1.9.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/sdmenu.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/laydate/laydate.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/public.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/saleData/allActivityType.js"></script>
    <title>主界面</title>
</head>
<body>
<div class="right" id="mainFrame">

    <div class="right_cont">
        <ul class="breadcrumb">当前位置：
            首页<span class="divider">/</span>
            用户管理<span class="divider">/</span>
            用户列表
        </ul>
        <div class="title_right">
            <span class="pull-right margin-bottom-5">
                <a class="btn btn-info btn-small" href="${pageContext.request.contextPath}/user/userAdd">
                    <i class="icon-plus icon-white"></i> 添加用户
                </a>
            </span><strong>用户列表</strong>
        </div>
        <div style="width:900px; margin:auto">

            <form id="pageSubmit" action="${pageContext.request.contextPath}/user/findAll" method="get">

                <span width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">客户编号:
                    <input class="span1-1" name="customerCode" id="customerCode" type="text" value="${adminUserVo.customerCode}"/></span>

                <span width="23%">销售员编号:<input name="saleCode" id="saleCode" type="text" value="${adminUserVo.saleCode}"/></span>

                <span width="10%" align="right" nowrap="nowrap">手机号码:
                    <input class="span1-1" name="mobile" id="mobile" type="text" value="${adminUserVo.mobile}"/></span>

                <span width="23%">真实姓名:
                    <input class="span1-1" name="realName" id="realName"  type="text" value="${adminUserVo.realName}"/></span>


                <span class="margin-bottom-20 text-center"><input type="submit" value="查询" class="btn btn-info "
                                                                  style="width:80px;"/></span>

            <table class="table table-bordered table-hover table-striped">
                <tbody>
                <tr align="center">
                    <td><strong>No</strong></td>
                    <td><strong>客户编号</strong></td>
                    <td><strong>销售员编号</strong></td>
                    <td><strong>手机号码</strong></td>
                    <td><strong>真实姓名</strong></td>
                    <td><strong>创建时间</strong></td>
                    <td><strong>更新时间</strong></td>
                    <td><strong>角色</strong></td>
                    <td><strong></strong></td>
                </tr>
                <c:forEach items="${userList.list}" var="user" varStatus="status">
                    <tr align="center">
                        <td>${status.count}</td>
                        <td>${user.customerCode}</td>
                        <td>${user.saleCode}</td>
                        <td>${user.mobile}</td>
                        <td>${user.realName}</td>

                        <td><fmt:formatDate value='${user.createDate}' pattern='yyyy-MM-dd'/></td>

                        <td><fmt:formatDate value='${user.modifyDate}' pattern='yyyy-MM-dd'/></td>
                        <td>
                            <c:if test="${user.roleCode == 1}">管理员</c:if>
                            <c:if test="${user.roleCode == 2}">商户</c:if>
                        </td>

                        <td>
                            <a id="DataGrid1_ctl03_LinkButton1" onclick="updateUser(${user.userId},${userList.pageNo},${userList.pageSize})">修改</a>
                            <a id="DataGrid1_ctl03_LinkButton2" onclick="deleteUser(${user.userId},${userList.pageNo},${userList.pageSize})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                <%@include file="../../../page.jsp" %>
                <input type="hidden" name="pageNo" id="pageNo">
            </form>

            <table class="margin-bottom-20 table  no-border">
                <tr>
                    <td class="text-center">
                        <input type="button" value="打印" class="btn btn-info    margin-right-20" style="width:80px;"/>
                        <input type="button" value="数据导出" class="btn btn-info  " style="width:80px;"/></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script>
    var customerCode = $("#customerCode").val();
    var saleCode = $("#saleCode").val();
    var mobile = $("#mobile").val();
    var realName = $("#realName").val();
    function updateUser(userId,pageNo,pageSize) {
            window.location.href="${pageContext.request.contextPath}/user/update?userId="
                +userId+"&&pageNo="+pageNo+"&&pageSize="+pageSize
                +"&&customerCode="+customerCode+"&&saleCode="+saleCode
                +"&&mobile="+mobile+"&&realName="+realName;
    }

    function deleteUser(userId,pageNo,pageSize) {
        //当删除的该条记录正好为当页最后一条时,跳转到第一页
        if ( ${userList.total % 5 == 1}){
            pageNo = 1;
        }
        var flag = confirm("确定删除该用户?");
        if (flag == true){
            window.location.href="${pageContext.request.contextPath}/user/delete?userId="
                +userId+"&&pageNo="+pageNo+"&&pageSize="+pageSize
                +"&&customerCode="+customerCode+"&&saleCode="+saleCode
                +"&&mobile="+mobile+"&&realName="+realName;
        }
    }
</script>
</body>
</html>
