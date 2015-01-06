<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-guard.jsp" %>
<div id="page-outer">
<!-- 内容添加在中间  top-->

<h5 class="header-h5">管理员修改车位信息</h5>
<div class="user-info">

<div style="width: 360px;margin: 0 auto;">
<s:form action="parking!updateRentParking.action" method="post">
			<s:hidden name="updateParking.id" type="int" value="%{#session.updateParking.id}"/>
			<s:textfield name="updateParking.pid" label="车位id" value="%{#session.updateParking.pid}" />
			<s:textfield name="updateParking.pposition" label="位置" value="%{#session.updateParking.pposition}" />	
			<s:textfield name="updateParking.ptype" label="类型" value="%{#session.updateParking.ptype}" />
				
			<s:textfield name="updateParking.pstatus" label="状态" value="%{#session.updateParking.pstatus}" />
			<s:textfield name="updateParking.pcarnum" label="车牌号" value="%{#session.updateParking.pcarnum}" />	
			<s:textfield name="updateParking.pphename" label="所属小区" value="%{#session.updateParking.pphename}" />			
			<s:textfield name="updateParking.user.id" label="对应user_id" type="int" value="%{#session.updateParking.user.id}" />
			<s:textfield name="updateParking.pbegintime" label="开始时间" value="%{#session.updateParking.pbegintime}" />
			<s:textfield name="updateParking.pendtime" label="结束时间" value="%{#session.updateParking.pendtime}" />
			<s:submit value="提交" />
	</s:form>
</div>
</div>


<!-- 内容添加在中间  end-->
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>