public class BST {
		
	private Node root;
	private BSTAnimations animations;
	private final double canvasWidth = 1.0;
	private final int level = 0;
	
	public BST () {
		animations = new BSTAnimations();
	}
	
	public boolean insert(String s) {
		if (s == "") {
			animations.print("ERROR");
		} else {
			insertHelper (s, root, null);
		}
		return true;
	}
	
	private void insertHelper(String s, Node cur, Node parent) {
		if (root == null) {
			root = new Node();
			root.key = s;
			animations.drawNode(root);
		} else if (cur.key.equals(s)) {
			animations.print("NO DUPLICATES");
		} else if (cur.key.compareTo(s) < 0) {
			animations.print("GOING RIGHT");
			if (cur.right == null) {
				cur.right = new Node (s);
				cur.right.depth ++;
				cur.right.x = cur.x + 0.5 / Math.pow(2, cur.right.depth);
				cur.right.y = cur.y - 0.15;
				cur.right.prev = cur;
				animations.drawNode(cur.right);
				animations.drawLine (cur, cur.right);
			} else {
				insertHelper (s, cur.right, cur);
			}
			
		} else {
			animations.print("GOING LEFT");
			if (cur.left == null) {
				cur.left = new Node (s);
				cur.left.depth ++;
				cur.left.x = cur.x - 0.5 / Math.pow(2, cur.left.depth);
				cur.left.y = cur.y - 0.15;
				cur.left.prev = parent;
				animations.drawNode(cur.left);
				animations.drawLine (cur, cur.left);
			} else {
				insertHelper (s, cur.left, cur);
			}
		}
		
	}
	
	public boolean delete (String s) {
		if (s == null) {
			animations.print("ERROR");
			return true;
		}
		Node toDelete = findNode (s, root);
		hibbardDeletion (toDelete, toDelete.prev);
		
		return true;
	}
	
	private Node findNode(String key, Node cur) {
		
		if (cur == null) {
			animations.print("NOT FOUND");
			return null;
		} else if (key.compareTo(cur.key) < 0) {
			animations.print("GOING LEFT");
			return findNode (key, cur.left);
		} else if (key.compareTo(cur.key) > 0) {
			animations.print("GOING RIGHT");
			return findNode (key, cur.right);
		} else {
			animations.print("FOUND IT!");
			return cur;
		}
	}
	
	private void hibbardDeletion (Node cur, Node parent) {
		if (cur == null) {
			return;
		}
		if (cur.left == null && cur.right == null) {
			animations.deleteNode (parent, cur);
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
			animations.deleteNode (parent, cur);
			cur = cur.right;
			animations.drawLine (parent, cur);
		} else if (cur.right == null) {
			animations.deleteNode (parent, cur);
			cur = cur.left;
			animations.drawLine (parent, cur);
		} else {
			animations.deleteNode (parent, cur);
			Node min = cur.right;
			Node minParent = cur;
			while (min.left != null) {
				minParent = min;
				min = min.left;
			}
			cur.key = min.key;
			
			hibbardDeletion(min, minParent);
			
			animations.drawNode (cur);
			animations.drawLine(parent, cur);
			
		}	
	}

}
