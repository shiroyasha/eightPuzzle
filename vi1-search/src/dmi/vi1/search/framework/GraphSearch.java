/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import dmi.vi1.search.datastructure.Queue;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class GraphSearch extends QueueSearch {
	

	protected Set<Object> explored = new HashSet<Object>();
	protected List<Node> addToFrontier = new ArrayList<>();
	protected Map<Object, Node> frontierStates = new HashMap<Object, Node>();
	private Comparator<Node> replaceFrontierNodeAtStateCostFunction = null;
	
	

	@Override
	public List<Node> getResultingNodesToAddToFrontier(Node nodeToExpand,
			Problem p) {
		addToFrontier.clear();
		explored.add(nodeToExpand.getState());
		List<Node> expandedNodes = expandNode(nodeToExpand, p);
		for(Node n:expandedNodes){
			boolean yesAddToFrontier = false;
			Node frontierNode = frontierStates.get(n.getState());
			if(frontierNode == null && !explored.contains(n.getState())){	
				// ako se stanje ne nalazi u skupu grannicnih cvorova 
				// niti u skupu vec posecenih cvorova
				yesAddToFrontier = true;
			}else if(frontierNode!=null
					 && replaceFrontierNodeAtStateCostFunction!=null
					 && replaceFrontierNodeAtStateCostFunction.compare(n,frontierNode)<0){
				// u skupu granicnih cvorova postoji isto stanje
				// ali to stanje ima vecu cenu
				// treba izvrsiti zamenu
				yesAddToFrontier = true;
				removeNodeFromFrontier(frontierNode);
				addToFrontier.remove(frontierNode);				
			}
			if(yesAddToFrontier){
				addToFrontier.add(n);
				frontierStates.put(n.getState(),n);
			}
		}
		
		return addToFrontier;
	}	
	
	
	@Override
	public List<Action> search(Problem p, Queue<Node> frontier) {
	    // inicijalizacija
		explored.clear();
		frontierStates.clear();
		return super.search(p, frontier);
	}
	
	@Override
	public Node popNodeFromFrontier() {
		Node toRemove = super.popNodeFromFrontier();
		frontierStates.remove(toRemove.getState());
		return toRemove;
	}

	@Override
	public boolean removeNodeFromFrontier(Node toRemove) {
		boolean removed = super.removeNodeFromFrontier(toRemove);
		if (removed) {
			frontierStates.remove(toRemove.getState());
		}
		return removed;
	}


	/**
	 * @return the replaceFrontierNodeAtStateCostFunction
	 */
	public Comparator<Node> getReplaceFrontierNodeAtStateCostFunction() {
		return replaceFrontierNodeAtStateCostFunction;
	}


	/**
	 * @param replaceFrontierNodeAtStateCostFunction the replaceFrontierNodeAtStateCostFunction to set
	 */
	public void setReplaceFrontierNodeAtStateCostFunction(
			Comparator<Node> replaceFrontierNodeAtStateCostFunction) {
		this.replaceFrontierNodeAtStateCostFunction = replaceFrontierNodeAtStateCostFunction;
	}
	
	

}
