package com.soft.vo;

public class GarbageInfo {
	
	private Integer id;
	private String name;
	private Integer type;
	private String category;
	private String remark;
	private Integer num;

	public GarbageInfo() {

	}

	public GarbageInfo(Integer id, String name, Integer type, String category, String remark, Integer num) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.remark = remark;
		this.num = num;
	}

	@Override
	public String toString() {
		return "GarbageType [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", remark="
				+ remark + ", num=" + num + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}