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
		return getUser(login).contactIterator();
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
		return getGroup(group).listMembers();
	}

	@Override
	public void insertMessage(String login, String title, String text, String url) throws UserDoesntExistException {
		
	}

	@Override
	public Iterator<Message> listContactMessages(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Message> listGroupMessages(String group, String login) throws UserNotFriendException,
			UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException {
		// TODO Auto-generated method stub
		return null;
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
}
