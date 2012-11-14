/**
 * 
 */
package dmi.vi1.search.framework;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class NoOpAction implements Action {

	
	public boolean isNoOpAction() {	
		return true;
	}
	
	public String toString(){
		return "No operation";
	}
}
