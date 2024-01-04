package com.josh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("mem")
public class MemEntity {
    @Id
    @Column("ID")
    Long id = 0L;

    @Column("PRODUCT_NAME")
	String productName = "";

    @Column("PRICE")
	float price = 0;

    @Column("DESCRIPTION")
	String description = "";

    @Column("IMG")
    String img = "NULL";
    
    //Default Constructor
    public MemEntity() {
    }

    //Param Constructor
    public MemEntity(Long id, String productName, float price, String description, String img) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.img = img;
    }
    //------------------------------
    //Getter / setter
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

    //Overrides
    public String toString() {
		return "New Entity: id=" + id + ", productName=" + productName + ", price=" + price
				+ ", Desc=" + description;
	}
}
