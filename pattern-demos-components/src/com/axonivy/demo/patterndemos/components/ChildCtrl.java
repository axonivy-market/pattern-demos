package com.axonivy.demo.patterndemos.components;

import com.axonivy.demo.patterndemos.entities.Person;

public class ChildCtrl {

	private Person person;

	public ChildCtrl(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
