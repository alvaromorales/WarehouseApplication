import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the EditUser screen to update a user
 * @author Alvaro Morales
 * @date 10/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class EditUser extends javax.swing.JFrame {

	/**
	 * GUI components generated by Jigloo
	 */
	private JLabel lblEditUser;
	private JLabel lblFullName;
	private JCheckBox chkAdmin;
	private JCheckBox chkEnabled;
	private JLabel lblStatus;
	private JLabel lblPasswordValidation;
	private JLabel lblPermissionsValidation;
	private JLabel lblUsernameValidation;
	private JSeparator spEdit;
	private JButton btnSave;
	private JCheckBox chkExit;
	private JCheckBox chkEntry;
	private JTextField txtFullName;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JLabel lblPermissions;
	private JLabel lblPassword;
	private JLabel lblUsername;

	/**
	 * The user is being edited
	 */
	private User user;

	/**
	 * Start of the code generated using CloudGarden's Jigloo SWT/Swing GUI Builder
	 */

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Creates a new EditUser object
	 * @param user - the user that is being edited
	 */
	public EditUser(User user) {
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
			this.setTitle("Edit User");
			getContentPane().setLayout(null);
			{
				lblEditUser = new JLabel();
				getContentPane().add(lblEditUser);
				lblEditUser.setText("Edit User");
				lblEditUser.setBounds(12, 12, 139, 16);
				lblEditUser.setFont(new java.awt.Font("Dialog",1,14));
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
				txtUsername.setText(user.getUsername());
				txtUsername.setEnabled(false);
			}
			{
				txtPassword = new JTextField();
				txtPassword.setDocument(new TextFieldLimit(30));
				getContentPane().add(txtPassword);
				txtPassword.setBounds(126, 75, 201, 20);
				txtPassword.setText(user.getPassword());
			}
			{
				txtFullName = new JTextField();
				getContentPane().add(txtFullName);
				txtFullName.setBounds(126, 112, 200, 20);
				txtFullName.setText(user.getFullName());
			}
			{
				chkAdmin = new JCheckBox();
				getContentPane().add(chkAdmin);
				chkAdmin.setText("Admin");
				chkAdmin.setBounds(128, 160, 61, 24);
				chkAdmin.setSelected(user.isAdmin());

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
			}
			{
				chkEntry = new JCheckBox();
				getContentPane().add(chkEntry);
				chkEntry.setText("Item Entry Operations");
				chkEntry.setBounds(128, 185, 148, 24);
				chkEntry.setSelected(user.isEntry());
			}

			{
				chkExit = new JCheckBox();
				getContentPane().add(chkExit);
				chkExit.setText("Item Exit Operations");
				chkExit.setBounds(128, 211, 140, 24);
				chkExit.setSelected(user.isExit());
			}
			{
				if(chkAdmin.isSelected()){
					chkEntry.setEnabled(false);
					chkExit.setEnabled(false);
				}
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("Save Changes");
				btnSave.setBounds(128, 300, 122, 26);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e){
						editUser();
					}
				});
			}
			{
				spEdit = new JSeparator();
				getContentPane().add(spEdit);
				spEdit.setBounds(12, 285, 342, 10);
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
				lblStatus = new JLabel();
				getContentPane().add(lblStatus);
				lblStatus.setText("Status:");
				lblStatus.setBounds(74, 251, 40, 16);
			}
			{
				chkEnabled = new JCheckBox();
				getContentPane().add(chkEnabled);
				chkEnabled.setText("Enabled");
				chkEnabled.setBounds(128, 248, 70, 24);
				chkEnabled.setSelected(user.isEnabled());
			}
			{
				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource(
						ApplicationConstants.USERS_ICON)).getImage()
				);
				pack();
				this.setSize(374, 364);
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
	 * If so, the performUpdate() method is called.
	 * If the information is not correct, the admin user is alerted
	 */
	public void editUser(){
		if(txtUsername.getText()!= null && txtPassword.getText()!=null && txtFullName.getText()!= null 
				&& (chkAdmin.isSelected() || chkEntry.isSelected() || chkExit.isSelected())){
			try{
				performUpdate();
				JOptionPane.showMessageDialog(this, "The user has been updated", 
						"Information", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "The user has not been updated. \n" +
						"The files may be corrupted", "Error", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Some fields are missing or the \n" +
					"information entered is erroneous.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Updates a user in the Users file by creating a temporary file and later renaming it
	 * @param user - the user to be updated
	 */
	public void performUpdate() throws IOException {
		try{

			user.setPassword(txtPassword.getText());
			user.setFullName(txtFullName.getText());
			user.setAdmin(chkAdmin.isSelected());
			user.setEntry(chkEntry.isSelected());
			user.setExit(chkExit.isSelected());
			user.setEnabled(chkEnabled.isSelected());

			File file = new File(ApplicationConstants.USERS_FILE);
			File tmpFile = new File(ApplicationConstants.USERS_TMP_FILE);
			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);
			FileWriter writer = new FileWriter(tmpFile);
			BufferedWriter buffwriter = new BufferedWriter(writer);

			boolean eof = false;                //stores if the end of the file (eof) has been reached

			while(!eof){
				String line = buff.readLine();
				if(line == null){
					eof = true;                //the end of the file has been reached
				} else {
					User userInFile = readUser(line);

					if(userInFile.getUsername().equals(user.getUsername())){
						buffwriter.write(user.toString());
						buffwriter.newLine();
					} else {
						buffwriter.write(userInFile.toString());
						buffwriter.newLine();
					}

				}

			}

			buffwriter.close();
			buff.close();

			file.delete();
			tmpFile.renameTo(file);


		} catch (Exception e){
			System.out.println(e.toString());
		}

	}

	/**
	 * Creates a User object from a tokenized String input
	 * @param line - a line read from the Users file
	 * @return - a User object
	 */
	public User readUser(String line){
		StringTokenizer tokenizer = new StringTokenizer(line, "|");                //Tokenize string

		if (tokenizer.countTokens()== 7){         //preliminary error checking
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