package com.yk.el;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Person {

	private int id = 1;
	private String name = "admin";
	private boolean sex = true;
	private List<String> list = Arrays.asList("list1", "list2", "list3");
	private Map<String, Object> info = new HashMap<String, Object>() {
		private static final long serialVersionUID = 1L;
		{
			this.put("1", "456");
			this.put("w.y.c", "袁铠");
			this.put("birhday", 1024);
		}
	};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public String toString() {
		return id + " " + name + (sex?"男":"女")+list.toString()+info.toString();
	}

}
