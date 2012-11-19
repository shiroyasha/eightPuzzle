package puzzle8;

public class PuzzleSlot {
	private boolean onRightPlace;
	private int value;
	private int row;
	private int column;

	public PuzzleSlot(int row, int column, int value) {
		this.row = row;
		this.column = column;
		this.value = value;
		onRightPlace = (value == (row * 3 + column));
	}

	public boolean isOnRightPlace() {
		return onRightPlace;
	}

	public void setOnRightPlace(boolean onRightPlace) {
		this.onRightPlace = onRightPlace;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString(){
		return "red :"+row+", kolona"+column+" , vrijednost:"+value ;
	}
}
