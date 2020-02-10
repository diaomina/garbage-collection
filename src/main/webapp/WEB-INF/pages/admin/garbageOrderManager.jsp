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
    <title>上门回收订单管理</title>
    <link rel="stylesheet"  href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/index.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/file.css" />
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/userSetting.js"></script>
</head>

<body>
    <div class="panel panel-default" id="userPic">
        <div class="panel-heading">
            <h3 class="panel-title">上门回收订单管理</h3>
        </div>
        <div class="panel-body">
            <div class="show-list">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                           <th class="text-center">序号</th>
			               <th class="text-center">订单编号</th>
			               <th class="text-center">垃圾名称</th>
			               <th class="text-center">垃圾类型</th>
			               <th class="text-center">重量</th>
			               <th class="text-center">上门地址</th>
			               <th class="text-center">上门时间</th>
			               <th class="text-center">下单时间</th>
			               <th class="text-center">取货时间</th>
			               <th class="text-center">订单状态</th>
			               <th class="text-center">结算积分</th>
			               <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
			            <c:forEach items="${garbageOrderList}" var="garbageOrder" varStatus="status">
			            <tr>
			                <td class="text-center">${status.index+1}</td>
			                <td class="text-center">${garbageOrder.id}</td>
			                <td class="text-center">${garbageOrder.garbagename}</td>
			                <td class="text-center">
			                	<c:forEach items="${garbageTypeList}" var="garbageType">
			                		<c:if test="${garbageType.id == garbageOrder.garbagetypeid}">
			                			${garbageType.garbagetypename}
			                		</c:if>
			                    </c:forEach>
			                </td>
			                <td class="text-center">${garbageOrder.weight}&nbsp;/&nbsp;kg</td>
			                <td class="text-center">
			                	<c:forEach items="${addresses}" var="address">
				                	<c:if test="${address.id == garbageOrder.addressid}">
				                		${address.name}&nbsp;${address.phone}&nbsp;${address.address}
				                	</c:if>
			                    </c:forEach>
			                </td>
			                <td class="text-center">
			                	<fmt:formatDate value="${garbageOrder.appointmenttime}" pattern="yyyy-MM-dd HH:mm" />
			                </td>
			                <td class="text-center">
			                	<fmt:formatDate value="${garbageOrder.starttime}" pattern="yyyy-MM-dd HH:mm:ss" />
			                </td>
			                <td class="text-center">
			                	<c:if test="${garbageOrder.status == 1}">
			                		等待取货
			                	</c:if>
			                	<c:if test="${garbageOrder.status == 2}">
			                		<fmt:formatDate value="${garbageOrder.endtime}" pattern="yyyy-MM-dd HH:mm:ss" />
			                	</c:if>
			                </td>
			                <td class="text-center">
			                	<c:if test="${garbageOrder.status == 1}">
			                		待上门
			                	</c:if>
			                	<c:if test="${garbageOrder.status == 2}">
			                		已完成
			                	</c:if>
			                </td>
			                <td class="text-center">
			                	<c:if test="${garbageOrder.status == 1}">
			                		等待取货
			                	</c:if>
			                	<c:if test="${garbageOrder.status == 2}">
			                		${garbageOrder.money}
			                	</c:if>
			                </td>
			                <td class="text-center">
			                	<c:if test="${garbageOrder.status == 1}">
			                		<!-- 
			                		<a href="<%=basePath%>garbageOrder/delete?id=${garbageOrder.id}">
				                    <button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认取消预约？');">
				                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 成功取货
				                    </button>
				                    </a>
				                     -->
			                		<input type="button" value="成功取货" class="btn btn-primary garbageOrderManagerUpdate" id="garbageOrderManagerUpdate" onclick="document.getElementById('FormGarbageOrderId').value=${garbageOrder.id}">
			                		
			                		<a href="<%=basePath%>garbageOrderManager/delete?id=${garbageOrder.id}">
				                    <button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认拒绝上门？');">
				                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 拒绝上门
				                    </button>
				                    </a>
			                	</c:if>
			                	<c:if test="${garbageOrder.status == 2}">
			                		<a href="<%=basePath%>garbageOrderManager/delete?id=${garbageOrder.id}">
				                    <button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认删除？');">
				                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 删除订单
				                    </button>
				                    </a>
			                	</c:if>
			                </td>
			            </tr>
			            </c:forEach>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    
    <!-- 成功取货 start -->     
    <div class="modal fade" tabindex="-1" id="gOMUpdate">
        <!-- 窗口声明 -->
        <div class="modal-dialog modal-lg">
            <!-- 内容声明 -->
            <form action="<%=basePath%>garbageOrderManager/update" method="post" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">请输入用户所获积分</h4>
                </div>
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="productTypeName" class="col-sm-4 control-label">所获积分：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="money" id="money">
                        </div>
                    </div>
                    <br>
                </div>
                <!-- 通过点击事件传入id的值 -->
                <input type="hidden" id="FormGarbageOrderId" name="garbageOrderId" value="" >
                <div class="modal-footer">
                    <button class="btn btn-primary updateGarbageOrder">提交</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <!-- 成功取货 end -->  
    
    

    
</body>

</html>