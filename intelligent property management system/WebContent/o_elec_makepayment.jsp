<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-owner.jsp" %>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
	<h5 class="header-h5">支付宝支付页面</h5>
	<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">

	<div style="padding-top:50px; padding-left:500px;">
		<s:form action="elec!ownerMakeElecPayment.action" method="post">
			<s:submit value="确认支付" />
		</s:form>
	</div>
</div>

<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>