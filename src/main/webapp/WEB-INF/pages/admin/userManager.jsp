<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
           + request.getServerName() + ":" + request.getServerPort()
           + path + "/";
%>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>会员管理</title>
    <link rel="stylesheet"  href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/index.css" />
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/userSetting.js"></script>
</head>

<body>
    <div class="panel panel-default" id="userInfo" id="homeSet">
        <div class="panel-heading">
            <h3 class="panel-title">会员管理</h3>
        </div>
        <div class="panel-body">
            <div class="showusersearch">
                <form class="form-inline" method="post" action="<%=basePath%>userManager/search">
                  <div class="form-group">
                  	&nbsp;&nbsp;
                    <label for="customer_loginName">帐号:</label>
                    &nbsp;&nbsp;
                    <input type="text" class="form-control" id="customer_loginName" name="username" placeholder="请输入帐号" size="15px">
                  </div>
                  &nbsp;&nbsp;<!-- id="doSearch" -->
                  <input type="submit" value="查询" class="btn btn-primary" >
                </form>
            </div>
            
            <div class="show-list" style="position: relative;top: 30px;">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                            <th class="text-center">序号</th>
                            <th class="text-center">ID</th>
                            <th class="text-center">帐号</th>
                            <th class="text-center">密码</th>
                            <th class="text-center">积分</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    	<c:forEach items="${users}" var="user" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.money}</td>
                            <td class="text-center">
                                <input type="button" class="btn btn-warning btn-sm doModify" value="修改" onclick="document.getElementById('id').value = ${user.id}"/>
                                <a href="<%=basePath%>userManager/delete?id=${user.id}">
			                    	<button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认删除？');">
			                        	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除
			                    	</button>
			                    </a>
                            </td>
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- 修改客户信息 start -->
    <div class="modal fade" tabindex="-1" id="myModal">
        <!-- 窗口声明 -->
        <div class="modal-dialog">
            <!-- 内容声明 -->
            <form action="<%=basePath%>userManager/update" method="post" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改会员</h4>
                </div>
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="id" class="col-sm-4 control-label">ID：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="id" id="id" value="" readonly="readonly">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="loginName" class="col-sm-4 control-label">帐号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="username" id="username" value="">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="phone" class="col-sm-4 control-label">密码：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="password" id="password" value="">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="adrees" class="col-sm-4 control-label">积分：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="money" id="money" value="">
                        </div>
                    </div>
                    <br>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary updateOne">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <!-- 修改客户信息 end -->

</body>

</html>