<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-owner.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
	<h5 class="header-h5">用户车位信息</h5>
	<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">



<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="10%">序号</td>
		<td width="10%">类型</td>
		<td width="10%">位置</td>
		<td width="10%">车牌号</td>
		<td width="10%">所属小区</td>
		<td width="10%">业主</td>
		<td width="10%">地址</td>
	</tr>
	<s:iterator value="#session.myParkings" >
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="ptype"/></td>
		<td><s:property value="pposition"/></td>
		<td><s:property value="pcarnum"/></td>
		<td><s:property value="pphename"/></td>
		<td><s:property value="user.name"/></td>
		<td><s:property value="user.address"/></td>
		
	</tr>
	</s:iterator>
	</table>
</div>

<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>