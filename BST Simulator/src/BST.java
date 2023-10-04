import java.util.ArrayList;

public class BST {
		
	private Node root;

	public BST () {
		root = null;
	}
	
	public void clear() {
//		clearHelper (root);
		root = null;
		BSTAnimations.drawTree(root);
	}
	
//	private void clearHelper (Node cur) {
//		if (cur == null) {
//			return;
//		}
//		clearHelper (cur.left);
//		clearHelper(cur.right);
//		hibbardDeletion(cur, cur.prev);
//	}
	
	public void insert(Integer n) {
		if (n != null) {
			insertHelper (n, root, null);
			BSTAnimations.drawTree(root);
		}	
	}

	public void insert(ArrayList<Integer> nums) {
		for (Integer num : nums) {
			insert(num);
		}
	}
	
	private void insertHelper(Integer num, Node cur, Node parent) {
		if (root == null) { //empty tree
			root = new Node(num);
			return;
		} else if (cur.key == num) { //no duplicates allowed
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("NO DUPLICATES");
			BSTAnimations.stopHighlight(cur);
		} else if (cur.key < num) { //num > cur.key, go right
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("GOING RIGHT");
			BSTAnimations.stopHighlight(cur);
			//if correct location to insert is found,
			//create a new node and draw it
			if (cur.right == null) {
				cur.right = new Node (num);
				cur.right.prev = cur;
				cur.right.depth = cur.right.prev.depth + 1;
				cur.right.x = cur.x + 0.25 / Math.pow(2, cur.right.depth);
				cur.right.y = cur.y - 0.15;
			} else {
				//search again for the correct location
				//set previous node to cur, and new node to search
				//as cur.
				insertHelper (num, cur.right, cur);
			}

		} else { // num < cur.key, go left
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("GOING LEFT");
			BSTAnimations.stopHighlight(cur);
			//if correct location to insert is found,
			//create a new node and draw it
			if (cur.left == null) {
				cur.left = new Node (num);
				cur.left.prev = cur;
				cur.left.depth = cur.left.prev.depth + 1;
				cur.left.x = cur.x - 0.25 / Math.pow(2, cur.left.depth);
				cur.left.y = cur.y - 0.15;
			} else {
				//search again for the correct location
				//set previous node to cur, and new node to search
				//as cur.
				insertHelper (num, cur.left, cur); 
			}
		}
	}

	public void delete (Integer num) {
		if (num != null) {
			//find node to delete
			Node toDelete = findHelper(num, root);
			//use hibbard deletion
			if (toDelete != null) {
				hibbardDeletion (toDelete, toDelete.prev);
				BSTAnimations.drawTree(root);
			}
		}
	}

	public void find (Integer num) {
		if (num != null) {
			Node toDelete = findHelper(num, root);
		}
	}
	
	//finds a node in the tree
	//returns the position of the node
	//if not found, returns null
	private Node findHelper(Integer num, Node cur) {
		if (cur == null) {
			BSTAnimations.printToTop("NOT FOUND");
			return null;
		}
		if (num < cur.key) {
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("GOING LEFT");
			BSTAnimations.stopHighlight(cur);
			return findHelper (num, cur.left);
		} else if (num > cur.key) {
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("GOING RIGHT");
			BSTAnimations.stopHighlight(cur);
			return findHelper (num, cur.right);
		} else {
			BSTAnimations.startHighlight(cur);
			BSTAnimations.printToTop("FOUND IT!");
			BSTAnimations.stopHighlight(cur);
			return cur;
		}
	}
	
	//uses hibbard deletion to delete a node
	private void hibbardDeletion (Node cur, Node parent) {
		//if cur has no children, just delete the node and remove its edge
		if (cur.left == null && cur.right == null) {
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
			
			if (root == cur) {
				root = cur.right;
			} else {
				if (parent.left == cur) {
					parent.left = cur.right;
				} else {
					parent.right = cur.right;
				}
				cur.right.prev = parent;
			}
			
			
		} else if (cur.right == null) {
			//if the node has a left child, move up the left child
			if (root == cur) {
				root = cur.left;
			} else {
				if (parent.left == cur) {
					parent.left = cur.left;
				} else {
					parent.right = cur.left;
				}
				cur.left.prev = parent;
			}
		} else {
			//if the node has two children...
			
			//delete the drawing of the node and its edge to its parent
			
			//find the minimum node as the successor node
			Node min = cur.right;
			Node minParent = cur;
			while (min.left != null) {
				minParent = min;
				min = min.left;
			}
			
			//replace the value of cur with min
			if (root == cur) {
				root.key = min.key;
			}
			cur.key = min.key;
			//remove the drawing of min
			hibbardDeletion(min, minParent);
			
			//redraw cur with the value of min
//			BSTAnimations.drawNode (cur);
//			BSTAnimations.drawLine(parent, cur);
		}
	}

	private String checkIfTextEmpty(String text) {
		if (text.length() == 0) {
			text = "bst is empty";
		} else {
			text = text.substring(0, text.length() - 2);
		}
		return text;
	}
	
	public void inOrderPrint () {
		if (root == null) {
			BSTAnimations.print("BST IS EMPTY");
		} else {
			BSTAnimations.print(inOrderPrintHelper("in order: ", root));
		}
	}
	
	private String inOrderPrintHelper(String s, Node cur) {
		if (cur == null) {
			return s;			
		}
		
		// call left tree
		s = inOrderPrintHelper(s, cur.left);
		
		// append current node
		s += cur.key + " ";
		
		BSTAnimations.startHighlight(cur);
		BSTAnimations.stopHighlight(cur);
		
		// call right tree
		s = inOrderPrintHelper(s, cur.right);
		
		return s;
	}

	public void postOrderPrint() {
		if (root == null) {
			BSTAnimations.print("BST IS EMPTY");
		} else {
			BSTAnimations.print(postOrderPrintHelper("post order: ", root));
		}
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
		s += cur.key + " ";
		
		BSTAnimations.startHighlight(cur);
		BSTAnimations.stopHighlight(cur);
		
		return s;
	}

	public void preOrderPrint() {
		if (root == null) {
			BSTAnimations.print("BST IS EMPTY");
		} else {
			BSTAnimations.print(preOrderPrintHelper("pre order: ", root));
		}		
	}

	private String preOrderPrintHelper(String s, Node cur) {
		if (cur == null) {
			return s;
		}
		
		// append current node
		s += cur.key + " ";
		
		BSTAnimations.startHighlight(cur);
		BSTAnimations.stopHighlight(cur);
		
		// call left tree
		s = preOrderPrintHelper(s, cur.left);
		
		// call right tree
		s = preOrderPrintHelper(s, cur.right);
		
		return s;
	}
	
	
}
