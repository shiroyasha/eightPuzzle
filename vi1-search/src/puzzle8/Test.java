package puzzle8;

import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.GraphSearch;
import dmi.vi1.search.framework.HeuristicFunction;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.TreeSearch;
import dmi.vi1.search.informed.AStarSearch;
import dmi.vi1.search.informed.GreedyBestFirstSearch;
import dmi.vi1.search.uninformed.BreadthFirstSearch;
import dmi.vi1.search.uninformed.DepthFirstSearch;
import dmi.vi1.search.uninformed.UniformCostSearch;

public class Test {
	public static void main(String args[]) {
		PuzzleActionsFunction paf = new PuzzleActionsFunction();
		PuzzleResultFunction prf = new PuzzleResultFunction();
		PuzzleStepCostFunction pscf = new PuzzleStepCostFunction();
		PuzzleGoalTest pgt = new PuzzleGoalTest();	
		
		PuzzleSlot[] ps=new PuzzleSlot[9];
		ps[0]=new PuzzleSlot(0,0,7);
		ps[1]=new PuzzleSlot(0,2,2);
		ps[2]=new PuzzleSlot(0,3,4);
		ps[3]=new PuzzleSlot(1,0,5);
		ps[4]=new PuzzleSlot(1,1,0);
		ps[5]=new PuzzleSlot(1,2,6);
		ps[6]=new PuzzleSlot(2,0,8);
		ps[7]=new PuzzleSlot(2,1,3);
		ps[8]=new PuzzleSlot(2,2,1);
		PuzzleState beginState;
		beginState=new PuzzleState(ps);
		//beginState=new PuzzleState();
		
		Problem puzzleProblem = new Problem(beginState, paf, prf, pgt, pscf);
		
		PuzzleMenhetnHeuristicFunction mheuristic=new PuzzleMenhetnHeuristicFunction();
		PuzzlePlaceHeuristicFunction pheuristic=new PuzzlePlaceHeuristicFunction();
		MHeuristicFunction menhetn2=new MHeuristicFunction();
		AStarSearch astars = new AStarSearch(new GraphSearch(), pheuristic);
		try {
			System.out.println("pocetno stanje:");
			System.out.println(beginState);
			System.out.println("Pretraga...");
			List<Action> actions = astars.search(puzzleProblem);
			System.out.println("Rezultat se dobija primjenom sledecih akcija:");
			System.out.println(beginState);
			for (Action a : actions) {
				System.out.println(a);
				beginState=(PuzzleState)(prf.result(beginState,a));
				System.out.println(beginState);
			}
			System.out.println("Rjeseno u "+actions.size()+" poteza...");
			System.out.println("ukupno izgenerisano "+astars.getSearch().getNumberOfGeneratedNodes()+" cvorova");
			System.out.println("ukupno otvoreno "+astars.getSearch().getNumberOfExpandedNodes()+" cvorova");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
