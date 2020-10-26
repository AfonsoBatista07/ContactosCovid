package covidSystem;
import covidSystem.exceptions.*;
import dataStructures.Iterator;
import user.User;
import group.Group;
import message.Message;
import user.exceptions.*;
import group.exceptions.*;

public interface CovidSystem {
	
	/**
	 * @param login
	 * @param name
	 * @param age
	 * @param address
	 * @param profession
	 * @throws UserAlreadyExistException
	 */
	void insertUser(String login, String name, int age, String address, String profession) 
			throws UserAlreadyExistException;
	
	/**
	 * @param login
	 * @return
	 * @throws UserDoesntExistException
	 */
	User showUser(String login) throws UserDoesntExistException;
	
	/**
	 * @param login1
	 * @param login2
	 * @throws UserDoesntExistException
	 * @throws UsersAlreadyFriendsException
	 */
	void insertContact(String login1, String login2) 
			throws UserDoesntExistException, UsersAlreadyFriendsException;
	
	/**
	 * @param login1
	 * @param login2
	 * @throws UserDoesntExistException
	 * @throws UserNotFriendException
	 * @throws SameUserException
	 */
	void removeContact(String login1, String login2) 
			throws UserDoesntExistException, UserNotFriendException, SameUserException;
	
	/**
	 * @param login
	 * @return
	 * @throws UserDoesntExistException
	 * @throws UserNoContactsException
	 */
	Iterator<User> listContacts(String login)
			throws UserDoesntExistException, UserNoContactsException;
	
	/**
	 * @param groupName
	 * @param description
	 * @throws GroupAlreadyExistsException
	 */
	void insertGroup(String groupName, String description) throws GroupAlreadyExistsException;
	
	/**
	 * @param groupName
	 * @return
	 * @throws GroupDoesntExistException
	 */
	Group showGroup(String groupName) throws GroupDoesntExistException;
	
	/**
	 * @param groupName
	 * @throws GroupDoesntExistException
	 */
	void removeGroup(String groupName) throws GroupDoesntExistException;
	
	/**
	 * @param login
	 * @param groupName
	 * @throws UserDoesntExistException
	 * @throws GroupDoesntExistException
	 * @throws UserAlreadyInGroupException
	 */
	void subscribeGroup(String login, String groupName) 
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException;
	
	/**
	 * @param login
	 * @param groupName
	 * @throws UserDoesntExistException
	 * @throws GroupDoesntExistException
	 * @throws UserIsntInGroupException
	 */
	void removeSubscription(String login, String groupName)
		throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException;
	
	/**
	 * @param groupName
	 * @return
	 * @throws UserDoesntExistException
	 * @throws GroupIsEmptyException
	 */
	Iterator<User> listParticipants(String groupName)
			throws UserDoesntExistException, GroupIsEmptyException;
	
	/**
	 * @param login
	 * @param title
	 * @param text
	 * @param url
	 * @throws UserDoesntExistException
	 */
	void insertMessage(String login, String title, String text, String url)
		throws UserDoesntExistException;
	
	/**
	 * @param login1
	 * @param login2
	 * @return
	 * @throws UserDoesntExistException
	 * @throws UserNotFriendException
	 * @throws NoFriendMessagesException
	 */
	Iterator<Message> listContactMessages(String login1, String login2)
		throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException; 
	
	/**
	 * @param groupName
	 * @param login
	 * @return
	 * @throws UserNotFriendException
	 * @throws UserDoesntExistException
	 * @throws UserIsntInGroupException
	 * @throws NoGroupMessagesException
	 */
	Iterator<Message> listGroupMessages(String groupName, String login)
			throws UserNotFriendException, UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException; 
}
