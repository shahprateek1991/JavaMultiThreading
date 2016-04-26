package com.semaphore;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author prateekshah
 * A blocking queue implementation using normal queue with the help of Semaphore
 * 
 * @param <T>
 */
public class BlockingQueue<T> {
	
	private Queue<T> queue;
	private Semaphore semaphore;
	
	public BlockingQueue(int size) {
		queue = new LinkedList<T>();
		semaphore = new Semaphore(size);
	}
	
	public void add(T element) throws InterruptedException {
		semaphore.acquire();
		queue.add(element);
	}
	
	public T remove() {
		T element = null;
		try {
			element =queue.remove();
			semaphore.release();
		} catch(NoSuchElementException ex) {
			
		}
		return element;
	}

}
