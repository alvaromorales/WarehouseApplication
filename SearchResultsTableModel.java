import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the New User screen and handles new user creation
 * @author Alvaro Morales
 * @date 10/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

public class SearchResultsTableModel extends AbstractTableModel {

	/**
	 * An ArrayList of search results
	 */
	private ArrayList searchResults;

	/**
	 * Constructs a SearchResultsTableModel object
	 * @param searchResults - an ArrayList of the search results
	 */
	public SearchResultsTableModel(ArrayList searchResults){
		this.searchResults = searchResults;
	}

	/**
	 * Returns the number of columns in the table
	 * @return - the number of columns in the table (7)
	 */
	public int getColumnCount(){
		return 6;
	}

	/**
	 * Returns the number of rows in the table
	 * @return - the number of rows in the table (the number of items in the ArrayList)
	 */
	public int getRowCount(){
		if(searchResults!= null){
			return searchResults.size();
		} else {
			return 0;
		}

	}

	/**
	 * Returns the object in a cell of the table at a given row-column location
	 * @param row - row number
	 * @param col - column number
	 * @return - the object at that row-column location
	 */
	public Object getValueAt(int row, int col){

		Item item = (Item)searchResults.get(row);

		switch(col){
		case 0: 
			return item.getCode();
		case 1:
			return item.getName();
		case 2:
			return item.getGroup().toString();
		case 3:
			return item.getUm().toString();
		case 4:
			return new Integer(Transactions.getQuantityInStock(item));
		case 5:
			return item.getLocation().toString();
		default:
			return null;
		}
	}

	/**
	 * Returns the name of a column
	 * @param col - the column number
	 * @return the name of a column
	 */
	public String getColumnName(int col){

		switch(col){

		case 0:
			return "Code";
		case 1:
			return "Name";
		case 2:
			return "Group";
		case 3:
			return "U.M.";
		case 4:
			return "Quantity in Stock";
		case 5:
			return "Location";
		default:
			return null;
		}
	}

	/**
	 * Returns the class of a column
	 * @param col - the column number
	 * @return the Class of a column
	 */
	public Class getColumnClass(int col){

		switch(col){

		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return Integer.class;
		case 5:
			return String.class;
		default:
			return null;
		}
	}

	/**
	 * Returns if a cell is editable
	 * @return false, regardless of row-column index
	 */
	public boolean isCellEditable(int row, int col){
		return false;
	}

	/**
	 * Returns an ArrayList of the search results
	 * @return an ArrayList of the search results
	 */
	public ArrayList getSearchResults(){
		return searchResults;
	}

}
