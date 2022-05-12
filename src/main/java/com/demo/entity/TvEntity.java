package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Tv")
public class TvEntity {
	@Id
	private int id;
	private String Model;
	private String Brand;
	private int Price;
	private String Colour;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getPrice() {
		return Price;
	}
	
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}

}
