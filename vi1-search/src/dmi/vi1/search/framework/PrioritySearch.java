/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.Comparator;
import java.util.List;

import dmi.vi1.search.datastructure.PriorityQueue;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public abstract class PrioritySearch implements Search {

	
	protected QueueSearch search;	
	
	
	

	@Override
	public List<Action> search(Problem p) throws Exception {		
		return search.search(p, new PriorityQueue<Node>(5, getComparator()));
	}

	protected abstract Comparator<Node> getComparator();
	
	/**
	 * @return the search
	 */
	public QueueSearch getSearch() {
		return search;
	}
}
