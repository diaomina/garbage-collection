package com.soft.model;

import java.util.Date;

public class GarbageOrder {
    private Integer id;

    private Integer userid;

    private Integer addressid;

    private String garbagename;

    private Integer garbagetypeid;

    private Double weight;

    private Double money;

    private Date appointmenttime;

    private Date starttime;

    private Date endtime;

    private Integer status;
    
    

    @Override
	public String toString() {
		return "GarbageOrder [id=" + id + ", userid=" + userid + ", addressid=" + addressid + ", garbagename="
				+ garbagename + ", garbagetypeid=" + garbagetypeid + ", weight=" + weight + ", money=" + money
				+ ", appointmenttime=" + appointmenttime + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", status=" + status + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGarbagename() {
        return garbagename;
    }

    public void setGarbagename(String garbagename) {
        this.garbagename = garbagename == null ? null : garbagename.trim();
    }

    public Integer getGarbagetypeid() {
        return garbagetypeid;
    }

    public void setGarbagetypeid(Integer garbagetypeid) {
        this.garbagetypeid = garbagetypeid;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(Date appointmenttime) {
        this.appointmenttime = appointmenttime;
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