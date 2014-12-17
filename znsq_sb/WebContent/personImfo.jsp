<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@include file="header.jsp" %>
			
			<div id="page-outer">
				<div id="page-container" class="page-wrapper">
					<!-- start yao -->
<div class="user-info">

<div style="width: 360px;margin: 0 auto;">
	<ul>
		<li>账号：<s:property value="user.username"/></li>
<li>密码：<s:property value="user.password"/></li>
<li>姓名：<s:property value="user.name"/></li>
<li>性别：<s:property value="user.sex"/></li>
<li>年龄：<s:property value="user.age"/></li>
<li>电话：<s:property value="user.phone"/></li>
<li>邮箱：<s:property value="user.email"/></li>


</ul>

<!-- 
<a href="usermodify.jsp">修改个人信息</a>
<a href="scanAll!getUsers.action">查看所有用户</a>
 -->
</div>
</div>
<!-- end yao -->
					
										
					
				</div>
			
			</div><!-- end page-outer-->


</div>

	</div>

</body>
</html>