package res;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue implements Queue {
	private int idxHead;
	private int idxTail;
	private int[] arr;
	private int length;
	
	/**
	 * Default constructor; creates an empty queue of default capacity
	 */
	public CircularArrayQueue() {
		arr = new int[DEFAULT_CAPACITY + 1];
		idxHead = 0;
		idxTail = 0;
		length = arr.length;
	}
	
	/**
	 * Explicit-value constructor; creates an empty queue of specified capacity
	 * @param capacity the desired queue capacity
	 * @throws IllegalArgumentException if the capacity is less than 1
	 */
	public CircularArrayQueue(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be at least 1.");
		}
		arr = new int[capacity + 1];
		idxHead = 0;
		idxTail = 0;
		length = arr.length;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO
		//return false;
		return idxHead == idxTail;
	}

	/**
	 * @throws FullQueueException if the queue is already full
	 */
	@Override
	public void enqueue(int item) {
		int idxTailUpdate = (idxTail + 1) % length;
		if (idxTailUpdate == idxHead) {
			throw new FullQueueException("Cannot add " + item + " to the queue.");
		}
		
		arr[idxTail] = item;
		idxTail = idxTailUpdate;
		return;
	}

	@Override
	public int dequeue() {
		if (idxHead == idxTail) {
			throw new EmptyQueueException("Cannot dequeue from an empty queue");
		}
		
		int element = arr[idxHead];
		idxHead = (idxHead + 1) % length;
		return element;
	}
	
	@Override
	public int length() {
		return idxTail - idxHead;
	}

	@Override
	public int peek() {
		// TODO 
		//return Integer.MAX_VALUE;
		if (idxHead == idxTail) {
			throw new EmptyQueueException("Cannot dequeue from an empty queue");
		}

		return arr[idxHead];
	}
	
	@Override
	public void clear() {
		// TODO
		arr = new int[arr.length];
		idxHead = 0;
		idxTail = 0;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO 
	    //return null;
		Iterator<Integer> queueIterator = new Iterator<Integer>() {
			int index = idxHead;
			
			@Override
			public boolean hasNext() {
				return index < idxTail;
			}

			@Override
			public Integer next() {
				if (index >= idxTail) {
					throw new NoSuchElementException();
				}
				
				int element = arr[index];
				index = (index + 1) % length;
				return element;
			}
		};
		return queueIterator;
	}
	
	@Override
	public String toString() {
		if (idxHead == idxTail) {
			return "Empty queue";
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = idxHead; i != idxTail; i = (i + 1) % length) {
			builder.append(String.valueOf(arr[i]));
			builder.append("; ");
		}
		return builder.substring(0, builder.length() - 2);
	}
	
	@Override
	public Object clone() {
		// TODO
		return null;
//		CircularArrayQueue clone = new CircularArrayQueue(length - 1);
//		clone.idxHead = this.idxHead;
//		clone.idxTail = this.idxTail;
//		clone.arr = Arrays.copyOf(this.arr, length);
//		return clone;
	}
}
