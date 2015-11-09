package com.nikhilw.adt.trees.family;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a relationship between two people. Any two people can have
 * multiple relationships, considering the scenario of re-marriage to the same
 * person. Equality is be object and not by value.
 * 
 * @author nikhil
 */
public class Relation {
	private Person person1;
	private Person person2;
	private Set<Person> children;
	
	public Relation(Person person1, Person person2) {
		this.person1 = person1;
		this.person2 = person2;
		this.children = new HashSet<>();
		
		this.person1.addRelationship(this);
		this.person2.addRelationship(this);
	}

	public Person getPerson1() {
		return person1;
	}

	public Person getPerson2() {
		return person2;
	}
	
	public Set<Person> getChildren() {
		return children;
	}

	public void addChild(Person child) {
		children.add(child);
	}
}
