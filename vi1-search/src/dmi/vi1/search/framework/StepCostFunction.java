/**
 * 
 */
package dmi.vi1.search.framework;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public interface StepCostFunction {
	
	/**
	 * Racuna cenu koraka da se iz stanja s dodje u stanje s1 iyvrsavanjem akcija a
	 * 
	 * 
	 * @param s
	 * @param a
	 * @param s1
	 * @return
	 */
	double c(Object s, Action a, Object s1);

}
