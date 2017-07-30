package com.self.entity;

import java.util.List;

public class Role {
	private int roleId;
	private String name;
	
	private List<User> userList;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", userList="
				+ userList.size() + "]";
	}
	
	
}
