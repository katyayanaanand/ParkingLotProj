package com.cg.main;

public class Car {
	private String color;
	private String RegNo;
	@Override
	public String toString() {
		return "Car [color=" + color + ", RegNo=" + RegNo + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegNo() {
		return RegNo;
	}
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	public Car(String RegNo, String color) {
		this.RegNo= RegNo;
		this.color= color;
	}
}
