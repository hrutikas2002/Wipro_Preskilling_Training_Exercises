package com.wipro.hibernate.HibernateDemonstration1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAN")
public class Pan {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;

	@Column(name="Placeholder_name")
	private String panholderName;

	@Column(name="pan_number")
	private String panNumber;

	public Pan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pan(String panholderName, String panNumber) {
		this.panholderName = panholderName;
		this.panNumber = panNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanholderName() {
		return panholderName;
	}

	public void setPanholderName(String panholderName) {
		this.panholderName = panholderName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "Pan [id=" + id + ", panholderName=" + panholderName + ", panNumber=" + panNumber + "]";
	}

}
