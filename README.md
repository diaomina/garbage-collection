# garbage-collection

#### 介绍
基于SSM的垃圾回收项目

[演示网址](http://39.108.5.98/garbage-collection/distinguish/toDistinguish )

本项目在线上可以快速帮助用户对垃圾类型进行查询和识别，提供了文字查询和图 片识别方式。并且实现垃圾上门回收功能，用户可以在客户端预约垃圾上门回收，根据回收的 物件获取对应的积分，积分可以在环保商城中使用。项目采用MVC 模式，前端界面使用Bootstrap和layer辅助构建完成，表现层采用SpringMVC 框架开发，前后端采用Ajax进行 交互，业务层业务模块均有专门的接口和实现类，数据访问层采用 MyBatis 实现，逆向生成 model和dao的功能代码。

主要功能模块有： 

​		 前台：会员登录注册、会员中心、垃圾识别、上门回收、回收订单、环保商城、购物车、 我的订单等。

​		 后台：管理员登录、会员管理、垃圾类型管理、商品管理、环保商城订单管理、上门回收 订单管理

#### 软件架构
开发环境：Eclipse+Tomcat9.0+MySQL5.5+Git+Maven 

使用技术：springMVC+spring+mybatis+Ajax+Bootstrap+layer 


#### 安装教程

1.  创建数据库db_garbage_collection
2.  导入运行db_garbage_collection.sql脚本
3.  修改 garbage-collection/src/main/resources/dbconfig.properties文件。
4.  将项目加入tomcat，启动tomcat。
5.  游览器访问主页。



