package com.ezio.StudentMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String gmail;
	private Long contact;
	private String course;
	private Float fees;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, String gmail, Long contact, String course, Float fees) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.contact = contact;
		this.course = course;
		this.fees = fees;
	}

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

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gmail=" + gmail + ", contact=" + contact + ", course="
				+ course + ", fees=" + fees + "]";
	}
	
	
	
}
