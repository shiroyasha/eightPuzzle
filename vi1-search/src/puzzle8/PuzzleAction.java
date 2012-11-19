package puzzle8;

import dmi.vi1.search.framework.Action;

public class PuzzleAction implements Action {

	private int first;
	private int second;

	public PuzzleAction(int first, int second) {
		this.first=first;
		this.second=second;
	}

	@Override
	public boolean isNoOpAction() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	@Override
	public String toString(){
		return " pomjeram plocicu sa pozicije "+PuzzleState.getRow(second)+","+PuzzleState.getColumn(second)
				+" na poziciju "+PuzzleState.getRow(first)+","+PuzzleState.getColumn(first);
	}
	

}
