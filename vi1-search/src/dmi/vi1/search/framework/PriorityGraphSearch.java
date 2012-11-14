/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.Comparator;
import java.util.List;





/**
 * @author bdimic@uns.ac.rs
 *
 */
public class PriorityGraphSearch extends GraphSearch {
	
	private Comparator<Node> nodeComparator = null;
	
	
	
	@Override
	public List<Node> getResultingNodesToAddToFrontier(Node nodeToExpand,
			Problem problem) {

		addToFrontier.clear();
		// add the node to the explored set
		explored.add(nodeToExpand.getState());
		// expand the chosen node, adding the resulting nodes to the frontier
		for (Node cfn : expandNode(nodeToExpand, problem)) {
			Node frontierNode = frontierStates.get(cfn.getState());
			boolean yesAddToFrontier = false;
			// only if not in the frontier or explored set
			if (null == frontierNode && !explored.contains(cfn.getState())) {
				yesAddToFrontier = true;
			} else if (null != frontierNode
					&& null != nodeComparator
					&& nodeComparator.compare(cfn,
							frontierNode) < 0) {
				// child.STATE is in frontier with higher cost
				// replace that frontier node with child
				yesAddToFrontier = true;
				// Want to replace the current frontier node with the child
				// node therefore mark the child to be added and remove the
				// current fontierNode
				removeNodeFromFrontier(frontierNode);
				// Ensure removed from add to frontier as well
				// as 1 or more may reach the same state at the same time
				addToFrontier.remove(frontierNode);
			}
			if (yesAddToFrontier) {
				addToFrontier.add(cfn);
				frontierStates.put(cfn.getState(), cfn);
			}
		}

		return addToFrontier;
	}



	/**
	 * @return the nodeComparator
	 */
	public Comparator<Node> getNodeComparator() {
		return nodeComparator;
	}



	/**
	 * @param nodeComparator the nodeComparator to set
	 */
	public void setNodeComparator(Comparator<Node> nodeComparator) {
		this.nodeComparator = nodeComparator;
	}

}
