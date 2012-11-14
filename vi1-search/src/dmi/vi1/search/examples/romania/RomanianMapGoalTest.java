/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.GoalTest;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianMapGoalTest implements GoalTest {

	/* (non-Javadoc)
	 * @see dmi.vi1.search.framework.GoalTest#isGoalState(java.lang.Object)
	 */
	@Override
	public boolean isGoalState(Object state) {		
		return ((String) state).equals(RomanianMap.goalCity);
	}

}
