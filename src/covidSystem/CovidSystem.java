package covidSystem;
import covidSystem.exceptions.*;
import user.User;
import user.exceptions.*;
import group.Group;
import group.exceptions.*;

public interface CovidSystem {
	
	void insertUser(String login, String name, int age, String address, String profession) 
			throws UserAlreadyExistException;
	
	User showUser(String login) throws UserDoesntExistException;
	
	void insertContact(String login1, String login2) 
			throws UserDoesntExistException, UsersAlreadyFriendsException;
	
	void removeContact(String login1, String login2) 
			throws UserDoesntExistException, UserNotFriendException, SameUserException;
	
	//TODO
	User listContacts(String login)
			throws UserDoesntExistException, UserNoContactsException;
	
	void insertGroup(String group, String description) throws GroupAlreadyExistsException;
	
	Group showGroup(String group) throws UserDoesntExistException;
	
	void removeGroup(String group) throws UserDoesntExistException;
	
	void subscribeGroup(String login, String group) 
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException;
	
	void removeSubscription(String login, String group)
		throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException;
	
	//TODO
	Iterator<*** A VOSSA INTERFACE AQUI***> listParticipants(String group)
			throws UserDoesntExistException, GroupIsEmptyException;

	void insertMessage(String login, String title, String text, String url)
		throws UserDoesntExistException;
	
	Iterator<Message> listContactMessages(String login1, String login2)
		throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException; 
	
	Iterator<Message> listGroupMessages(String group, String login)
			throws UserNotFriendException, UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException; 
}
