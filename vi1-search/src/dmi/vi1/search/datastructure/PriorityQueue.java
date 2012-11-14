/**
 * 
 */
package dmi.vi1.search.datastructure;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;


/**
 * @author bdimic@uns.ac.rs
 *
 */
public class PriorityQueue<E> extends java.util.PriorityQueue<E> implements
		Queue<E> {
	
	private static final long serialVersionUID = 1;
	
	public PriorityQueue(){
		super();
	}
	
	public PriorityQueue(Collection<? extends E> c) {
		super(c);
	}
	
	public PriorityQueue(int initialCapacity) {
		super(initialCapacity);
	}

	public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
		super(initialCapacity, comparator);
	}
	
	public PriorityQueue(PriorityQueue<? extends E> c) {
		super(c);
	}

	public PriorityQueue(SortedSet<? extends E> c) {
		super(c);
	}
	
	public boolean isEmpty() {
		return 0 == size();
	}

	public E pop() {
		return poll();
	}

	public Queue<E> insert(E element) {
		if (offer(element)) {
			return this;
		}
		return null;
	}

}
