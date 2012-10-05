import java.io.File;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Class stores all global constants of the application, including file locations
 * @author Alvaro Morales
 * @date 03/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public interface ApplicationConstants {

	//Location of program icons
	 public static final String CREATE_ITEM_ICON = "." + File.separator + "Icons" + File.separator + "CreateItemIcon.png";
	 public static final String ITEM_ENQUIRY_ICON = "." + File.separator + "Icons" + File.separator + "ItemEnquiryIcon.png";
	 public static final String ITEM_ENTRY_ICON = "." + File.separator + "Icons" + File.separator + "ItemEntryIcon.png";
	 public static final String ITEM_EXIT_ICON = "." + File.separator + "Icons" + File.separator + "ItemExitIcon.png";
	 public static final String WAREHOUSE_LOGO = "." + File.separator + "Icons" + File.separator + "WarehouseLogo.png";
	 public static final String USERS_ICON = "." + File.separator + "Icons" + File.separator + "ManageUsers.png";
	 public static final String PASSWORD_ICON = "." + File.separator + "Icons" + File.separator + "PasswordIcon.png";
	 public static final String NO_ITEM_IMAGE = "." + File.separator + "Files" + File.separator + "Item_Images" + File.separator + "NoImage.jpg";
	
	 //Location of database files
	 public static final String USERS_FILE = "." + File.separator + "Files" + File.separator + "Users.txt";
	 public static final String ITEMS_FILE = "." + File.separator + "Files" + File.separator + "Items.dat";
	 public static final String NAME_INDEX_FILE = "." + File.separator + "Files" + File.separator + "Item_Name.txt";
	 public static final String CODE_INDEX_FILE = "." + File.separator + "Files" + File.separator + "Item_Code.txt";
	 
	 //Location of info files
	 public static final String GROUPS_FILE = "." + File.separator + "Files" + File.separator + "Groups.txt";
	 public static final String UM_FILE = "." + File.separator + "Files" + File.separator + "UMs.txt";
	 
	 //Location of temporary files
	 public static final String USERS_TMP_FILE = "." + File.separator + "Files" + File.separator + "Users_tmp.txt";
	 public static final String TMP_CODE_INDEX_FILE = "." + File.separator + "Files" + File.separator + "Item_Code_Tmp.txt";
	 public static final String TMP_NAME_INDEX_FILE = "." + File.separator + "Files" + File.separator + "Item_Name_Tmp.txt";
	 
	 //Location of directories
	 public static final String IMAGES_FOLDER = "." + File.separator + "Images" + File.separator;
	 public static final String ITEM_IMAGES_FOLDER = "." + File.separator + "Files" + File.separator + "Item_Images" + File.separator;
	 public static final String TRANSACTIONS_FOLDER = "." + File.separator + "Files" + File.separator + "Transactions" + File.separator;
	 
	 //Record lengths
	 public static final int ITEMS_FILE_RECORD_LENTGTH = 869;
	 
	 //Tranasction Types
	 public static final int ITEM_ENTRY = 0;
	 public static final int ITEM_EXIT = 1;
	 
	 //Transaction start date (when transactions start to be recorded)
	 public static final int TRANSACTION_YEAR_START = 2000;
	 
}
