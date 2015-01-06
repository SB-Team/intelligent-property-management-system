<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-manager.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
<!-- 内容添加在中间  top-->
<h5 class="header-h5">查询业主</h5>

<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">

<s:form action="parking!managercheckOwner.action" method="post">
	
<s:textfield name="checkownername" label="请输入业主姓名"/>
<s:textfield name="checkownerphone" label="请输入电话号码"/>
<s:submit value="提交" />
</s:form>
</div>

<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>