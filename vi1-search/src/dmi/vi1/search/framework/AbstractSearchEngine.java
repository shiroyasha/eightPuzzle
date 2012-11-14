/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.List;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public abstract class AbstractSearchEngine {
	
	protected List<Action> listOfActions;
	
	public abstract List<Object> solve(Object initialState);
	
	public List<Action> getListOfActions(){
		return listOfActions;
	}
}
