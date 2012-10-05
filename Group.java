/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the Group object that has information regarding item groups
 * @author Alvaro Morales
 * @date 24/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class Group {

	/**
	 * The group code
	 */
	private short code;
	
	/**
	 * The group name
	 */
	private String name;
	
	/**
	 * Constructs a Group object
	 * @param code - the group code of type short
	 * @param name - the group name of type name
	 */
	public Group(short code, String name){
		this.code = code;
		this.name = name;
	}

	/**
	 * Gets the group code
	 * @return the group code of type short
	 */
	public short getCode() {
		return code;
	}

	/**
	 * Sets the group code
	 * @param code, the group code of type short
	 */
	public void setCode(short code) {
		this.code = code;
	}

	/**
	 * Gets the group name
	 * @return the group name of type String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the group name
	 * @param name, the group name of type String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Outputs the name of the group
	 */
	public String toString(){
		return getName();
	}
	
}
