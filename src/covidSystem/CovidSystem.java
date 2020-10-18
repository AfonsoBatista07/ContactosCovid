package covidSystem;
import covidSystem.exceptions.*;
import user.exceptions.*;
import group.exceptions.*;

public interface CovidSystem {
	
	void insertUser(String login, String name, int age, String address, String profession) 
			throws UserExists;
	
	*** A VOSSA INTERFACE AQUI*** showUser(String login) throws UserDoesntExistException;
	
	void insertContact(String login1, String login2) 
			throws UserNotExists, ContactExists;
	
	void removeContact(String login1, String login2) 
			throws UserNotExists, ContactNotExists, ContactNotRemoved;
	
	//TODO
	Iterator<*** A VOSSA INTERFACE AQUI***> listContacts(String login)
			throws UserNotExists, NoContacts;
	
	void insertGroup(String group, String description) throws GroupExists;
	
	*** A VOSSA INTERFACE AQUI*** showGroup(String group) throws UserDoesntExistException;
	
	void removeGroup(String group) throws UserDoesntExistException;
	
	void subscribeGroup(String login, String group) 
			throws UserDoesntExistException, GroupNotExists, SubscriptionExists;
	
	void removeSubscription(String login, String group)
		throws UserDoesntExistException, GroupNotExists, SubscriptionNotExists;
	
	//TODO
	Iterator<*** A VOSSA INTERFACE AQUI***> listParticipants(String group)
			throws UserDoesntExistException, NoParticipants;

	void insertMessage(String login, String title, String text, String url)
		throws UserDoesntExistException;
	
	Iterator<Message> listContactMessages(String login1, String login2)
		throws UserDoesntExistException, ContactNotExists, NoContactMessages; 
	
	Iterator<Message> listGroupMessages(String group, String login)
			throws GroupNotExists, UserNotExists, SubscriptionNotExists, NoGroupMessages; 
}
