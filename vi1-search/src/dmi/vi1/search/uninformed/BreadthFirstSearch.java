/**
 * 
 */
package dmi.vi1.search.uninformed;

import java.util.List;

import dmi.vi1.search.datastructure.FIFOQueue;
import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.GraphSearch;
import dmi.vi1.search.framework.Node;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.QueueSearch;
import dmi.vi1.search.framework.Search;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class BreadthFirstSearch implements Search {
	
	
	private QueueSearch search;
	
	public BreadthFirstSearch(){
		this(new GraphSearch());
	}
	
	public BreadthFirstSearch(QueueSearch search){
		this.search = search;
	}
	
	public List<Action> search(Problem p) throws Exception {	
		return search.search(p, new FIFOQueue<Node>());
	}

	/**
	 * @return the search
	 */
	public QueueSearch getSearch() {
		return search;
	}
	
	

}
