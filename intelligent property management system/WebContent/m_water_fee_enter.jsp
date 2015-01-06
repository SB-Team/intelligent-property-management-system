<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-manager.jsp" %>

<sx:head/>
<div id="page-outer">
<div id="page-container" class="page-wrapper">
<!-- 内容添加在中间  top-->
<h5 class="header-h5">管理员水费录入</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">


<s:form action="water" method="post">
<s:textfield name="enteringWaterDegree.community.id" label="请输入小区号" type="int"/>

<s:textfield name="enteringWaterDegree.buildingNum" label="请输入楼号" type="int"/>	
<s:textfield name="enteringWaterDegree.floorNum" label="请输入层号" type="int"/>
<s:textfield name="enteringWaterDegree.roomNum" label="请输入房间号" type="int"/>	
<sx:datetimepicker name="enteringWaterDegree.thisEnteringTime" label="请输入本次抄表时间" displayFormat="yyyy-MM-dd"/>
<s:textfield name="enteringWaterDegree.thisEnteringDegree" label="请输入本次水表度数" type="int"/>
<s:submit value="提交" />
</s:form>
<div style="padding-top:70px; padding-left:500px;">
	<s:form action="water!createWaterBill.action" method="post">
	<s:submit value="生成账单" />
	
	</s:form>
</div>
<div style=" padding-left:500px;">
	<s:form action="water!createWaterDebt.action" method="post">
	<s:submit value="催缴账单" />
	</s:form>
</div>


</div>
<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->

<%@include file="footer.jsp" %>