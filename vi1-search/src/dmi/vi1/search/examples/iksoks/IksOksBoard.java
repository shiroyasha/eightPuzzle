/**
 * 
 */
package dmi.vi1.search.examples.iksoks;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.datastructure.XYLocation;



/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class IksOksBoard {
	
	public static final String O = "O";
	public static final String X = "X";
	public static final String EMPTY = "-";
	
	private String[] state = new String[9];
	
	
	
	public IksOksBoard() {
		super();
		
	}

	/**
	 * @param state
	 */
	public IksOksBoard(String[] state) {
		super();
		this.state = state;
	}

	private int getAbsPosition(int row, int col) {
		return row * 3 + col;
	}
	
	public String[] getState() {
		return state;
	}

	public void setState(String[] state) {
		this.state = state;
	}
	
	public String getValue(int row, int col) {
		return state[getAbsPosition(row, col)];
	}

	public void setValue(int row, int col, String val) {
		state[getAbsPosition(row, col)] = val;
	}
	
	public boolean isEmpty(int row, int col) {
		return state[getAbsPosition(row, col)] == EMPTY;
	}
	
	public void mark(XYLocation loc, String mark){
		state[getAbsPosition(loc.getPositionX(), loc.getPositionY())]=mark;
		
	}
	
	public boolean isAnyRowComplete() {
		for (int i = 0; i < 3; i++) {
			String val = getValue(i, 0);
			if (val != EMPTY && val == getValue(i, 1) && val == getValue(i, 2))
				return true;
		}
		return false;
	}

	public boolean isAnyColumnComplete() {
		for (int j = 0; j < 3; j++) {
			String val = getValue(0, j);
			if (val != EMPTY && val == getValue(1, j) && val == getValue(2, j))
				return true;
		}
		return false;
	}

	public boolean isAnyDiagonalComplete() {
		boolean retVal = false;
		String val = getValue(0, 0);
		if (val != EMPTY && val == getValue(1, 1) && val == getValue(2, 2))
			return true;
		val = getValue(0, 2);
		if (val != EMPTY && val == getValue(1, 1) && val == getValue(2, 0))
			return true;
		return retVal;
	}
	
	public List<XYLocation> getEmptyPositions() {
		List<XYLocation> retVal = new ArrayList<XYLocation>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (isEmpty(i, j)) {
					retVal.add(new XYLocation(i, j));
				}
			}

		}
		return retVal;
	}
	
	public boolean isTerminalState(){
		return getEmptyPositions().size()==0 || someoneWon();
	}
	
	public boolean someoneWon() {
		return (isAnyRowComplete() || isAnyColumnComplete() || isAnyDiagonalComplete());
	}
	
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				buf.append(getValue(i, j) + " ");
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public IksOksBoard cloneBoard() {
		return (IksOksBoard) clone();
	}

	@Override
	public Object clone() {
		IksOksBoard newBoard = new IksOksBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String s = getValue(i, j);
				newBoard.setValue(i, j, s);
			}
		}
		return newBoard;
	}
	
	public void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(getValue(i, j) + " ");
			System.out.println();
		}
	}
	


}
