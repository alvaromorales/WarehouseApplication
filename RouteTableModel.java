import java.util.ArrayList;
import javax.swing.table.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * The table model for the Optimal Route table
 * @author Alvaro Morales
 * @date 14/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class RouteTableModel extends AbstractTableModel {

	/**
	 * An ArrayList of Items to pick up from the warehouse
	 */
	private ArrayList itemsToWithdraw;
	
	
	/**
	 * Constructs a TransactionsTableModel object to display transactions in a JTable
	 * @param itemsToWithdraw - an ArrayList of TransactionRecord objects that will be displayed in the table
	 */
	public RouteTableModel(ArrayList itemsToWithdraw){
		this.itemsToWithdraw = itemsToWithdraw;
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
		if(itemsToWithdraw!= null){
			return itemsToWithdraw.size();
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

		Item item = (Item)itemsToWithdraw.get(row);

		switch(col){
		case 0: 
			return new Integer(row+1);
		case 1:
			return item.getCode();
		case 2:
			return item.getName();
		case 3:
			return item.getUm().toString();
		case 4:
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
			return "Order";
		case 1:
			return "Code";
		case 2:
			return "Name";
		case 3:
			return "UM";
		case 4:
			return "Location";
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
	public ArrayList getItemsToWithdraw() {
		return itemsToWithdraw;
	}
}
