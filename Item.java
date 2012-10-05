import java.io.*;
import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the Item object that has information regarding an item stored inside the warehouse
 * @author Alvaro Morales
 * @date 24/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * @mastery achieves HL mastery factor 8 by having private instance variables 
 * and providing appropriate getters and setters
 * @mastery achieves SL mastery factor 2 as it is a user defined method with attributes and operations
 * @mastery achieves SL mastery factor 3 as the Item object is used as a data record
 * ---------------------------------------------------------------------
 */

public class Item {

	/**
	 * The ID of the item in the internal system
	 */
	private int ID;

	/**
	 * The code of the item in the existing system
	 * Stored as a String to allow leading 0's
	 */
	private String code;

	/**
	 * The item's name
	 */
	private String name;

	/**
	 * The Group an item belongs to
	 */
	private Group group;

	/**
	 * The Unit of Measurement (UM) by which the item is measured and stored
	 */
	private UM um;

	/**
	 * The item's description
	 */
	private String description;

	/**
	 * The Location of the item inside the warehouse
	 */
	private Location location;

	/**
	 * The username of the user that created the Item
	 */
	private String createdBy;

	/**
	 * The Item's creation date
	 */
	private GregorianCalendar creationDate;

	/**
	 * A comparator based on location
	 */
	public static final Comparator LOCATION_ORDER = new Comparator() {
		public int compare(Object obj1, Object obj2){
			return ((Item)obj1).getLocation().compareTo(((Item)obj2).getLocation());
		}
	};

	/**
	 * Constructs an Item object
	 * @param ID - the ID of the item in the internal system
	 * @param code - the code of the item in the existing system
	 * @param name - the item's name
	 * @param group - the Group an item belongs to
	 * @param um - the Unit of Measurement (UM) by which the item is measured and stored
	 * @param description - the item's description
	 * @param location - the Location of the item inside the warehouse
	 */
	public Item(int ID, String code, String name, Group group, UM um, String description, 
			Location location, String createdBy, GregorianCalendar creationDate){
		this.ID = ID;
		this.code = code;
		this.name = name;
		this.group = group;
		this.um = um;
		this.description = description;
		this.location = location;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}

	/**
	 * Gets the Item's code
	 * @return the item code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the item's code
	 * @param code - the item code (in the existing system), of type String
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the item description
	 * @return the item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the item description
	 * @param description - the item description, of type String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the group the item belongs to
	 * @return the group the item belongs to
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Gets the name of the user that created this item
	 * @return the username of the user that created this item
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the name of the user that created this item
	 * @param createdBy - the username of the user that created this item, of type String
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the item's creation date
	 * @return the item's creation date
	 */
	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the item's creation date
	 * @param creationDate - the item's creation date, of type GregorianCalendar
	 */
	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Sets the group an item belongs to
	 * @param group - the group an item belongs to, of type Group
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * Gets the item ID (of the internal system)
	 * @return the item ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the item ID
	 * @param id - the item ID, of type int
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * Gets the Location of the item stored in the warehouse
	 * @return the item location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the Location of where the item is stored in the warehouse
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the item name
	 * @return the item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the item name
	 * @param name - the item name, of type String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Unit of Measurement (UM) by which the item is stored/measured
	 * @return the unit of measurement
	 */
	public UM getUm() {
		return um;
	}

	/**
	 * Sets the Unit of Measurement (UM) by which the item is stored/measured
	 * @param um - the unit of measurement, of type UM
	 */
	public void setUm(UM um) {
		this.um = um;
	}

	/**
	 * Writes the Item object to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	public void writeItemToFile(RandomAccessFile file){
		writeIDToFile(file);
		writeCodeToFile(file);
		writeNameToFile(file);
		writeGroupToFile(file);
		writeUMToFile(file);
		writeDescriptionToFile(file);
		writeLocationToFile(file);
		writeCreatedBy(file);
		writeCreationDate(file);
	}

	/**
	 * Writes the Item ID to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeIDToFile(RandomAccessFile file){
		try{
			file.getFilePointer();
			file.writeInt(getID());
		} catch (Exception e) {

		}

	}

	/**
	 * Writes the Item Code to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeCodeToFile(RandomAccessFile file){
		String code = getCode();
		while(code.length()!= 6){
			code = "0" + code;
		}

		try{
			file.writeUTF(code);
		} catch (Exception e) {

		}
	}

	/**
	 * Writes the Item Name to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeNameToFile(RandomAccessFile file){
		String name = getName();

		while(name.length()!= 200){
			name = name + " ";
		}

		try{
			file.writeUTF(name);
		} catch (Exception e) {

		}
	}

	/**
	 * Writes the Item Group to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeGroupToFile(RandomAccessFile file){
		try{
			file.writeShort(getGroup().getCode());
		} catch (Exception e) {

		}
	}

	/**
	 * Writes the Item UM to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeUMToFile(RandomAccessFile file){
		try{
			file.writeShort(getUm().getCode());
		} catch (Exception e) {

		}
	}

	/**
	 * Writes the Item description to the Items Random Access File
	 * @param file - the Items Random Access File
	 */
	private void writeDescriptionToFile(RandomAccessFile file){
		String description = getDescription();

		if(description == null || description.equals("")){		//As description is optional
			description = "<No description>";
		}

		while(description.length()!= 200){
			description = description + " ";
		}

		try{
			file.writeUTF(description);
		} catch (Exception e) {

		}

	}

	/**
	 * Writes the Item location to the Items Random Access File
	 * @param file - the Item's Random Access File
	 */
	private void writeLocationToFile(RandomAccessFile file){
		try{
			file.writeByte(1);							//Write the warehouse number
			file.writeByte(getLocation().getAisle());	//Write the aisle number
			file.writeByte(getLocation().getColumn());	//Write the column number
			file.writeChar(getLocation().getRow());		//Write the row number
		} catch (Exception e) {

		}
	}

	/**
	 * Writes the username of the user that created the Item to the Items Random Access File
	 * @param file- the Item's Random Access File
	 */
	private void writeCreatedBy(RandomAccessFile file){
		String createdBy = getCreatedBy();

		try{
			while(createdBy.length()!= 20){
				createdBy = createdBy + " ";
			}

			file.writeUTF(createdBy);
		} catch (Exception e){

		}
	}

	/**
	 * Writes the Item's creation date to the Items Random Access File
	 * @param file - the Item's Random Access File
	 */
	private void writeCreationDate(RandomAccessFile file){
		try{
			file.writeShort(getCreationDate().get(Calendar.YEAR));
			file.writeByte(getCreationDate().get(Calendar.MONTH));
			file.writeByte(getCreationDate().get(Calendar.DAY_OF_MONTH));
		} catch (Exception e){

		}
	}

	/**
	 * Outputs the item in the format Code: Name
	 */
	public String toString(){
		return getCode() + ": " + getName();
	}


}
