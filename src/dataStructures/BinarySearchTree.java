package dataStructures;

/**
 * BinarySearchTree implementation
 * @author AED team
 * @version 1.0
 * @param <K> Generic type Key, must extend comparable
 * @param <V> Generic type Value 
 */
public class BinarySearchTree<K extends Comparable<K>, V> 
    implements OrderedDictionary<K,V>
{                                                                   

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
	    		BSTNode<K,V> left, BSTNode<K,V> right )
	    {                                                                
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
	    public BSTNode( K key, V value )
	    {    
	        this(key, value, null, null, null);
	    }


	    /**
	     * Returns the parent node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getParent( )                                     
	    {    
	        return parent;
	    }
	    
	    /**
	     * Returns the left child node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getLeft( )                                     
	    {    
	        return leftChild;
	    }


	    /**
	     * Returns the right child node of the current node.
	     * 
	     * @return
	     */
	    public BSTNode<K,V> getRight( )                                    
	    {    
	        return rightChild;
	    }
	    
	    /**
	     * Returns the entry (key and value) of the current node.
	     * 
	     * @return
	     */
	    public EntryClass<K,V> getEntry( )                           
	    {
	        return entry;
	    }


	    /**
	     * Returns the key of the current node.
	     * 
	     * @return
	     */
	    public K getKey( )                           
	    {
	        return entry.getKey();
	    }


	    /**
	     * Returns the value of the current node.
	     * 
	     * @return
	     */
	    public V getValue( )                           
	    {
	        return entry.getValue();
	    }


	    /**
	     * Assigns a new entry (key and value) to the current BST node
	     *   
	     * @param newEntry
	     */
	    public void setEntry( EntryClass<K,V> newEntry )
	    {    
	        entry = newEntry;
	    }

	    /**
	     * Sets the new value object of the current node.
	     * 
	     * @param newValue
	     */
	    public void setValue( V newValue )
	    {    
	        entry.setValue(newValue);
	    }


	    /**
	     * Sets the new left child node of this node
	     * 
	     * @param newLeft the new left child node of the current node
	     */
	    public void setLeft( BSTNode<K,V> newLeft )                     
	    {    
	        leftChild = newLeft;
	    }


	    /**
	     * Sets the new right child node of this node
	     * 
	     * @param newLeft the new right child node of the current node
	     */
	    public void setRight( BSTNode<K,V> newRight )                   
	    {    
	        rightChild = newRight;
	    }

	    /**
	     * Sets the new parent of this node
	     * 
	     * @param newParent the new parent of the current node
	     */
	    public void setParent( BSTNode<K,V> newParent )                   
	    {    
	        parent = newParent;
	    }
	 
	    /**
	     * Returns true iff the current node is internal.
	     */
		public boolean isInternal() {
			//TODO
			return true;
		}


	    /**
	     * Returns true iff the node is a leaf.
	     * 
	     * @return
	     */
	    public boolean isLeaf( )                                
	    {    
	    	//TODO
	        return true;          
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
		//int nChildren = 0;
		//TODO
		return nChildren;
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
        else
        {
            int compResult = key.compareTo( node.getKey() );
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
    public Entry<K,V> minEntry( ) throws NoElementException
    {                                                                   
        //TODO                   
    }

    @Override
    public Entry<K,V> maxEntry( ) throws NoElementException
    {                                                                   
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
    protected BSTNode<K,V> maxNode( BSTNode<K,V> node )
    {                                                                   
        if ( node.getRight() == null )                            
            return node;                                             
        else                                                     
            return this.maxNode( node.getRight() );                       
    }                               

    public V insert( K key, V value ) {
        if (root == null) //arvore estava vazia
        	//caso especial – inserir raiz
        else {	
        	BSTNode<K,V> parent = findPlaceToInsert(root, key);  //metodo auxiliar para implementarem
        	//findPlaceToInsert - parecido com o findNode mas devolve pai do novo no

        	//TODO
        	/*Se chave de parent == key
        	 *   Alterar valor de parent para value
        	 *   devolver value antigo
        	 *Senao
        	 *  inserir novo no como filho esquerdo ou direito de parent
        	 *  devolver null (nao esquecer o currentSize)
        	 */
        }
    }
    
  
    //sugestao: implementar metodo auxiliary replaceParentWithChild(nodeToRemove, child) que poe
    //pai de noteToRemove a apontar para child (filho de nodeToRemove)
    public V remove (K key) {
    	BSTNode<K,V> nodeToRemove = findNode(root, key);
	
    	if (nodeToRemove!=null) {
    		/*se nodeToRemove so tem um filho ou e folha
    		 *   o pai fica a apontar para esse filho (ou para null)
    		 *senao  //tem 2 filhos
    		 *  procurar no substituto (na subarvore esq. ou na dir.)
    		 *  remover no substituto
    		 *  trocar entry do nodeToRemove pela entry do no substituto
    		 *  (reparem que, caso ainda nao o tenham feito, e preciso 
    		 *  implementar a classe EntryClass, e precisam do metodo setEntry)
    		 *  
    		 *return ...  (nao esquecer o currentSize)
    		 */

    	}
    	else  //não encontra nó para remover
    		//return ...	
    }
    
  
    /**
     * Returns an iterator of the entries in the dictionary 
     * which preserves the key order relation.
     * @return  key-order iterator of the entries in the dictionary
     */
    public Iterator<Entry<K,V>> iterator( ) 
    {
        //TODO: Original comentado para nao dar erro de compilacao.
        // return new BSTKeyOrderIterator<K,V>(root);
        return null;
    }

}

