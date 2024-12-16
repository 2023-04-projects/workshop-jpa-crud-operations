package com.khadri.crud.operations.entity.bike;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bike {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String company;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}
