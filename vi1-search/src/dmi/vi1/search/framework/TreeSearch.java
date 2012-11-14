/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.List;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class TreeSearch extends QueueSearch {

	
	@Override
	public List<Node> getResultingNodesToAddToFrontier(Node nodeToExpand,
			Problem p) {		
		return expandNode(nodeToExpand, p);
	}

}
