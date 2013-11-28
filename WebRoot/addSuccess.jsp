<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'addSuccess.jsp' starting page</title>
  </head>
  
  <body>
       <a href="findAllUser">返回首页</a>
       <h2><s:property value="user.name"/>添加成功。</h2>
	   <s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>
  </body>
</html>
