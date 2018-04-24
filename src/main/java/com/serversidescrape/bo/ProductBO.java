package com.serversidescrape.bo;

public class ProductBO {

	private String title;
	private String description;
	private float kcal_per_100g;
	private float unit_price;

	public ProductBO() {
	}

	public ProductBO(String title, String description, float calorie, float price) {
		super();
		this.title = title;
		this.description = description;
		this.kcal_per_100g = calorie;
		this.unit_price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCalorie() {
		return kcal_per_100g;
	}

	public void setCalorie(float calorie) {
		this.kcal_per_100g = calorie;
	}

	public float getPrice() {
		return unit_price;
	}

	public void setPrice(float price) {
		this.unit_price = price;
	}

	
}
