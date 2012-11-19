package puzzle8;

import java.util.ArrayList;
import java.util.List;

public class PuzzleState{
	private PuzzleSlot[] puzzleSlots;

	public PuzzleState() {
		puzzleSlots = generatePuzzle();
	}

	public PuzzleState(PuzzleSlot[] puzzleSlots) {
		this.puzzleSlots = puzzleSlots;
	}

	public boolean isFinished() {
		for (int i = 0; i < 9; i++) {
			if (puzzleSlots[i].getValue() != i) {
				return false;
			}
		}
		return true;
	}

	public PuzzleSlot[] getPuzzleSlots() {
		return puzzleSlots;
	}

	public static int getLocation(int row, int column) {
		return row * 3 + column;
	}

	public static int getRow(int location) {
		return location / 3;
	}

	public static int getColumn(int location) {
		return location % 3;
	}

	public static PuzzleSlot[] generatePuzzle() {
		PuzzleSlot[] puzzle = new PuzzleSlot[9];
		do {
			List<Integer> numberList = new ArrayList<Integer>();
			for (int i = 0; i < 9; i++) {
				numberList.add(i);
			}
			int brojac = 0;
			while (!numberList.isEmpty()) {
				int num = (int) (Math.random() * (numberList.size()));
				puzzle[brojac] = new PuzzleSlot(brojac / 3, brojac % 3,
						numberList.get(num));
				numberList.remove(num);
				brojac++;
			}

		} while (!isPuzzleSolvable(puzzle));
		return puzzle;
	}

	public static boolean isPuzzleSolvable(PuzzleSlot[] puzzleSlots) {
		int permutations = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = i ; j < 9; j++) {

				if ((puzzleSlots[j].getValue() < puzzleSlots[i].getValue()) && puzzleSlots[j].getValue()!=0) {
					permutations++;
				}
			}
		}
		return (permutations % 2) == 0;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			if(puzzleSlots[i].getValue()==0){
				string.append(" ");
			} else{
				string.append(puzzleSlots[i].getValue());
			}
			if (i == 2 || i == 5 || i == 8) {
				string.append("\n");
			} else {
				string.append(" ");
			}
		}
		return string.toString();
	}

	@Override
	public int hashCode(){
		StringBuilder value=new StringBuilder();
		for(int i=0;i<9;i++){
			value.append(puzzleSlots[i].getValue());
		}
		return value.toString().hashCode();
	}
	@Override
	public boolean equals(Object s){
		if(s==null){
			return false;
		}
		if(s==this){
			return true;
		}
		if (!(s instanceof PuzzleState)){
			return false;
		}
		PuzzleState temp=(PuzzleState)s;
		return this.hashCode()==temp.hashCode();
	}

}
