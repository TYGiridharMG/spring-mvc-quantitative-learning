package com.tyss.springmvc.beans;

import java.util.List;

import lombok.Data;

@Data
public class UserBean {
	private String name;
	private String email;
	private String password;
	private String gender;
	private List<UserAddressBean> addressBeans;
}
