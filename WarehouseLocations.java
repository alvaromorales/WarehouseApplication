/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Stores the number of aisles in the warehouse and the number of rows and columns per rack
 * @author Alvaro Morales
 * @date 03/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class WarehouseLocations {

	/**
	 * An array of aisles in the warehouse
	 */
	private Integer[] aisles = completeIntegerArray(70);
	
	/**
	 * An array of rows in a rack in the warehouse
	 */
	private String[] rows = completeStringArray('E');
	
	/**
	 * An array of columns in a rack in the warehouse
	 */
	private Integer[] columns = completeIntegerArray(10);
	
	/**
	 * Constructs a new WarehouseLocations object.
	 * 70 aisles from 1 - 70,
	 * 5 rows per rack from A - E,
	 * 10 columns per rack from 1 - 10.
	 */
	public WarehouseLocations(){

	}

	/**
	 * Completes an int array given its last value
	 * @param intArray - the int array to complete
	 * @param lastAisle - the last value
	 */
	private Integer[] completeIntegerArray(int lastValue){
		Integer[] intArray = new Integer[lastValue];
		
		int value = 0;
		
		for (int i=0;i<intArray.length;i++){
			intArray[i] = new Integer(value+1);
			value = value + 1;
		}
		
		return intArray;
	}
	
	/**
	 * Complete a char array given its last uppercase char from the first value 'A'
	 * @param charArray - the char array to complete
	 * @param lastChar - the last uppercase char
	 */
	private String[] completeStringArray(char lastChar){
		char firstChar = (char)((int)('A')-1);
		int size = (int)lastChar - (int)firstChar;
		
		String[] stringArray = new String[size];
		
		char character = (int)('A')-1;
		
		for (int i=0;i<stringArray.length;i++){
			stringArray[i] = new String("" + (char)(character+1));
			character = (char)(character+1);

		}
		return stringArray;
	}

	/**
	 * Gets the array of aisle numbers
	 * @return the array of aisle numbers
	 */
	public Integer[] getAisles() {
		return aisles;
	}

	/**
	 * Gets the array of column numbers
	 * @return
	 */
	public Integer[] getColumns() {
		return columns;
	}

	/**
	 * Gets the array of row characters
	 * @return the array of row characters
	 */
	public String[] getRows() {
		return rows;
	}
	
}
