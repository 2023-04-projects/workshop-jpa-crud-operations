package com.khadri.crud.operations.pharmacy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tablet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String tabletName;
	private int tabletQty;
	private double tabletPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTabletName() {
		return tabletName;
	}
	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}
	public int getTabletQty() {
		return tabletQty;
	}
	public void setTabletQty(int tabletQty) {
		this.tabletQty = tabletQty;
	}
	public double getTabletPrice() {
		return tabletPrice;
	}
	public void setTabletPrice(double tabletPrice) {
		this.tabletPrice = tabletPrice;
	}
	@Override
	public String toString() {
		return "Tablet [id=" + id + ", tabletName=" + tabletName + ", tabletQty=" + tabletQty + ", tabletPrice="
				+ tabletPrice + "]";
	}
	 
}