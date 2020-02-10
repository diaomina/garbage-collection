package com.soft.vo;

import java.util.Date;

/**
 * 
* @ClassName: Orders1VO
* @Description: 待支付订单
* @author ljy
* @date 2019年12月12日 下午7:20:01
*
 */
public class Orders1VO {

	private Integer id;	//订单编号
	private Integer allPrice;	//商品总价
	private String address;	//收货地址
	private Date starttime;	//下单时间
	private Integer status;	//订单状态
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(Integer allPrice) {
		this.allPrice = allPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders1VO [id=" + id + ", allPrice=" + allPrice + ", address=" + address + ", starttime=" + starttime
				+ ", status=" + status + "]";
	}
	
	
	
	

	
}
