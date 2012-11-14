/**
 * 
 */
package dmi.vi1.search.informed;

import java.util.Comparator;



import dmi.vi1.search.framework.EvaluationFunction;
import dmi.vi1.search.framework.GraphSearch;
import dmi.vi1.search.framework.Node;
import dmi.vi1.search.framework.PrioritySearch;
import dmi.vi1.search.framework.QueueSearch;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class BestFirstSearch extends PrioritySearch {

	private EvaluationFunction evaluationFunction;
	
	public BestFirstSearch(QueueSearch search, EvaluationFunction ef) {
		this.search = search;
		evaluationFunction = ef;
	}
	
	
	@Override
	protected Comparator<Node> getComparator() {
		Comparator<Node> f = new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				Double f1 = evaluationFunction.f(n1);
				Double f2 = evaluationFunction.f(n2);

				return f1.compareTo(f2);
			}
		};

		if (this.search instanceof GraphSearch) {
			((GraphSearch) this.search)
			.setReplaceFrontierNodeAtStateCostFunction(f);				
		}

		return f;
	}

}
