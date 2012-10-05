import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Class contains methods relevant to Item processing
 * @author Alvaro Morales
 * @date 10/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

public class Items {

	/**
	 * Gets an Item from the Items Random Access File given its position in the file
	 * @param position - the position of the item in the file (the Item's ID)
	 * @return the Item at that position, or null if found or not matching the ID provided
	 */
	public static Item getItemFromFile(int position){
		try{
			RandomAccessFile file = new RandomAccessFile(ApplicationConstants.ITEMS_FILE, "r");

			file.seek(position * ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH);

			int ID = file.readInt();

			if(ID == position){		//The correct item has been found
				String code = removeExtraSpaces(file.readUTF());
				String name = removeExtraSpaces(file.readUTF());
				short groupCode = file.readShort();
				short umCode = file.readShort();
				String description = removeExtraSpaces(file.readUTF());
				byte warehouseNumber = file.readByte();
				byte aisleNumber = file.readByte();
				byte columnNumber = file.readByte();
				char row = file.readChar();
				String createdBy = removeExtraSpaces(file.readUTF());
				short year = file.readShort();
				byte month = file.readByte();
				byte day = file.readByte();

				Group group = getGroup(groupCode);
				UM um = getUM(umCode);
				Location location = new Location(warehouseNumber, aisleNumber, columnNumber, row);
				GregorianCalendar creationDate = new GregorianCalendar(year, month, day);

				return new Item(ID, code, name, group, um, description, location, createdBy, creationDate);
			} else {
				return null;
			}

		} catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Sequentially searches the Items file to search for an item by group
	 * @param groupCode - the code of the group (search query)
	 * @return an ArrayList of items belonging to that group
	 */
	public static ArrayList searchByGroup(short groupCode){
		try{
			ArrayList searchResults = new ArrayList();
			RandomAccessFile file = new RandomAccessFile(ApplicationConstants.ITEMS_FILE, "r");

			int position;
			int numberOfRecords = (int)file.length() / ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH;

			for(int i=0;i<numberOfRecords;i++){
				file.seek(i * ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH);
				position = file.readInt();
				if(position!=-999){		//if record is not empty
					file.seek(position * ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH);
					Item item = getItemFromFile(position);
					if(item.getGroup().getCode() == groupCode){
						searchResults.add(item);
					}
				}
			}
			searchResults.trimToSize();
			return searchResults;
		} catch (Exception e){
			return null;
		}
	}
	
	/**
	 * Sequentially searches the Items file to search for an item by location
	 * @param location - the location of the item (search query)
	 * @return an ArrayList of items stored at that location
	 */
	public static ArrayList searchByLocation(Location location){
		try{
			ArrayList searchResults = new ArrayList();
			RandomAccessFile file = new RandomAccessFile(ApplicationConstants.ITEMS_FILE, "r");

			int position;
			int numberOfRecords = (int)file.length() / ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH;

			for(int i=0;i<numberOfRecords;i++){
				file.seek(i * ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH);
				position = file.readInt();
				if(position!=-999){		//if record is not empty
					file.seek(position * ApplicationConstants.ITEMS_FILE_RECORD_LENTGTH);
					Item item = getItemFromFile(position);
					if(item.getLocation().getAisle() == location.getAisle() &&
							item.getLocation().getRow() == location.getRow() &&
							item.getLocation().getColumn() == location.getColumn()){
						searchResults.add(item);
					}
				}
			}

			searchResults.trimToSize();
			return searchResults;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * Gets a Group object from the Groups array given its Group code
	 * @param groupCode - the code of the Group
	 * @return the Group matching the code provided, or null if not found
	 */
	public static Group getGroup(short groupCode){
		for (int i = 0; i < MainScreen.groups.length; i++){
			if(MainScreen.groups[i].getCode() == groupCode){
				return MainScreen.groups[i];
			}
		}

		return null;
	}

	/**
	 * Gets a UM object from the UM array given its UM code
	 * @param umCode - the code of the Unit of Measurement (UM)
	 * @return the UM matching the code provided, or null if not found
	 */
	public static UM getUM(short umCode){
		for (int i = 0; i < MainScreen.umArray.length; i++){
			if(MainScreen.umArray[i].getCode() == umCode){
				return MainScreen.umArray[i];
			}
		}

		return null;
	}

	/**
	 * Removes the extra spaces at the end of a String
	 * @param s - the String to remove extra spaces from
	 * @return the same String without the extra spaces at the end
	 */
	public static String removeExtraSpaces(String s){
		while(s.charAt(s.length() -1) == ' '){
			s = s.substring(0, s.length() -1);
		}
		return s;
	}
	
}
