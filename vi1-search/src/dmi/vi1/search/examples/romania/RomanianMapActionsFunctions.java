/**
 * 
 */
package dmi.vi1.search.examples.romania;

import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianMapActionsFunctions implements ActionsFunction {

	/* (non-Javadoc)
	 * @see dmi.vi1.search.framework.ActionsFunction#actions(java.lang.Object)
	 */
	@Override
	public List<Action> actions(Object s) {
		
		return RomanianMap.getActionsInCity((String)s);
	}

}
