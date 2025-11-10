package res;

public class FullQueueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FullQueueException() {
		super();
	}
	
	public FullQueueException(String message) {
		super(message);
	}
}
