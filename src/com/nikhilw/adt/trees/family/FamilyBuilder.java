package com.nikhilw.adt.trees.family;

/**
 * Builds a family tree as in Star Wars. And traces the chosen one.
 * 
 * The two biological parents of the person are always going to share a
 * relationship; complexity arises when adoption and cloning are involved!
 * 
 * Whearas cloning can be represented by keeping both people in the relationship
 * same as the "father"; to represent Jango/Boba and the clones.
 * 
 * But Some thought needs to be put in to represent 'Organa' lineage of Leia.
 * Should we allow multiple parentages? or should the parentages be named as
 * Biological, Adoption etc.
 * 
 * @author nikhil
 */
public class FamilyBuilder {

	public static void main(String[] args) {
		Person anakin = startTheStarWars();
		findAnakinToLuke(anakin);
	}

	private static Person startTheStarWars() {
		Person anakin = new Person("Anakin", null);
		Person padme = new Person("Padme", null);
		Relation r1 = new Relation(anakin, padme); // sets up bi-directional

		new Person("Luke", r1); // sets up bi-directional
		new Person("Leia", r1); // sets up bi-directional
		
		// Waiting for episode 7!
		
		return anakin;
	}
	
	private static void findAnakinToLuke(Person anakin) {
		for (Relation rel : anakin.getRelationships()) {
			for (Person person : rel.getChildren()) {
				if (person.getName().equals("Luke")) {
					System.out.println("Luke, I am your father!");
				}
			}
		}
	}
}
