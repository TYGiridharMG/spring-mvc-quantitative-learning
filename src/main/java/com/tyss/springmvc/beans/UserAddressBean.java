package com.tyss.springmvc.beans;

import lombok.Data;

@Data
public class UserAddressBean {
	private String addressType;
	private String address;
	private String city;
	private String state;
}
