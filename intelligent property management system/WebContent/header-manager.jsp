<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>智能社区管理系统｜SB团队</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="https://abs.twimg.com/favicons/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="./css/style.css" type="text/css" media="all"> 
	<script type="text/javascript" src="./js/jquery-1.11.1.min.js" charset="utf-8""></script>
	<script type="text/javascript" src="./js/vankesb.js" charset="utf-8""></script>
	<link rel="stylesheet" type="text/css" href="./js/slick/slick.css"/>
	<script type="text/javascript" src="./js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="./js/slick/slick.min.js"></script>
</head>


<body>
	<div id="wrap-all">

		
		
		<div class="home-page topbar">
			<div class="global-nav">
				<div class="global-nav-inner container">
			
					<h3 class="sb-logo-top"><span><!-- ㍿ --></span></h3>
					<div class="navigation-menu pull-left">
						<ul class="nav global-action" id="global-actions">
							<li id="global-nav-home" class="home active new">
								<a class="manager-home-a js-tooltip-home" href="manager_index.jsp">
								<span class="icon icon-home">㍿</span>
								<span class="text">我的首页</span>
								</a>
							</li>
							<li id="global-nav-home" class="home new">
								<a class="manager-usermanagement-a home-users-management js-tooltip-home" href="/">
								<span class="icon icon-home">㍿</span>
								<span class="text">用户管理</span>
								</a>
							</li>
							<li id="global-nav-profile" class="profile">
								<a class="manager-fee-a profile-a js-tooltip-profile" href="http://NeXT17.ME">
								<span class="icon icon-profile">♞</span>
								<span class="text">费用管理</span>
								</a>
							</li>
							<li id="global-nav-profile" class="profile">
								<a class="manager-pp-a profile-a js-tooltip-profile" href="http://NeXT17.ME">
								<span class="icon icon-profile">☁</span>
								<span class="text">车位管理</span>
								</a>
							</li>
							<li id="global-nav-profile" class="profile">
								<a class="manager-profile-a profile-a js-tooltip-profile" href="http://NeXT17.ME">
								<span class="icon icon-profile">☁</span>
								<span class="text">我的信息</span>
								</a>
							</li>
				
						</ul>
					</div>
					<div class="nav-right pull-right nav">
						<div class="search">
							<form>
								
							</form>
						</div>
						<div class="profile-logo">
							<ul class="nav right-actions">
							<li class="topbar-help">
								<div style="padding-top: 14px;padding-right: 14px;">
										<span class="text" style="font-size: 15px;font-weight: bold;font-style: italic;">Designed by SB</span>
								</div>
								</li>
								<li class="me dropdown user-session" id="user-dropdown">
									<a href="#" class="btn dropdown-toggle">
										<img class="avatar size32" src="./images/sb-avatar.png" alt="profile and Settings" data-user-id="xianyuxmu"/>
									</a>
								</li>
								<li class="topbar-help">
									<button id="global-help-btn" class="global-help-btn" type="button" onclick="exit()">
										<span class="text">EXIT</span>
									</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			
			</div><!-- end global-nav-->
			
			<div class="sub-menus-pool" >
				<div id="sub-menu-1" class="sub-menu" style="left: 277px; width: 170px; background: #000; background: rgba(0, 0, 0, 0.53);">
					<div class="submenu-title">
						<h3>
							<a href="http://next17.me" target="_blank" >用户管理</a>
						</h3>
                    
               		</div>
               		<dl class="first" style="width: 160px; height: 165px;">
                        	
                                <dt></dt>
                           
                            	<dd>
                                    <a href="addUser.jsp">添加用户</a>
                                </dd>
                            	<dd>
                                    <a href="usermodify.jsp">修改用户</a>
                                </dd>
                                                         
                                <dd>
                                    <a href="#">删除用户</a>
                                </dd>
                                <dd>
                                    <a href="scanAll!getUsers.action">查看所有用户</a>
                                </dd>
                                
                            
                        
                    </dl>
				</div>
				<div id="sub-menu-2" class="sub-menu" style="left: 393px; width: 240px;background: rgba(0, 0, 0, 0.529412);">
					<div class="submenu-title">
	                    <h3>
	                        <a href="http://next17.me" target="_blank" >费用管理</a>
	                    </h3>
	                    
                	</div>
                	<dl class="first" style="width: 160px; height: 165px;">
                        	
                                <dt></dt>
                           
                                <dd>
                                    <a href="m_water_fee_enter.jsp">水费录入</a>
                                </dd>
                            	<dd>
                                    <a href="m_electricity_fee_enter.jsp">电费录入</a>
                                </dd>
                            	<dd>
                                    <a href="usermodify.jsp">收费管理</a>
                                </dd>
                               
                                <dd>
                                    <a href="scanAll!getUsers.action">费用标准</a>
                                </dd>
                                
                        
                    </dl>
                	
				</div>
				<div id="sub-menu-3" class="sub-menu" style="left: 510px; width: 240px;background: rgba(0, 0, 0, 0.529412);">
					<div class="submenu-title">
	                    <h3>
	                        <a href="parking!getAllParkings.action" target="_blank" >车位管理</a>
	                    </h3>
	                    
              	    </div>
              	                  	<dl class="first" style="width: 160px; height: 165px;">
                        	
                                <dt></dt>
                           		<dd>
                                    <a href="m_find_owner.jsp">查询业主</a>
                                </dd>
                                <dd>
                                    <a href="parking!getAllRentParkings.action">租用管理</a>
                                </dd>
                            	<dd>
                                    <a href="addUser.jsp">临时车位管理</a>
                                </dd>
                            	                      
                    </dl>
  
				</div>
				
				<div id="sub-menu-4" class="sub-menu" style="left: 625px; width: 240px;background: rgba(0, 0, 0, 0.529412);">
					<div class="submenu-title">
	                    <h3>
	                        <a href="http://next17.me" target="_blank" >我的信息</a>
	                    </h3>
	                    
              	    </div>
              	    <dl class="first" style="width: 160px; height: 165px;">
                        	
                                <dt></dt>
                           
                                <dd>
                                    <a href="scan">查看个人信息</a>
                                </dd>
                            	
                                <dd>
                                    <a href="modify">修改个人信息</a>
                                </dd>
                            	
                        
                    </dl>
				</div>
				<script type="text/javascript">
					function exit(){
						window.location.href="exit.action";
					}
				</script>
			</div><!-- end sub-menus-pool-->