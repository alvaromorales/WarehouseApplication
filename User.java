/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the User object that has information regarding the user of the application
 * @author Alvaro Morales
 * @date 03/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class User {

	/**
	 * The user's unique identifier name
	 */
	private String username;
	
	/**
	 * The user's password
	 */
	private String password;
	
	/**
	 * The user's full name
	 */
	private String fullName;
	
	/**
	 * Stores whether the user has administrator permissions
	 */
	private boolean isAdmin;
	
	/**
	 * Stores whether the user has item entry permissions
	 */
	private boolean isEntry;
	
	/**
	 * Stores whether the user has item exit permissions
	 */
	private boolean isExit;
	
	/**
	 * Stores whether the user is allowed to login
	 */
	private boolean isEnabled;

	/**
	 * Constructs a User object
	 * @param username - the unique identifier name for a user
	 * @param password - the password to have access to the application
	 * @param fullName - the user's full name
	 * @param isAdmin - indicates if the user has administrator permissions
	 * @param isEntry - indicates if the user has permission to execute item entry related operations
	 * @param isExit - indicates if the user has permission to execute item exit related operations
	 * @param isEnabled - indicates if the user is enabled to access the system
	 */
	public User(String username, String password, String fullName, boolean isAdmin, boolean isEntry, 
			boolean isExit, boolean isEnabled){
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.isAdmin = isAdmin;
		this.isEntry = isEntry;
		this.isExit = isExit;
		this.isEnabled = isEnabled;
	}

	/**
	 * Returns the user's full name
	 * @return the user's full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the user's full name
	 * @param fullName - the user's full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Returns the boolean that stores whether the user has admin permissions or not
	 * @return true if the user has admin permissions, else false
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * Sets the admin permissions of the user
	 * @param isAdmin - true if the user has admin permissions, else false
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * Returns the boolean that stores whether the user is enabled or not
	 * @return true if the user is enabled, else false
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * Sets the boolean that stores whether the user is enabled or not
	 * @param isEnabled - true if the user is enabled, else false
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * Returns the boolean that stores whether the user has entry permissions or not
	 * @return true if the user has entry permissions, else false
	 */
	public boolean isEntry() {
		return isEntry;
	}

	/**
	 * Sets the boolean that stores whether the user has entry permissions or not
	 * @param isEntry - true if the user has entry permissions, else false
	 */
	public void setEntry(boolean isEntry) {
		this.isEntry = isEntry;
	}

	/**
	 * Returns the boolean that stores whether the user has exit permissions or not
	 * @return true if the user has exit permissions, else false
	 */
	public boolean isExit() {
		return isExit;
	}

	/**
	 * Sets the boolean that stores whether the user has exit permissions or not
	 * @param isExit
	 */
	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	/**
	 * Gets the user's password
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user, that should not be longer than 30 characters
	 * @param password - the user's password
	 * @throws Exception if password is longer than 30 characters
	 */
	public void setPassword(String password) throws Exception {

		if(password.length()<=30){
			this.password = password;
		} else{
			throw new Exception();
		}

	}

	/**
	 * Gets the user's username
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user, that should not be longer than 20 characters
	 * @param username - the user's unique identifier name
	 * @throws Exception if username is longer than 20 characters
	 */
	public void setUsername(String username) throws Exception {
		if(username.length()<=30){
			this.username = username;
		} else{
			throw new Exception();
		}
	}

	/**
	 * Returns an int from a boolean
	 * @param b - the boolean
	 * @return 1 if true, else 0
	 */
	public int booleanToInt(boolean b){
		return (b) ? 1:0;
	}

	/**
	 * Outputs a User object in tokenized form with '|' as the token, for use with the Users file
	 * @return the tokenized user object
	 */
	public String toString(){
		return (getUsername() + "|" + getPassword() + "|" 
				+ getFullName() + "|" 
				+ booleanToInt(isAdmin()) + "|"
				+ booleanToInt(isEntry()) + "|"
				+ booleanToInt(isExit()) + "|"
				+ booleanToInt(isEnabled())+ "|");
	}

}