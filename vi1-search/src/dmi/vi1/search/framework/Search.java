/**
 * 
 */
package dmi.vi1.search.framework;

import java.util.List;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public interface Search {
	
	List<Action> search(Problem p) throws Exception;
	
	

}
