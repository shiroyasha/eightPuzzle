package puzzle8;

import dmi.vi1.search.framework.HeuristicFunction;

public class PuzzlePlaceHeuristicFunction implements HeuristicFunction{

	@Override
	public double h(Object arg0) {
		PuzzleSlot[] ps=((PuzzleState)arg0).getPuzzleSlots();
		double counter=0;
		for(int i=0;i<9;i++){
			if(ps[i].getValue()!=i){
				counter++;
			}
		}
		return counter;
		
	}

}
