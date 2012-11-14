/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.StepCostFunction;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianMapStepCostFunction implements StepCostFunction {

	
	public double c(Object s, Action a, Object s1) {	
		return RomanianMap.getDistance((String)s, (String)s1);
	}

}
