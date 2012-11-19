package puzzle8;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;

public class PuzzleActionsFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object state) {
		List<Action> actions = new ArrayList<Action>();
		PuzzleSlot[] puzzleSlots = ((PuzzleState) state).getPuzzleSlots();
		int first = 0;
		for (int i = 0; i < 9; i++) {
			if (puzzleSlots[i].getValue() == 0) {
				first = i;
				break;
			}
		}
		int column = PuzzleState.getColumn(first);
		int row = PuzzleState.getRow(first);
		
		if (column != 0) {
			actions.add(new PuzzleAction(first, PuzzleState.getLocation(row,
					column - 1)));
		}
		if (column != 2) {
			actions.add(new PuzzleAction(first, PuzzleState.getLocation(row,
					column + 1)));
		}
		if (row != 2) {
			actions.add(new PuzzleAction(first, PuzzleState.getLocation(
					row + 1, column)));
		}
		
		if (row != 0) {
			actions.add(new PuzzleAction(first, PuzzleState.getLocation(
					row - 1, column)));
		}

		// for(Action a:actions){
		// System.out.println(a);
		// }
		return actions;
	}

}
