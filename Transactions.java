import java.io.*;
import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Class contains methods relevant to Transaction processing
 * @author Alvaro Morales
 * @date 10/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class Transactions {

	/**
	 * Gets the quantity in stock of an item
	 * @param item - the item
	 * @return the quantity in stock of that item
	 */
	public static int getQuantityInStock(Item item){
		try {
			int ID = item.getID();

			File file = new File(ApplicationConstants.TRANSACTIONS_FOLDER + ID + ".txt");
			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);

			boolean eof = false;		//stores if the end of the file (eof) has been reached
			TransactionRecord transaction = null;

			while(!eof){
				String line = buff.readLine();
				if(line == null){
					eof = true;		//the end of the file has been reached
				} else {
					transaction = readTransaction(item, line);
				}

			}

			buff.close();
			reader.close();

			return transaction.getBalance();
		} catch (Exception e){
			return 0;
		}
	}

	/**
	 * Creates a TransactionRecord object from a tokenized String input
	 * @param line - a line read from a Transactions file
	 * @return - a TransactionRecord object
	 */
	public static TransactionRecord readTransaction(Item item, String line){
		StringTokenizer tokenizer = new StringTokenizer(line, "|");		//Tokenize string

		if (tokenizer.countTokens()== 10){ 	//preliminary error checking
			int ID = new Integer(tokenizer.nextToken()).intValue();
			int type = new Integer(tokenizer.nextToken()).intValue();
			int day = new Integer(tokenizer.nextToken()).intValue();
			int month = new Integer(tokenizer.nextToken()).intValue();
			int year = new Integer(tokenizer.nextToken()).intValue();
			int quantity = new Integer(tokenizer.nextToken()).intValue();
			int balance = new Integer(tokenizer.nextToken()).intValue();
			String warehouseWorker = tokenizer.nextToken();
			String document = tokenizer.nextToken();
			String thirdParty = tokenizer.nextToken();

			GregorianCalendar date = new GregorianCalendar(year, month, day);

			return new TransactionRecord(ID, type, date, quantity, balance, warehouseWorker, document, thirdParty, item);
		}
		return null;
	}

}
