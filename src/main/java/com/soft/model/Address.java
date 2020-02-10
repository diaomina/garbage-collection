package com.soft.model;

public class Address {
    private Integer id;

    private Integer userid;

    private String name;

    private String phone;

    private String address;
    
    

    @Override
	public String toString() {
		return "Address [id=" + id + ", userid=" + userid + ", name=" + name + ", phone=" + phone + ", address="
				+ address + "]";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}