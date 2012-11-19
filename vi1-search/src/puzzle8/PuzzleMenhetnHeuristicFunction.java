package puzzle8;

import dmi.vi1.search.framework.HeuristicFunction;

public class PuzzleMenhetnHeuristicFunction implements HeuristicFunction {

	@Override
	public double h(Object arg0) {
		PuzzleSlot[] ps = ((PuzzleState) arg0).getPuzzleSlots();
		double counter = 0;
		for (PuzzleSlot slot : ps) {
				counter += (Math.abs(PuzzleState.getRow(slot.getValue()) - slot.getRow()) + Math
						.abs(PuzzleState.getColumn(slot.getValue()) - slot.getColumn()));
		}
		return counter;
	}

}
