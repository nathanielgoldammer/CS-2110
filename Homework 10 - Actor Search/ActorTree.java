/**
 * <p>This is the class you will complete - fill in all the missing method implementations</p>
 * 
 *  * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 * 
 * @author Your friendly CS professors
 *
 */
public class ActorTree 
{
	/** ActorTree has only one property, the root node */
	Node root;
	/** Initializes the root node in the default constructor */
	public ActorTree() 
	{
		root = null;
	}
	/**
	 * Finds an Actor in the ActorTree with the given name
	 * @param name the name to find
	 * @return the matching Actor object or null if the Actor is not found
	 */
	public Actor find(String name) 
	{
		if(root != null)
		{
			if(name.compareTo(root.actor.getPrimaryName()) < 0)
			{
				if(root.left != null)
					return root.left.find(name);
				else
					return null;
			}
			else if(name.compareTo(root.actor.getPrimaryName()) > 0)
			{
				if(root.right != null)
					return root.right.find(name);
				else
					return null;
			}
			else 
				return root.actor;
		}
		else 
			return null;
	}
	/**
	 * Computes the size (the number of nodes) of the ActorTree
	 * @return an int representing the number of nodes in the ActorTree
	 */
	public int size() 
	{
		if(root == null)
			return 0; 
		else 
			return root.size() + 1;
	}
	/**
	 * Computes the height of the calling ActorTree. 
	 * The height of an ActorTree is the maximum number of Nodes 
	 * in any path from the root of the ActorTree to a leaf Node. 
	 * @return the height of the calling ActorTree
	 */
	public int height() 
	{
		if(root != null)
			return root.height() + 1;
		else 
			return 0;		
	}
	/**
	 * Determines if the calling ActorTree is empty. 
	 * An empty ActorTree is one with no data. 
	 * @return true if the calling ActorTree is empty, and false if otherwise
	 */
	public boolean isEmpty() 
	{
		if(root == null)
			return true; 
		else
			return false;
	}
	/**
	 * Inserts an Actor into the calling ActorTree
	 * @param a an Actor object
	 * @return true if the Actor was inserted, false if otherwise
	 */
	public boolean insert(Actor a) 
	{
		if(root == null)
		{
			Node node = new Node();
			node.actor = a; 
			node.left = null; 
			node.right = null;
			root = node; 
			return true;
		}
		else
			return root.insert(a);
	}
	/**
	 * Creates a String representation of the in-order traversal of the calling ActorTree. 
	 * @return the in-order traversal String of the calling ActorTree if it's not empty, and returns an empty String if otherwise
	 */
	public String inOrder() 
	{
		if(root != null)
		{
			if(root.left == null && root.right == null)
				return root.actor.toString();
			else if(root.left != null && root.right == null)
				return root.left.inOrder() + root.actor.toString();
			else if(root.left == null && root.right != null)
				return root.actor.toString() + "\n" + root.right.inOrder();
			else
				return root.left.inOrder() + root.actor.toString() + "\n" + root.right.inOrder();
		}
		else
			return "";
	}
	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 * @author Your friendly CS Professors
	 */
	class Node 
	{
		Actor actor;
		Node left;
		Node right;
		/** Default constructor */
		public Node() 
		{
			actor = new Actor();
			left = null; 
			right = null;
		}
		/**
		 * Overloaded constructor that takes an Actor object. 
		 * Left and right children are initialized to null. 
		 * @param a an Actor 
		 */
		public Node(Actor a) 
		{
			actor = a;
			left = null; 
			right = null;
		}
		/**
		 * Recusively computes the number of Nodes in the subtree rooted at the calling Node. 
		 * @return the number of all Nodes in the subtree rooted at the calling Node
		 */
		public int size() 
		{
			if(left == null && right == null)
				return 0;
			else if(left != null && right == null)
				return left.size() + 1; 
			else if(left == null && right != null)
				return right.size() + 1;
			else 
				return left.size() + right.size() + 2;
		}
		/**
		 * Recursively computes the height of the subtree rooted at the calling Node.
		 * The height of a subtree is the maximum number of Nodes in any path from 
		 * the calling Node to a leaf Node of the subtree. 
		 * @return the height of the subtree rooted at the calling Node
		 */
		public int height() 
		{
			if(left == null && right == null)
				return 0;
			else if(left != null && right == null)
				return left.height() + 1;
			else if(left == null && right != null)
				return right.height() + 1;
			else
				return  Math.max(left.height(), right.height()) + 1;
		}
		/**
		 * Inserts an Actor into the subtree rooted at the calling Node. 
		 * @param a an Actor to insert
		 * @return true if the Actor was added, false if otherwise
		 */
		public boolean insert(Actor a) 
		{	
			if(a.compareTo(actor) < 0)
			{
				if(left == null)
				{
					Node node = new Node();
					node.actor = a; 
					node.left = null; 
					node.right = null;
					left = node;
					return true; 
				}
				else
					return left.insert(a);
			}
			else if(a.compareTo(actor) > 0)
			{
				if(right == null)
				{
					Node node = new Node();
					node.actor = a; 
					node.left = null; 
					node.right = null;
					right = node; 
					return true;
				}
				else
					return right.insert(a);
			}
			else 
				return false;
		}
		/**
		 * Finds an Actor in the subtree rooted at the node with the given name. 
		 * @param name the name to be searched for
		 * @return the matching Actor or null if not found
		 */
		public Actor find(String name) 
		{
			if(name.compareTo(actor.getPrimaryName()) < 0)
			{
				if(left != null)
					return left.find(name);
				else
					return null;
			}
			else if(name.compareTo(actor.getPrimaryName()) > 0)
			{
				if(right != null)
					return right.find(name);
				else
					return null;
			}
			else
				return actor; 
		}
	    /**
	     * Creates a String representation of the in-order traversal of the subtree rooted at the calling Node. 
	     * @return the in-order traversal String of the subtree rooted at the calling Node if it isn't empty, and returns an empty String if otherwise
	     */
		public String inOrder() 
		{
			if(left == null && right == null)
				return actor.toString();
			else if(left != null && right == null)
				return left.inOrder() + "\n" + actor.toString() + "\n";
			else if(left == null && right != null)
				return actor.toString() + "\n" + right.inOrder() + "\n";
			else
				return left.inOrder() + actor.toString() + right.inOrder();
		}
	}
}