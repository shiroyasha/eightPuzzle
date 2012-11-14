/**
 * 
 */
package dmi.vi1.search.uninformed;

import java.util.Comparator;

import dmi.vi1.search.framework.Node;
import dmi.vi1.search.framework.PriorityGraphSearch;
import dmi.vi1.search.framework.PrioritySearch;
import dmi.vi1.search.framework.QueueSearch;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class UniformCostSearch extends PrioritySearch {

	
	
	private static final Comparator<Node> pathCostComprator = new Comparator<Node>() {
		public int compare(Node node1, Node node2) {
			return (new Double(node1.getPathCost()).compareTo(new Double(node2
					.getPathCost())));
		}
	};
	
	public UniformCostSearch(){
		this(new PriorityGraphSearch());
	}
	
	public UniformCostSearch(QueueSearch search){
		this.search = search;
		if(search instanceof PriorityGraphSearch){
			((PriorityGraphSearch)search).setNodeComparator(pathCostComprator);
		}
	}
	
	
	
	@Override
	protected Comparator<Node> getComparator() {		
		return pathCostComprator;
	}

}
