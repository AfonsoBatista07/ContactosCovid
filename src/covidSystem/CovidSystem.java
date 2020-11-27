package covidSystem;
import covidSystem.exceptions.*;
import dataStructures.Entry;
import dataStructures.Iterator;
import user.User;
import group.Group;
import message.Message;
import user.exceptions.*;
import group.exceptions.*;

/**
 * Interface of the CovidSystemClass.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface CovidSystem {
	
	/**
	 * 
	 * @param login - User login (its unique).
	 * @param name - User name.
	 * @param age - User age.
	 * @param address - User address.
	 * @param profession - User profession.
	 * @throws UserAlreadyExistException - If already exists a user with the same login. 
	 */
	void insertUser(String login, String name, int age, String address, String profession) 
			throws UserAlreadyExistException;
	
	/**
	 * @param login - User login (its unique).
	 * @return the wanted user.
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 */
	User showUser(String login) throws UserDoesntExistException;
	
	/**
	 * 
	 * @param login1 - login of the first user.
	 * @param login2 - login of the second user.
	 * @throws UserDoesntExistException - If one of the wanted users doesn't exist.
	 * @throws UsersAlreadyFriendsException - If the two users are already friends.
	 */
	void insertContact(String login1, String login2) 
			throws UserDoesntExistException, UsersAlreadyFriendsException;
	
	/**
	 * 
	 * @param login1 - login of the first user.
	 * @param login2 - login of the second user. 
	 * @throws UserDoesntExistException - If one of the wanted users doesn't exist.
	 * @throws UserNotFriendException - If the two users are not yet friends.
	 * @throws SameUserException - If the first and second users are the same.
	 */
	void removeContact(String login1, String login2) 
			throws UserDoesntExistException, UserNotFriendException, SameUserException;
	
	/**
	 * @param login - User login (its unique).
	 * @return an Iterator of all the user contacts.
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 * @throws UserNoContactsException - If the user doesn't have any contacts.
	 */
	Iterator<Entry<String, User>> listContacts(String login) 
			throws UserDoesntExistException, UserNoContactsException;
	
	/**
	 * 
	 * @param groupName - Group name (its unique).
	 * @param description - The group description.
	 * @throws GroupAlreadyExistsException - If already exists a group with the same name.
	 */
	void insertGroup(String groupName, String description) throws GroupAlreadyExistsException;
	
	/**
	 * @param groupName - Group name (its unique).
	 * @return the wanted Group.
	 * @throws GroupDoesntExistException - If the wanted group doesn't exist.
	 */
	Group showGroup(String groupName) throws GroupDoesntExistException;
	
	/**
	 * 
	 * @param groupName - Group name (its unique).
	 * @throws GroupDoesntExistException - If the wanted group doesn't exist.
	 */
	void removeGroup(String groupName) throws GroupDoesntExistException;
	
	/**
	 * 
	 * @param login - User login (its unique).
	 * @param groupName - Group name (its unique).
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 * @throws GroupDoesntExistException - If the wanted group doesn't exist.
	 * @throws UserAlreadyInGroupException - If the user is already in group.
	 */
	void subscribeGroup(String login, String groupName) 
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException;
	
	/**
	 * 
	 * @param login - User login (its unique).
	 * @param groupName - Group name (its unique).
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 * @throws GroupDoesntExistException - If the wanted group doesn't exist.
	 * @throws UserIsntInGroupException - If the user isn't in the group.
	 */
	void removeSubscription(String login, String groupName)
		throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException;
	
	/**
	 * @param groupName - Group name (its unique).
	 * @returnan Iterator with all the Users.
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 * @throws GroupIsEmptyException - If the group is empty.
	 */
	Iterator<Entry<String, User>> listParticipants(String groupName)
			throws UserDoesntExistException, GroupIsEmptyException;
	
	/**
	 * 
	 * @param login - User login (its unique).
	 * @param title - Message title.
	 * @param text - Message text.
	 * @param url - Message url.
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 */
	void insertMessage(String login, String title, String text, String url)
		throws UserDoesntExistException;
	
	/**
	 * @param login1 - login of the first user.
	 * @param login2 - login of the second user.
	 * @return an Iterator with all the messages of the first user.
	 * @throws UserDoesntExistException - If one of the wanted users doesn't exist.
	 * @throws UserNotFriendException - If the two users are not yet friends.
	 * @throws NoFriendMessagesException - If the first user doesn't have messages.
	 */
	Iterator<Message> listContactMessages(String login1, String login2)
		throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException; 
	
	/**
	 * @param groupName - Group name (its unique).
	 * @param login - User login (its unique).
	 * @return an Iterator with all the group messages.
	 * @throws GroupDoesntExistException - If the wanted group doesn't exist.
	 * @throws UserDoesntExistException - If the wanted user doesn't exist.
	 * @throws UserIsntInGroupException - If the user isn't in the group. 
	 * @throws NoGroupMessagesException - If the group doesn't have any messages.
	 */
	Iterator<Message> listGroupMessages(String groupName, String login)
			throws GroupDoesntExistException, UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException; 
}
