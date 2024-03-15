package com.loginPageAssignment;
import java.io.*;
import java.util.Date;
public class DetailsBean 
{
	private int id;
	private String Name,Email;
	private int age;
	private Date date;
	
	public DetailsBean()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
