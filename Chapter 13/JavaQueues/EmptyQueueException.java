package res;

public class EmptyQueueException extends RuntimeException {
	private static final long serialVersionUID = 2L;

	public EmptyQueueException() {
		super();
	}
	
	public EmptyQueueException(String message) {
		super(message);
	}
}
