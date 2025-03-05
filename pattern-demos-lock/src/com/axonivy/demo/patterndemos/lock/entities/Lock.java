package com.axonivy.demo.patterndemos.lock.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.axonivy.utils.persistence.beans.AuditableIdEntity;

@Entity
@Table
public class Lock extends AuditableIdEntity {
	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@Column
	private boolean locked;

	@Column
	private Instant validUntil;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the validUntil
	 */
	public Instant getValidUntil() {
		return validUntil;
	}

	/**
	 * @param validUntil the validUntil to set
	 */
	public void setValidUntil(Instant validUntil) {
		this.validUntil = validUntil;
	}
}
