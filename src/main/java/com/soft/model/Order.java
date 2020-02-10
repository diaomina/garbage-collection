package com.soft.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Double allprice;

    private Integer userid;

    private Integer addressid;

    private Date starttime;

    private Date endtime;

    private Integer status;
    
    

    @Override
	public String toString() {
		return "Order [id=" + id + ", allprice=" + allprice + ", userid=" + userid + ", addressid=" + addressid
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", status=" + status + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
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
}