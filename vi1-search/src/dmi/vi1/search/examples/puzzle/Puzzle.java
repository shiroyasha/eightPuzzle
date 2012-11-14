package dmi.vi1.search.examples.puzzle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dmi.vi1.search.framework.*;
import dmi.vi1.search.informed.AStarSearch;
import dmi.vi1.search.uninformed.BreadthFirstSearch;
import dmi.vi1.search.uninformed.UniformCostSearch;

class PuzzleState {
	
	private String state;
	
	PuzzleState(String state) {
		this.state = state;
	}
	
	String getState() {
		return state;
	}
	
	int getX( char c ) {
		return state.indexOf(c) % 3;
	}
	
	int getY(char c) {
		return state.indexOf(c) / 3;
	}
	
	char getPlate( int x, int y ) {
		return state.charAt(y * 3 + x);
	}

	@Override
	public String toString() {
		return state.substring(0, 3)  +
			   state.substring(3, 6)  +
			   state.substring(6, 9) ;
	}
	
	@Override
	public int hashCode() {
		return state.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return ((PuzzleState)obj).state.equals(state);
	}
}

class PuzzleAction implements Action {
	
	private char plateNumber;
	
	public PuzzleAction(char plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public char getPlateNumber() {
		return plateNumber;
	}
		
	@Override
	public String toString() {
		return "move plate with number " + plateNumber;
	}

	@Override
	public boolean isNoOpAction() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

class PuzzleActionFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object s1) {
		List<Action> ret = new ArrayList<Action>();
		
		PuzzleState s = (PuzzleState)s1;
		
		int x = s.getX('*');
		int y = s.getY('*');

		if( x - 1 >= 0 ) ret.add( new PuzzleAction( s.getPlate(x - 1, y) ));
		if( x + 1 <= 2 ) ret.add( new PuzzleAction( s.getPlate(x + 1, y) ));
		if( y - 1 >= 0 ) ret.add( new PuzzleAction( s.getPlate(x, y - 1) ));
		if( y + 1 <= 2 ) ret.add( new PuzzleAction( s.getPlate(x, y + 1) ));
		
		return ret;
	}
	
}

class PuzzleGoal implements GoalTest {
	
	public final static PuzzleState goal = new PuzzleState("*12345678");

	@Override
	public boolean isGoalState(Object state) {
		PuzzleState s = (PuzzleState) state;

		return s.equals( goal );
	}
	
}

class PlateMoveCost implements StepCostFunction {

	@Override
	public double c(Object s, Action a, Object s1) {
		return 1;
	}
	
}


class PuzzleActionResult implements ResultFunction {

	@Override
	public Object result(Object s1, Action a1) {
		
		PuzzleAction a = (PuzzleAction)a1;
		PuzzleState s = (PuzzleState)s1;
		
		
		int p1 = s.getState().indexOf('*');
		int p2 = s.getState().indexOf(a.getPlateNumber());
		
		if( p1 > p2 ) {  int t = p2; p2 = p1; p1 = t; };
		
		PuzzleState ret  = new PuzzleState( s.getState().substring(0, p1) + 
								s.getState().charAt(p2) + 
								s.getState().substring(p1 + 1, p2) + 
								s.getState().charAt(p1) + 
								s.getState().substring( p2 + 1) );
		
		return ret;
	}
	
}

class ManhattanDistance implements HeuristicFunction {

	@Override
	public double h(Object state) {
		PuzzleState s = (PuzzleState)state;
		
		int ret = 0;
		
		for( int y = 0; y < 3; y++ ) {
			for( int x = 0; x < 3; x++ ) {
				
				char c = s.getPlate(x, y);
				if( c == '*' ) continue;
				
				int x2 = PuzzleGoal.goal.getX(c);
				int y2 = PuzzleGoal.goal.getY(c);
				
				ret += Math.abs(x - x2) + Math.abs(y - y2);
			}
		}
		
		return ret;
	}
	
}


class HammingDistance implements HeuristicFunction {

	@Override
	public double h(Object state) {
		PuzzleState s = (PuzzleState)state;
		
		int ret = 0;
		
		for( int y = 0; y < 3; y++ ) {
			for( int x = 0; x < 3; x++ ) {
				if( s.getPlate(x, y) == '*' ) continue;
				if( s.getPlate(x, y) != PuzzleGoal.goal.getPlate(x, y) ) ret++; 
			}
		}
		
		return ret;
	}
	
}



public class Puzzle {
	
	public static boolean checkState( PuzzleState p ) {
		if( p.getState().length() != 9 ) return false;
		
		int[] niz = new int[9];
		boolean[] every = new boolean[9];
		
		for( int i = 0; i < p.getState().length(); i++ ) {
			if( p.getState().charAt(i) == '*' ) {
				niz[i] = 0;
				every[0] = true;
			} else {
				if( p.getState().charAt(i) < '1' || p.getState().charAt(i) > '9') return false;
				every[((int)(p.getState().charAt(i) - '0'))] = true;
				niz[i] = ((int)(p.getState().charAt(i) - '0'));
			}
		}
		
		for( boolean b : every )
			if( !b ) return false; 
		
		
		int inverses = 0;
		for( int i = 0; i < 9; i++ ) {
			if( niz[i] == 0 ) continue;
			for( int j = 0; j < i; j++) {
				if( niz[j] > niz[i] ) inverses++;
			}
		}
		
		return (inverses % 2 == 0) ;
	}
	
	
	
	
	public static PuzzleState enterInitState() {
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		
		PuzzleState init = null;
		boolean ok = false;
		
		do {
			
			System.out.print("Enter initial state( for example '12*345678' ): ");
			System.out.flush();
			String line;
			try{ line = input.readLine(); } catch(Exception e) { line = ""; };
			
			init = new PuzzleState(line);
			
			if( !checkState( init) ) {
				System.out.println("--- Error: the state " + line + " is not solvable");
			} else {
				ok = true;
			}
		} while( !ok );
		System.out.println();
		return init;
	}
	
	public static Problem createProblem(PuzzleState init) {
		PuzzleActionFunction actionFunction = new PuzzleActionFunction();
		PuzzleActionResult actionResult = new PuzzleActionResult();
		PuzzleGoal actionGoal = new PuzzleGoal();
		PlateMoveCost moveCost = new PlateMoveCost();
		
		return new Problem( init, actionFunction, actionResult,  actionGoal, moveCost );
	}
	
	
	public static void printResults(List<Action> actions, GraphSearch search, String heuristicName, long start) {
		
		long end = System.currentTimeMillis();
		
		System.out.println("######### Result for " + heuristicName + " ##############");
		for( Action a : actions) {
				System.out.println("\t" + a);
		}
		
		System.out.println("\t------------------------------------");
		System.out.println("\t" + "Number of generated nodes: " + search.getNumberOfGeneratedNodes() );
		System.out.println("\t" + "Number of expanded nodes: " + search.getNumberOfExpandedNodes() );
		System.out.println("\t" + "Number of moves: " + actions.size() );
		System.out.println("\t" + "Number of miliseconds to solve: " + (end - start));
		System.out.println();
	}
	
	
	
	public static void main( String[] args ) {
		PuzzleState init = enterInitState();
		Problem p = createProblem( init );
		
		HeuristicFunction md = new ManhattanDistance();
		HeuristicFunction hd = new HammingDistance();

		GraphSearch gs1 = new GraphSearch();
		GraphSearch gs2 = new GraphSearch();
		AStarSearch search1 = new AStarSearch( gs1, md);
		AStarSearch search2 = new AStarSearch( gs2, hd);
		
		long start = 0;
		start = System.currentTimeMillis();
		try {
			printResults(search1.search(p), gs1, "ManhattanDistance", start);
		} catch(Exception e) {
			System.out.println("FatalError: search failed");
		}
		
		start = System.currentTimeMillis();
		try {
			printResults(search2.search(p), gs2, "HammingDistance", start);
		} catch(Exception e) {
			System.out.println("FatalError: search failed");
		}
	}
}
