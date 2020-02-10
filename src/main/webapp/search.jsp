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
<meta charset="UTF-8">
<title>垃圾分类查询</title>
<script type="text/javascript" src="<%=basePath %>/js/jquery.min.js"></script>

</head>
<body>
<h3>垃圾识别</h3>

	<input type="text" id="kw" name="kw" />
	<input type="button" id="submit" value="查询">
	<br/>
	<div>
		垃圾名称：<b id="name" style="color: red"></b><br/>
		类型：<b id="category"  style="color: red"></b><br/>
		备注：<b id="remark"  style="color: red"></b><br/>
	</div>
	
	<hr/>
	<input type="file" name="filename">

<script>
	$(document).ready(function(){
	  $("#submit").click(function(){
		  $.ajax({
	            //请求方式
	            type : "GET",
	            //请求的媒体类型
	            contentType: "application/json;charset=UTF-8",
	            //请求地址
	            url : "distinguish/search?kw="+$("#kw").val(),
	            //数据，json字符串
	            //data : JSON.stringify(list),
	            //请求成功
	            success : function(data) {
	                //console.log(data);
	                $("#name").html(data.name);
	                $("#category").html(data.category);
	                $("#remark").html(data.remark);
	            },
	            //请求失败，包含具体的错误信息
	            error : function(e){
	            	alert("请求失败！");
	                console.log(e.status);
	                console.log(e.responseText);
	            }
	        });
	  });
	});
</script>
</body>
</html>