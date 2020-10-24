package group;

import dataStructures.Iterator;
import message.Message;
import user.User;

public interface Group extends Comparable<Group>{
	
	String getName();
	
	String getDescritpion();
	
	void addMember(User user);
	
	void removeMember(User user);
	
	void recieveMessage(Message message);
	
	Iterator<User> listMembers();
	
	Iterator<Message> listMessages();
}
