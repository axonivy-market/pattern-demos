package com.axonivy.demo.patterndemos;

import com.axonivy.demo.patterndemos.components.ChildCtrl;
import com.axonivy.demo.patterndemos.entities.Person;

public class ParentCtrl {

	private ChildCtrl childCtrl;
	private Person person;

	public ParentCtrl() {
		init();
	}

	/**
	 * Method to initialize controllers.
	 * 
	 **/
	public void init() {
		person = new Person();
		this.childCtrl = new ChildCtrl(person);
	}

	/**
	 * This method simulates saving data to the database, necessitating the creation
	 * of a new Person object because the database always returns a distinct
	 * instance. We must ensure that this new Person object is assigned to the
	 * controllers; failing to do so will cause the application to crash due to the
	 * use of two different object instances.
	 *
	 * 
	 **/
	public void save() {
		Person savedPerson = new Person();
		savedPerson.setId("simulatedId");
		savedPerson.setTitleBeforeName(getChildCtrl().getPerson().getTitleBeforeName());
		savedPerson.setFirstName(getChildCtrl().getPerson().getFirstName());
		savedPerson.setLastName(getChildCtrl().getPerson().getLastName());
		savedPerson.setTitleAfterName(getChildCtrl().getPerson().getTitleAfterName());
		savedPerson.setEmail(getChildCtrl().getPerson().getEmail());

		person = savedPerson;

		// This method set current instance to controllers.
		updateControllers();
	}

	/**
	 * This method simulates saving data to the database, but if the controllers are
	 * not updated, it will cause issues with two different object instances.
	 *
	 **/
	public void saveWithoutUpdateControllers() {
		Person savedPerson = new Person();
		savedPerson.setId("simulatedId");
		savedPerson.setTitleBeforeName(getChildCtrl().getPerson().getTitleBeforeName());
		savedPerson.setFirstName(getChildCtrl().getPerson().getFirstName());
		savedPerson.setLastName(getChildCtrl().getPerson().getLastName());
		savedPerson.setTitleAfterName(getChildCtrl().getPerson().getTitleAfterName());
		savedPerson.setEmail(getChildCtrl().getPerson().getEmail());

		person = savedPerson;
	}

	/**
	 * Method to update controllers.
	 *
	 **/
	public void updateControllers() {
		getChildCtrl().setPerson(person);
	}

	public ChildCtrl getChildCtrl() {
		return childCtrl;
	}

	public void setChildCtrl(ChildCtrl childCtrl) {
		this.childCtrl = childCtrl;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
