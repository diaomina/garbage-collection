package com.soft.model;

public class Goods {
    private Integer id;

    private String goodsname;

    private Integer goodstype;

    private String goodsdesc;

    private String imageurl;

    private Double price;

    private Integer number;
    
    

    @Override
	public String toString() {
		return "Goods [id=" + id + ", goodsname=" + goodsname + ", goodstype=" + goodstype + ", goodsdesc=" + goodsdesc
				+ ", imageurl=" + imageurl + ", price=" + price + ", number=" + number + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Integer getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(Integer goodstype) {
        this.goodstype = goodstype;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}