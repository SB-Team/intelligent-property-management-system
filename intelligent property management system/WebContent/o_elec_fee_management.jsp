<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header-owner.jsp" %>
<div id="page-outer">
<!-- 内容添加在中间  top-->
<div id="page-container" class="page-wrapper">
<h5 class="header-h5">本期电费账单</h5>
<div class="user-info" style="padding-left: 10px; padding-right: 10px;margin: 0 auto;">

<div style="width: 1000px;margin: 0 auto;">
<div>
	房号:<s:property value="user.room.roomid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户名称:<s:property value="user.name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     建筑面积:<s:property value="user.room.roomarea"/>
</div>
<table class="all-users">
	<tr class="first-row" align="center"  height="22">
		<td width="10%">项目名称</td>
		<td width="10%">时间周期</td>
		<td width="10%">上月读数</td>
		<td width="10%">本月读数</td>
		<td width="10%">本月用量</td>
		<td width="10%">金额</td>
	</tr>
	<tr>
		<td>房间电费</td>
		<td><s:property value="ownerViewThisElecBill.roomElecDegree.lastEnteringTime"/>~<s:property value="ownerViewThisElecBill.roomElecDegree.thisEnteringTime"/></td>
		<td><s:property value="ownerViewThisElecBill.roomElecDegree.lastEnteringDegree"/></td>
		<td><s:property value="ownerViewThisElecBill.roomElecDegree.thisEnteringDegree"/></td>
		<td><s:property value="ownerViewThisElecBill.roomElecDegree.degree"/></td>
		<td><s:property value="ownerViewThisElecBill.roomPayment"/>元</td>
	</tr>
	<tr class="first-row" align="center"  height="22">
		<td width="10%">项目名称</td>
		<td width="10%">时间周期</td>
		<td width="10%">金额</td>
	</tr>
	<tr>
		<td>公摊小区水费</td>
		<td><s:property value="ownerCommunityElecDegree.lastEnteringTime"/>~<s:property value="ownerCommunityElecDegree.thisEnteringTime"/></td>
		<td><s:property value="ownerViewThisElecBill.communityPayment"/>元</td>
	</tr>
	<tr>
		<td>公摊楼水费</td>
		<td><s:property value="ownerBuildingElecDegree.lastEnteringTime"/>~<s:property value="ownerBuildingElecDegree.thisEnteringTime"/></td>
		<td><s:property value="ownerViewThisElecBill.buildingPayment"/>元</td>
	</tr>
	<tr>
		<td>公摊层水费</td>
		<td><s:property value="ownerFloorElecDegree.lastEnteringTime"/>~<s:property value="ownerFloorElecDegree.thisEnteringTime"/></td>
		<td><s:property value="ownerViewThisElecBill.floorPayment"/>元</td>
	</tr>
	<tr class="first-row" align="center"  height="22">
		<td width="10%">本月费用合计</td>
		<td width="10%">欠费合计</td>
		<td width="10%">应收费用总合计</td>
		<td width="10%">是否付费</td>
		
	</tr>
	<tr>
		<td><s:property value="ownerViewThisElecBill.total"/>元</td>
		<td><s:property value="ownerDebt.elecDebt"/>元</td>
		<td><s:property value="elecTotalWithDebt"/>元</td>
		<td><s:if  test='%{ownerViewThisElecBill.isPay!=0}'>已付费</s:if>
			<s:else>未付费</s:else>
		</td>
		
	</tr>
	<!--  <ul>
	<li>水费</li>
		<li>时间周期:(房间电表)<s:property value="ownerViewThisWaterBill.roomDegree.lastEnteringTime"/>~<s:property value="ownerViewThisWaterBill.roomDegree.thisEnteringTime"/></li>
		<li>上期度数:<s:property value="ownerViewThisWaterBill.roomDegree.lastEnteringDegree"/></li>
		<li>本期度数:<s:property value="ownerViewThisWaterBill.roomDegree.thisEnteringDegree"/></li>
		<li>本期用量:<s:property value="ownerViewThisWaterBill.roomDegree.degree"/></li>
		<li>房间水费:<s:property value="ownerViewThisWaterBill.roomPayment"/></li>
		<li>层分摊水费:<s:property value="ownerViewThisWaterBill.floorPayment"/></li>
		<li>楼分摊水费：<s:property value="ownerViewThisWaterBill.buildingPayment"/></li>
		<li>时间周期:(小区总电表)<s:property value="ownerCommunityWaterDegree.lastEnteringTime"/>~<s:property value="ownerCommunityWaterDegree.thisEnteringTime"/></li>
		<li>小区分摊水费：<s:property value="ownerViewThisWaterBill.communityPayment"/></li>
		<li>水费总价：<s:property value="ownerViewThisWaterBill.total"/>
		<li>是否付费：<s:property value="ownerViewThisWaterBill.isPay"/>
	</ul>-->
	</table>
	<div style="padding-top: 100px; padding-left: 400px; padding-right: 400px; margin: 0 auto;">
	<s:if test='%{ownerViewThisElecBill.isPay==0}'>
	<s:form action="o_elec_makepayment.jsp" method="post">
		<s:submit value="支付" />
	</s:form>
	</s:if>
	</div>
</div>
</div>
<!-- 内容添加在中间  end-->
</div>
</div><!-- end page-outer-->
<%@include file="footer.jsp" %>