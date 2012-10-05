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

public class TransactionProcessingTableModel extends AbstractTableModel {

	/**
	 * An ArrayList of items to process (either enter into or withdraw from the warehouse)
	 */
	private ArrayList itemsToProcess;
	
	/**
	 * An array of transactions
	 */
	private TransactionRecord[] transactions;

	/**
	 * Constructs a SearchResultsTableModel
	 * @param itemsToProcess - an ArrayList of the search results
	 */
	public TransactionProcessingTableModel(ArrayList itemsToProcess){
		this.itemsToProcess = itemsToProcess;
		
		if(itemsToProcess != null){
			transactions = new TransactionRecord[itemsToProcess.size()];
			
			//Initialize the transactions
			for(int i=0;i<transactions.length;i++){
				transactions[i] = new TransactionRecord();
			}
		}
		
	}

	/**
	 * Returns the number of columns in the table
	 * @return - the number of columns in the table
	 */
	public int getColumnCount(){
		return 5;
	}

	/**
	 * Returns the number of rows in the table
	 * @return - the number of rows in the table (the number of items in the ArrayList)
	 */
	public int getRowCount(){
		if(itemsToProcess!= null){
			return itemsToProcess.size();
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

		Item item = (Item)itemsToProcess.get(row);

		switch(col){
		case 0: 
			return item.getCode();
		case 1:
			return item.getName();
		case 2:
			return item.getUm().toString();
		case 3:
			return new Integer(Transactions.getQuantityInStock(item));
		case 4:
			if(transactions[row].getQuantity() != 0){
				return new Integer(transactions[row].getQuantity());
			} else {
				return new Integer(0);
			}
			
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
			return "U.M.";
		case 3:
			return "In Stock";
		case 4:
			return "Quantity*";
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
			return Integer.class;
		case 4:
			return Integer.class;
		default:
			return null;
		}

	}

	/**
	 * Returns if a cell is editable (only the 'Quantity' column)
	 * @return false unless the col index is column 4 (quantity)
	 */
	public boolean isCellEditable(int row, int col){
		if(col == 4){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns an ArrayList of the search results
	 * @return an ArrayList of the search results
	 */
	public ArrayList getSearchResults(){
		return itemsToProcess;
	}

	/**
	 * Sets the value for the quantity of the transaction
	 */
	public void setValueAt(Object field, int row, int col){	

		switch(col){
		case 4:
			transactions[row].setQuantity(((Integer)field).intValue());
			break;
		default:
			break;
		}
	}

	/**
	 * Gets the transactions
	 * @return the transactions to process
	 */
	public TransactionRecord[] getTransactions() {
		return transactions;
	}

}
