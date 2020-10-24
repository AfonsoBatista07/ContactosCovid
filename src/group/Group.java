package group;

import dataStructures.Iterator;
import group.exceptions.GroupIsEmptyException;
import user.User;

public interface Group extends Comparable<Group>{
	
	String getName();
	
	String getDescritpion();
	
	void addMember(User user);
	
	void removeMember(User user);
	
	Iterator<User> listMembers() throws GroupIsEmptyException;
}
