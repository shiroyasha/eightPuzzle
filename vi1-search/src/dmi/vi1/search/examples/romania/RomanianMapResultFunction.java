/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianMapResultFunction implements ResultFunction {

	
	@Override
	public Object result(Object s, Action a) {		
		return RomanianMap.getDestinantion((String)s, (GoToCityAction)a);
	}

}
