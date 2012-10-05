/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the IndexTreeNode object, a node in the Index Binary Tree
 * @author Alvaro Morales
 * @date 28/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */
public class IndexTNode {

	/**
	 * The Index object, an index of an Item
	 */
	private Index index;
	
	/**
	 * This node's left child
	 */
	private IndexTNode left;
	
	/**
	 * This node's right child
	 */
	private IndexTNode right;
	
	/**
	 * Constructs an IndexTreeNode object
	 * @param index - the index of an Item
	 */
	public IndexTNode(Index index){
		this.index = index;
	}

	/**
	 * Gets the Item index
	 * @return the item index
	 */
	public Index getIndex() {
		return index;
	}

	/**
	 * Sets the Item index
	 * @param index - the index of an item
	 */
	public void setIndex(Index index) {
		this.index = index;
	}

	/**
	 * Gets the node's left child
	 * @return the node's left child
	 */
	public IndexTNode getLeft() {
		return left;
	}

	/**
	 * Sets the node's left child
	 * @param left - the node's left child, of type IndexTreeNode
	 */
	public void setLeft(IndexTNode left) {
		this.left = left;
	}

	/**
	 * Gets the node's right child
	 * @return the node's right child
	 */
	public IndexTNode getRight() {
		return right;
	}

	/**
	 * Sets the node's right child
	 * @param right - the node's right child, of type IndexTreeNode
	 */
	public void setRight(IndexTNode right) {
		this.right = right;
	}
	
}
