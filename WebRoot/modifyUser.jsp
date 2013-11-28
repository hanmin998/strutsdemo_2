<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'modifyUser.jsp' starting page</title>
  </head>
  
  <body>
    	    <a href="findAllUser">返回首页</a><br>
    <form action="updateAllUser" method="post">
    	<s:hidden name="user.id" value="%{user.id}" /><br>
    	<s:textfield name="user.name" label="姓名"/><br>
    	<s:textfield name="user.birthday" label="生日"/><br>
    	<s:textfield name="user.sex" label="性别" /><br>
    	<s:textfield name="user.email" label="邮箱" /><br>
    	<s:textfield name="user.phone" label="联系方式" /><br>
    	<s:submit name="modify" value="提交"/>
        <s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>

    </form>
  </body>
</html>
