<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/user/login.css" />
<script src="${pageContext.request.contextPath }/resource/js/public/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/bootstrap.min.js"></script>
<script type="text/javascript">
    // 在被嵌套时就刷新上级窗口
    if(window.parent != window){
        window.parent.location.reload(true);
    }
</script>
<title>主界面</title>
</head>
<body>
<div class="tit"><img src="${pageContext.request.contextPath }/resource/img/tit.png" alt="" /></div>
<div class="login-wrap">
    <form action="${pageContext.request.contextPath }/loginCheck" method="post" id="loginUser">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td height="15" valign="bottom">用户名：</td>
            </tr>
            <tr>
                <td><input type="text" name="userCode" class="login_input login_user"/></td>
            </tr>
            <tr>
                <td height="15" valign="bottom">密  码：</td>
            </tr>
            <tr>
                <td><input type="password" name="password" class="login_input login_password"/></td>
            </tr>
            <tr>
                <td height="15" valign="bottom"></td>
            </tr>
            <tr>
                <td>
                    <select name="roleCode" style="height: 24px;width: 218px;">
                        <option value="1">普通用户</option>
                        <option value="2">销售员</option>
                        <option value="3">管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td height="50" valign="bottom"><a class="btn btn-block btn-login" id="loginButton">登录</a></td>
            </tr>
            <tr>
                <td height="15" valign="bottom" style="color: red;">${loginError}</td>
            </tr>
        </table>
    </form>
</div>
<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
</body>
<script type="text/javascript">
    $('#loginButton').click(function(e) {
        $("#loginUser").submit();
    });
</script>
</html>
