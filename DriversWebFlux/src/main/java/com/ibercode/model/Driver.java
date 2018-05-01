package com.ibercode.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
public class Driver {
	
	@Id
	private String id;
	private String name;
	private int car;
	private String team;
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(String id, String name, int car, String team) {
		super();
		this.id = id;
		this.name = name;
		this.car = car;
		this.team = team;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", car=" + car + ", team=" + team + "]";
	}
	
	
}
