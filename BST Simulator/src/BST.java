public class BST {
		
	private Node root;
	private final double canvasWidth = 1.0;

	public BST () {
		root = null;
	}
	
	public void insert(String s) {
		//if no value given, print an error
		if (s.isEmpty()) {
			BSTAnimations.print("ERROR");
		} else {
			insertHelper (s, root, null);
		}	
	}

	private void insertHelper(String s, Node cur, Node parent) {
		if (root == null) { //empty tree
			root = new Node(s);
			BSTAnimations.drawNode(root);
			return;
		} else if (cur.key.compareTo(s) == 0) { //no duplicates allowed
			BSTAnimations.print("NO DUPLICATES");
		} else if (cur.key.compareTo(s) < 0) { //s > cur.key, go right
			BSTAnimations.print("GOING RIGHT");
			//if correct location to insert is found,
			//create a new node and draw it
			if (cur.right == null) {
				cur.right = new Node (s);
				cur.right.prev = cur;
				cur.right.depth = cur.right.prev.depth + 1;
				cur.right.x = cur.x + 0.25 / Math.pow(2, cur.right.depth);
				cur.right.y = cur.y - 0.15;
				BSTAnimations.drawNode(cur.right);
				BSTAnimations.drawLine (cur, cur.right);
			} else {
				//search again for the correct location
				//set previous node to cur, and new node to search
				//as cur.
				insertHelper (s, cur.right, cur);
			}

		} else { // s < cur.key, go left
			BSTAnimations.print("GOING LEFT");
			//if correct location to insert is found,
			//create a new node and draw it
			if (cur.left == null) {
				cur.left = new Node (s);
				cur.left.prev = cur;
				cur.left.depth = cur.left.prev.depth + 1;
				cur.left.x = cur.x - 0.25 / Math.pow(2, cur.left.depth);
				cur.left.y = cur.y - 0.15;
				BSTAnimations.drawNode(cur.left);
				BSTAnimations.drawLine (cur, cur.left); 
			} else {
				//search again for the correct location
				//set previous node to cur, and new node to search
				//as cur.
				insertHelper (s, cur.left, cur); 
			}
		}
	}

	public void delete (String s) {
		if (s.isEmpty()) {
			BSTAnimations.print("ERROR");
		} else {
			//find node to delete
			Node toDelete = findNode (s, root);
			//use hibbard deletion
			if (toDelete != null) {
				hibbardDeletion (toDelete, toDelete.prev);
			}
		}
	}

	//finds a node in the tree
	//returns the position of the node
	//if not found, returns null
	private Node findNode(String key, Node cur) {
		if (cur == null) {
			BSTAnimations.print("NOT FOUND");
			return null;
		} else if (key.compareTo(cur.key) < 0) {
			BSTAnimations.print("GOING LEFT");
			return findNode (key, cur.left);
		} else if (key.compareTo(cur.key) > 0) {
			BSTAnimations.print("GOING RIGHT");
			return findNode (key, cur.right);
		} else {
			BSTAnimations.print("FOUND IT!");
			return cur;
		}
	}
	
	//uses hibbard deletion to delete a node
	private void hibbardDeletion (Node cur, Node parent) {
		//if cur has no children, just delete the node and remove its edge
		if (cur.left == null && cur.right == null) {
			BSTAnimations.deleteNode (parent, cur);
			//if the node has a parent, remove the edge between them.
			if (parent != null) {
				if (parent.left == cur) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			if (root == cur) {
				root = null;
			}
		} else if (cur.left == null) {
			//if the node has a right child, move up the right child
			BSTAnimations.deleteNode (parent, cur);
			//MOVE UP
			cur = cur.right;
			
		} else if (cur.right == null) {
			//if the node has a left child, move up the left child
			BSTAnimations.deleteNode (parent, cur);
			//MOVE UP
			cur = cur.left;
		} else {
			//if the node has two children...
			
			//delete the drawing of the node and its edge to its parent
			BSTAnimations.deleteNode (parent, cur);
			
			//find the minimum node as the successor node
			Node min = cur.right;
			Node minParent = cur;
			while (min.left != null) {
				minParent = min;
				min = min.left;
			}
			
			//replace the value of cur with min
			cur.key = min.key;
			
			//remove the drawing of min
			hibbardDeletion(min, minParent);
			
			//redraw cur with the value of min
			BSTAnimations.drawNode (cur);
			BSTAnimations.drawLine(parent, cur);
		}
	}

	private String checkIfTextEmpty(String text) {
		if (text.length() == 0) {
			text = "binary search tree is empty";
		} else {
			text = text.substring(0, text.length() - 2);
		}
		return text;
	}
	
	public void inOrderPrint () {
		String inOrder = inOrderPrintHelper("", root);
		
		inOrder = checkIfTextEmpty(inOrder);
		
		// print to the screen
		BSTAnimations.print("in order: " + inOrder);
	}
	
	private String inOrderPrintHelper(String s, Node cur) {
		if (cur == null) {
			return s;
		}
		
		// call left tree
		s = inOrderPrintHelper(s, cur.left);
		
		// append current node
		s += cur.key + ", ";
		
		// call right tree
		s = inOrderPrintHelper(s, cur.right);
		
		return s;
	}

	
	public void postOrderPrint() {
		String postOrder = postOrderPrintHelper("", root);
		
		postOrder = checkIfTextEmpty(postOrder);
		
		// print to the screen
		BSTAnimations.print("post order: " + postOrder);
	}
	
	private String postOrderPrintHelper(String s, Node cur) {
		if (cur == null) {
			return s;
		}
		
		// call left tree
		s = postOrderPrintHelper(s, cur.left);
		
		// call right tree
		s = postOrderPrintHelper(s, cur.right);
		
		// append current node
		s += cur.key + ", ";
		
		return s;
	}

	
	public void preOrderPrint() {
		String preOrder = preOrderPrintHelper("", root);
		
		preOrder = checkIfTextEmpty(preOrder);
		
		// print to the screen
		BSTAnimations.print("pre order: " + preOrder);
		
	}

	private String preOrderPrintHelper(String s, Node cur) {
		if (cur == null) {
			return s;
		}
		
		// append current node
		s += cur.key + ", ";
		
		// call left tree
		s = preOrderPrintHelper(s, cur.left);
		
		// call right tree
		s = preOrderPrintHelper(s, cur.right);
		
		return s;
	}
	
	
}
