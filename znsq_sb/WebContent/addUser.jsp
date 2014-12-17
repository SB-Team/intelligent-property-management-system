<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<%@include file="header.jsp" %>
	
	<!-- start  -->
		
			<div id="page-outer">
				<div id="page-container" class="page-wrapper">
					<!-- start yao -->
<div class="user-info">

<div style="width: 456px;margin: 0 auto;">

    <s:form action="scanAll" method="post">
    <s:hidden name="newUser.id" value="8"/>
    <s:hidden name="newUser.roleId" value="1"/>
    	<s:textfield name="newUser.username" label="账号" size="16"/>
    	<s:textfield name="newUser.password" label="密码" size="12"/>
    	<s:textfield name="newUser.name" label="姓名" size="20"/>
    	<s:radio list="#{'1':'男','2':'女'}" label="性别" value="'男'" name="newUser.sex"/>
    	<s:textfield name="newUser.age" label="年龄" size="5"/>
    	<s:textfield name="newUser.phone" label="电话" size="20"/>
    	<s:textfield name="newUser.email" label="邮箱" size="30"/>
    	
   		<s:submit value="用户添加" style="display: inherit;"/>
    </s:form>
</div>
</div>
<!-- end yao -->
					
										
					
				</div>
			
			</div><!-- end page-outer-->
	
	<!-- end  -->
   </div>
   </div>
    	
</body>
</html>