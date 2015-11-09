package com.nikhilw.adt.trees.family;

import java.util.HashSet;
import java.util.Set;

/**
 * Holds a person and its relationships. The relationship the person comes from
 * is nullable, basically, for the scope of the tree; as none the roots of the
 * tree can have parents in this scope. Two people can have same name, so
 * equality is be object and not by value.
 * 
 * @author nikhil
 */
public class Person {
	private String name;
	private Relation parentage;
	private Set<Relation> relationships;
	
	public Person(String name, Relation parentage) {
		this.name = name;
		this.parentage = parentage;
		relationships = new HashSet<>();
		
		if (this.parentage != null) {
			this.parentage.addChild(this);
		}
	}

	public Relation getParentage() {
		return parentage;
	}

	public Set<Relation> getRelationships() {
		return relationships;
	}
	
	public String getName() {
		return name;
	}

	public void addRelationship(Relation relationship) {
		relationships.add(relationship);
	}
}
