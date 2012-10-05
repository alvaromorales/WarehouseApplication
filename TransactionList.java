import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the TransactionList object, a list of transactions
 * @author Alvaro Morales
 * @date 10/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class TransactionList {

	/**
	 * The head (first item) of the list of transactions
	 */
	private TransactionNode head;

	/**
	 * Constructs an empty TransactionList object
	 */
	public TransactionList(){

	}

	/**
	 * Constructs the TransactionList object, a list of transactions
	 * @param head - the first item of the list
	 */
	public TransactionList(TransactionNode head) {
		this.head = head;
	}

	/**
	 * Gets the head (first item) of the list
	 * @return the head (first item) of the list
	 */
	public TransactionNode getHead() {
		return head;
	}

	/**
	 * Sets the head (first item) of the list
	 * @param head - the head (first item) of the list, of type TransactionNode
	 */
	public void setHead(TransactionNode head) {
		this.head = head;
	}

	/**
	 * Adds a node to the head of the transactions list
	 * @param node - the node to add
	 */
	public void addToHead(TransactionNode node){
		if(head == null){
			setHead(node);
		} else {
			node.setNext(head);
			head.setPrev(node);
			setHead(node);
		}
	}

	/**
	 * Method searches the list for transactions between specified dates
	 * @param start - the lower boundary of the date search
	 * @param end - the upper boundary of the date search
	 * @return an ArrayList of transactions between the specified dates
	 */
	public ArrayList searchTransactions(GregorianCalendar start, GregorianCalendar end){
		return searchTransactions(head, start, end, new ArrayList());
	}

	/**
	 * Method is called recursively to search the list for transactions between specified dates
	 * @param current - a pointer to the current node
	 * @param start - the lower boundary of the date search
	 * @param end - the upper boundary of the date search
	 * @param searchResults - an ArrayList of transactions between the specified dates
	 * @return an ArrayList of transactions between the specified dates
	 */
	private ArrayList searchTransactions(TransactionNode current, GregorianCalendar start, 
			GregorianCalendar end, ArrayList searchResults){
		if(current == null){
			if(searchResults.isEmpty()){
				return null;
			} else {
				return searchResults;
			}
		} else if (current.getTransaction().getDate().compareTo(start) >= 0 
				&& current.getTransaction().getDate().compareTo(end) <= 0){
			searchResults.add(current.getTransaction());
			return searchTransactions(current.getNext(), start, end, searchResults);
		} else if (current.getTransaction().getDate().compareTo(end) > 0) {
			//Stop searching, past the end date
			searchResults.trimToSize();
			return searchResults;
		} else {
			return searchTransactions(current.getNext(), start, end, searchResults);
		}
	}

	/**
	 * Gets a node from the list given the ID of the TransactionRecord stored at that node
	 * @param transactionID - the ID of the TransactionRecord stored at that node
	 * @return the node with that transactionID, or null if not found
	 */
	public TransactionNode getNode(int transactionID){
		return getNode(getHead(), transactionID);
	}

	/**
	 * Method is called recursively to get a node from the list given a TransactionRecord ID
	 * @param current - a pointer to the current node
	 * @param transactionID - the ID of the TransactionRecord stored at that node
	 * @return the node with that transactionID, or null if not found
	 */
	private TransactionNode getNode(TransactionNode current, int transactionID){
		if(current == null){
			return null;
		} else {
			if(current.getTransaction().getID() == transactionID){
				return current;
			} else {
				return getNode(current.getNext(), transactionID);
			}
		}
	}

	/**
	 * Deletes a node from the Transactions list
	 * @param node - the node to delete
	 */
	public void deleteTransaction(TransactionNode node){
		if(node.getPrev() == null){				//it is the head of the list
			setHead(node.getNext());
			head.setPrev(null);
			node.setNext(null);
			node.setPrev(null);
		} else if (node.getNext() == null){		//it is the tail of the list
			node.getPrev().setNext(null);
			node.setPrev(null);
		} else {
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
			node.setPrev(null);
			node.setNext(null);
		}
	}

}
