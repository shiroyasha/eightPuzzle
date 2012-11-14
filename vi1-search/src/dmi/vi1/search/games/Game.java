/**
 * 
 */
package dmi.vi1.search.games;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;
import dmi.vi1.search.framework.ResultFunction;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public abstract class Game {
	
		
	
	
	protected int maxDepth;
	
	protected ActionsFunction gameActionsFunction;
	
	protected ResultFunction gameResultFunction;
	
	
	
	public  List<Action> getPossibleMoves(GameState state){
		return gameActionsFunction.actions(state);
	}

	public GameState makeMove(GameState state, Action a){
		return (GameState)gameResultFunction.result(state, a);
	}
	
	
	protected abstract int computeUtility(GameState state);

	protected abstract boolean terminalTest(GameState state);
	
	public Action minimaxDecision(GameState state){
		int v = Integer.MIN_VALUE;	
		Action bestAction = null;
		List<Action> actions = getPossibleMoves(state);
		for(Action a:actions){
			GameState successor = makeMove(state, a);
			System.out.println(successor.getBoard());
			int newMin = minValue(successor);
			System.out.println(newMin);
			if(newMin>v){
				v=newMin;
				bestAction = a;
			}
		}		
		return bestAction;		
	}
	
	
	// TODO depth
	// 
	public int maxValue(GameState state){
		int v = Integer.MIN_VALUE;
		if(terminalTest(state)) return computeUtility(state);
		else{
			List<Action> actions = getPossibleMoves(state);
			for(Action a:actions){
				GameState successor = makeMove(state, a);
				int newMax = minValue(successor);
				if(newMax>v)
					v=newMax;
			}
		}
		return v;		
	}
	
	// TODO depth
	//
	
	public int minValue(GameState state){
		int v = Integer.MAX_VALUE;
		if(terminalTest(state)) return computeUtility(state);
		else{
			List<Action> actions = getPossibleMoves(state);
			for(Action a:actions){
				GameState successor = makeMove(state, a);
				int newMin = maxValue(successor);
				if(newMin<v)
					v=newMin;
			}
		}
		return v;		
	}
	
	
	
	
	
	
}
