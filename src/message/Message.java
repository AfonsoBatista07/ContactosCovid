package message;

/**
 * Interface of the MessageClass.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public interface Message {
	
	/**
	 * @return Message title.
	 */
	String getTitle();
	
	/**
	 * @return Message text.
	 */
	String getText();
	
	/**
	 * @return Message URL.
	 */
	String getUrl();
}
