/**
 * 
 */
package dmi.vi1.search.uninformed;

import java.util.List;

import dmi.vi1.search.datastructure.LIFOQueue;
import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.Node;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.QueueSearch;
import dmi.vi1.search.framework.Search;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class DepthFirstSearch implements Search {

	private QueueSearch search;
	
	/**
	 * @param search
	 */
	public DepthFirstSearch(QueueSearch search) {
		super();
		this.search = search;
	}

	@Override
	public List<Action> search(Problem p) throws Exception {	
		return search.search(p, new LIFOQueue<Node>());
	}

	/**
	 * @return the search
	 */
	public QueueSearch getSearch() {
		return search;
	}

}
