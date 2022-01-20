package com.mycart.model;

//import com.loanbroker.creditbureau.model.CreditScore;
import com.mycart.model.Item;

public class MyCartResponse {
	
	private String status;
	private String errMsg;
	private  Item itemData;
	
	
	public MyCartResponse() {
		super();
	}
	public MyCartResponse(String status, String errMsg, Item itemData) {
		super();
		this.status = status;
		this.errMsg = errMsg;
		this.itemData = itemData;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Item getItem() {
		return itemData;
	}
	public void setItem(Item itemData) {
		this.itemData = itemData;
	}
	

}
