package com.axonivy.demo.patterndemos.ui.components;

import com.axonivy.demo.patterndemos.PersonHolder;

public class ChildCtrl {

	private PersonHolder personHolder;

	public ChildCtrl(PersonHolder personHolder) {
		this.personHolder = personHolder;
	}

	public PersonHolder getPersonHolder() {
		return personHolder;
	}
}
