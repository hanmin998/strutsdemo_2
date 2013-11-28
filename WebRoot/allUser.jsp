<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'allUser.jsp' starting page</title>
	</head>
	<body>
		<h4 align="right">
			<font color="blue">欢迎您，
			<s:property value="#session.useUser.UserName"></s:property>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">注销</a>
			</font>
		</h4>

		<center>
			<h2>
				所有用户名片：
			</h2>
			<br>
			
			<br>
			<table cellspacing="2" cellpadding="2" border="2"
				bordercolor="#c0c0c0">
				<tr>
					<td align="center">
						编号
					</td>
					<td align="center">
						姓名
					</td>
					<td align="right">
						生日
					</td>
					<td align="center">
						性别
					</td>
					<td align="center">
						邮箱
					</td>
					<td align="center">
						联系方式
					</td>
					<td align="center">
						属于
					</td>
					<td align="center">
						修改
					</td>
					<td align="center">
						删除
					</td>
				</tr>
				<s:iterator value="userList" id="id">
					<tr>
						<td>
							<s:property value="#id.id" />
						</td>
						<td>
							<s:property value="#id.name" />
						</td>
						<td>
							<s:property value="#id.birthday" />
						</td>
						<td>
							<s:property value="#id.sex" />
						</td>
						<td>
							<s:property value="#id.email" />
						</td>
						<td>
							<s:property value="#id.phone" />
							<br>
						</td>
						<td>
							<s:property value="#id.userId" />
						</td>
						<td>
							<s:url id="url" action="modifyUser">
								<s:param name="id">
									<s:property value="#id.id" />
								</s:param>
							</s:url>
							<s:a href="%{url}">修改</s:a>
						</td>
						<td>
							<s:url id="url" action="deletePresent">
								<s:param name="id">
									<s:property value="#id.id" />
								</s:param>
							</s:url>
							<s:a href="%{url}">放入回收站</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
			<a href="selectRecover">查看回收站</a>
			<br>
			<br>
			<a href="addUser.jsp">添加名片</a>
		<s:form action="selectMuddy" method="post">
			<s:select name="selectType" label="模糊查询类型"
			list="#{'0':'编号','1':'姓名','2':'联系方式'}" listKey="key"
			listValue="value" headerKey="0"></s:select>		
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="condition"
				label="查询条件" />
				<s:submit name="select" value="查询"></s:submit>
		</s:form>
		</center>


	</body>
</html>
