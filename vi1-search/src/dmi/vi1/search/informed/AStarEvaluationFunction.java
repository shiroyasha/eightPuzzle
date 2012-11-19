/**
 * 
 */
package dmi.vi1.search.informed;



import dmi.vi1.search.framework.EvaluationFunction;
import dmi.vi1.search.framework.HeuristicFunction;
import dmi.vi1.search.framework.Node;
import dmi.vi1.search.framework.PathCostFunction;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class AStarEvaluationFunction implements EvaluationFunction {
	PathCostFunction gf = new PathCostFunction();
	HeuristicFunction hf = null; 
	
	
	public AStarEvaluationFunction(HeuristicFunction hf){
		this.hf=hf;
	}
	
	
	
	@Override
	public double f(Node n) {
		//System.out.println( gf.g(n) + " " + hf.h(n.getState()));
		return gf.g(n)+hf.h(n.getState());
	}

}
