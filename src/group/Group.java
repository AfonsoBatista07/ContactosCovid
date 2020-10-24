package group;

import user.User;

public interface Group extends Comparable<Group>{
	
	String getName();
	
	String getDescritpion();
	
	void addMember(User user);
	
	void removeMember(User user);
}
