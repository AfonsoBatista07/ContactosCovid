import java.util.Scanner;

import covidSystem.*;
import covidSystem.exceptions.*;
import user.exceptions.*;
import group.exceptions.*;
 
/** 
 * Main Program. 
 * @author Afonso Batista 57796 
 * @author Joao Jorge 57994 
 */ 
public class Main { 
 
	/* Commands Constants */ 
	private static final String ADD_USER = "IU"; 
	private static final String USER_DATA = "DU"; 
	private static final String NEW_CONTACT = "IC"; 
	private static final String REMOVE_CONTACT = "RC"; 
	private static final String LIST_CONTACTS = "LC"; 
	private static final String NEW_GROUP = "IG"; 
	private static final String GROUP_DATA = "DG"; 
	private static final String REMOVE_GROUP = "RG"; 
	private static final String NEW_GROUP_USER = "IP"; 
	private static final String REMOVE_GROUP_USER = "RP"; 
	private static final String LIST_GROUP_USERS = "LP"; 
	private static final String NEW_MESSAGE = "IM"; 
	private static final String LIST_USER_MESSAGES = "LMC"; 
	private static final String LIST_GROUP_MESSAGES = "LMG"; 
	private static final String EXIT = "FIM"; 
	 
	/* Success Constants */ 
 	private static final String SUCCESS_ADD_USER = "Registo de utilizador executado.\n"; 
 	private static final String SUCCESS_USER_DATA = "%s %s %d\n%s %s\n"; 
 	private static final String SUCCESS_NEW_CONTACT = "Registo de contacto executado.\n"; 
 	private static final String SUCCESS_REMOVE_CONTACT = "Remocao de contacto executada.\n"; 
 	private static final String SUCCESS_LIST_CONTACTS = "%s %s\n"; 
 	private static final String SUCCESS_NEW_GROUP = "Registo de grupo executado.\n"; 
 	private static final String SUCCESS_GROUP_DATA = "%s\n%s\n"; 
 	private static final String SUCCESS_REMOVE_GROUP = "Remocao de grupo executada.\n"; 
 	private static final String SUCCESS_NEW_GROUP_USER = "Registo de participante executado.\n"; 
 	private static final String SUCCESS_REMOVE_GROUP_USER = "Remocao de aderencia executada.\n"; 
 	private static final String SUCCESS_LIST_GROUP_USERS = "%s %s\n"; 
 	private static final String SUCCESS_NEW_MESSAGE = "Registo de mensagem executado.\n"; 
 	private static final String SUCCESS_LIST_MESSAGES = "%s\n%s\n%s\n";
 	private static final String SUCCESS_EXIT = "Obrigado. Ate a proxima.\n"; 
 	 
 	/* Error Constants */ 
 	private static final String ERROR_USER_ALREADY_EXIST = "Utilizador ja existente.\n"; 
 	private static final String ERROR_USER_DOESNT_EXIST = "Inexistencia do utilizador referido.\n"; 
 	private static final String ERROR_USERS_ALREADY_FRIENDS = "Existencia do contacto referido.\n"; 
 	private static final String ERROR_USERS_ARENT_FRIENDS = "Inexistencia do contacto referido.\n"; 
 	private static final String ERROR_CANT_REMOVE_CONTACT = "Contacto nao pode ser removido.\n"; 
 	private static final String ERROR_USER_NO_CONTACTS = "Inexistencia de contactos.\n"; 
 	private static final String ERROR_GROUP_ALREADY_EXIST = "Grupo ja existente.\n"; 
 	private static final String ERROR_GROUP_DOESNT_EXIST = "Inexistencia do grupo referido.\n";
 	private static final String ERROR_GROUP_NO_MESSAGES = "Grupo nao tem mensagens.";
 	private static final String ERROR_USER_ALREADY_IN_GROUP = "Existencia de aderencia referida.\n"; 
 	private static final String ERROR_USER_ARENT_IN_GROUP = "Inexistencia de aderencia referida.\n"; 
 	private static final String ERROR_GROUP_IS_EMPTY = "Inexistencia de participantes.\n"; 
 	private static final String ERROR_CONTACT_NO_MESSAGES = "Contacto nao tem mensagens.\n";
	 
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in); 
		CovidSystem csys = new CovidSystemClass(); 
		String cm; 
		do{
			System.out.print("> ");
			cm = readOption(in); 
			exeOption(in, csys, cm); 
		} while(!cm.equals(EXIT)); 
		in.close(); 
		 
	} 
	 
	/** 
	 * Read the user input. 
	 * @param in - Scanner
	 * @return the user input.
	 */ 
	private static String readOption(Scanner in) { 
		return in.next().toUpperCase(); 
	} 
	 
	/** 
	 * Execute one available command. 
	 * @param in - Scanner
	 * @param csys - CovidSystem 
	 * @param option - the user input 
	 */ 
	private static void exeOption(Scanner in, CovidSystem csys, String option) { 
		switch(option) { 
			case ADD_USER: 
				addUser(in, csys); 
				break; 
			case USER_DATA: 
				userData(in, csys);
				break; 
			case NEW_CONTACT: 
				addContact(in, csys);
				break; 
			case REMOVE_CONTACT: 
				removeContact(in, csys);
				break; 
			case LIST_CONTACTS: 
				listContacts(in, csys);
				break; 
			case NEW_GROUP: 
				newGroup(in, csys);
				break; 
			case GROUP_DATA:
				groupData(in, csys);
				break; 
			case REMOVE_GROUP: 
				removeGroup(in, csys);
				break; 
			case NEW_GROUP_USER: 
				addUserToGroup(in, csys);
				break; 
			case REMOVE_GROUP_USER: 
				removeUserFromGroup(in, csys);
				break; 
			case LIST_GROUP_USERS: 
				listGroupUsers(in, csys);
				break; 
			case NEW_MESSAGE: 
				newMessage(in, csys);
				break; 
			case LIST_USER_MESSAGES: 
				listUserMessages(in, csys);
				break; 
			case LIST_GROUP_MESSAGES: 
				listGroupMessages(in, csys);
				break;  
			case EXIT: 
				exit(); 
				break; 
		} 
	} 
	
	/** 
	 * Register a new User on System. 
	 * @param in - Scanner 
	 * @param csys - CovidSystem 
	 */ 
	private static void addUser(Scanner in, CovidSystem csys) { 
		String userName = in.next(); int age = in.nextInt();
		String locality = in.next(); String profession = in.next();
		in.nextLine();
		
		try {
			
			System.out.println(SUCCESS_ADD_USER);
		} catch(UserAlreadyExistException e) {
			System.out.println(ERROR_USER_ALREADY_EXIST);
		}
	} 
	
	/**
	 * Query the data of a User.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void userData(Scanner in, CovidSystem csys) {
		// TODO 
		
		try {
			
			System.out.println(SUCCESS_USER_DATA);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		}
		
	}
	
	/**
	 * Register a new contact between two Users.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void addContact(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_NEW_CONTACT);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(UsersAlreadyFriendsException e) {
			System.out.println(ERROR_USERS_ALREADY_FRIENDS);
		}
	}
	
	/**
	 * Removes a contact between two Users.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void removeContact(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_REMOVE_CONTACT);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(UserNotFriendException e) {
			System.out.println(ERROR_USERS_ARENT_FRIENDS);
		} catch(SameUserException e) {
			System.out.println(ERROR_CANT_REMOVE_CONTACT);
		}
	}
	
	/**
	 * List all the contacts of a User.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void listContacts(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_LIST_CONTACTS);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(UserNoContactsException e) {
			System.out.println(ERROR_USER_NO_CONTACTS);
		}
	}
	
	/**
	 * Registers a new Group on System.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void newGroup(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_NEW_GROUP);
		} catch(GroupAlreadyExistsException e) {
			System.out.println(ERROR_GROUP_ALREADY_EXIST);
		}
	}
	
	/**
	 * Query the data of a group.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void groupData(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_GROUP_DATA);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		}
	}
	
	/**
	 * Removes a group from System.
	 * @param in - Scanner 
	 * @param csys - CovidSyste
	 */
	private static void removeGroup(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_REMOVE_GROUP);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		}
	}
	
	/**
	 * Adds a User to a Group.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void addUserToGroup(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_NEW_GROUP_USER);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		} catch(UserAlreadyInGroupException e) {
			System.out.println(ERROR_USER_ALREADY_IN_GROUP);
		}
	}
	
	/**
	 * Removes a User from a Group.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void removeUserFromGroup(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_REMOVE_GROUP_USER);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		} catch(UserIsntInGroupException e) {
			System.out.println(ERROR_USER_ARENT_IN_GROUP);
		}
	}
	
	/**
	 * Lists all the Users from a Group.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void listGroupUsers(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_LIST_GROUP_USERS);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		} catch(GroupIsEmptyException e) {
			System.out.println(ERROR_GROUP_IS_EMPTY);
		}
	}
	
	/**
	 * Registers a new associated Message to a User.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void newMessage(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_NEW_MESSAGE);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		}
	}

	/**
	 * Lists all the User Messages.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void listUserMessages(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_LIST_MESSAGES);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(UserNotFriendException e) {
			System.out.println(ERROR_USERS_ARENT_FRIENDS);
		} catch(NoFriendMessagesException e) {
			System.out.println(ERROR_CONTACT_NO_MESSAGES);
		}
	}
	
	/**
	 * Lists all the Messages of a Group.
	 * @param in - Scanner 
	 * @param csys - CovidSystem
	 */
	private static void listGroupMessages(Scanner in, CovidSystem csys) {
		// TODO 
		try {
			
			System.out.println(SUCCESS_LIST_MESSAGES);
		} catch(GroupDoesntExistException e) {
			System.out.println(ERROR_GROUP_DOESNT_EXIST);
		} catch(UserDoesntExistException e) {
			System.out.println(ERROR_USER_DOESNT_EXIST);
		} catch(UserIsntInGroupException e) {
			System.out.println(ERROR_USER_ARENT_IN_GROUP);
		} catch(NoGroupMessagesException e) {
			System.out.println(ERROR_GROUP_NO_MESSAGES);
		}
	}
 
	/** 
	 * Terminates the execution of the program. 
	 */ 
	private static void exit() { 
		System.out.println(SUCCESS_EXIT); 
	} 
} 
 
