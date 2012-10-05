import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Class stores methods to change the screen of MainScreen's content pane
 * @author Alvaro Morales
 * @date 13/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class ChangeScreen {

	/**
	 * Changes the content pane of MainScreen to a blank panel
	 */
	public static void setBlankScreen(User user){
		JPanel pnlBlank = new JPanel();
		pnlBlank.setSize(800, 500);
		pnlBlank.setBackground(new java.awt.Color(192,192,192));
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(pnlBlank, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

	/**
	 * Changes the content pane of MainScreen to the Create New Item screen
	 * @param currentPanel - the current panel added to the content pane of MainScreen
	 * @param user - the user that logged in
	 */
	public static void setCreateNewItemScreen(User user){
		CreateNewItem create = new CreateNewItem(user);
		create.setSize(800, 500);
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(create, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

	/**
	 * Changes the content pane of MainScreen to the Manage Users screen
	 * @param currentPanel - the current panel added to the content pane of MainScreen
	 */
	public static void setManageUsersScreen(User user){
		ManageUsers users = new ManageUsers(user);
		users.setSize(800, 500);
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(users, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

	/**
	 * Changes the content pane of MainScreen to the Item Search screen
	 * @param currentPanel - the current panel added to the content pane of MainScreen
	 * @param user - the user that logged in
	 */
	public static void setItemSearchScreen(User user){
		ItemSearch search = new ItemSearch(user);
		search.setSize(800, 500);
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(search, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

	/**
	 * Changes the content pane of MainScreen to the Multiple Item Search screen
	 * @param currentPanel - the current panel added to the content pane of MainScreen
	 * @param user - the user that logged in
	 * @param transactionType - the type of transaction (Item entry or exit)
	 */
	public static void setMultipleItemSearchScreen(User user, int transactionType){
		MultipleItemSearch search = new MultipleItemSearch(user, transactionType);
		search.setSize(800, 500);
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(search, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

	/**
	 * Changes the content pane of MainScreen to the Optimal Route screen
	 * @param user - the user that logged in
	 * @param itemsToWithdraw - an ArrayList of items to withdraw from the warehouse
	 */
	public static void setOptimalRouteScreen(User user, ArrayList itemsToWithdraw){
		OptimalRoute route = new OptimalRoute(itemsToWithdraw, user);
		route.setSize(800, 500);
		MainScreen.contentPane.removeAll();
		MainScreen.contentPane.add(new WarehouseToolbar(user), BorderLayout.NORTH);
		MainScreen.contentPane.add(route, BorderLayout.CENTER);
		MainScreen.contentPane.validate();
	}

}
