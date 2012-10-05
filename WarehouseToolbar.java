import java.awt.event.*;
import javax.swing.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the application's toolbar
 * @author Alvaro Morales
 * @date 10/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

public class WarehouseToolbar extends javax.swing.JToolBar {

	/**
	 * Start of the code generated using CloudGarden's Jigloo SWT/Swing GUI Builder
	 */
	
	/**
	 * GUI components generated by Jigloo
	 */
	private JButton btnSearch;
	private JButton btnExit;
	private JButton btnEntry;
	private JSeparator sp1;
	private JButton btnCreate;
	
	/**
	 * The user that logged in
	 */
	private User user;

	/**
	 * Constructs a new WarehouseToolbar object
	 * @param user - the user that logged in
	 */
	public WarehouseToolbar(User user) {
		this.user = user;
		this.setBounds(0, 0, 392, 29);
		this.setEnabled(false);
		this.setVisible(true);
		{
			//Construct items only relevant to user permissions
			if(user.isEntry() || user.isAdmin()){
				btnCreate = new JButton();
				this.add(btnCreate);
				btnCreate.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource(ApplicationConstants.CREATE_ITEM_ICON)));
				btnCreate.setBounds(39, 85, 44, 38);
				btnCreate.setToolTipText("Create a New Item");
				btnCreate.setPreferredSize(new java.awt.Dimension(28, 28));
				btnCreate.setSize(45, 28);
				btnCreate.setOpaque(false);
				btnCreate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				btnCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ChangeScreen.setCreateNewItemScreen(getUser());
					}
				});
			}
		}
		{
			btnSearch = new JButton();
			this.add(btnSearch);
			btnSearch.setPreferredSize(new java.awt.Dimension(28, 28));
			btnSearch.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource(ApplicationConstants.ITEM_ENQUIRY_ICON)));
			btnSearch.setBorder(BorderFactory.createCompoundBorder(null, null));
			btnSearch.setFocusable(false);
			btnSearch.setOpaque(false);
			btnSearch.setSize(28, 28);
			btnSearch.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ChangeScreen.setItemSearchScreen(getUser());
				}
			});
		}

		{
			//Construct items only relevant to user permissions
			if(user.isEntry() || user.isAdmin()){
				btnEntry = new JButton();
				this.add(btnEntry);
				btnEntry.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource(ApplicationConstants.ITEM_ENTRY_ICON)));
				btnEntry.setBorder(BorderFactory.createCompoundBorder(null,
						BorderFactory.createEmptyBorder(0, 0, 0, 0)));
				btnEntry.setSize(28, 16);
				btnEntry.setPreferredSize(new java.awt.Dimension(28, 10));
				btnEntry.setOpaque(false);
				btnEntry.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ChangeScreen.setMultipleItemSearchScreen(getUser(), ApplicationConstants.ITEM_ENTRY);
					}
				});
			}

		}
		{
			//Construct items only relevant to user permissions
			if(user.isExit() || user.isAdmin()){
				btnExit = new JButton();
				this.add(btnExit);
				btnExit.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource(ApplicationConstants.ITEM_EXIT_ICON)));
				btnExit.setOpaque(false);
				btnExit.setPreferredSize(new java.awt.Dimension(28, 10));
				btnExit.setBorder(BorderFactory.createCompoundBorder(null, null));
				btnExit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ChangeScreen.setMultipleItemSearchScreen(getUser(), ApplicationConstants.ITEM_EXIT);
					}
				});
			}

		}
		{
			sp1 = new JSeparator();
			this.add(sp1);
			sp1.setSize(25, 25);
			sp1.setPreferredSize(new java.awt.Dimension(25, 25));
			sp1.setOrientation(SwingConstants.VERTICAL);
		}
	}

	/**
	 * Gets the user that logged in
	 * @return the user that logged in
	 */
	public User getUser(){
		return user;
	}

}
