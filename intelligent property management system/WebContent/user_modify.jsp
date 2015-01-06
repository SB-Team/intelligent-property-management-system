<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@include file="header-owner.jsp" %>

	<!-- start  -->
		
			<div id="page-outer">
				<div id="page-container" class="page-wrapper">
					<!-- start yao -->
						<h5 class="header-h5">用户信息更改</h5>
<div class="user-info">

<div style="width: 360px;margin: 0 auto;">
<s:form action="modifyuser" method="post">
			<s:hidden name="user.id" value="%{#session.user.id}"/>
			<s:hidden name="user.roleId" value="%{#session.user.roleId}"/>
			<s:textfield name="user.username" label="账号" value="%{#session.user.username}" />
			<s:textfield name="user.password" label="密码" value="%{#session.user.password}" />		
			<s:textfield name="user.name" label="姓名" value="%{#session.user.name}" />	
			<s:textfield name="user.sex" label="性别" value="%{#session.user.sex}" />			
			<s:textfield name="user.age" label="年龄" value="%{#session.user.age}" />
			<s:textfield name="user.phone" label="联系电话" value="%{#session.user.phone}"/>
			<s:textfield name="user.email" label="邮箱地址" value="%{#session.user.email}"/>
			<s:submit value="修改" />
	</s:form>
</div>
</div>
<!-- end yao -->
					
										
					
				</div>
			
			</div><!-- end page-outer-->
	
	<!-- end  -->
<%@include file="footer.jsp" %>