/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.HeuristicFunction;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class RomanianMapHeuristicFunction implements HeuristicFunction {

	
	@Override
	public double h(Object state) {
		
		return RomanianMap.getStrightLineDistanceToBucharest((String)state);
	}

}
