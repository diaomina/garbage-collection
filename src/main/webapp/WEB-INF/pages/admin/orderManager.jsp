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
    <title>环保商城订单管理</title>
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
            <h3 class="panel-title">环保商城订单管理</h3>
        </div>
        <div class="panel-body">
            <div class="show-list">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                        	<th class="text-center">序号</th>
                            <th class="text-center">订单编号</th>
                            <th class="text-center">商品详情</th>
                            <th class="text-center">总价</th>
                            <th class="text-center">收货地址</th>
                            <th class="text-center">下单时间</th>
                            <th class="text-center">收货时间</th>
                            <th class="text-center">订单状态</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    	<c:forEach items="${orderManagerVOList}" var="orderManagerVO" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${orderManagerVO.id}</td>
                            <td>
                            	<c:forEach items="${orderManagerVO.goodsList}" var="goods">
                            		${goods.goodsname}&nbsp;x1<br/>
                            	</c:forEach>
                            </td>
                            <td>${orderManagerVO.allprice}</td>
                            <td style="text-align:left">
                            	<b>收货人：</b>${orderManagerVO.address.name}<br/>
                            	<b>联系电话：</b>${orderManagerVO.address.phone}<br/>
                            	<b>收货地址：</b>${orderManagerVO.address.address}<br/>
                            </td>
                            <td>
                            	<fmt:formatDate value="${orderManagerVO.starttime}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                            	<c:if test="${orderManagerVO.status==3}">
                            		<fmt:formatDate value="${orderManagerVO.endtime}" pattern="yyyy-MM-dd HH:mm:ss" />
                            	</c:if>
                            	<c:if test="${orderManagerVO.status!=3}">
                            		尚未确认收货
                            	</c:if>
                            </td>
                            <td>
                            	<c:if test="${orderManagerVO.status==1}">
                            		待支付
                            	</c:if>
                            	<c:if test="${orderManagerVO.status==2}">
                            		待收货
                            	</c:if>
                            	<c:if test="${orderManagerVO.status==3}">
                            		已完成
                            	</c:if>
                            </td>
                            <td class="text-center">
                                <a href="<%=basePath%>orderManager/delete?id=${orderManagerVO.id}">
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
    
    

    
</body>

</html>