<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  <script type="text/javascript">
	function update(obj){
		var time=new Date().getTime();
		obj.src="imageAction.action?d"=time;
	}
  </script>
    <title>My JSP 'register.jsp' starting page</title>
  </head> 
  <body>
  <h1 align="center">用户注册</h1>
  <div align="center">
  	<s:fielderror cssStyle="color:red"></s:fielderror>
  	<s:actionerror cssStyle="color:red"></s:actionerror>
  	<br>
    <s:form action="registerUser" theme="simple" method="post">
    	<table width="50%" border="0" style="width:501px;height:342px;">
    		<tr>
    			<td align="right">用户名：</td>
    			<td><s:textfield name="UserName"></s:textfield></td>
    			<td><font color="red" align="left"><h6>*必填</h6></font></td>
    		</tr>
    		<tr>
    			<td align="right">密码：</td>
    			<td><s:password name="UserPwd"></s:password></td>
    			<td><font color="red" align="left"><h6>*必填</h6></font></td>
    		</tr>
    		<tr>
    			<td align="right">重复密码：</td>
    			<td><s:password name="ReUserPwd"></s:password></td>
    			<td><font color="red" align="left"><h6>*必填</h6></font></td>
    		</tr>
    		<tr>
    			<td align="right">性别：</td>
    			<td>
    				<input type="radio" name="UserSex" checked />男
    				<input type="radio" name="UserSex" />女
    			</td>
    		</tr>
    		<tr>
    			<td align="right">邮箱：</td>
    			<td><s:textfield name="UserEmail"></s:textfield></td>
    			<td><font color="red" align="left"><h6>*必填</h6></font></td>
    		</tr>
    		<tr>
    			<td align="right">验证码：</td>
    			<td><s:textfield name="validate"></s:textfield></td>
    			<td>
    				<img src="imageAction" align="left" alt="点击图片" onClick="update(this)" /><br>
    			</td>
    		</tr>
    		<tr>
    			<td></td>
    			<td>
    				<s:submit value="提交"></s:submit>
    				<s:reset value="重置"></s:reset>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
