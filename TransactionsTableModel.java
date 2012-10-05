import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * A TableModel for the displaying of transactions
 * @author Alvaro Morales
 * @date 10/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class TransactionsTableModel extends AbstractTableModel {

	/**
	 * An ArrayList of TransactionRecord objects that will be displayed in the table
	 */
	private ArrayList transactionsToDisplay;
	
	/**
	 * Constructs a TransactionsTableModel object to display transactions in a JTable
	 * @param transactionsToDisplay - an ArrayList of TransactionRecord objects that will be displayed in the table
	 */
	public TransactionsTableModel(ArrayList transactionsToDisplay){
		this.transactionsToDisplay = transactionsToDisplay;
	}
	
	/**
	 * Returns the number of columns in the table
	 * @return - the number of columns in the table
	 */
	public int getColumnCount(){
		return 8;
	}
	
	/**
	 * Returns the number of rows in the table
	 * @return - the number of rows in the table (the number of items in the ArrayList)
	 */
	public int getRowCount(){
		if(transactionsToDisplay!= null){
			return transactionsToDisplay.size();
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

		TransactionRecord transaction = (TransactionRecord)transactionsToDisplay.get(row);

		switch(col){
		case 0: 
			GregorianCalendar transactionDate = transaction.getDate();
			int day = transactionDate.get(Calendar.DAY_OF_MONTH);
			int month = transactionDate.get(Calendar.MONTH);
			int year = transactionDate.get(Calendar.YEAR);
			return (day + "/" + month + "/" + year);
		case 1:
			if(transaction.getType() == ApplicationConstants.ITEM_ENTRY){
				return "Entry";
			} else {
				return "Exit";
			}
		case 2:
			return new Integer(transaction.getQuantity());
		case 3:
			return new Integer(transaction.getBalance());
		case 4:
			return transaction.getDocument();
		case 5:
			if(transaction.getType() == ApplicationConstants.ITEM_ENTRY){
				return transaction.getThirdParty();
			} else {
				return null;
			}
		case 6:
			if(transaction.getType() == ApplicationConstants.ITEM_EXIT){
				return transaction.getThirdParty();
			} else {
				return null;
			}
		case 7:
			return transaction.getWarehouseWorker();
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
			return "Date";
		case 1:
			return "Type";
		case 2:
			return "Quantity";
		case 3:
			return "Balance";
		case 4:
			return "Document";
		case 5:
			return "Delivered By";
		case 6:
			return "Requested By";
		case 7:
			return "Warehouse Staff";
		default:
			return null;
		}
	}
	
	/**
	 * Returns if a cell is editable
	 * @return a boolean indicating if the cell is editable
	 */
	public boolean isCellEditable(int row, int col){
		return false;
	}

	/**
	 * Gets the ArrayList of TransactionRecord objects to display
	 * @return the ArrayList of TransactionRecord objects to display
	 */
	public ArrayList getTransactionsToDisplay() {
		return transactionsToDisplay;
	}
	
}
