package com.soft.model;

public class ChildOrder {
    private Integer id;

    private Integer orderid;

    private Integer childordertype;

    private Integer goodsid;
    
    

    @Override
	public String toString() {
		return "ChildOrder [id=" + id + ", orderid=" + orderid + ", childordertype=" + childordertype + ", goodsid="
				+ goodsid + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getChildordertype() {
        return childordertype;
    }

    public void setChildordertype(Integer childordertype) {
        this.childordertype = childordertype;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}