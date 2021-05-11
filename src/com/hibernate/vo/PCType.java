package com.hibernate.vo;
public class PCType {
	private long id;
	private String Name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "PCType [id=" + id + ", Name=" + Name + "]";
	}
}
