/**
 * 
 */
package dmi.vi1.search.examples.iksoks;


import dmi.vi1.search.games.Game;
import dmi.vi1.search.games.GameState;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class IksOks extends Game {
	
	
	
	
	public IksOks(){			
		gameActionsFunction = new IksOksActionsFunctions();
		gameResultFunction = new IksOksResultFunkction();		
	}
	

	
	@Override
	protected int computeUtility(GameState state) {	
		IksOksBoard board = (IksOksBoard) state.getBoard();		
		int retVal = 0;
		if (board.someoneWon()) {
			if (state.getPlayerToMove().equals(IksOksBoard.X)) {
				retVal = -1;
			} else {
				retVal = 1;
			}
		}
		return retVal;	
	}

	
	@Override
	protected boolean terminalTest(GameState state) {		
		return ((IksOksBoard)state.getBoard()).isTerminalState();
	}
	
	public static void main(String[] args){		
		IksOks iksOks = new IksOks();
		String[] positions = 
			{IksOksBoard.O,     IksOksBoard.X,     IksOksBoard.O, 
			 IksOksBoard.X,     IksOksBoard.O,     IksOksBoard.X, 
			 IksOksBoard.EMPTY, IksOksBoard.EMPTY, IksOksBoard.EMPTY};
		IksOksAction action = (IksOksAction)iksOks.minimaxDecision(new GameState(IksOksBoard.X, new IksOksBoard(positions)));
		System.out.println(action.toString());
		
	}
	
	

}
