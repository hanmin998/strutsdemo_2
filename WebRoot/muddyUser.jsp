<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'muddyUser.jsp' starting page</title>
	</head>
	<body>
		<h4 align="right">
			<font color="blue">欢迎您，<s:property
					value="#session.useUser.UserName"></s:property>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">注销</a>
			</font>
		</h4>
<a href="findAllUser">返回首页</a>

		<center>
			<h2>
				符合条件的用户名片：
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
		</center>
		<s:reset onclick="history.go(-1)" value="返回上一页"></s:reset>
	</body>
</html>
