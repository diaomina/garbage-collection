package com.soft.service;

import java.util.List;

import com.soft.model.Goods;

/**
 * 
 * @ClassName: GoodsService
 * @Description: 商品的业务接口
 * @author: ljy
 * @date: 2019年12月10日 下午5:51:46
 */
public interface GoodsService {
	
	// 根据商品类型查找
	List<Goods> getByGoodsType(Integer goodstype);

	// 根据id查找
	Goods getById(Integer id);
	
	// 获取所有
	List<Goods> getAll();

	// 添加
	int add(Goods goods);

	// 修改
	int update(Goods goods);

	// 删除
	int delete(Integer id);

}
