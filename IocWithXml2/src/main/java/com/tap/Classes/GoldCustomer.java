package com.tap.Classes;

import com.tap.Interface.Customer;

public class GoldCustomer implements Customer {
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void showDetails() {
		System.out.println("Gold Wearing :"+type);

	}

}
