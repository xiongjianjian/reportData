<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/index/css.css" />
<script src="${pageContext.request.contextPath }/resource/js/public/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/public/laydate/laydate.js"></script>
<script type="text/javascript">
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	function changeMunu(id) {
		$("a").removeClass("current");
		$("#"+id).addClass("current");
	}
</script>
<title>主界面</title>
</head>
<body>
<div id="my_menu" class="sdmenu">
	<div>
		<span>用户管理</span>
		<a target="right" id="1" href="${pageContext.request.contextPath }/user/findAll" onclick="changeMunu(1);">用户列表</a>
		<a target="right" id="2" href="${pageContext.request.contextPath }/user/toUpdatePass" onclick="changeMunu(2);">修改密码</a>
	</div>
	<div>
		<span>商户数据</span>
		<a target="right" id="3" href="${pageContext.request.contextPath }/saleExport/findAll" onclick="changeMunu(3);">销售报表</a>
	</div>
</div>
</body>
</html>
