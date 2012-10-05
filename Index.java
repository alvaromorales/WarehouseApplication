import java.util.StringTokenizer;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the Index object that stores information regarding the position of an Item in the Items file
 * @author Alvaro Morales
 * @date 24/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class Index implements Comparable {

	/**
	 * The position of the Item in the Items file (effectively the Item's ID)
	 */
	private int position;
	
	/**
	 * The field by which the Item is being indexed
	 * Index can be by Item Name or Code
	 */
	private String field;

	/**
	 * Constructs an Index object
	 * @param position - the position of the Item in the item's file (effectively the Item's ID)
	 */
	public Index(int position, String field) {
		this.position = position;
		this.field = field;
	}
	
	/**
	 * Constructs an Index object from a tokenized String from the index file.
	 * Format: field|position
	 * @param line - a tokenized String from the index file
	 */
	public Index(String line){
		StringTokenizer tokenizer = new StringTokenizer(line, "|");		//Tokenize string

		String field = tokenizer.nextToken();
		int position = new Integer(tokenizer.nextToken()).intValue();
		
		this.position = position;
		this.field = field;
	}

	/**
	 * Gets the position of the item in the Items file
	 * @return the position of the item in the Items file
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the position of the item in the Items file
	 * @param position - the position in the items file, of type int
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Gets the field by which the item is being indexed
	 * @return the field by which the item is being indexed (code or name)
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets the field by which the item is being indexed
	 * @param field - the field by which the item is being indexed, of type String
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * Outputs the Index object formatted for the index file:
	 * Field + | + position.
	 * @return a String representation of the Index, formatted for the index file
	 */
	public String toString(){
		return new String(getField() + "|" + getPosition());
	}
	
	/**
	 * Compares an Index by comparings its field value using the method compareTo(String s)
	 * @param index - the index to compare
	 * @return 0 if they are equal, 1 if index is greater, -1 if index is smaller
	 */
	public int compareTo(Index index){
		return this.getField().compareTo(index.getField());
	}
	
	/**
	 * Compares an Index by comparings its field value using the method compareTo(String s)
	 * @param index - the index to compare
	 * @return 0 if they are equal, 
	 * a value greater than 0 if index is greater, 
	 * a value less than 0 if index is smaller
	 * @throws ClassCastException if the object being compared is not an instance of Index
	 */
	public int compareTo(Object o) throws ClassCastException {
		if (!(o instanceof Index)) {
			throw new ClassCastException();
		}
		
		if (o instanceof Index) {
			Index i = (Index) o;
			int comparison = this.field.compareTo(i.getField());
			return comparison;
		}
		
		return Integer.MIN_VALUE;	//if it is not an instance of Index
	}
	
}
