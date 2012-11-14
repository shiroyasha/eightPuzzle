/**
 * 
 */
package dmi.vi1.search.informed;


import dmi.vi1.search.framework.HeuristicFunction;
import dmi.vi1.search.framework.QueueSearch;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class GreedyBestFirstSearch extends BestFirstSearch {

	/**
	 * @param search
	 * @param hf
	 */
	public GreedyBestFirstSearch(QueueSearch search, HeuristicFunction hf) {
		super(search, new GreedyBestFirstEvaluationFunction(hf));
		
	}

}
