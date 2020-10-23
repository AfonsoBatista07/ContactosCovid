package covidSystem;
import covidSystem.exceptions.*;
import dataStructures.Iterator;
import user.User;
import group.Group;
import message.Message;
import user.exceptions.*;
import group.exceptions.*;

public interface CovidSystem {
	
	void insertUser(String login, String name, int age, String address, String profession) 
			throws UserAlreadyExistException;
	
	User showUser(String login) throws UserDoesntExistException;
	
	void insertContact(String login1, String login2) 
			throws UserDoesntExistException, UsersAlreadyFriendsException;
	
	void removeContact(String login1, String login2) 
			throws UserDoesntExistException, UserNotFriendException, SameUserException;
	
	User listContacts(String login)
			throws UserDoesntExistException, UserNoContactsException;
	
	void insertGroup(String groupName, String description) throws GroupAlreadyExistsException;
	
	Group showGroup(String groupName) throws UserDoesntExistException;
	
	void removeGroup(String groupName) throws UserDoesntExistException;
	
	void subscribeGroup(String login, String groupName) 
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException;
	
	void removeSubscription(String login, String groupName)
		throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException;
	
	Iterator<User> listParticipants(String groupName)
			throws UserDoesntExistException, GroupIsEmptyException;
	
	void insertMessage(String login, String title, String text, String url)
		throws UserDoesntExistException;
	
	Iterator<Message> listContactMessages(String login1, String login2)
		throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException; 
	
	Iterator<Message> listGroupMessages(String groupName, String login)
			throws UserNotFriendException, UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException; 
}
