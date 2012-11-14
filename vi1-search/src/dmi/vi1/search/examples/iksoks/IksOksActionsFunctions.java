/**
 * 
 */
package dmi.vi1.search.examples.iksoks;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.datastructure.XYLocation;
import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;
import dmi.vi1.search.games.GameState;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class IksOksActionsFunctions implements ActionsFunction {

	
	@Override
	public List<Action> actions(Object s) {
		GameState state = (GameState)s;
		IksOksBoard board = (IksOksBoard)state.getBoard();
		List<XYLocation> positions = board.getEmptyPositions();
		List<Action> retVal = new ArrayList<Action>();
		for(XYLocation loc:positions){
			IksOksAction action = new IksOksAction(loc, (String)state.getPlayerToMove());
			retVal.add(action);			
		}			
		return retVal;
	}

}
