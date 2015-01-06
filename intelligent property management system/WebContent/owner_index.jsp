<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@include file="header-owner.jsp" %>
			
			<div id="page-outer">
				<div id="page-container" class="page-wrapper">
					<div class="dashboard dashboard-left">
						<div class="DashboardProfileCard  module">
							<a class="DashboardProfileCard-bg u-block" href=""></a>
							
							<div class="DashboardProfileCard-content">
								<a class="DashboardProfileCard-avatarLink u-inlineBlock" href="" title="MAC CHEN.">
									<img class="DashboardProfileCard-avatarImage" src="./images/sb-avatar.png"/>
								</a>
								
								<div class="DashboardProfileCard-userFields">
									<h5>欢迎你，<s:property value="user.name" /></h5>
								
								</div>
								
								<div class="dashboard-content">
									<h5>☀  ／  MON  ／  2015年1月7日  </h5>
								</div>
							</div>
						</div>
						
						<div class="module bills" style="display: block;">
							<div class="bills-inner">
								<div class="flex-module trends-container">
									
									<div class="flex-module-header">
    
									      <h3><span class="bill-location">您的费用</span></h3>
										  <span class="middot">·</span> 
										  <a href="#"class="detail-bills">详细账单</a>
  									</div>
									
									<div class="flex-module-inner">
											<ul class="bill-items js-bills">
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年8月费用:230.0元</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年9月费用:220.0元</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年10月费用:233.0元</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年11月费用:190.0元</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年12月费用:320.4元</a>
												  </li>

												  
											</ul>
									</div><!-- end  flex-module-inner -->
									
								</div><!-- end flex-moudle  -->
							</div>
							
							
						</div>
					</div><!-- end dashboard-left -->
					
					<div class="content-main" id="sb-timeline">
						
						
						
						<div class="sb-image-slider" style="color: #66757f; height:190px; width: 500px;">
							
							<div>
							<a href="http://next17.me">
								<img src="./images/s1.jpg" height="190" width="500"/>	
							</a>
							</div>
							<div>
							<a href="http://next17.me">
								<img src="./images/s2.jpg" height="190" width="500"/>	
							</a>
							</div>
							<div>
							<a href="http://next17.me">
								<img src="./images/s3.jpg" height="190" width="500"/>	
							</a>
							</div>
							
						</div><!-- end sb-image-slider  -->
						
						<div class="community-news-board module">
							
							
							<div class="flex-module trends-container">
									
									<div class="flex-module-header">
    
									      <h3><span class="bill-location">社区新闻</span></h3>
										  <span class="middot">·</span> 
										  <a role="button" href="#" class="detail-bills">更多</a>
  									</div>
									
									<div class="flex-module-inner">
											<ul class="bill-items js-bills">
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年9月11日SB小组第一次会议圆满成功－草拟Scrum计划</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年10月9日SB小组第二次会议圆满成功－开始下一阶段Back-Log</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年11月20日SB小组第七次会议圆满成功-团队分享会成功召开</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2014年12月25日SB小组第十次会议圆满成功-圣诞Scrum大战开始</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">2015年1月1日SB小组一起跨年成功-Happy New Year</a>
												  </li>
												 

												  
											</ul>
									</div><!-- end  flex-module-inner -->
									
								</div>
						
						</div><!-- end community-news-board  -->
						
					</div><!-- end content-main -->
					
					<div class="dashboard dashboard-right">
					
						<div class="Notifications-center module">
							
							
							<div class="flex-module trends-container">
									
									<div class="flex-module-header">
    
									      <h3><span class="bill-location">通知中心</span></h3>
										  <span class="middot">·</span> 
										  <a role="button" href="#" class="detail-bills">更多</a>
  									</div>
									
									<div class="flex-module-inner">
											<ul class="bill-items js-bills">
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">您有待缴电费！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">请更改您的用户信息！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">社区福利申请！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">您的上月电费滞纳金需要您去处理！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">物业管理员发来消息！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">您的车位快到期，请您续费！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">校区举办跨年舞会！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">有访客给您留言！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">本月小区物业报告已出来！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">圣诞联欢晚会精彩回顾！</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">五缘湾小区邀您一起过圣诞啦！</a>
												  </li>

												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">您11月电费已经开始缴费，请留意！</a>
												  </li>

												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">台风“阿穆特”来袭，小区紧急预案！</a>
												  </li>

												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">物业10月报告已经发送到您的邮箱！</a>
												  </li>

												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">五缘湾采用SB团队的“智能物业系统”啦！</a>
												  </li>

												  
											</ul>
									</div><!-- end  flex-module-inner -->
									
								</div>
						
							
						</div><!-- end Notifications-center  -->
						
					</div><!-- end dashboard-right -->
					
				</div>
			<script type="text/javascript">
	function exit(){
		window.location.href="exit.action";
	}
</script>
			</div><!-- end page-outer-->
		

<%@include file="footer.jsp" %>