<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/user/common.css"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="pagination" style="margin-left: 450px;">
    <a id="firstpage" onclick="submitfrist();">首页</a>
    <c:if test="${userList.pageNo==1}">
        <a id="uppage" class="current prev">&lt;&nbsp;上一页</a>
    </c:if>
    <c:if test="${userList.pageNo!=1}">
        <a id="uppage" onclick="submitup(${userList.pageNo});">&lt;&nbsp;上一页</a>
    </c:if>
    <c:if test="${userList.pageNo==userList.lastPage}">
        <a id="nextpage" class="current prev">下一页&nbsp;&gt;</a>
    </c:if>
    <c:if test="${userList.pageNo != userList.lastPage}">
        <a id="nextpage" onclick="submitnext(${userList.pageNo});">下一页&nbsp;&gt;</a>
    </c:if>
    <span>共&nbsp;${userList.total}条记录
  </span>
    <span>跳转到:
      <select id="pageNumber" onchange="submitpage()">
      <c:forEach var="i" begin="1" end="${userList.lastPage}" step="1">
          <c:if test="${userList.pageNo==i}">
              <option selected="selected" value="${i}">${i}</option>
          </c:if>
          <c:if test="${userList.pageNo!=i}">
              <option value="${i}">${i}</option>
          </c:if>
      </c:forEach>
      </select>
   </span>
    <a id="lastpage" onclick="submitlast(${userList.lastPage });">尾页</a>
</div>
</body>
</html>