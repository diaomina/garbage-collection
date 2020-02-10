<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>我的订单</title>
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet" href="<%=basePath%>css/style.css" />
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
</head>

<body>
    <div class="navbar navbar-default clear-bottom">
        <div class="container">
            
        <!-- navbar start -->
        <div class="navbar navbar-default clear-bottom">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand logo-style" href="http://edu.51cto.com/center/lec/info/index?user_id=12392007">
                        <img class="brand-img" src="<%=basePath%>images/com-logo1.png" alt="logo" height="70">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    	<li class="active">
                            <a href="<%=basePath%>distinguish/toDistinguish">垃圾识别</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>garbageOrder/toRetrieve">上门回收</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>garbageOrder/toGarbageOrder">回收订单</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>user/toMain">环保商城</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>order/toMyOrders">我的订单</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>cart/toCart">购物车</a>
                        </li>
                        <li class="dropdown">
                            <a href="<%=basePath%>user/toCenter">会员中心</a>
                        </li>
                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" data-toggle="modal" data-target="#loginModal">登陆</a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#registModal">注册</a>
                        </li>
                        <li class="userName">
                           <c:if test="${sessionScope.user!=null}">
                           		 您好：<span>${sessionScope.user.username}</span>&nbsp;！
                           </c:if>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle user-active" data-toggle="dropdown" role="button">
                                <img class="img-circle" src="<%=basePath%>images/user.jpeg" height="30" />
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#modifyPasswordModal">
                                        <i class="glyphicon glyphicon-cog"></i>修改密码
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=basePath%>user/logout">
                                        <i class="glyphicon glyphicon-off"></i> 退出
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- navbar end -->
        </div>
    </div>
    <!-- 待支付订单 start -->
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="page-header" style="margin-bottom: 0px;">
                    <h3>待支付订单</h3>
                </div>
            </div>
        </div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th class="text-center">序号</th>
                <th class="text-center">订单编号</th>
                <th class="text-center">商品总价</th>
                <th class="text-center">收货地址</th>
                <th class="text-center">下单时间</th>
                <th class="text-center">订单状态</th>
                <th class="text-center">操作</th>
            </tr>
            
            <c:forEach items="${orders1}" var="order" varStatus="status">
            <form action="<%=basePath%>order/pay" class="form-horizontal" method="post">
            <tr>
                <td class="text-center">${status.index+1}</td>
                <td class="text-center">${order.id}</td>
                <td class="text-center">${order.allprice}</td>
                <td class="text-center">
                   <div class="col-sm-8">
                       <select style="width:450px" class="form-control" name="addressId">
                       		<c:forEach items="${addresses}" var="address">
                       			<option value="${address.id}">
                       				${address.name}&nbsp;${address.phone}&nbsp;${address.address}
                       			</option>
                       		</c:forEach>
                       </select>
                   </div>
                </td>
                <td class="text-center">
                	<fmt:formatDate value="${order.starttime}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td class="text-center">待支付</td>
                <td class="text-center">
                	<input type="hidden" name="orderId" value="${order.id}">
                	<button type="submit" class="btn btn-warning"> 付款</button>
                	<!-- 
                	<a href="order/pay?orderId=${order.id}">
                        <button class="btn btn-warning " type="button"> 付款</button>
                    </a>
                     -->
                
                    <a href="<%=basePath%>order/delete?orderId=${order.id}">
                    <button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认删除');">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                    </button>
                    </a>
                </td>
            </tr>
            </form>
            </c:forEach>
        </table>
    </div>
    <!-- 待支付订单 end-->
    
    
    <!-- 待收货订单 start -->
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="page-header" style="margin-bottom: 0px;">
                    <h3>待收货订单</h3>
                </div>
            </div>
        </div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th class="text-center">序号</th>
                <th class="text-center">订单编号</th>
                <th class="text-center">商品总价</th>
                <th class="text-center">收货地址</th>
                <th class="text-center">下单时间</th>
                <th class="text-center">订单状态</th>
                <th class="text-center">操作</th>
            </tr>
            
            <c:forEach items="${orders2}" var="order" varStatus="status">
            <tr>
                <td class="text-center">${status.index+1}</td>
                <td class="text-center">${order.id}</td>
                <td class="text-center">${order.allprice}</td>
                <td class="text-center">
               		<c:forEach items="${addresses}" var="address">
               			<c:if test="${address.id == order.addressid}">
               				${address.name}&nbsp;${address.phone}&nbsp;${address.address}
               			</c:if>
               		</c:forEach>
                </td>
                <td class="text-center">
                	<fmt:formatDate value="${order.starttime}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td class="text-center">待收货 </td>
                <td class="text-center">
                	<a href="<%=basePath%>order/receive?orderId=${order.id}">
                        <button class="btn btn-warning " type="button"> 确认收货</button>
                    </a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 待收货订单 end-->
    
    
    <!-- 已完成订单 start -->
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="page-header" style="margin-bottom: 0px;">
                    <h3>已完成订单</h3>
                </div>
            </div>
        </div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th class="text-center">序号</th>
                <th class="text-center">订单编号</th>
                <th class="text-center">商品总价</th>
                <th class="text-center">收货地址</th>
                <th class="text-center">下单时间</th>
                <th class="text-center">收货时间</th>
                <th class="text-center">订单状态</th>
                <th class="text-center">操作</th>
            </tr>
            
            <c:forEach items="${orders3}" var="order" varStatus="status">
            <tr>
                <td class="text-center">${status.index+1}</td>
                <td class="text-center">${order.id}</td>
                <td class="text-center">${order.allprice}</td>
                <td class="text-center">
               		<c:forEach items="${addresses}" var="address">
               			<c:if test="${address.id == order.addressid}">
               				${address.name}&nbsp;${address.phone}&nbsp;${address.address}
               			</c:if>
               		</c:forEach>
                </td>
                <td class="text-center">
                	<fmt:formatDate value="${order.starttime}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td class="text-center">
                	<fmt:formatDate value="${order.endtime}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td class="text-center">已完成 </td>
                <td class="text-center">
                	<a href="<%=basePath%>order/delete?orderId=${order.id}">
                    	<button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认删除');">
                       		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                    	</button>
                    </a>
                 </td>
                
                
                
            </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 已完成订单 end-->
    
    
    
    
    <!-- footers start -->
    <div class="footers">
        版权所有：南京网博
    </div>
    <!-- footers end -->
     <!-- 修改密码模态框 start -->
    <div class="modal fade" id="modifyPasswordModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <form action="" class="form-horizontal" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">原密码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">新密码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">重复密码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-dismiss="modal" aria-label="Close">关&nbsp;&nbsp;闭</button>
                        <button type="reset" class="btn btn-warning">重&nbsp;&nbsp;置</button>
                        <button type="submit" class="btn btn-warning">修&nbsp;&nbsp;改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 修改密码模态框 end -->

    <!-- 登录模态框 start  -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <!-- 用户名密码登陆 start -->
            <div class="modal-content" id="login-account">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">用户名密码登录</h4>
                </div>
                <form action="<%=basePath%>user/login" class="form-horizontal" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户名：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" placeholder="请输入用户名" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password" placeholder="请输入密码" name="password">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-warning" data-dismiss="modal" aria-label="Close">关&nbsp;&nbsp;闭</button>
                        <button type="submit" class="btn btn-warning">登&nbsp;&nbsp;陆</button> &nbsp;&nbsp;
                    </div>
                </form>
            </div>
            <!-- 用户名密码登陆 end -->
        </div>
    </div>
    <!-- 登录模态框 end  -->

    <!-- 注册模态框 start -->
    <div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">会员注册</h4>
                </div>
                <form action="<%=basePath%>user/regist" class="form-horizontal" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登陆账号:</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登录密码:</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">您的姓名:</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系电话:</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">收货地址:</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="address">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-dismiss="modal" aria-label="Close">关&nbsp;&nbsp;闭</button>
                        <button type="reset" class="btn btn-warning">重&nbsp;&nbsp;置</button>
                        <button type="submit" class="btn btn-warning">注&nbsp;&nbsp;册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 注册模态框 end -->
</body>

</html>