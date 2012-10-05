/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the TransactionNode object, a node in a doubly linked list
 * @author Alvaro Morales
 * @date 10/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class TransactionNode {

	/**
	 * The transaction stored in the node
	 */
	private TransactionRecord transaction;
	
	/**
	 * The previous transaction node
	 */
	private TransactionNode prev;
	
	/**
	 * The next transaction node
	 */
	private TransactionNode next;

	/**
	 * Constructs the TransactionNode object, a node in a doubly linked list
	 * @param transaction - the transaction stored in the node
	 * @param prev - the previous transaction
	 * @param next - the next transaction
	 */
	public TransactionNode(TransactionRecord transaction, TransactionNode prev, TransactionNode next) {
		this.transaction = transaction;
		this.prev = prev;
		this.next = next;
	}
	
	/**
	 * Constructs a new Transaction node object
	 * @param transaction - the transaction record stored in this node
	 */
	public TransactionNode(TransactionRecord transaction){
		this.transaction = transaction;
	}

	/**
	 * Gets the next transaction node
	 * @return the next transaction node
	 */
	public TransactionNode getNext() {
		return next;
	}

	/**
	 * Sets the next transaction node
	 * @param next - the next transaction node, of type TransactionNode
	 */
	public void setNext(TransactionNode next) {
		this.next = next;
	}

	/**
	 * Gets the previous transaction node
	 * @return - the previous transaction node
	 */
	public TransactionNode getPrev() {
		return prev;
	}

	/**
	 * Sets the previous transaction node
	 * @param prev - the previous transaction node, of type TransactionNode
	 */
	public void setPrev(TransactionNode prev) {
		this.prev = prev;
	}

	/**
	 * Gets the transaction stored in this node
	 * @return the transaction stored in this node
	 */
	public TransactionRecord getTransaction() {
		return transaction;
	}

	/**
	 * Sets the transaction stored in this node
	 * @param transaction - the transaction stored in this node, of type TransactionRecord
	 */
	public void setTransaction(TransactionRecord transaction) {
		this.transaction = transaction;
	}
	
}
