<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/css.css" />
<script src="${pageContext.request.contextPath }/resource/js/public/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/laydate/laydate.js"></script>
<title>头部</title>

</head>
<body>
<div class="header">
    <div class="logo"><img  src="${pageContext.request.contextPath }/resource/img/logo.png" /></div>

    <div class="header-right">
        <a>用户名:${currAdminUser.realName }</a>
        <i class="icon-off icon-white"></i>
        <a target="_parent" href="${pageContext.request.contextPath }/logout">注销</a>
        <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">
                    注销系统
                </h3>
            </div>
            <div class="modal-body">
                <p>
                    您确定要注销退出系统吗？
                </p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="登录.html" >确定退出</a>
            </div>
        </div>
    </div>
</div>
</body>

</html>
