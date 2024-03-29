import javax.swing.*;
import java.awt.event.*;
import java.io.*;
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
public class NewUser extends javax.swing.JFrame {

	/**
	 * Start of the code generated using CloudGarden's Jigloo SWT/Swing GUI Builder
	 */

	/**
	 * GUI components generated by Jigloo
	 */
	private JLabel lblNewUser;
	private JLabel lblFullName;
	private JCheckBox chkAdmin;
	private JLabel lblPasswordValidation;
	private JLabel lblPermissionsValidation;
	private JLabel lblUsernameValidation;
	private JSeparator spCreate;
	private JButton btnCreate;
	private JCheckBox chkExit;
	private JCheckBox chkEntry;
	private JTextField txtFullName;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JLabel lblPermissions;
	private JLabel lblPassword;
	private JLabel lblUsername;

	/**
	 * The user that logged in
	 */
	private User user;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructs a new NewUser object
	 */
	public NewUser(User user) {
		super();
		this.user = user;
		initGUI();
	}

	/**
	 * Method generated by Jigloo to initialize GUI components
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("New User");
			getContentPane().setLayout(null);
			{
				lblNewUser = new JLabel();
				getContentPane().add(lblNewUser);
				lblNewUser.setText("Create a new user");
				lblNewUser.setBounds(12, 12, 139, 16);
				lblNewUser.setFont(new java.awt.Font("Dialog",1,14));
			}
			{
				lblUsername = new JLabel();
				getContentPane().add(lblUsername);
				lblUsername.setText("Username:");
				lblUsername.setBounds(51, 40, 62, 16);
			}
			{
				lblPassword = new JLabel();
				getContentPane().add(lblPassword);
				lblPassword.setText("Password:");
				lblPassword.setBounds(53, 76, 61, 16);
			}
			{
				lblFullName = new JLabel();
				getContentPane().add(lblFullName);
				lblFullName.setText("Full Name:");
				lblFullName.setBounds(56, 113, 58, 16);
			}
			{
				lblPermissions = new JLabel();
				getContentPane().add(lblPermissions);
				lblPermissions.setText("Permissions:");
				lblPermissions.setBounds(39, 143, 75, 16);
			}
			{
				txtUsername = new JTextField();
				txtUsername.setDocument(new TextFieldLimit(20));
				getContentPane().add(txtUsername);
				txtUsername.setBounds(127, 40, 250, 20);
				txtUsername.setSize(200, 20);
			}
			{
				txtPassword = new JTextField();
				txtPassword.setDocument(new TextFieldLimit(30));
				getContentPane().add(txtPassword);
				txtPassword.setBounds(126, 75, 201, 20);
			}
			{
				txtFullName = new JTextField();
				getContentPane().add(txtFullName);
				txtFullName.setBounds(126, 112, 200, 20);
			}
			{
				chkAdmin = new JCheckBox();
				getContentPane().add(chkAdmin);
				chkAdmin.setText("Admin");
				chkAdmin.setBounds(128, 160, 61, 24);
				chkAdmin.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e){
						if(chkAdmin.isSelected()){
							chkEntry.setEnabled(false);
							chkEntry.setSelected(true);
							chkExit.setEnabled(false);
							chkExit.setSelected(true);
						} else {
							chkEntry.setEnabled(true);
							chkEntry.setSelected(false);
							chkExit.setEnabled(true);
							chkExit.setSelected(false);
						}

					}
				});
				{
					chkEntry = new JCheckBox();
					getContentPane().add(chkEntry);
					chkEntry.setText("Item Entry Operations");
					chkEntry.setBounds(128, 185, 148, 24);
				}
			}
			{
				chkExit = new JCheckBox();
				getContentPane().add(chkExit);
				chkExit.setText("Item Exit Operations");
				chkExit.setBounds(128, 211, 140, 24);
			}
			{
				btnCreate = new JButton();
				getContentPane().add(btnCreate);
				btnCreate.setText("Create");
				btnCreate.setBounds(140, 264, 92, 26);
				btnCreate.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e){
						createUser();
						System.gc();
						deleteAndRename();
					}
				});
			}
			{
				spCreate = new JSeparator();
				getContentPane().add(spCreate);
				spCreate.setBounds(12, 247, 342, 10);
			}
			{
				lblUsernameValidation = new JLabel();
				getContentPane().add(lblUsernameValidation);
				lblUsernameValidation.setText("Max. 20 characters");
				lblUsernameValidation.setBounds(23, 53, 91, 16);
				lblUsernameValidation.setFont(new java.awt.Font("Dialog",0,10));
			}
			{
				lblPermissionsValidation = new JLabel();
				getContentPane().add(lblPermissionsValidation);
				lblPermissionsValidation.setText("(at least one must be selected)");
				lblPermissionsValidation.setBounds(120, 144, 175, 16);
				lblPermissionsValidation.setFont(new java.awt.Font("Dialog",0,10));
			}
			{
				lblPasswordValidation = new JLabel();
				getContentPane().add(lblPasswordValidation);
				lblPasswordValidation.setText("Max. 30 characters");
				lblPasswordValidation.setBounds(25, 88, 95, 16);
				lblPasswordValidation.setFont(new java.awt.Font("Dialog",0,10));
			}
			{
				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource(
						ApplicationConstants.USERS_ICON)).getImage());
				pack();
				this.setSize(374, 329);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * End of the code generated using CloudGarden's Jigloo SWT/Swing GUI Builder
	 */

	/**
	 * Checks if the information entered in the fields is correct. 
	 * If so, the writeNewUser() method is called.
	 * If the information is not correct, the admin user is alerted
	 */
	public void createUser(){
		if(txtUsername.getText()!= null && txtPassword.getText()!=null && txtFullName.getText()!= null 
				&& (chkAdmin.isSelected() || chkEntry.isSelected() || chkExit.isSelected())){
			User user = new User(txtUsername.getText(),txtPassword.getText(), txtFullName.getText(), 
					chkAdmin.isSelected(),chkEntry.isSelected(),chkExit.isSelected(), true);
			try{
				writeNewUser(user);
				JOptionPane.showMessageDialog(this, "The user has been created", 
						"Information", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				ChangeScreen.setManageUsersScreen(this.user);
			} catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "The user has not been created. \n"
						+ "The files may be corrupted", "Error", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Some fields are missing or the \n" 
					+ "information entered is erroneous.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Writes a new user to the Users file by creating a temporary file and later renaming it
	 * @param user - the user to be created
	 * @mastery achieves HL mastery factor 17 by inserting a new user into the appropriate position 
	 * in the ordered Users sequential file without reading the entire file into RAM
	 */
	public void writeNewUser(User user) throws IOException {
		try{

			File file = new File(ApplicationConstants.USERS_FILE);
			File tmpFile = new File(ApplicationConstants.USERS_TMP_FILE);		//Creates the temporary file

			if(!tmpFile.exists()){
				tmpFile.createNewFile();
			}

			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);
			FileWriter writer = new FileWriter(tmpFile);
			BufferedWriter buffwriter = new BufferedWriter(writer);

			boolean eof = false;		//stores if the end of the file (eof) has been reached
			boolean written = false;	//stores if the user to enter has been written to the file

			while(!eof){
				String line = buff.readLine();
				if(line == null){
					if(!written){
						buffwriter.write(user.toString());
						buffwriter.newLine();
					}
					eof = true;		//the end of the file has been reached
				} else {
					User userInFile = readUser(line);
					if(userInFile.getUsername().compareTo(user.getUsername()) < 0){
						buffwriter.write(userInFile.toString());
						buffwriter.newLine();
					} else if (userInFile.getUsername().compareTo(user.getUsername()) > 0){
						if(!written){
							buffwriter.write(user.toString());
							buffwriter.newLine();
							buffwriter.write(userInFile.toString());
							buffwriter.newLine();
							written = true;
						} else {
							buffwriter.write(userInFile.toString());
							buffwriter.newLine();
						}
					}
				}

			}

			reader.close();
			buff.close();
			buffwriter.close();
			writer.close();

			/**
			file.delete();
			tmpFile.renameTo(file);
*/
		} catch (Exception e){
			e.printStackTrace();
		}



	}

	/**
	 * Deletes and renames the users file
	 */
	public void deleteAndRename(){
		File file = new File(ApplicationConstants.USERS_FILE);
		File tmpFile = new File(ApplicationConstants.USERS_TMP_FILE);
		
		file.delete();
		tmpFile.renameTo(new File(ApplicationConstants.USERS_FILE));
	}

	/**
	 * Creates a User object from a tokenized String input
	 * @param line - a line read from the Users file
	 * @return - a User object
	 */
	public User readUser(String line){
		StringTokenizer tokenizer = new StringTokenizer(line, "|");		//Tokenize string

		if (tokenizer.countTokens()== 7){ 	//preliminary error checking
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			String fullName = tokenizer.nextToken();
			boolean admin = intToBoolean(new Integer(tokenizer.nextToken()).intValue());
			boolean entry = intToBoolean(new Integer(tokenizer.nextToken()).intValue());
			boolean exit = intToBoolean(new Integer(tokenizer.nextToken()).intValue());
			boolean userEnabled = intToBoolean(new Integer(tokenizer.nextToken()).intValue());

			return new User(username, password, fullName, admin, entry, exit, userEnabled);
		}

		return null;

	}

	/**
	 * Converts an int to a boolean
	 * @param 0 if false, 1 if true
	 * @return true if param is 1, else false
	 */
	public boolean intToBoolean(int i){
		return (i==1);
	}

}