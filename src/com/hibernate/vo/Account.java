package com.hibernate.vo;

public class Account {
	private long id;
	private String login;
	private String pwd;
	private String FirstName;
	private String LastName;
	private AccountType accountType;
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", pwd=" + pwd
				+ ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", accountType=" + accountType + "]";
	}
	
}
