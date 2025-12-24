package com.axonivy.demo.patterndemos.lock.entities;

import com.axonivy.utils.persistence.beans.AuditableIdEntity_;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;

/**
 * Static metamodel for {@link com.axonivy.demo.patterndemos.lock.entities.Lock}
 **/
@StaticMetamodel(Lock.class)
public abstract class Lock_ extends AuditableIdEntity_ {

	
	/**
	 * @see #name
	 **/
	public static final String NAME = "name";
	
	/**
	 * @see #locked
	 **/
	public static final String LOCKED = "locked";
	
	/**
	 * @see #validUntil
	 **/
	public static final String VALID_UNTIL = "validUntil";

	
	/**
	 * Static metamodel type for {@link com.axonivy.demo.patterndemos.lock.entities.Lock}
	 **/
	public static volatile EntityType<Lock> class_;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.lock.entities.Lock#name}
	 **/
	public static volatile SingularAttribute<Lock, String> name;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.lock.entities.Lock#locked}
	 **/
	public static volatile SingularAttribute<Lock, Boolean> locked;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.lock.entities.Lock#validUntil}
	 **/
	public static volatile SingularAttribute<Lock, Instant> validUntil;

}

