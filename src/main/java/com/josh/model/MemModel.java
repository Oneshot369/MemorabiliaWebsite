package com.josh.model;

public class MemModel {

	Long id = 0L;
	String productName = "";
	float price = 0;
	String description = "";

	// image is set to null until we implement it
	String img = "NULL";
	
	public MemModel(Long id, String img, String productName, float price, String dec) {
		super();
		this.id = id;
		this.img = img;
		this.productName = productName;
		this.price = price;
		this.description = dec;
	}

	public MemModel() {
		this.id = null;
		this.img = null;
		this.productName = null;
		this.price = 0f;
		this.description = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "New Model: id=" + id + ", productName=" + productName + ", price=" + price
				+ ", Desc=" + description;
	}

	
	
}
