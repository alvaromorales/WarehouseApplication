import java.util.*;
import java.io.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the TransactionRecord object that has information regarding an item transaction
 * @author Alvaro Morales
 * @date 10/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class TransactionRecord {

	/**
	 * The transaction's unique identifier code
	 */
	private int ID;

	/**
	 * The type of transaction (Item entry or exit)
	 */
	private int type;

	/**
	 * The date when the transaction happened
	 */
	private GregorianCalendar date;

	/**
	 * Amount of the item's unit of measurement to be transacted (entered or removed)
	 */
	private int quantity;

	/**
	 * The amount remaining of the item's unit of measurement after this transaction
	 */
	private int balance;

	/**
	 * The username of the worker who processed the transaction
	 */
	private String warehouseWorker;

	/**
	 * The item that is being transacted
	 */
	private Item item;

	/**
	 * The document noting the transaction
	 */
	private String document;

	/**
	 * The person/company delivering or withdrawing the item
	 */
	private String thirdParty;

	/**
	 * Constructs a TransactionRecord object that has information regarding an item transaction
	 * @param ID - the transaction's unique identifier code
	 * @param date - the date when the transaction happened
	 * @param quantity - amount of the item's unit of measurement to be transacted (entered or removed)
	 * @param balance - the amount remaining of the item's unit of measurement after this transaction
	 * @param warehouseWorker - the username of the worker who processed the transaction
	 * @param item - the item that is being transacted
	 * @param document - the document noting the transaction
	 * @param thirdParty - the person/company delivering or withdrawing the item
	 */
	public TransactionRecord(int ID, int type, GregorianCalendar date, int quantity, int balance, 
			String warehouseWorker, String document, String thirdParty, Item item) {
		this.ID = ID;
		this.type = type;
		this.date = date;
		this.quantity = quantity;
		this.balance = balance;
		this.warehouseWorker = warehouseWorker;
		this.document = document;
		this.thirdParty = thirdParty;
		this.item = item;
	}

	/**
	 * Constructs an empty TransactionRecord object
	 */
	public TransactionRecord(){

	}

	/**
	 * Gets the transaction balance
	 * @return the transaction balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the transaction balance
	 * @param balance - the transaction balance, of type int
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * Gets the date of the transaction
	 * @return the date of the transaction
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Sets the date of the transaction
	 * @param date - the date of the transaction, of type Calendar
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * Gets the ID of the transaction
	 * @return - the ID of the transaction
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the ID of the transaction
	 * @param ID - the ID of the transaction, of type int
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Gets the item being transacted
	 * @return - the item being transacted
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item being transacted
	 * @param item - the item being transacted, of type Item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the quantity of the transaction
	 * @return - the quantity of the transaction
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the transaction
	 * @param quantity - the quantity of the transaction, of type int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the username of the warehouse that processed the transaction
	 * @return the username of the warehouse that processed the transaction
	 */
	public String getWarehouseWorker() {
		return warehouseWorker;
	}

	/**
	 * Sets the username of the warehouse that processed the transaction
	 * @param warehouseWorker - the username of the warehouse that processed the transaction, of type String
	 */
	public void setWarehouseWorker(String warehouseWorker) {
		this.warehouseWorker = warehouseWorker;
	}

	/**
	 * Gets the Transaction's document (Proof of reception or Exit voucher)
	 * @return the transaction's document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Sets the transaction's document
	 * @param document - the transaction's document, of type String
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * Gets the third party that requested/delivered the transaction
	 * @return the third party
	 */
	public String getThirdParty() {
		return thirdParty;
	}

	/**
	 * Sets the third party that requested/delivered the transaction
	 * @param thirdParty - the third party, of type String
	 */
	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

	/**
	 * Gets the type of transaction
	 * @return the type of transaction
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the type of transaction
	 * @param type - the type of transaction, of type int
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Processes a transaction (adds it to the Transactions file)
	 * @param transaction - the transaction to process
	 */
	public void processTransaction(){
		try{
			int itemID = getItem().getID();
			File file = new File(ApplicationConstants.TRANSACTIONS_FOLDER + itemID + ".txt");
			File tmpFile = new File(ApplicationConstants.TRANSACTIONS_FOLDER + itemID + "_tmp.txt");		//Creates the temporary file
			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);
			FileWriter writer = new FileWriter(tmpFile);
			BufferedWriter buffwriter = new BufferedWriter(writer);

			boolean eof = false;		//stores if the end of the file (eof) has been reached
			int transactionID = 0;		//will record the ID of this transaction
			TransactionRecord previousTransaction = null;

			while(!eof){
				String line = buff.readLine();
				if(line == null){
					eof = true;		//the end of the file has been reached
				} else {
					previousTransaction = Transactions.readTransaction(getItem(), line);	//all transactions in this file will be of the same item
					buffwriter.write(line);
					buffwriter.newLine();
					transactionID++;
				}
			}

			if(previousTransaction == null){
				setBalance(getQuantity());		//the first transaction will always be an Item Entry
			} else {
				if(getType() == ApplicationConstants.ITEM_ENTRY){
					setBalance(previousTransaction.getBalance() + getQuantity());
				} else {
					setBalance(previousTransaction.getBalance() - getQuantity());
				}
			}

			setID(transactionID);
			buffwriter.write(toString());
			buffwriter.newLine();

			buffwriter.close();
			buff.close();

			//Rename temporary file to old file
			file.delete();
			tmpFile.renameTo(file);

		} catch (Exception e){

		}

	}

	/**
	 * Outputs a TransactionRecord object to a tokenized String formatted for the transactions file
	 */
	public String toString(){
		int day = getDate().get(Calendar.DAY_OF_MONTH);
		int month = getDate().get(Calendar.MONTH) + 1;
		int year = getDate().get(Calendar.YEAR);

		return (getID() + "|" + getType() + "|" + day + "|" + month + "|" + year + "|" + 
				getQuantity() + "|" + getBalance() + "|"	+ getWarehouseWorker() + "|" 
				+ getDocument() + "|" + getThirdParty());
	}

}
