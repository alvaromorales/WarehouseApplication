import javax.swing.table.AbstractTableModel;
import javax.swing.JButton;

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

public class UsersTableModel extends AbstractTableModel {

	/**
	 * An array of users
	 */
	private User[] users;

	/**
	 * Constructs a UsersTableModel
	 * @param users - array of all users
	 */
	public UsersTableModel(User[] users){
		this.users = users;
	}

	/**
	 * Returns the number of columns in the table
	 * @return - the number of columns in the table (7)
	 */
	public int getColumnCount(){
		return 7;
	}

	/**
	 * Returns the number of rows in the table
	 * @return - the number of rows in the table (the number of users in the file)
	 */
	public int getRowCount(){
		return users.length;
	}

	/**
	 * Returns the object in a cell of the table at a given row-column location
	 * @param row - row number
	 * @param col - column number
	 * @return - the object at that row-column location
	 */
	public Object getValueAt(int row, int col){

		User user = users[row];

			switch(col){
			case 0: 
				return user.getUsername();
			case 1:
				return user.getPassword();
			case 2:
				return user.getFullName();
			case 3:
				return new Boolean(user.isAdmin());
			case 4:
				return new Boolean(user.isEntry());
			case 5:
				return new Boolean(user.isExit());
			case 6:
				return new Boolean(user.isEnabled());
			case 7:
				return new JButton("Edit");
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
			return "Username";
		case 1:
			return "Password";
		case 2:
			return "Full Name";
		case 3:
			return "Admin";
		case 4:
			return "Entry";
		case 5:
			return "Exit";
		case 6:
			return "Enabled";
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
			return Boolean.class;
		case 4:
			return Boolean.class;
		case 5:
			return Boolean.class;
		case 6:
			return Boolean.class;
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
	 * Returns all the users in the table
	 * @return the user array
	 */
	public User[] getAllUsers(){
		return users;
	}

}
