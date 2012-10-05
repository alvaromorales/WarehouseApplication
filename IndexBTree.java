import java.util.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Constructs the IndexBTree object, a binary tree of Item indexes
 * @author Alvaro Morales
 * @date 28/06/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * @mastery achieves HL mastery factors 12-15 with the implementation of a Binary Tree 
 * with all key methods and full error checking
 * ---------------------------------------------------------------------
 */
public class IndexBTree {

	/**
	 * The root of the tree
	 */
	private IndexTNode root;

	/**
	 * Constructs an empty binary tree
	 */
	public IndexBTree(){
		this.root = null;
	}

	/**
	 * Constructs a binary tree
	 * @param root - the root of the binary tree
	 */
	public IndexBTree(IndexTNode root) {
		this.root = root;
	}

	/**
	 * Gets the root of the binary tree
	 * @return the root of the binary tree
	 */
	public IndexTNode getRoot() {
		return root;
	}

	/**
	 * Sets the root of the binary tree
	 * @param root - the root of the binary tree, of type IndexTNode
	 */
	public void setRoot(IndexTNode root) {
		this.root = root;
	}

	/**
	 * Checks if the tree is empty
	 * @return true if empty, else false
	 */
	public boolean isEmpty(){
		return (root == null);
	}

	/**
	 * Calculates the size of the binary tree, by recursively calling the method size(IndexTNode current)
	 * @return the size of the binary tree
	 */
	public int size(){
		return size(root);
	}

	/**
	 * Method is called recursively to calculate the number of nodes in a binary tree
	 * @param current - a pointer to the current node
	 * @return the size of the binary tree
	 */
	public int size(IndexTNode current){
		if(current == null){
			return 0;
		} else {
			return 1 + size(current.getLeft()) + size(current.getRight());
		}
	}

	/**
	 * Inserts an Index to the binary tree 
	 * by recursively calling the method insertIndex(IndexTNode current, IndexTNode index)
	 * @param index - the Index to insert
	 */
	public void insertIndex(IndexTNode index){
		if(isEmpty()){
			//Add dummy root to avoid the root (and consequently the entire tree) being deleted
			String field = index.getIndex().getField().substring(0, 1);
			IndexTNode dummyRoot = new IndexTNode(new Index(-1, field));
			root = dummyRoot;
			insertIndex(index);
		} else {
			insertIndex(root, index);
		}
	}

	/**
	 * Method is called recursively to insert an index to the Index binary tree
	 * @param current - a pointer of the current node being evaluated for insertion
	 * @param index - the node to insert
	 * @mastery achieves HL mastery factor 4 by recursively calling itself
	 */
	private void insertIndex(IndexTNode current, IndexTNode index){
		if(index.getIndex().getField().equals(current.getIndex().getField()) && 
				index.getIndex().getPosition()==(current.getIndex().getPosition())){ 
			//Error checking: if the Index already exists, do nothing
			return;
		} else if(index.getIndex().getField().compareTo(current.getIndex().getField()) < 0) {
			if(current.getLeft() == null){
				current.setLeft(index);
			} else {
				insertIndex(current.getLeft(), index);
			}
		} else if(index.getIndex().getField().compareTo(current.getIndex().getField()) > 0){
			if(current.getRight() == null){
				current.setRight(index);
			} else {
				insertIndex(current.getRight(), index);
			}
		}
	}

	/**
	 * Method gets a node from the Binary Tree given its field, 
	 * by recursively calling the method getNode(IndexTNode current, String field)
	 * @param field - a node's field (item code or name)
	 * @return a node containing the field, or null if not found
	 */
	public IndexTNode getNode(String field){
		return getNode(root, field);
	}

	/**
	 * Method is called recursively to get a node from the binary tree given its field
	 * @param current - a pointer to the current node
	 * @param field - a node's field (item code or name)
	 * @return a node containing the field, or null if not found
	 */
	private IndexTNode getNode(IndexTNode current, String field){
		if (current == null){
			return null;
		} else {
			if (current.getIndex().getField().compareTo(field) > 0){
				return getNode(current.getLeft(), field);
			} else if (current.getIndex().getField().compareTo(field) < 0){
				return getNode(current.getRight(), field);
			} else {
				return current;
			}
		}
	}

	/**
	 * Searches the binary tree for nodes exactly matching a query
	 * @param query - the exact match from an item name or code
	 * @return a node exactly matching a query; null if no results
	 */
	public Item search(String query){
		return search(root, query);
	}

	/**
	 * Traverses the binary tree to find a node that exactly matches a query
	 * @param current - a pointer to the current node
	 * @param query - the exact match from an item name or code
	 * @return a node exactly matching a query; null if no results
	 */
	private Item search(IndexTNode current, String query){
		if (current == null){
			return null;
		} else {
			if (current.getIndex().getField().compareToIgnoreCase(query) > 0){
				return search(current.getLeft(), query);
			} else if (current.getIndex().getField().compareToIgnoreCase(query) < 0){
				return search(current.getRight(), query);
			} else if (current.getIndex().getField().equalsIgnoreCase(query)) {
				return Items.getItemFromFile(current.getIndex().getPosition());
			}
		}
		
		return null;
	}

	/**
	 * Searches the binary tree for nodes partially matching a query
	 * @param query - the starting characters from an item name or code
	 * @return an ArrayList of search results, null if no results found
	 */
	public ArrayList partialSearch(String query){

		IndexBTree partialTree = getPartialTree(query);

		if(partialTree == null){
			return null;
		} else {
			return getResults(partialTree, query);
		}
	}

	/**
	 * Gets a sub-tree from the first node that matches the search criteria 
	 * by calling the method getMatchingSubTree(IndexTNode current, String field)
	 * @param query - the starting characters from an item name or code
	 * @return an IndexBTree that has as its root the first node that matches the query, 
	 * or null if no results
	 */
	private IndexBTree getPartialTree(String query){
		return getMatchingSubTree(root, query);
	}

	/**
	 * Gets a sub-tree from the first node that matches the search criteria
	 * @param current - a pointer to the current node
	 * @param query - the starting characters from an item name or code
	 * @return an IndexBTree that has as its root the first node that matches the query, 
	 * or null if no results
	 */
	private IndexBTree getMatchingSubTree(IndexTNode current, String query){
		if(current == null){
			return null;
		}
		if(query.length() < current.getIndex().getField().length()){
			if (current.getIndex().getField().compareToIgnoreCase(query) == 0){
				return new IndexBTree(current);
			} else if (current.getIndex().getField().toLowerCase().startsWith(query.toLowerCase())) {
				return new IndexBTree(current);
			} else if (current.getIndex().getField().substring(
					0, query.length()).compareToIgnoreCase(query) < 0){
				return getMatchingSubTree(current.getRight(), query);
			} else if (current.getIndex().getField().substring(
					0, query.length()).compareToIgnoreCase(query) > 0){
				return getMatchingSubTree(current.getLeft(), query);
			} else {
				return null;
			}
		} else {
			if(current == null){
				return null;
			} else if (current.getIndex().getField().compareToIgnoreCase(query) == 0){
				return new IndexBTree(current);
			} else if (current.getIndex().getField().toLowerCase().startsWith(query.toLowerCase())) {
				return new IndexBTree(current);
			} else if (current.getIndex().getField().compareToIgnoreCase(
					query.substring(0, current.getIndex().getField().length())) == 0) {
				return new IndexBTree(current);
			} else if (current.getIndex().getField().compareToIgnoreCase(
					query.substring(0, current.getIndex().getField().length())) < 0) {
				return getMatchingSubTree(current.getRight(), query);
			} else if (current.getIndex().getField().compareToIgnoreCase(
					query.substring(0, current.getIndex().getField().length())) > 0) {
				return getMatchingSubTree(current.getLeft(), query);
			} else {
				return null;
			}
		}

	}

	/**
	 * Returns an ArrayList of Items that match the query
	 * @param tree - a sub-tree matching that has the first node that matched the query as its root
	 * @param query - the starting characters from an item name or code
	 * @return an ArrayList of Items that match the query
	 */
	private ArrayList getResults(IndexBTree tree, String query){
		ArrayList searchResults = new ArrayList();
		addResults(tree.getRoot(), query, searchResults);

		if(!searchResults.isEmpty()){
			searchResults.trimToSize();
			return searchResults;
		} else {
			return null;
		}
	}

	/**
	 * Traverses the tree and adds nodes that match the query to the ArrayList of search results
	 * @param current - a pointer to the current node
	 * @param query - the starting characters from an item name or code
	 * @param searchResults - an ArrayList of Items matching the query
	 */
	private void addResults(IndexTNode current, String query, ArrayList searchResults){
		if(current == null){
			return;
		} else if(current.getIndex().getPosition() == -1){	
			//If dummy root, recursively call methods on children
			addResults(current.getLeft(), query, searchResults);
			addResults(current.getRight(), query, searchResults);
		} else if (!current.getIndex().getField().toLowerCase().startsWith(query.toLowerCase())){
			if(current.getLeft() != null && 
					current.getLeft().getIndex().getField().toLowerCase().startsWith(query.toLowerCase())){
				addResults(current.getLeft(), query, searchResults);
			} else if(current.getRight() != null && 
					current.getRight().getIndex().getField().toLowerCase().startsWith(
							query.toLowerCase())){
				addResults(current.getRight(), query, searchResults);
			} else {
				return;
			}
		} else {
			addResults(current.getLeft(), query, searchResults);
			searchResults.add(Items.getItemFromFile(current.getIndex().getPosition()));
			addResults(current.getRight(), query, searchResults);
		}
	}

	/**
	 * Gets the parent of a node 
	 * by recursively calling the method getParent(IndexTNode current, IndexTNode node, String field)
	 * @param node - the child node
	 * @return the parent of the node
	 */
	public IndexTNode getParent(IndexTNode node){
		return getParent(root, node, node.getIndex().getField());
	}


	/**
	 * Method is called recursively to find a node's parent
	 * @param current - a pointer to the current node being evaluated for search
	 * @param node - the child node
	 * @param field - the data that the node stores
	 * @return the node's parent
	 */
	private IndexTNode getParent(IndexTNode current, IndexTNode node, String field){

		if(current == null){
			return null;
		} else if (current.getIndex().getField().equals(field) && current.equals(getRoot())) {
			return null;
		} else if (current.getLeft() != null && current.getLeft().equals(node)){
			return current;
		} else if  (current.getLeft() != null && current.getRight().equals(node)){
			return current;
		} else if (current.getIndex().getField().compareTo(field) < 0){
			return getParent(current.getRight(), node, field);
		} else if (current.getIndex().getField().compareTo(field) > 0){
			return getParent(current.getLeft(), node, field);
		} else {
			return null;
		}

	}

	/**
	 * Deletes an Index node from the binary tree
	 * @param node - the node to delete
	 */
	public void deleteIndex(IndexTNode node){
		if (node.equals(getRoot()) && node.getLeft() == null && node.getRight() == null){
			setRoot(null);
		} else {
			String s = getParent(node).getIndex().getField();
			if(node.getIndex().getField().compareTo(getParent(node).getIndex().getField()) > 0){
				//If it is the right child of its parent
				if(node.getRight() != null){
					getParent(node).setRight(node.getRight());
				}
				if(node.getLeft() != null){
					node.getRight().setLeft(node.getLeft());
				}
				if(node.getLeft() == null &&  node.getRight() == null){
					getParent(node).setRight(null);
				}
				node.setLeft(null);
				node.setRight(null);
			} else {	//If it is the left child of its parent
				if (node.getLeft() != null){
					getParent(node).setLeft(node.getLeft());
				}
				if (node.getRight() != null){
					node.getLeft().setRight(node.getRight());
				}
				if(node.getLeft() == null && node.getRight() == null){
					getParent(node).setLeft(null);
				}
				node.setLeft(null);
				node.setRight(null);
			}
		}
	}


}
