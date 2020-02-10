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
    <title>商品管理</title>
    <link rel="stylesheet"  href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/index.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/file.css" />
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/userSetting.js"></script>
    <script>
        $(function(){
            //上传图像预览
            $('#product-image').on('change',function() {
                $('#img').attr('src', window.URL.createObjectURL(this.files[0]));
            });        
            $('#pro-image').on('change',function() {
                $('#img2').attr('src', window.URL.createObjectURL(this.files[0]));
            });    
        });
    </script>
</head>

<body>
    <div class="panel panel-default" id="userPic">
        <div class="panel-heading">
            <h3 class="panel-title">商品管理</h3>
        </div>
        <div class="panel-body">
            <input type="button" value="添加商品" class="btn btn-primary" id="doAddPro">
            <br>
            <br>
            <div class="show-list">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                            <th class="text-center">商品编号</th>
                            <th class="text-center">商品名称</th>
                            <th class="text-center">商品描述</th>
                            <th class="text-center">商品价格</th>
                            <th class="text-center">商品数量</th>
                            <th class="text-center">商品图片</th>
                            <th class="text-center">商品类型</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    	<c:forEach items="${goodsList}" var="goods" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${goods.goodsname}</td>
                            <td>${goods.goodsdesc}</td>
                            <td>${goods.price}</td>
                            <td>${goods.number}</td>
                            <td>
                            	<img src="<%=basePath%>${goods.imageurl}"/>
                            </td>
                            <td>
                            	<c:if test="${goods.goodstype==1}">
                            		垃圾桶
                            	</c:if>
                            	<c:if test="${goods.goodstype==2}">
                            		垃圾袋
                            	</c:if>
                            </td>
                            <td class="text-center">
                            	<%--  <a href="<%=basePath%>goods/toUpdateGoods?id=${goods.id}"> <input type="button" class="btn btn-warning btn-sm doProModify"  value="修改"></a> --%>
                                
			                	<input type="button" class="btn btn-warning btn-sm doProModify" value="修改" onclick="
			                			document.getElementById('goods_id').value = ${goods.id};
				                	    document.getElementById('goods_goodsname').value = '${goods.goodsname}';
				                	    document.getElementById('goods_goodsdesc').value = '${goods.goodsdesc}';
				                	    document.getElementById('goods_price').value = ${goods.price};
				                	    document.getElementById('goods_number').value = ${goods.number};
				                	    document.getElementById('img2').src = '<%=basePath%>${goods.imageurl}';
				                	    document.getElementById('goods_goodstype').value = ${goods.goodstype};
			                	">
                                <a href="<%=basePath%>goods/deleteGoods?id=${goods.id}"> <input type="button" class="btn btn-warning btn-sm doProDelete" value="删除"></a>
                            </td>
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- 添加商品 start -->     
    <div class="modal fade" tabindex="-1" id="Product">
        <!-- 窗口声明 -->
        <div class="modal-dialog modal-lg">
            <!-- 内容声明 -->
            <form action="<%=basePath%>goods/addGoods" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">添加商品</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="product-name" class="col-sm-4 control-label">商品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goodsname" id="goodsname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-name" class="col-sm-4 control-label">商品描述：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goodsdesc" id="goodsdesc">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-price" class="col-sm-4 control-label">商品价格：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="price" id="price">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-price" class="col-sm-4 control-label">商品数量：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="number" id="number">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-image" class="col-sm-4 control-label">商品图片：</label>
                            <div class="col-sm-8">
                                <a href="javascript:;" class="file">选择文件
                                    <input type="file" name="imageFile" id="product-image">
                                </a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-type" class="col-sm-4 control-label">商品类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="goodstype">
                                    <option>请选择</option>
                                    <option value="1">垃圾桶</option>
                                    <option value="2">垃圾袋</option>
                                </select>
                            </div>
                        </div>
                    </div>  
                    <div class="col-sm-4">
                        <!-- 显示图像预览 -->
                        <img style="width: 160px;height: 180px;" id="img">
                    </div>  
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary">添加</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <!-- 添加商品 end -->  
    
    

    
    <!-- 修改商品 start -->  
    <div class="modal fade" tabindex="-1" id="myProduct">
        <!-- 窗口声明 -->
        <div class="modal-dialog modal-lg">
            <!-- 内容声明 -->
           <form action="<%=basePath%>goods/updateGoods" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改商品</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="pro-num" class="col-sm-4 control-label">商品ID：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="id" id="goods_id" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">商品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goodsname" id="goods_goodsname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">商品描述：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="goodsdesc" id="goods_goodsdesc">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-price" class="col-sm-4 control-label">商品价格：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="price" id="goods_price">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-price" class="col-sm-4 control-label">商品数量：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="number" id="goods_number">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-image" class="col-sm-4 control-label">商品图片：</label>
                            <div class="col-sm-8">
                                <a class="file">
                                    选择文件 <input type="file" name="imageFile" id="pro-image">
                                </a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-type" class="col-sm-4 control-label">商品类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="goodstype" id="goods_goodstype">
                                    <option value="1">垃圾桶</option>
                                    <option value="2">垃圾袋</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- 显示图像预览 -->
                        <img style="width: 160px;height: 180px;" id="img2">
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
    <!-- 修改商品 end -->  

    
</body>

</html>