package com.soft.vo;

import java.util.Date;
import java.util.List;

import com.soft.model.Address;
import com.soft.model.Goods;

/**
 * 
* @ClassName: OrderManagerVO
* @Description: 环保商城订单管理的vo
* @author ljy
* @date 2019年12月13日 上午10:24:16
*
 */
public class OrderManagerVO {
	
	private Integer id;				//订单id
	private List<Goods> goodsList;	//商品列表 
	private Double allprice;		//总价
	private Address address;		//收货地址
	private Date starttime;			//下单时间
	private Date endtime;			//收货时间
	private Integer status;			//订单状态
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderManagerVO [id=" + id + ", goodsList=" + goodsList + ", allprice=" + allprice + ", address="
				+ address + ", starttime=" + starttime + ", endtime=" + endtime + ", status=" + status + "]";
	}
	
	
}
