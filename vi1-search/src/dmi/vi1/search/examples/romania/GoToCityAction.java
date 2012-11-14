/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.Action;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class GoToCityAction implements Action {

	
	private String destination;
	
	public GoToCityAction(String destinantion){
		this.destination = destinantion;
	}
	
	@Override
	public boolean isNoOpAction() {	
		return false;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String toString(){
		return "Go to "+destination;
	}

}
