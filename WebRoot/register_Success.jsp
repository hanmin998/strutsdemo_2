<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'register_Success.jsp' starting page</title>
	<script language='javascript' type='text/javascript'>
		var secs=5; //倒计时的秒数
		var URL;
		function Load(url){
			URL=url;
			for(var i=secs;i>=0;i--){
				window.setTimeout('doUpdate('+i+')',(secs-i)*1000);
			}
		}
		function doUpdate(num){
			document.getElementById('ShowDiv').innerHTML='将在'+num+'秒后自动跳转到登陆页面';
			if(num==0){
				window.location=URL;
			}
		}
	</script>
  </head>
  
  <body>
    <center>
    	<h1>
    		<font color="red" align="center">恭喜您，注册成功！！</font>
    	</h1><br>
    	<div id="ShowDiv"></div>
    	<script language="javascript">
    		Load("http://localhost:8080/strutsdemo_2/index.jsp");
    	</script>
    	<s:a href="http://localhost:8080/strutsdemo_2/index.jsp">
    		<font color="blue"><h5>手动登陆</h5></font>
    	</s:a>
    </center>
  </body>
</html>
