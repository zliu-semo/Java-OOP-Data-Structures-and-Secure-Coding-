package res;

public interface Queue extends Iterable<Integer>, Cloneable {
	public static final int DEFAULT_CAPACITY = 5;
	
	/**
	 * @return {@code true} if the queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Adds the specified item to the tail of the queue, if possible
	 * @param item the specified item
	 */
	public void enqueue(int item);
	
	/**
	 * Removes and returns the element at the head of the queue, if possible
	 * @return the element at the head of the queue
	 * @throws EmptyQueueException if the queue is already empty
	 */
	public int dequeue();
	
	/**
	 * @return the length of the queue
	 */
	public int length();
	
	/**
	 * Returns (but does not remove) the element at the head of the queue, if possible
	 * @return the element at the head of the queue
	 * @throws EmptyQueueException if the queue is already empty
	 */
	public int peek();
	
	/**
	 * Empties all elements from the queue
	 */
	public void clear();
	
	public Object clone();
}
