<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
           + request.getServerName() + ":" + request.getServerPort()
           + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>垃圾回收-后台管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/mycss.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
  </head>
  <body>
  	<!-- 使用自定义css样式 div-signin 完成元素居中-->
    <div class="container div-signin">
      <div class="panel panel-primary div-shadow">
      	<!-- h3标签加载自定义样式，完成文字居中和上下间距调整 -->
	    <div class="panel-heading">
	    	<h3>垃圾回收系统 1.0</h3>
	    	<span>ZSHOP Manager System</span>
	    </div>
	    <div class="panel-body">
	      <!-- login form start -->
	      <form action="<%=basePath%>admin/login" class="form-horizontal" method="post">
		     <div class="form-group">
		       <label class="col-sm-3 control-label">用户名：</label>
		       <div class="col-sm-9">
		         <input class="form-control" type="text" placeholder="请输入用户名" name="username">
		       </div>
		    </div>
		     <div class="form-group">
		       <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
		       <div class="col-sm-9">
		         <input class="form-control" type="password" placeholder="请输入密码" name="password">
		       </div>
		    </div>
		    <div class="form-group">
		       <div class="col-sm-3">
		       </div>
		       <div class="col-sm-9 padding-left-0">
		       	 <div class="col-sm-4">
			         <button type="submit" class="btn btn-primary btn-block">登&nbsp;&nbsp;陆</button>
		       	 </div>
		       	 <div class="col-sm-4">
			         <button type="reset" class="btn btn-primary btn-block">重&nbsp;&nbsp;置</button>
		       	 </div>
		       </div>
		    </div>
	      </form>
	      <!-- login form end -->
	    </div>
	  </div>
    </div>
    <!-- 页尾 版权声明 -->
    <div class="container">
		<div class="col-sm-12 foot-css">
		        <p class="text-muted credit">
		            Copyright 南京网博 版权所有
		        </p>
	    </div>
    </div>
  
  </body>
</html>
