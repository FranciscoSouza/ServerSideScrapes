package com.serversidescrape.bo;

import java.util.List;

public class JSONResultBO {

	private List<ProductBO> results;
	private Float total;
	
	public JSONResultBO() {
	}

	public JSONResultBO(List<ProductBO> productList, Float total) {
		super();
		this.results = productList;
		this.total = total;
	}

	public List<ProductBO> getProductList() {
		return results;
	}

	public void setProductList(List<ProductBO> productList) {
		this.results = productList;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	

}
