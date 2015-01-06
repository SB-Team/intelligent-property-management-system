<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-manager.jsp" %>
<div id="page-outer">
<!-- 内容添加在中间  top-->


<div id="page-container" class="page-wrapper">
					<!-- start yao -->
					<h5 class="header-h5">临时停车账单</h5>
<div class="user-info">

<div style="width: 360px;margin: 0 auto;">
	<ul>
		<li>车牌号：<s:property value="carnum"/></li>
		<li>开始时间：<s:property value="begintime"/></li>
		<li>结束时间：<s:property value="endtime"/></li>
		<li>时长：<s:property value="hour"/>小时</li>
		<li>收费：<s:property value="bill"/>元</li>
		
		
</ul>
</div>

<div style="width: 360px;margin: 0 auto;">
<s:form action="parking!getAllTempParkings.action" method="post">
<s:submit value="确定" />
</s:form>
</div> 
</div>


<!-- 内容添加在中间  end-->
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>