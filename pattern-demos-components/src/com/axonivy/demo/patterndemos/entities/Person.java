package com.axonivy.demo.patterndemos.entities;

public class Person {

	private String id;
	private String titleBeforeName;
	private String firstName;
	private String lastName;
	private String titleAfterName;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleBeforeName() {
		return titleBeforeName;
	}

	public void setTitleBeforeName(String titleBeforeName) {
		this.titleBeforeName = titleBeforeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitleAfterName() {
		return titleAfterName;
	}

	public void setTitleAfterName(String titleAfterName) {
		this.titleAfterName = titleAfterName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
