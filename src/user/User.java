package user;

import group.Group;

public interface User {
	
	String getName();
	
	String getProfession();
	
	String getAddress();
	
	int getAge();
	
	void addGroup(Group group);
}
