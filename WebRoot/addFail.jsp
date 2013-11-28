<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'addFail.jsp' starting page</title>	
  </head>
  
  <body>
		<a href="findAllUser">返回首页</a><br><br>
    	<center><s:property value="user.name"/>添加失败，该用户名片已经存在。</center>
        <s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>

  </body>
</html>
