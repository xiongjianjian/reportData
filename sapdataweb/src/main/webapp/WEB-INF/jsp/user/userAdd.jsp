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
    <script src="${pageContext.request.contextPath }/resource/js/public/jquery1.9.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/sdmenu.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/laydate/laydate.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/public/saleData/checkUserAddForm.js"></script>


    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/easyhelper.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/es6-shim.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/resource/js/jquery.transit.min.js"></script>

    <title>主界面</title>
</head>
<body>
<div class="right_cont">
    <ul class="breadcrumb">当前位置：
        首页<span class="divider">/</span>
        用户管理<span class="divider">/</span>
        <span>
        <c:if test="${empty adminUser}">添加用户</c:if>
        <c:if test="${!empty adminUser}">修改用户</c:if>
        </span>
    </ul>


    <div class="title_right">
        <strong>
            <c:if test="${empty adminUser}">添加用户</c:if>
            <c:if test="${!empty adminUser}">修改用户</c:if>
        </strong>
    </div>

    <div style="width:900px; margin:auto">
        <form id="addAndUpdate" method="post">
            <table class="table table-bordered">
                <tr>
                    <td width="12%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">客户编号：</td>
                    <td width="28%"><input type="text" name="customerCode" id="customerCode"
                                           value="${adminUser.customerCode}"
                                           class="span1-1" onchange="checkCustomerCodeIsExist()"
                                           placeholder="选填"
                            <c:if test="${adminUser.customerCode != null && adminUser.customerCode != ''}">readonly</c:if>/>

                        <span id="customerCodeMsg" height="15" style="color: red;"></span>
                    </td>

                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">销售员编号：</td>
                    <td><input type="text" name="saleCode" id="saleCode"
                               value="${adminUser.saleCode}" class="span1-1"
                               onchange="checkSaleCodeIsExist()" placeholder="选填"
                               <c:if test="${adminUser.saleCode != null && adminUser.saleCode !=''}">readonly</c:if>/>

                        <span id="saleCodeMsg" height="15" style="color: red;"></span>
                    </td>
                </tr>


                <tr>
                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">真实姓名：</td>
                    <td><input type="text" name="realName" id="realName" value="${adminUser.realName}" class="span1-1"
                               placeholder="必填"/></td>

                    <td align="right" bgcolor="#f1f1f1">手机号码：</td>
                    <td><input type="text" name="mobile" id="mobile" value="${adminUser.mobile}" class="span1-1"
                               placeholder="必填"/></td>

                </tr>
                <tr>
                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">角色：</td>
                    <td>
                        <select name="roleCode">

                            <option value="1" <c:if test="${adminUser.roleCode==1}"> selected </c:if> >管理员</option>

                            <option value="2" <c:if test="${adminUser.roleCode==2}"> selected </c:if> >商户</option>


                        </select>
                    </td>

                    <td align="right" bgcolor="#f1f1f1">身份证号码：</td>
                    <td><input type="text" name="idcard" id="idCard" value="${adminUser.idcard}" class="span1-1"
                               placeholder="非必填"/></td>

                </tr>

                <tr>
                    <td align="right" nowrap="nowrap" bgcolor="#f1f1f1">住址：</td>
                    <td colspan="3"><textarea name="address" value="${adminUser.address}" id="input11"
                                              class="span10"></textarea></td>

                    <c:if test="${adminUser != null} ">
                        <td align="right" bgcolor="#f1f1f1">客户登录密码：</td>
                        <td><input type="text" name="customerPassword" id="customerPassword" value="" class="span1-1"
                                   placeholder="非必填选项"/></td>

                        <td align="right" bgcolor="#f1f1f1">登录密码：</td>
                        <td><input type="text" name="salePassword" id="salePassword" value="" class="span1-1"
                                   placeholder="非必填选项"/></td>
                    </c:if>

                </tr>


                <tr>
                    <td align="right" bgcolor="#f1f1f1">登录方式：</td>
                    <td>
                        <select name="loginMode">
                            <option value="1" <c:if test="${adminUser.loginMode==1}"> selected </c:if> >客户号登录</option>
                            <option value="2" <c:if test="${adminUser.loginMode==2}"> selected </c:if> >销售员登录</option>
                            <option value="3" <c:if test="${adminUser.loginMode==3}"> selected </c:if> >管理员登录</option>
                        </select>
                    </td>
                </tr>

            </table>

            <c:if test="${adminUser != null}"><input type="hidden" name="userId" value="${adminUser.userId}"/></c:if>

            <%--防止表单重复提交--%>
            <input type="hidden" name="token" value="<%=session.getAttribute("token")%>"/>

            <%--修改时传递模糊查询条件--%>
            <input type="hidden" name="pageNo" value="${adminUserVo.pageNo}"/>
            <input type="hidden" name="pageSize" value="${adminUserVo.pageSize}"/>
            <input type="hidden" id="customerCodeKey" value="${adminUserVo.customerCode}"/>
            <input type="hidden" id="saleCodeKey" value="${adminUserVo.saleCode}"/>
            <input type="hidden" id="mobileKey" value="${adminUserVo.mobile}"/>
            <input type="hidden" id="realNameKey" value="${adminUserVo.realName}"/>



            <table class="margin-bottom-20 table  no-border">
                <tr>
                    <td class="text-center"><input type="button" id="sure" value="确定" onclick="checkToAction()"
                                                   class="btn btn-info " style="width:80px;"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script>
    function checkToAction() {
        //获取模糊查询传递过来的条件
        var customerCodeKey = $("#customerCodeKey").val();
        var saleCodeKey = $("#saleCodeKey").val();
        var mobileKey = $("#mobileKey").val();
        var realNameKey = $("#realNameKey").val();
        //获得表单
        //var flag = checkInfo();
        var form = document.getElementById("addAndUpdate");
        //设置表单地址 form.action = ""
        //提交 form.submit();
        if (this.checkInfo()) {
            if (${adminUser == null}) {
                form.action = "${pageContext.request.contextPath}/user/userInsert";
                form.onsubmit = this.dosubmit();
                form.submit();
                //当点击提交后，按钮不可再提交
                $("#sure").disable(true);
            } else if (${adminUser != null}) {
                form.action = "${pageContext.request.contextPath}/user/updateUser?customerCodeKey=" + customerCodeKey
                    + "&&saleCodeKey=" + saleCodeKey + "&&mobileKey=" + mobileKey + "&&realNameKey=" + realNameKey;
                form.submit();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
</script>
</body>

</html>
