/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.ArrayList;
import java.util.List;



/**
 * @author bdimic@uns.ac.rs
 *
 */
public class Node {
	
	private Object state;
	private Node parent;	
	private Action action;	
	private double pathCost;
	
	
	
	public Node(Object state){
		this.state = state;
	}
	
	public Node(Object state, Node parent, Action action){
		this(state);
		this.action = action;
		this.parent = parent;
		
		
	}
	
	public Node(Object state, Node parent, Action action, double stepCost){
		this(state,parent,action);
		this.pathCost = this.pathCost + stepCost;
		
	}
	
	/**
	 * @return the state
	 */
	public Object getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Object state) {
		this.state = state;
	}

	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * @return the pathCost
	 */
	public double getPathCost() {
		return pathCost;
	}

	/**
	 * @param pathCost the pathCost to set
	 */
	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}
    
	public boolean isRootNode(){
		return parent==null;
	}
	
	public List<Node> getPathFromRoot() {
		List<Node> path = new ArrayList<Node>();
		Node current = this;
		while (!current.isRootNode()) {
			path.add(0, current);
			current = current.getParent();
		}		
		path.add(0, current);
		return path;
	}	
	
	
	
}
