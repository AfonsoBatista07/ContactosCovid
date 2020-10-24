package message;

public class MessageClass implements Message{
	private String title, text, url;
	
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
