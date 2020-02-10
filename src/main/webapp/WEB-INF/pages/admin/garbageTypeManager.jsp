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
    <title>垃圾类型管理</title>
    <link rel="stylesheet"  href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/index.css" />
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/userSetting.js"></script>
</head>

<body>
    <div class="panel panel-default" id="userSet">
        <div class="panel-heading">
            <h3 class="panel-title">垃圾类型管理</h3>
        </div>
        <div class="panel-body">
            <input type="button" value="添加垃圾类型" class="btn btn-primary" id="doAddProTpye">
            <br>
            <br>
            <div class="show-list">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                            <th class="text-center">编号</th>
                            <th class="text-center">类型名称</th>
                            <th class="text-center">投放建议</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    	<c:forEach items="${garbageTypeList}" var="garbageType" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${garbageType.garbagetypename}</td>
                            <td>${garbageType.garbagetip}</td>
                            <td class="text-center">
                            	<input type="button" class="btn btn-warning btn-sm doProModify" value="修改" onclick="
			                			document.getElementById('garbageType_id').value = ${garbageType.id};
				                	    document.getElementById('garbageType_garbagetypename').value = '${garbageType.garbagetypename}';
				                	    document.getElementById('garbageType_garbagetip').value = '${garbageType.garbagetip}';
			                	">
                            
                                <a href="<%=basePath%>garbageType/delete?id=${garbageType.id}">
				                    <button class="btn btn-danger" type="button" onclick="javaScript:return confirm('是否确认删除');">
				                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
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
    
    <!-- 添加垃圾类型 start -->     
    <div class="modal fade" tabindex="-1" id="ProductType">
        <!-- 窗口声明 -->
        <div class="modal-dialog modal-lg">
            <!-- 内容声明 -->
            <form action="<%=basePath%>garbageType/add" method="post" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">添加垃圾类型</h4>
                </div>
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="productTypeName" class="col-sm-4 control-label">类型名称：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="garbagetypename" id="productTypeName">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="productTypeName" class="col-sm-4 control-label">投放建议：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="garbagetip" id="productTypeName">
                        </div>
                    </div>
                    <br>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary addProductType">添加</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <!-- 添加垃圾类型 end -->
    
    
    
    <!-- 修改垃圾类型 start -->  
    <div class="modal fade" tabindex="-1" id="myProduct">
        <!-- 窗口声明 -->
        <div class="modal-dialog modal-lg">
            <!-- 内容声明 -->
           <form action="<%=basePath%>garbageType/update" method="post" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改垃圾类型</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="pro-num" class="col-sm-4 control-label">垃圾类型ID：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="id" id="garbageType_id" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">类型名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="garbagetypename" id="garbageType_garbagetypename">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">投放建议：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="garbagetip" id="garbageType_garbagetip">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary updatePro">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <!-- 修改垃圾类型 end --> 
    
   
</body>

</html>