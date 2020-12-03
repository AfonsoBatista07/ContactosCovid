package group;

import dataStructures.Iterator;
import message.Message;
import user.User;

/**
 * Interface of the GroupClass.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface Group extends Comparable<Group>{
	
	/**
	 * @return Group name.
	 */
	String getName();
	
	/**
	 * @return Group Description.
	 */
	String getDescritpion();
	
	/**
	 * Adds a user to the the list of group members.
	 * @param user - User
	 */
	void addMember(User user);
	
	/**
	 * Removes a user from the list of group members.
	 * @param user - User
	 */
	void removeMember(User user);
	
	/**
	 * Adds the given message to the group message list.
	 * @param message - Message
	 */
	void recieveMessage(Message message);
	
	/**
	 * @return Iterator of the group members.
	 */
	 Iterator<User> listMembers();
	
	/**
	 * @return Iterator of the group messages.
	 */
	Iterator<Message> listMessages();
}
