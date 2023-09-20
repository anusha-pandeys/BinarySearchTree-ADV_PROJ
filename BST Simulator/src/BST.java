public class BST {
		
	private Node root;
	private BSTAnimations animations;
	
	public BST () {
		root = new Node();
		animations = new BSTAnimations();
	}
	
	public void insert(String s) {
		if (s == "") {
			animations.print("ERROR");
			return;
		}
		insertHelper (s, root);
	}
	
	private void insertHelper(String s, Node cur) {
		if (cur == null) {
			cur = new Node (s);
			//DRAW NEW NODE
		} else if (cur.key.equals(s)) {
			animations.print("NO DUPLICATES");
		} else if (cur.key.compareTo(s) > 0) {
			if (cur.right == null) {
				cur.right = new Node (s);
				//DRAW NEW NODE
			} else {
				insertHelper (s, cur.right);
				animations.print("GOING RIGHT");
			}
			
		} else {
			if (cur.left == null) {
				cur.left = new Node (s);
				//DRAW NEW NODE
			} else {
				insertHelper (s, cur.left);
				animations.print("GOING LEFT");
			}
		}
		
	}
	
	public void delete (String s) {
		if (s == "") {
			animations.print("ERROR");
			return;
		}
		Node toDelete = findNode (s, root);
		hibbardDeletion (toDelete);
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
	
	private void hibbardDeletion (Node cur) {
		if (cur == null) {
			return;
		}
		if (cur.left == null && cur.right == null) {
			//DELETE
			cur = null;
		} else if (cur.left == null) {
			//DEL AND REPLACE
			cur = cur.right;
		} else if (cur.right == null) {
			//DEL AND REPLACE
			cur = cur.left;
		}
		
		//DEL AND REPLACE
		Node min = cur.right;
		while (min.left != null) {
			min = min.left;
		}
		cur.key = min.key;
		min = null;		
	}

}
