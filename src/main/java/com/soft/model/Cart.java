package com.soft.model;

public class Cart {
    private Integer id;

    private Integer userid;

    private Double allprice;
    
    

    @Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", allprice=" + allprice + "]";
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

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }
}