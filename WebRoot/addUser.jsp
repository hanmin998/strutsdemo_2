<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'addUser.jsp' starting page</title>
  </head>
  
  <body>
    <s:form action="addUser" method="post">
    <s:textfield name="user.name" label="姓名"/><br>
    <s:textfield name="user.birthday" label="生日"/><br>
    <s:textfield name="user.sex" label="性别" /><br>
    <s:textfield name="user.email" label="邮箱" /><br>
    <s:textfield name="user.phone" label="联系方式" /><br>
    <s:submit name="submit" value="添加"/>
    </s:form>
  </body>
</html>
