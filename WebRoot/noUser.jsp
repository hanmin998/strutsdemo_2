<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'noUser.jsp' starting page</title>
  </head>
  
  <body>
    <a href="findAllUser">返回首页</a><br>
  	<h2>当前没有用户名片。</h2>
    <s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>

  </body>
</html>
