/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.List;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public interface ActionsFunction {
	
	/**
	 * Vraca sve akcije dostupne iz stanja s
	 * 
	 * ACTIONS(s)
	 * 
	 * @param s
	 * @return
	 */
	
	List<Action> actions(Object s);

}
