<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  <div align="right">
  	<s:a href="register.jsp">
  		<font color="blue"><h5>还未注册？点击注册</h5></font>
  	</s:a>
  </div>
  <div style="color:#7FFF00">
    <s:form action="userLogin" method="post">
    <s:textfield name="useUser.UserName" label="用户名"></s:textfield>
    <s:password name="useUser.UserPwd" label="密码"></s:password>
    
    <%--
    	<s:textfield name="UserCheck" label="验证码"></s:textfield>
    --%>
    <s:submit name="login" value="登陆"></s:submit>
    </s:form>
    </div>
  </body>
</html>
