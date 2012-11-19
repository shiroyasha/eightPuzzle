/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import dmi.vi1.search.datastructure.Queue;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public abstract class QueueSearch {
	
	private Queue<Node> frontier = null;
	private boolean checkGoalBeforeAddingToFrontier = true;
	
	private int numberOfGeneratedNodes = 0;
	private int numberOfExpandedNodes = 0;
	//public static final int MAX_QUEUE_SIZE = 50; 
	
	
	
	
	public List<Action> search(Problem p, Queue<Node> frontier){
		numberOfGeneratedNodes = 0;
		numberOfExpandedNodes = 0;
		this.frontier = frontier;
		Node root = new Node(p.getInitialState());	
		if(checkGoalBeforeAddingToFrontier)
			if(p.getGoalTest().isGoalState(p.getInitialState())){			
				return SearchUtils.actionsFromNodes(root.getPathFromRoot());
			}
		frontier.insert(root);
		numberOfGeneratedNodes++;
		while(!frontier.isEmpty()){			
			Node nodeToExpand = popNodeFromFrontier();
			if(!checkGoalBeforeAddingToFrontier){
				if(p.getGoalTest().isGoalState(nodeToExpand.getState())){
					return SearchUtils.actionsFromNodes(nodeToExpand.getPathFromRoot());				
				}
			}			
			List<Node> nodesToBeAddedToFrontier = getResultingNodesToAddToFrontier(nodeToExpand, p);
			numberOfGeneratedNodes = numberOfGeneratedNodes+nodesToBeAddedToFrontier.size();
			numberOfExpandedNodes++;
			for(Node n:nodesToBeAddedToFrontier){
				if(checkGoalBeforeAddingToFrontier){					
					if(p.getGoalTest().isGoalState(n.getState())){
						
						return SearchUtils.actionsFromNodes(n.getPathFromRoot());
					}					
				}
				frontier.insert(n);
			}
			
		}	
		return failure();
	}
	
	public void setQueueSize(int queueSize){		
    }
	
	
	//zavisi da li je graf ili tree search
	
	public abstract List<Node> getResultingNodesToAddToFrontier(Node nodeToExpand, Problem p);
	
	private List<Action> failure() {
		return Collections.emptyList();
	}
	
	public List<Node> expandNode(Node node, Problem problem) {
		List<Node> childNodes = new ArrayList<Node>();
		ActionsFunction actionsFunction = problem.getActionsFunction();
		ResultFunction resultFunction = problem.getResultFunction();
		StepCostFunction stepCostFunction = problem.getStepCostFunction();
		for (Action action : actionsFunction.actions(node.getState())) {
			Object successorState = resultFunction.result(node.getState(),
					action);
			double stepCost = stepCostFunction.c(node.getState(), action,
					successorState);
			childNodes.add(new Node(successorState, node, action, stepCost));
		}		
		return childNodes;
	}
	
	public Node popNodeFromFrontier(){
		return frontier.pop();
	}
	public boolean removeNodeFromFrontier(Node toRemove) {
		return frontier.remove(toRemove);
	}

	/**
	 * @return the checkGoalBeforeAddingToFrontier
	 */
	public boolean isCheckGoalBeforeAddingToFrontier() {
		return checkGoalBeforeAddingToFrontier;
	}

	/**
	 * @param checkGoalBeforeAddingToFrontier the checkGoalBeforeAddingToFrontier to set
	 */
	public void setCheckGoalBeforeAddingToFrontier(
			boolean checkGoalBeforeAddingToFrontier) {
		this.checkGoalBeforeAddingToFrontier = checkGoalBeforeAddingToFrontier;
	}

	/**
	 * @return the numberOfGeneratedNodes
	 */
	public int getNumberOfGeneratedNodes() {
		return numberOfGeneratedNodes;
	}

	/**
	 * @return the numberOfExpandedNodes
	 */
	public int getNumberOfExpandedNodes() {
		return numberOfExpandedNodes;
	}

	
}
