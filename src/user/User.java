package user;

import dataStructures.Iterator;
import group.Group;
import message.Message;
import user.exceptions.*;

/**
 * Interface of the UserClass.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface User extends Comparable<User> {
	
	
	/**
	 * @return User login.
	 */
	String getLogin();
	
	/**
	 * @return User name.
	 */
	String getName();
	
	/**
	 * @return User profession.
	 */
	String getProfession();
	
	/**
	 * @return User address.
	 */
	String getAddress();
	
	/**
	 * @return User age.
	 */
	int getAge();
	
	/**
	 * Adds a Group to the User group List.
	 * @param group - Group
	 * @throws UserAlreadyInGroupException if the User is already in the given group.
	 * @throws UserMaxedGroupsException if the User is already in 10 groups.
	 */
	void addGroup(Group group) throws UserAlreadyInGroupException, UserMaxedGroupsException;
	
	/**
	 * Removes a Group from the User group List.
	 * @param group - Group
	 * @throws UserIsntInGroupException if the User isnt in the group.
	 */
	void removeGroup(Group group);
	
	/**
	 * Adds a Contact to the User contact List.
	 * @param user - User
	 * @throws UsersAlreadyFriendsException if the given user is already a contact.
	 */
	void newContact(User user) throws UsersAlreadyFriendsException;
	
	/**
	 * Removes a Contact from the User contact List.
	 * @param user
	 * @throws UserNotFriendException if the given user isnt a contact.
	 */
	void removeContact(User user) throws UserNotFriendException;
	
	/**
	 * Adds a message to the User feed.
	 * @param message - Message
	 */
	void recieveMessage(Message message);
	
	/**
	 * Verifies if the user is a contact.
	 * @param user - User
	 * @return true if he is, false if not.
	 */
	boolean isContact(User user);
	
	/**
	 * Verifies if the User is part of the given group.
	 * @param group - Group
	 * @return true if he is, false if not.
	 */
	boolean inGroup(Group group);
	
	/**
	 * @return Iterator of the User Contacts.
	 */
	Iterator<User> listContacts();
	
	/**
	 * @return Iterator of the User Messages.
	 */
	Iterator<Message> listMessages();
	
	/**
	 * @return Iterator of the User Group.
	 */
	Iterator<Group> listGroups();
}
