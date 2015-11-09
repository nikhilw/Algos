package com.nikhilw.designpatterns.singleton;

import java.io.Serializable;

/**
 * Hard-to-get-it-right implementation of a Singleton supporting lazy
 * instantiation.
 * 
 * Although the name is CorrectSingleton, its only an attempt at being correct,
 * like many other but possibly only place where you can find all checks and
 * guards together.
 * 
 * @author nikhil
 */
public class CorrectSingleton implements Serializable, Cloneable {
	private static final long serialVersionUID = 6462207486558031828L; // Ensure compatibility and versioning of class
	
	/*
	 * Marking volatile is necessary for avoiding the threads from creating
	 * their own copies, even with double checked locking.
	 */
	private static volatile CorrectSingleton INSTANCE = null; 
	int i = 0;
	
	/*
	 * Guard against 'reflection' to create a new instance.
	 */
	private CorrectSingleton() {
		if (INSTANCE != null) {
			throw new IllegalStateException();
		}
		i = 10;
	}
	
	/*
	 * Synchronises only on the critical section, and uses double checked
	 * locking to ensure that all get requests are not synchronised once the
	 * instance is created.
	 */
	public static CorrectSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (CorrectSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new CorrectSingleton();
				}
			}
		}
		return INSTANCE;
	}
	
	/**
	 * Yeah, why dont you try cloning me?
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		
	}
	
	/**
	 * Guard against "serialize-deserialize" to create another copy of the
	 * object, this method is called after the deserialization is done, when
	 * resolving the objects after reading from the readStream.
	 * 
	 * @return
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}

// Have you covered?
// Ensured correct copies in multi-threaded? volatile
// Synchronization
// Double checked locking
// Cloning
// Serialization
// Reflection