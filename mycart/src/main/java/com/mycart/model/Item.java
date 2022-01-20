package com.mycart.model;

import java.util.Date;

import javax.inject.Named;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Named("itemdetails")
public class Item {
	
	private String _id;
	private String itemName;
	private String categoryId;
	//private String lastUpdateDate;
	private Date lastUpdateDate;

	private boolean specialProduct;
	
	@JsonProperty("ItemPrice")
	private ItemPrice itemPrice;
	@JsonIgnoreProperties
	private Review[] review;
	
	@JsonProperty("stockDetails")
	private StockDetails stockDetails;
	
	public Item() {
		super();
	}

	
	
	
	public Item(String _id, String itemName, String categoryId, Date lastUpdateDate, boolean specialProduct) {
		super();
		this._id = _id;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.lastUpdateDate = lastUpdateDate;
	
		this.specialProduct = specialProduct;
		
	}

/*	public String getLastUpdateDate() {
		return lastUpdateDate;
	}




	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
*/



	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}




	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}




	public boolean isSpecialProduct() {
		return specialProduct;
	}

	public void setSpecialProduct(boolean specialProduct) {
		this.specialProduct = specialProduct;
	}

	
	@Override
	public String toString() {
		return "ItemDetails [_id=" + _id + ", itemName=" + itemName + ", categoryId=" + categoryId + ", lastUpdateDate="
				+ lastUpdateDate + ",specialProduct=" + specialProduct
				+  "]";
	}
	
	
	

}
