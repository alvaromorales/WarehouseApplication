/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the Location object that has information regarding an item's location in the warehouse
 * @author Alvaro Morales
 * @date 24/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

public class Location implements Comparable {

	/**
	 * The warehouse number where the item is stored
	 */
	private byte warehouse;

	/**
	 * The aisle where the item is stored
	 */
	private byte aisle;

	/**
	 * The column of the aisle where the item is stored
	 */
	private byte column;

	/**
	 * The row of the aisle where the item is stored
	 */
	private char row;


	/**
	 * Constructs a new Location object
	 * @param aisle - the aisle where the item is tored
	 * @param column - the column of the aisle where the item is stored
	 * @param row - the row of the aisle where the item is stored
	 * @param position - the position in a row/column location where the item is stored
	 */
	public Location(byte aisle, byte column, char row){
		this.warehouse = 1;		//this application deals with item stored in Warehouse 1
		this.aisle = aisle;
		this.column = column;
		this.row = row;
	}

	/**
	 * Constructs a new Location object
	 * @param aisle - the aisle where the item is tored
	 * @param column - the column of the aisle where the item is stored
	 * @param row - the row of the aisle where the item is stored
	 * @param position - the position in a row/column location where the item is stored
	 */
	public Location(byte warehouse, byte aisle, byte column, char row){
		this.warehouse = warehouse;
		this.aisle = aisle;
		this.column = column;
		this.row = row;
	}


	/**
	 * Gets the aisle number where the item is stored
	 * @return the aisle number where the item is stored
	 */
	public byte getAisle() {
		return aisle;
	}

	/**
	 * Sets the aisle number where the item is stored
	 * @param aisle - the aisle number where the item is stored, of type byte
	 */
	public void setAisle(byte aisle) {
		this.aisle = aisle;
	}

	/**
	 * Gets the column where the item is stored
	 * @return the column where the item is stored
	 */
	public byte getColumn() {
		return column;
	}

	/**
	 * Sets the column where the item is stored
	 * @param column - the column where the item is stored, of type byte
	 */
	public void setColumn(byte column) {
		this.column = column;
	}

	/**
	 * Gets the row where the item is stored
	 * @return the row where the item is stored
	 */
	public char getRow() {
		return row;
	}

	/**
	 * Sets the row where the item is stored
	 * @param row - the row where the item is stored, of type char
	 */
	public void setRow(char row) {
		this.row = row;
	}

	/**
	 * Gets the warehouse number where the item is stored
	 * @return the warehouse number where the item is stored
	 */
	public byte getWarehouse() {
		return warehouse;
	}

	/**
	 * Sets the warehouse number where the item is stored
	 * @param warehouse - the warehouse number where the item is stored
	 */
	public void setWarehouse(byte warehouse) {
		this.warehouse = warehouse;
	}

	/**
	 * Outputs the Location object in the format A01.AA.RCC 
	 * where AA is the aisle number, R is the row char and CC is the column number
	 * @return the Location of the item
	 */
	public String toString(){

		String aisle = "" + getAisle();
		if(aisle.length()!= 2){
			aisle = "0" + aisle;
		}

		String column = "" + getColumn();
		if(column.length()!= 2){
			column = "0" + column;
		}

		return ("A01." + aisle + "." + getRow() + column);

	}

	/**
	 * Checks if this Location object is equal to another one
	 * @param o - the object to compare
	 * @return true if the aisle, row and column number match, else false
	 */
	public boolean equals(Object o){
		if(!(o instanceof Location)){
			return false;
		}
		Location location = (Location)o;
		return (location.getAisle() == getAisle() && location.getRow() == getRow() 
				&& location.column == getColumn());
	}

	/**
	 * Compares this Location to another Location
	 * @param o - the object (of type Location) to compare to
	 * @return 0 if equal, 1 if this object is greater than o, -1 if this object is less than o
	 */
	public int compareTo(Object o) throws ClassCastException{
		if (o instanceof Location) {
			Location location = (Location) o;
			if(equals(o)){
				return 0;
			} else if(getAisle() < location.getAisle()){
				return -1;
			} else if(getAisle() > location.getAisle()){
				return 1;
			} else if(getColumn() < location.getColumn()){
				return -1;
			} else if (getColumn() > location.getColumn()){
				return 1;
			} else if (getRow() < location.getRow()){
				return -1;
			} else {
				return 1;
			}
		} else {
			throw new ClassCastException();
		}
	}


}
