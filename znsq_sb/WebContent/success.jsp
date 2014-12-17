<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@include file="header.jsp" %>
			
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
									<h3>欢迎你，<b>Yao.</b><%-- <s:textfield name="user.username" value="%{#session.user.username}" disable="true" readonly="true"/> --%></h3>
								
								</div>
								
								<div class="dashboard-content">
									<h5>☀  ／  MON  ／  12月15日  </h5>
								</div>
							</div>
						</div>
						
						<div class="module bills" style="display: block;">
							<div class="bills-inner">
								<div class="flex-module trends-container">
									
									<div class="flex-module-header">
    
									      <h3><span class="bill-location">您的费用</span></h3>
										  <span class="middot">·</span> 
										  <a role="button" href="#"class="detail-bills">详细账单</a>
  									</div>
									
									<div class="flex-module-inner">
											<ul class="bill-items js-bills">
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
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
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
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
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>
												  <li class="bill-item js-bill-item" data-bill-name="#iHeartJingleBall">
														<a class="bill-name" href="/" data-query-source="bill_click">#iHeartJingleBall</a>
												  </li>

												  
											</ul>
									</div><!-- end  flex-module-inner -->
									
								</div>
						
							
						</div><!-- end Notifications-center  -->
						
					</div><!-- end dashboard-right -->
					
				</div>
			
			</div><!-- end page-outer-->
		</div>

	</div>

</body>
<script type="text/javascript">
	function exit(){
		window.location.href="exit.action";
	}
</script>
</html>