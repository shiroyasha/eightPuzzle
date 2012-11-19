package puzzle8;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;

public class PuzzleResultFunction implements ResultFunction {
	public int counter=0;

	@Override
	public Object result(Object arg0, Action arg1) {
		counter++;
		PuzzleSlot[] puzzleSlots = ((PuzzleState) arg0).getPuzzleSlots();
		PuzzleAction puzzleAction = (PuzzleAction) arg1;

		PuzzleSlot[] returnPuzzle = new PuzzleSlot[9];
		for (int i = 0; i < 9; i++) {
			returnPuzzle[i] = new PuzzleSlot(puzzleSlots[i].getRow(),
					puzzleSlots[i].getColumn(), puzzleSlots[i].getValue());
		}
		
		PuzzleSlot temp = returnPuzzle[puzzleAction.getFirst()];
		returnPuzzle[puzzleAction.getFirst()] = returnPuzzle[puzzleAction
				.getSecond()];
		returnPuzzle[puzzleAction.getSecond()] = temp;

		PuzzleState returnState = new PuzzleState(returnPuzzle);
		return returnState;
	}
}
