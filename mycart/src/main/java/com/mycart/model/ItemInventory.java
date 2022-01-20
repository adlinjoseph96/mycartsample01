package com.mycart.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemInventory {
	
	private String _id;
	
	@JsonProperty("Stock")
	private Stock[] stock;
	

	public ItemInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}


	@Override
	public String toString() {
		return "ItemInventory [_id=" + _id + ", stock=" + Arrays.toString(stock) + "]";
	}

	

}
