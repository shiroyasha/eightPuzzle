/**
 * 
 */
package dmi.vi1.search.games;

import java.util.List;



/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class GameState {
	
	
	private Object playerToMove;	
	private Object board;
	
	
	
	public GameState(Object playerToMove, Object board) {
		super();
		this.playerToMove = playerToMove;
		this.board = board;
	}
	
	
	/**
	 * @return the playerToMove
	 */
	public Object getPlayerToMove() {
		return playerToMove;
	}
	/**
	 * @param playerToMove the playerToMove to set
	 */
	public void setPlayerToMove(Object playerToMove) {
		this.playerToMove = playerToMove;
	}	
	/**
	 * @return the board
	 */
	public Object getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(Object board) {
		this.board = board;
	}
	
	
	
	
	
}
