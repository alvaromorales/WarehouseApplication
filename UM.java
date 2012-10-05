/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the UM (Unit of Measurement) object that has information regarding unit of measurements for items
 * @author Alvaro Morales
 * @date 24/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

public class UM {

	/**
	 * The UM's code
	 */
	private short code;
	
	/**
	 * The UM's name
	 */
	private String name;
	
	/**
	 * Constructs a new UM (Unit of Measurement) object
	 * @param code - the UM's code of type short
	 * @param name - the UM's name of type String
	 */
	public UM(short code, String name){
		this.code = code;
		this.name = name;
	}

	/**
	 * Gets the UM's (Unit of Measurement's) code
	 * @return the UM's code
	 */
	public short getCode() {
		return code;
	}

	/**
	 * Sets the UM's (Unit of Measurement's) code
	 * @param code - the UM's code of type short
	 */
	public void setCode(short code) {
		this.code = code;
	}

	/**
	 * Gets the UM's (Unit of Measurement's) name
	 * @return the UM's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the UM's (Unit of Measurement's) name
	 * @param name - the UM's name of type String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the Unit of Measurement (UM)
	 */
	public String toString(){
		return getName();
	}
	
}
