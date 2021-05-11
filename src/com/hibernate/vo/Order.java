package com.hibernate.vo;

import java.util.Date;
import java.util.List;

public class Order {
	private long id;
	private Date date;
	private String Adress;
	private Account account;
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	private List<Tovar> tovars;
	public List<Tovar> getTovars() {
		return tovars;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", Adress=" + Adress
				+ ", account=" + account + ", status=" + status + ", tovars="
				+ tovars + "]";
	}
	public void setTovars(List<Tovar> tovars) {
		this.tovars = tovars;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	
}
