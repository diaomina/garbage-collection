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
    <title>垃圾分类系统</title>
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet" href="<%=basePath%>css/style.css" />
    <link rel="stylesheet" href="<%=basePath%>iconfont/iconfont.css">
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/zshop.js"></script>
</head>

<body>
    <div id="wrapper">
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
        <!-- content start -->
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-header" style="margin-bottom: 0px;">
                        <h3>商品列表</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <form action="<%=basePath%>user/getGoodsByType" class="form-inline hot-search">
                        &nbsp;
                        <div class="form-group">
                            <label class="control-label">种类：</label>
                            <select class="form-control input-sm" name="goodstype">
                                <option value="0" selected="selected">查询全部</option>
                                <option value="1">垃圾桶</option>
                                <option value="2">垃圾袋</option>
                            </select>
                        </div>
                        &nbsp;
                        <div class="form-group">
                            <button type="submit" class="btn btn-warning">
                                <i class="glyphicon glyphicon-search"></i> 查询
                            </button>
                        </div>    
                    </form>
                </div>
            </div>
        </div>
        
        <div class="content-back">
            <div class="container" id="a">
                <div class="row">
                
                	<c:forEach items="${goodsList}" var="goods">
                    <div class="col-xs-3  hot-item">
                        <div class="panel clear-panel">
                            <div class="panel-body">
                                <div class="art-back clear-back">
                                    <div class="add-padding-bottom">
                                        <img src="<%=basePath%>${goods.imageurl}" class="shopImg">
                                    </div>
                                    <h4><a href="">${goods.goodsname}</a></h4>
                                    <div class="user clearfix pull-right">
             ${goods.price}&nbsp;积分
                                    </div>
                                    <div class="desc">${goods.goodsdesc}
                                    </div>
                                    <div class="attention pull-right">
            <a href="<%=basePath%>cart/addCart?id=${goods.id}"> 加入购物车</a> <i class="icon iconfont icon-gouwuche"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
        <!-- content end-->
        <!-- footers start -->
        <div class="footers">
            版权所有：南京网博
        </div>
        <!-- footers end -->
    </div>

    <!-- 修改密码模态框 start -->
    <div class="modal fade" id="modifyPasswordModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <form action="<%=basePath%>user/updatePassword" class="form-horizontal" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">原密码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password" name="oldPassword">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">新密码：</label>
                            <div class="col-sm-6">
                                <input class="form-control" type="password" name="newPassword">
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