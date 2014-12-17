<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>


<%@include file="header.jsp" %>
			


	<!-- start  -->
		
			<div id="page-outer">
				<div id="page-container" class="page-wrapper">
					<!-- start yao -->
<div class="user-info">

<div style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">
<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="28%">账号</td>
		<td width="10%">密码</td>
		<td width="20%">姓名</td>
		<td width="6%">性别</td>
		<td width="8%">年龄</td>
		<td width="20%">电话</td>
		<td width="20%">邮箱</td>
	</tr>
	<s:iterator value="%{#session.userList}" var="user">
	<tr>
		<td><s:property value="#user.username"/></td>
		<td><s:property value="#user.password"/></td>
		<td><s:property value="#user.name"/></td>
		<td><s:property value="#user.sex"/></td>
		<td><s:property value="#user.age"/></td>
		<td><s:property value="#user.phone"/></td>
		<td><s:property value="#user.email"/></td>
	</tr>
	</s:iterator>
	</table>
</div>
</div>
<!-- end yao -->
					
										
					
				</div>
			
			</div><!-- end page-outer-->
	
	<!-- end  -->
	
	</body>
	</html>