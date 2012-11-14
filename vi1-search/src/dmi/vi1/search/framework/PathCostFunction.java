/**
 * 
 */
package dmi.vi1.search.framework;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class PathCostFunction {
	
	public PathCostFunction(){		
	}
	
	public double g(Node n){
		return n.getPathCost();
	}

}
