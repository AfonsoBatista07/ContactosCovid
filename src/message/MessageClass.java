package message;

/**
 * Implements a Message.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class MessageClass implements Message{
	private String title, text, url;
	
	
	/**
	 * Constructor of MessageClass, initializes variables.
	 * @param title - Message title
	 * @param text - Message text
	 * @param url - Message URL
	 */
	public MessageClass( String title, String text, String url ) {
		this.title = title;
		this.text = text;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
	public String getUrl() {
		return url;
	}
}
