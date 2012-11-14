/**
 * 
 */
package dmi.vi1.search.informed;

import dmi.vi1.search.framework.EvaluationFunction;
import dmi.vi1.search.framework.HeuristicFunction;
import dmi.vi1.search.framework.Node;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class GreedyBestFirstEvaluationFunction implements EvaluationFunction {

	private HeuristicFunction hf = null;
	
	public GreedyBestFirstEvaluationFunction(HeuristicFunction hf){
		this.hf = hf;
	}
	
	
	@Override
	public double f(Node n) {		
		return hf.h(n.getState());
	}

}
