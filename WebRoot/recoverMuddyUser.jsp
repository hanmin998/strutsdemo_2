<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'findRecoverUser.jsp' starting page</title>
  </head>
  <body>
    	 <a href="findAllUser">返回首页</a><br><br>
    	 <center>
	 <table cellspacing="2" cellpadding="2" border="2" bordercolor="#c0c0c0">
	 <tr>
	 		<td align="center">编号</td>
	 		<td align="center">姓名</td>
	 		<td align="right">生日</td>
	 		<td align="center">性别</td>
	 		<td align="center">邮箱</td>
	 		<td align="center">联系方式</td>
	 		<td align="center">属于</td>
	 		<td align="center">彻底删除</td>
	 	</tr>
	    <s:iterator value="userList" id="id">
	 	
		<tr>
	 		<td><s:property value="#id.id"/></td>
	 		<td><s:property value="#id.name"/></td>
	 		<td><s:property value="#id.birthday"/></td>
	 		<td><s:property value="#id.sex" /></td>
	 		<td><s:property value="#id.email" /></td>
	 		<td><s:property value="#id.phone" /></td>
	 		<td><s:property value="#id.userId" /></td>
      		<td>
      			<s:url id="url" action="deleteRecover">
      				<s:param name="id"><s:property value="#id.id" /></s:param>
      			</s:url>
      			<s:a href="%{url}">彻底删除</s:a>
      		</td>
      		<td>
      		<s:url id="url" action="userRecover">
								<s:param name="id">
									<s:property value="#id.id" />
								</s:param>
							</s:url>
							<s:a href="%{url}">恢复</s:a>
			</td>
		</tr>
		</s:iterator>
	 </table>
	 </center>
	<s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>
   </body>
</html>
