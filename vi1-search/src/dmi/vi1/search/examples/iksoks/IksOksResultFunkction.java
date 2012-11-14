/**
 * 
 */
package dmi.vi1.search.examples.iksoks;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;
import dmi.vi1.search.games.GameState;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class IksOksResultFunkction implements ResultFunction {

	
	@Override
	public Object result(Object s, Action a) {
		GameState state = (GameState)s;
		IksOksBoard board = (IksOksBoard)state.getBoard();
		IksOksBoard newBoard = board.cloneBoard();
		IksOksAction action = (IksOksAction)a;
		newBoard.mark(action.getXyLocation(), action.getMark());
		
		String playerToMove;
		if(action.getMark()==IksOksBoard.O){
			playerToMove = IksOksBoard.X;
		}else{
			playerToMove = IksOksBoard.O;
		}
		
		GameState newState = new GameState(playerToMove, newBoard);
		
		return newState;
	}

}
