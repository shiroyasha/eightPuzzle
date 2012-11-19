package puzzle8;

import dmi.vi1.search.framework.GoalTest;

public class PuzzleGoalTest implements GoalTest{

	@Override
	public boolean isGoalState(Object arg0) {
		return ((PuzzleState)arg0).isFinished();
	}

}
