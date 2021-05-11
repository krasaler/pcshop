package com.hibernate.vo;

public class Tovar {
	private long ID;
	private String Name;
	private int price;
	private PCType pctype;
	private Integer RAM;
	private Integer HDD;
	private Integer CoresCount;

	public Integer getRAM() {
		return RAM;
	}

	public void setRAM(Integer RAM) {
		this.RAM = RAM;
	}

	public Integer getHDD() {
		return HDD;
	}

	public void setHDD(Integer HDD) {
		this.HDD = HDD;
	}

	public Integer getCoresCount() {
		return CoresCount;
	}

	public void setCoresCount(Integer coresCount) {
		CoresCount = coresCount;
	}

	public PCType getPctype() {
		return pctype;
	}

	public void setPctype(PCType pctype) {
		this.pctype = pctype;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tovar [ID=" + ID + ", Name=" + Name + ", price=" + price
				+ ", pctype=" + pctype + ", RAM=" + RAM + ", HDD=" + HDD
				+ ", CoresCount=" + CoresCount + "]";
	}

}
