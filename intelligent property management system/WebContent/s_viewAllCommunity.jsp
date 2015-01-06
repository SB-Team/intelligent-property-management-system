<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-super.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
<!-- 内容添加在中间  top-->
<h5 class="header-h5">查看所有小区</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">
	<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="5%">序号</td>
		<td width="10%">小区名字</td>
		<td width="5%">所在地区</td>
		<td width="10%">操作</td>
	</tr>
	<s:iterator value="#session.allCommunities" status="n">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="area"/></td>
		<td>	
			<a href="community!viewAllBuildings.action?gid=${n.index}">添加楼</a>
			<a href="community!deleteCommunity.action?gid=${n.index}">删除</a>
		</td>
	</tr>
	</s:iterator>
	</table>
</div>
<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>