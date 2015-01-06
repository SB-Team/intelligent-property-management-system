<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-guard.jsp" %>
<div id="page-outer">
<!-- 内容添加在中间  top-->
<div id="page-container" class="page-wrapper">
<h5 class="header-h5">存在该业主！</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">


<div style="width: 360px;margin: 0 auto;">
	<ul>
		<li>业主id：<s:property value="checkOwner.id"/></li>
		<li>业主姓名：<s:property value="checkOwner.name"/></li>
		<li>业主电话：<s:property value="checkOwner.phone"/></li>
</ul>
</div>
</div>

<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>