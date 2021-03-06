<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-manager.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
<!-- 内容添加在中间  top-->
<h5 class="header-h5">管理员租用车位管理</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">

<s:form action="parking!findRentParkings.action" method="post">
<s:submit value="找空闲可租用车位" />
</s:form>
<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="5%">序号</td>
		<td width="10%">类型</td>
		<td width="5%">位置</td>
		<td width="10%">状态</td>
		<td width="10%">车牌号</td>
		
		<td width="10%">业主</td>
		<td width="10%">电话</td>
		<td width="10%">地址</td>
		<td width="10%">开始时间</td>
		<td width="10%">结束时间</td>
		<td width="10%">操作</td>
	</tr>
	<s:iterator value="#session.MParkings" status="n">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="ptype"/></td>
		<td><s:property value="pposition"/></td>
		<td><s:property value="pstatus"/></td>
		<td><s:property value="pcarnum"/></td>
		
		<td><s:property value="user.name"/></td>
		<td><s:property value="user.phone"/></td>
		<td><s:property value="user.address"/></td>
		<td><s:property value="pbegintime"/></td>
		<td><s:property value="pendtime"/></td>
		<td>
		<s:if  test='%{pstatus!="空"}'></s:if>
		<s:else>	<a href="parking!clickRentParking.action?gid=${n.index}">租用</a></s:else>
			<a href="parking!releaseRentParking.action?gid=${n.index}">释放</a>
			<!-- <a href="parking!deleteParking.action?gid=${n.index}">删除</a> -->
			
		</td>
	</tr>
	</s:iterator>
	</table>
</div>



<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>