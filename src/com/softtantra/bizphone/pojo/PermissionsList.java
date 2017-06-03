package com.softtantra.bizphone.pojo;

import java.io.Serializable;

public class PermissionsList implements Serializable {
	
	private String user_name;
	private String permission_link;
	private String dispalay_name;
	private String mainmenu;
	private int sequence;
	private int count;
	
	
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMainmenu() {
		return mainmenu;
	}
	public void setMainmenu(String mainmenu) {
		this.mainmenu = mainmenu;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getDispalay_name() {
		return dispalay_name;
	}
	public void setDispalay_name(String dispalay_name) {
		this.dispalay_name = dispalay_name;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPermission_link() {
		return permission_link;
	}
	public void setPermission_link(String permission_link) {
		this.permission_link = permission_link;
	}
	
	

}
