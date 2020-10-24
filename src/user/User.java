package user;

import dataStructures.Iterator;
import group.Group;

public interface User extends Comparable<User> {
	
	String getLogin();
	
	String getName();
	
	String getProfession();
	
	String getAddress();
	
	int getAge();
	
	void addGroup(Group group);
	
	void removeGroup(Group group);
	
	void newContact(User user);
	
	void removeContact(User user);
	
	Iterator<User> contactIterator();
}
