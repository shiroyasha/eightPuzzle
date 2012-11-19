package puzzle8;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.StepCostFunction;

public class PuzzleStepCostFunction implements StepCostFunction{

	@Override
	public double c(Object arg0, Action arg1, Object arg2) {
		return 1.0;
	}

}
