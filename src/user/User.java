package user;

import group.Group;

public interface User extends Comparable<User> {
	
	String getLogin();
	
	String getName();
	
	String getProfession();
	
	String getAddress();
	
	int getAge();
	
	void addGroup(Group group);
}
