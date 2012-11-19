package puzzle8;

import dmi.vi1.search.framework.HeuristicFunction;

public class MHeuristicFunction implements HeuristicFunction {

	@Override
	public double h(Object arg0) {
		return Math.random();
	}

}
