<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>酒店后台管理系统</title>
</head>
<frameset rows="60,*" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/top">
		<frameset cols="200,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/menu" style="border:1px solid #c5c5c5;">
			<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/saleExport/findAll">
		</frameset>
</frameset>
<body>
	
</body>
</noframes>
</html>