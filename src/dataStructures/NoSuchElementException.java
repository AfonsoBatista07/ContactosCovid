package dataStructures;

public class NoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MSG = "No such element.";

	public NoSuchElementException( )
	{
		super(DEFAULT_MSG);
	}
	
	public NoSuchElementException( String msg )
	{
		super(msg);
	}
}
