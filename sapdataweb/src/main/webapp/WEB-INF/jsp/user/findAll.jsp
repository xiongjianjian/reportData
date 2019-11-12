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
<title>主界面</title>
</head>
<body>
<div class="right"  id="mainFrame">

    <div class="right_cont">
        <ul class="breadcrumb">当前位置：
            首页<span class="divider">/</span>
            用户管理<span class="divider">/</span>
            用户列表
        </ul>
        <div class="title_right">
            <span class="pull-right margin-bottom-5">
                <a class="btn btn-info btn-small" href="${pageContext.request.contextPath }/user/userAdd">
                    <i class="icon-plus icon-white"></i> 添加用户
                </a>
            </span><strong>用户列表</strong>
        </div>
        <div style="width:900px; margin:auto">
            <table class="table table-bordered">
                <tr>
                    <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">款到开始时间：</td>
                    <td width="23%"><input type="text"  class="laydate-icon span1-1" id="Calendar" value="2015-08-25"  /></td>
                    <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">款到结束时间：</td>
                    <td width="23%"><input type="text"  class="laydate-icon  span1-1" id="Calendar2" value="2015-08-25"  /></td>
                    <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">选择排行内容：</td>
                    <td><input type="text"   class=" span1-1" /></td>
                </tr>
            </table>

            <table  class="margin-bottom-20 table  no-border" >
                <tr>
                    <td class="text-center"><input type="button" value="查询" class="btn btn-info " style="width:80px;" /></td>
                </tr>
            </table>
            <table class="table table-bordered table-hover table-striped">
                <tbody>
                <tr align="center">
                    <td><strong>No</strong></td>
                    <td><strong>分理处</strong></td>
                    <td><strong>运费合计</strong></td>
                    <td><strong>代收款合计</strong></td>
                    <td><strong> </strong></td>
                </tr>
                <tr align="center">
                    <td>1</td>
                    <td>华商汇二部分理处</td>
                    <td>18701</td>
                    <td>110517</td>
                    <td><a id="DataGrid1_ctl03_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl03$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>2</td>
                    <td>华南城分理处</td>
                    <td>1637</td>
                    <td>151776</td>
                    <td><a id="DataGrid1_ctl04_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl04$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>3</td>
                    <td>圃田分理处</td>
                    <td>1258</td>
                    <td>26834</td>
                    <td><a id="DataGrid1_ctl05_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl05$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>4</td>
                    <td>东建材分理处</td>
                    <td>1216</td>
                    <td>7672</td>
                    <td><a id="DataGrid1_ctl06_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl06$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>5</td>
                    <td>广材分理处</td>
                    <td>950</td>
                    <td>21068</td>
                    <td><a id="DataGrid1_ctl07_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl07$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>6</td>
                    <td>白沙分理处</td>
                    <td>769</td>
                    <td>21078</td>
                    <td><a id="DataGrid1_ctl08_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl08$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>7</td>
                    <td>总部</td>
                    <td>609</td>
                    <td>19916</td>
                    <td><a id="DataGrid1_ctl09_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl09$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>8</td>
                    <td>北天荣分理处</td>
                    <td>540</td>
                    <td>23240</td>
                    <td><a id="DataGrid1_ctl10_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl10$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>9</td>
                    <td>香江分理处</td>
                    <td>260</td>
                    <td>26820</td>
                    <td><a id="DataGrid1_ctl11_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl11$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>10</td>
                    <td>汽配城分理处</td>
                    <td>128</td>
                    <td>7676</td>
                    <td><a id="DataGrid1_ctl12_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl12$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>11</td>
                    <td>华丰分理处</td>
                    <td>62</td>
                    <td>2306</td>
                    <td><a id="DataGrid1_ctl13_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl13$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>12</td>
                    <td>九龙分理处</td>
                    <td>58</td>
                    <td>0</td>
                    <td><a id="DataGrid1_ctl14_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl14$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>13</td>
                    <td>宽广分理处</td>
                    <td>45</td>
                    <td>120</td>
                    <td><a id="DataGrid1_ctl15_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl15$LinkButton1','')">详细</a></td>
                </tr>
                <tr align="center">
                    <td>14</td>
                    <td>孟庄分理处</td>
                    <td>30</td>
                    <td>1320</td>
                    <td><a id="DataGrid1_ctl16_LinkButton1" href="javascript:__doPostBack('DataGrid1$ctl16$LinkButton1','')">详细</a></td>
                </tr>
                </tbody>
            </table>

            <table  class="margin-bottom-20 table  no-border" >
                <tr>
                    <td class="text-center"><input type="button" value="打印" class="btn btn-info    margin-right-20" style="width:80px;"  /><input type="button" value="数据导出" class="btn btn-info  "  style="width:80px;" /></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
