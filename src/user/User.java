package user;

import dataStructures.Iterator;
import group.Group;
import message.Message;

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
	
	void recieveMessage(Message message);
	
	boolean isContact(User user);
	
	boolean inGroup(Group group);
	
	Iterator<User> listContacts();
	
	Iterator<Message> listMessages();
	
	Iterator<Group> listGroups();
}
