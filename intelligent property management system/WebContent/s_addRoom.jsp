<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-super.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
<!-- 内容添加在中间  top-->
<h5 class="header-h5">新增房</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">

<s:form action="community!addRoom.action" method="post">
<s:textfield name="newRoom.roomnum" label="房号"/>
<s:textfield name="newRoom.roomarea" label="面积"/>
<s:submit value="提交" />
</s:form>
	<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="5%">序号</td>
		<td width="10%">房号</td>
		<td width="10%">面积</td>
	</tr>
	<s:iterator value="#session.allMyRooms" status="n">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="roomnum"/></td>
		<td><s:property value="roomarea"/></td>
	</tr>
	</s:iterator>
	</table>
</div>
<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>