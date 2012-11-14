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
public class AStarSearch extends BestFirstSearch {
	public AStarSearch(QueueSearch search, HeuristicFunction hf) {
		super(search, new AStarEvaluationFunction(hf));
	}
}
