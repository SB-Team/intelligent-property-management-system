<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>超智能物业系统｜SB团队</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="shortcut icon" href="http://lecture.xmu.edu.cn/wp-content/themes/lectureinfo/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="./css/style.css" type="text/css" media="all"> 
</head>


<body>
	<div id="wrap-all">

		<header id="header">
			
				<div class="header-box">
				<h3>☀  ／  MON  ／  12月15日  </h3>
				</div>
		</header>
		<form action="login" method="post">
		<div id="main">
		
			<div class="login-box">
				<img src="./images/sb-logo.png" class="sb-logo"/>
				<h2>欢迎，请登录</h2>
				<div class="login-account">
					<div class="input-padding">
					
					<input type="text" name="user.username">
					</div>
					<div class="field-underline"></div>
				</div>
				<div class="login-account">
					<div class="input-padding">
					<input type="password" name="user.password">
					</div>
					<div class="field-underline"></div>
				</div>
				
				<div class="login-button">
					<button type="submit">登录</button>
				</div>
				<s:fielderror/>
			</div>
				
			
			
		</div>
		</form>
	</div>
	
</body>
</html>