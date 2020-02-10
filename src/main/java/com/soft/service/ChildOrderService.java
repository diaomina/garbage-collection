package com.soft.service;

import java.util.List;

import com.soft.model.ChildOrder;

/**
 * 
 * @ClassName: ChildOrderService
 * @Description: 子订单业务接口
 * @author ljy
 * @date 2019年12月10日 下午9:38:58
 *
 */
public interface ChildOrderService {
	
	/**
	 * 
	* @Title: getByOrderIdType
	* @Description: 根据订单id和订单类型查询( 查询出的数据只需要商品id的列表即可 ,实现一个订单内所有商品查询)
	* @param @param orderId 订单id
	* @param @param childOrderType 订单类型(1 购物车 , 2 环保商城订单)
	* @param @return
	* @return List<ChildOrder>
	* @throws
	 */
	List<ChildOrder> getByOrderIdAndType(Integer orderId, Integer childOrderType);

	// 根据id查找
	ChildOrder getById(Integer id);

	// 获取所有
	List<ChildOrder> getAll();

	// 添加
	int add(ChildOrder childOrder);

	// 修改
	int update(ChildOrder childOrder);

	// 删除
	int delete(Integer id);
	
	
	/**
	 * 	根据根据订单id和订单类型批量删除( 实现清空购物车功能 )
	 * @param orderId 订单id
	 * @param childOrderType 订单类型(1 购物车 , 2 环保商城订单)
	 * @return
	 */
	int deleteByOrderIdAndType(Integer orderId, Integer childOrderType);
	
	
	/**
	 * 	实现将一个商品移出购物车功能
	 * @param orderId 订单id
	 * @param childOrderType 订单类型(1 购物车 , 2 环保商城订单)
	 * @param goodsId 商品id
	 * @return
	 */
	int deleteByOrderIdAndTypeAndGoodsId(Integer orderId, Integer childOrderType, Integer goodsId);

}
