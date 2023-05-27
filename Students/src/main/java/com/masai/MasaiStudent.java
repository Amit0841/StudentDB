package com.masai;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MasaiStudent {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String unit;
private LocalDate joinDate;
private String skill;
public MasaiStudent() {
	super();
	// TODO Auto-generated constructor stub
}
public MasaiStudent( String naem, String unit, LocalDate joinDate, String skill) {
	super();
	this.name = naem;
	this.unit = unit;
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
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getYear() {
	return unit;
}
public void setYear(String year) {
	this.unit = year;
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
	return "MasaiStudent [id=" + id + ", naem=" + name + ", year=" + unit + ", joinDate=" + joinDate + ", skill="
			+ skill + "]";
}

}
