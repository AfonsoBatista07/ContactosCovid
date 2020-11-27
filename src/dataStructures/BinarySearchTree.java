package dataStructures;

/**
 * BinarySearchTree implementation
 * @author AED team
 * @version 1.0
 * @param <K> Generic type Key, must extend comparable
 * @param <V> Generic type Value 
 */
public class BinarySearchTree<K extends Comparable<K>, V> 
    implements OrderedDictionary<K,V> {                                                                   

	/**
	 * BST node implementation
	 * 
	 * @author AED team
	 * @version 1.0
	 *
	 * @param <K> Generic type Key
	 * @param <V> Generic type Value 
	 */
	static class BSTNode<K,V> {                                                                   

	    //Entry stored in the node.
	    private EntryClass<K,V> entry;                                      

	    //(Pointer to) the parent node.
	    private BSTNode<K,V> parent;
	    
	    //(Pointer to) the left child.
	    private BSTNode<K,V> leftChild;

	    //(Pointer to) the right child.
	    private BSTNode<K,V> rightChild;


	    /**
	     * Constructor for BST nodes
	     * 
	     * @param key to be stored in this BST tree node
	     * @param value to be stored in this BST tree node
	     * @param left sub-tree of this node
	     * @param right sub-tree of this node
	     */
	    public BSTNode( K key, V value, BSTNode<K,V> parent,
	    		BSTNode<K,V> left, BSTNode<K,V> right ) {                                                                
	        entry = new EntryClass<K,V>(key, value);
	        this.parent = parent;
	        leftChild = left; 
	        rightChild = right;                                      
	    }


	    /**
	     * Constructor for BST nodes
	     * 
	     * @param key to be stored in this BST tree node
	     * @param value to be stored in this BST tree node
	     */
	    public BSTNode( K key, V value ) {    
	        this(key, value, null, null, null);
	    }


	    /**
	     * Returns the parent node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getParent() {    
	        return parent;
	    }
	    
	    /**
	     * Returns the left child node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getLeft() {    
	        return leftChild;
	    }


	    /**
	     * Returns the right child node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getRight() {    
	        return rightChild;
	    }
	    
	    /**
	     * Returns the entry (key and value) of the current node.
	     * 
	     * @return
	     */
	    public EntryClass<K,V> getEntry( ) {
	        return entry;
	    }


	    /**
	     * Returns the key of the current node.
	     * 
	     * @return
	     */
	    public K getKey() {
	        return entry.getKey();
	    }


	    /**
	     * Returns the value of the current node.
	     * 
	     * @return
	     */
	    public V getValue() {
	        return entry.getValue();
	    }


	    /**
	     * Assigns a new entry (key and value) to the current BST node
	     *   
	     * @param newEntry
	     */
	    public void setEntry( EntryClass<K,V> newEntry ) {    
	        entry = newEntry;
	    }

	    /**
	     * Sets the new value object of the current node.
	     * 
	     * @param newValue
	     */
	    public void setValue( V newValue ) {    
	        entry.setValue(newValue);
	    }


	    /**
	     * Sets the new left child node of this node
	     * 
	     * @param newLeft the new left child node of the current node
	     */
	    public void setLeft( BSTNode<K,V> newLeft ) {    
	        leftChild = newLeft;
	    }


	    /**
	     * Sets the new right child node of this node
	     * 
	     * @param newLeft the new right child node of the current node
	     */
	    public void setRight( BSTNode<K,V> newRight ) {    
	        rightChild = newRight;
	    }

	    /**
	     * Sets the new parent of this node
	     * 
	     * @param newParent the new parent of the current node
	     */
	    public void setParent( BSTNode<K,V> newParent ) {    
	        parent = newParent;
	    }
	 
	    /**
	     * Returns true iff the current node is internal.
	     */
		public boolean isInternal() {
			return rightChild!= null || leftChild!=null;
		}


	    /**
	     * Returns true iff the node is a leaf.
	     * 
	     * @return
	     */
	    public boolean isLeaf( ) {    
	        return (rightChild==null && leftChild==null);          
	    }                                                                  


	}

    //The root of the tree.                                            
    protected BSTNode<K,V> root;                                

    //Number of nodes in the tree.                                  
    protected int currentSize;                   

    /**
     * Tree Constructor - creates an empty tree.
     */
    public BinarySearchTree( )  {    
        root = null;
        currentSize = 0;
    }

    /**
     * Returns the number of children of node.
     *                         
     * @param node 
     * @return the number of children of node 
     */
	protected int numChildren(BSTNode<K,V> node) {
		if(node.isLeaf()) return 0;
		else if(node.getLeft()==null || node.getRight()==null) return 1;
		else return 2;
	}
	
	@Override
    public boolean isEmpty( )  {    
        return root == null;
    }


    @Override
    public int size( )  {    
        return currentSize;
    }

    /**
     * Returns the node whose key is the specified key;
     * or null if no such node exists.        
     *                         
     * @param node where the search starts 
     * @param key to be found
     * @return the found node, when the search is successful
     */
    protected BSTNode<K,V> findNode( BSTNode<K,V> node, K key )  {                                                                   
        if ( node == null )
            return null;
        else {
            int compResult = key.compareTo(node.getKey());
            if ( compResult == 0 )
                return node;                                         
            else if ( compResult < 0 )
                return this.findNode(node.getLeft(), key);
            else                                                     
                return this.findNode(node.getRight(), key); 
        }                 
    }
    
    @Override
    public V find( K key ) {    
        BSTNode<K,V> node = this.findNode(root, key);
        if ( node == null )                                   
            return null;                                    
        else                                                     
            return node.getValue();
    }

    @Override
    public Entry<K,V> minEntry( ) throws NoElementException {                                                                   
    	if(this.isEmpty())
    		throw new NoElementException();  
    	
    	return this.minNode(root).getEntry();
    }

    @Override
    public Entry<K,V> maxEntry( ) throws NoElementException {                                                                   
        if ( this.isEmpty() )                              
            throw new NoElementException();           

        return this.maxNode(root).getEntry();                    
    }


    /**
     * Returns the node with the largest key 
     * in the tree rooted at the specified node.
     * Requires: node != null.
     * @param node that roots the tree
     * @return node with the largest key in the tree
     */
    protected BSTNode<K,V> maxNode( BSTNode<K,V> node ) {                                                                   
        if ( node.getRight() == null )                            
            return node;                                             
        else                                                     
            return this.maxNode( node.getRight() );                       
    }  
    
    protected BSTNode<K,V> minNode(BSTNode<K,V> node) {
    	if(node.getLeft()==null)
    		return node;
    	else
    		return this.minNode(node.getLeft());
    }

    public V insert( K key, V value ) {
        if (root == null) 										// tree is empty.
        	root = new BSTNode<K, V>(key, value, null, null, null);
        else {	
        	BSTNode<K,V> parent = findPlaceToInsert(root, key);  
        	K parentKey = parent.getKey();

        	if(parentKey==key) {
        		V oldValue = parent.getValue();
        		parent.setValue(value);
        		return oldValue;
        	} else { 
        		BSTNode<K,V> newNode = new BSTNode<K,V>(key, value ,parent, null, null);
        		if(parentKey.compareTo(key)<0)
        			parent.setRight(newNode);
        		else
        			parent.setLeft(newNode);
        	}
        }
        currentSize++;
        return null;
    }
    
    private BSTNode<K,V> findPlaceToInsert(BSTNode<K,V> node, K key) {
   	 int compResult = key.compareTo(node.getKey());
        if ( compResult == 0 )
            return node;                                         
        else if ( compResult < 0 ) {
            if(node.getLeft()==null)
            	return node;
            return this.findPlaceToInsert(node.getLeft(), key);
        } else {
        	if(node.getRight()==null)
        		return node;
        	return this.findPlaceToInsert(node.getRight(), key); 
   		}
   }
  
    public V remove (K key) {
    	BSTNode<K,V> nodeToRemove = findNode(root, key);
	
    	if (nodeToRemove!=null) {
    		if(numChildren(nodeToRemove)==1)
    			replaceParentWithChild(nodeToRemove, getChild(nodeToRemove), key);
    		else if(nodeToRemove.isLeaf())
    			replaceParentWithChild(nodeToRemove, null, key);
    		else
    			replaceParentWithChildTwoChilds(nodeToRemove,nodeToRemove.getLeft(), key);
    		currentSize--;
    		return nodeToRemove.getValue();
    	}
    	return null;                              	
    }
    
    private void replaceParentWithChild(BSTNode<K,V> nodeToRemove, BSTNode<K,V> child, K key) {
    	BSTNode<K,V> parent = nodeToRemove.getParent();
    	if(parent==null) root=child;
    	else if(parent.getKey().compareTo(key) < 0) parent.setRight(child);
    	else parent.setLeft(child);
    	if(child!=null)
    		child.setParent(parent);
    }
    
    private void replaceParentWithChildTwoChilds(BSTNode<K,V> nodeToRemove, BSTNode<K,V> child, K key) {
    	BSTNode<K,V> parent = nodeToRemove.getParent();
    	BSTNode<K,V> rightNode = nodeToRemove.getRight();
    	BSTNode<K,V> rightNodeOfChild = child.getRight();
    	BSTNode<K,V> leftNodeOfRight = rightNode;

    	if(parent==null) root = child;
    	else if(parent.getKey().compareTo(key) < 0)
    		parent.setRight(child);
    	else
    		parent.setLeft(child);
    	child.setParent(parent);
    	while(!leftNodeOfRight.isLeaf())
    		leftNodeOfRight = leftNodeOfRight.getLeft();
    	
    	if(rightNodeOfChild!=null) {
    		leftNodeOfRight.setLeft(rightNodeOfChild);
    		rightNodeOfChild.setParent(leftNodeOfRight);
    	}
    	
    	child.setRight(rightNode);
    	rightNode.setParent(child);
    	
    }
    
    private BSTNode<K,V> getChild(BSTNode<K,V> parent) {
    	BSTNode<K,V> left = parent.getLeft();
    	if(left==null) return parent.getRight();
    	return left;
    }
  
    /**
     * Returns an iterator of the entries in the dictionary 
     * which preserves the key order relation.
     * @return  key-order iterator of the entries in the dictionary
     */
    public Iterator<Entry<K,V>> iterator() {
        return new BSTKeyOrderIterator<K,V>(root);
    }

}

