package covidSystem;

public class CovidSystemClass implements CovidSystem {

	public CovidSystemClass() {
		
	}

	@Override
	public void insertUser(String login, String name, int age, String address, String profession) throws UserExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUser(String login) throws UserNotExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertContact(String login1, String login2) throws UserNotExists, ContactExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContact(String login1, String login2) throws UserNotExists, ContactNotExists, ContactNotRemoved {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listContacts(String login) throws UserNotExists, NoContacts {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertGroup(String group, String description) throws GroupExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showGroup(String group) throws GroupNotExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGroup(String group) throws GroupNotExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeGroup(String login, String group) throws UserNotExists, GroupNotExists, SubscriptionExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubscription(String login, String group)
			throws UserNotExists, GroupNotExists, SubscriptionNotExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listParticipants(String group) throws GroupNotExists, NoParticipants {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMessage(String login, String title, String text, String url) throws UserNotExists {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Message> listContactMessages(String login1, String login2)
			throws UserNotExists, ContactNotExists, NoContactMessages {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Message> listGroupMessages(String group, String login)
			throws GroupNotExists, UserNotExists, SubscriptionNotExists, NoGroupMessages {
		// TODO Auto-generated method stub
		return null;
	}
}
