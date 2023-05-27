package com.college.Dto;

import java.time.LocalDate;

public class CollegeStu {
	private int id;
	private String name;
	private String year;
	private LocalDate joinDate;
	private String skill;
	
	public CollegeStu( String name, String year, LocalDate joinDate, String skill) {
		super();
		
		this.name = name;
		this.year = year;
		this.joinDate = joinDate;
		this.skill = skill;
	}
	
	public CollegeStu(int id, String name, String year, LocalDate joinDate, String skill) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.joinDate = joinDate;
		this.skill = skill;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return year;
	}
	public void setUnit(String unit) {
		this.year = unit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "MasaiStudent [id=" + id + ", naem=" + name + ", year=" + year + ", joinDate=" + joinDate + ", skill="
				+ skill + "]";
	}
}
