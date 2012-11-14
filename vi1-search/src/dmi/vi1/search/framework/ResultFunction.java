/**
 * 
 */
package dmi.vi1.search.framework;



/**
 * @author bdimic@uns.ac.rs
 *
 */
public interface ResultFunction {
	
	
	/**
	 * Vraca stanje koje se dobija kada se u stanju s izvrsi akcija a
	 * RESULT(s,a)
	 * 
	 * @param s
	 * @param a
	 * @return
	 */
	Object result(Object s, Action a);
}
