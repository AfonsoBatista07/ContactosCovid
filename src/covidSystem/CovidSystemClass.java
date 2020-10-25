package covidSystem;

import group.*;
import message.*;
import user.*;
import dataStructures.*;
import user.exceptions.*;
import covidSystem.exceptions.*;
import group.exceptions.*;

public class CovidSystemClass implements CovidSystem {
	
	OrderedSequence<User> users;
	OrderedSequence<Group> groups;
	
	public CovidSystemClass() {
		users = new OrderedSequenceClass<User>();
		groups = new OrderedSequenceClass<Group>();
	}

	@Override
	public void insertUser(String login, String name, int age, String address, String profession)
			throws UserAlreadyExistException {
		
		User newUser = new UserClass(login, name, age, address, profession);
		if(users.get(newUser)!=null) throw new UserAlreadyExistException();
		users.insert(newUser);
	}

	@Override
	public User showUser(String login) throws UserDoesntExistException {
		return getUser(login);
	}

	@Override
	public void insertContact(String login1, String login2)
			throws UserDoesntExistException, UsersAlreadyFriendsException {
		
		User user1 = getUser(login1); User user2 = getUser(login2);
		user1.newContact(user2); user2.newContact(user1);
	}

	@Override
	public void removeContact(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, SameUserException {
		
		User user1 = getUser(login1); User user2 = getUser(login2);
		if(login1.equals(login2)) throw new SameUserException();
		
		user1.removeContact(user2); user2.removeContact(user1);
		
	}

	@Override
	public Iterator<User> listContacts(String login) throws UserDoesntExistException, UserNoContactsException {
		Iterator<User> it = getUser(login).listContacts();
		if(!it.hasNext()) throw new UserNoContactsException();
		return it;
	}

	@Override
	public void insertGroup(String group, String description) throws GroupAlreadyExistsException {
		Group newGroup = new GroupClass(group, description);
		if(groups.get(newGroup)!=null) throw new GroupAlreadyExistsException();
		
		groups.insert(newGroup);
	}

	@Override
	public Group showGroup(String group) throws GroupDoesntExistException {
		return getGroup(group);
	}

	@Override
	public void removeGroup(String group) throws GroupDoesntExistException {
		Group objGroup = getGroup(group);
		Iterator<User> it = objGroup.listMembers();
		while(it.hasNext()) {
			it.next().removeGroup(objGroup);
		}
		groups.remove(objGroup);
	}

	@Override
	public void subscribeGroup(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException {
		User user = getUser(login); Group objGroup = getGroup(group);
		user.addGroup(objGroup); objGroup.addMember(user);
	}

	@Override
	public void removeSubscription(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException {
		User user = getUser(login); Group objGroup = getGroup(group);
		user.removeGroup(objGroup); objGroup.removeMember(user);
	}

	@Override
	public Iterator<User> listParticipants(String group) throws GroupDoesntExistException, GroupIsEmptyException {
		Iterator<User> it = getGroup(group).listMembers();
		if(!it.hasNext()) throw new GroupIsEmptyException();
		return it;
	}

	@Override
	public void insertMessage(String login, String title, String text, String url) throws UserDoesntExistException {
		Message message = new MessageClass(title, text, url);
		User user = getUser(login);
		user.recieveMessage(message);
		Iterator<Group> itGroups = user.listGroups(); sendToGroups(itGroups, message);
		Iterator<User> itContacts = user.listContacts(); sendToContacts(itContacts, message);
		
	}

	@Override
	public Iterator<Message> listContactMessages(String login1, String login2) throws UserDoesntExistException,
			UserNotFriendException, NoFriendMessagesException {
		User user1 = getUser(login1); User user2 = getUser(login2);
		if(!user1.isContact(user2)) throw new UserNotFriendException();
		
		Iterator<Message> it = user1.listMessages();
		if(!it.hasNext()) throw new NoFriendMessagesException();
		
		return it;
	}

	@Override
	public Iterator<Message> listGroupMessages(String group, String login) throws GroupDoesntExistException,
			UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException {
		Group objGroup = getGroup(group);
		User user = getUser(login);
		if(!user.inGroup(objGroup)) throw new UserIsntInGroupException();
		
		Iterator<Message> it = objGroup.listMessages();
		if(!it.hasNext()) throw new NoGroupMessagesException();
		
		return it;
	}
	
	// ns se se pode meter a exception assim mas ya
	private User getUser(String login) throws UserDoesntExistException {
		User fakeUser = new UserClass(login, null, 0, null, null);
		User realUser = users.get(fakeUser);
		if(realUser == null) throw new UserDoesntExistException();
		return realUser;
	}
	
	private Group getGroup(String group) throws GroupDoesntExistException {
		Group fakeGroup = new GroupClass(group, null);
		Group realGroup = groups.get(fakeGroup);
		if(realGroup == null) throw new GroupDoesntExistException();
		return realGroup;
	}
	
	private void sendToGroups(Iterator<Group> itGroups, Message message) {
		while(itGroups.hasNext())
			itGroups.next().recieveMessage(message);
	}
	
	private void sendToContacts(Iterator<User> itContacs, Message message) {
		while(itContacs.hasNext())
			itContacs.next().recieveMessage(message);
	}
}
