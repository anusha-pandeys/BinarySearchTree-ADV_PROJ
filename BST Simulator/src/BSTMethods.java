public class BSTMethods {
	
	class Node {
		String key;
		Node left;
		Node right;
		
		public Node () {
			key = null;
			left = null;
			right = null;
        }
        public Node (String s) {
        	key = s;
        }
	}
	
	private Node root;
	
	public void insert(String s) {
		if (s == "") {
			return;
		}
		insertHelper (s, root);
	}
	
	private void insertHelper(String s, Node cur) {
		if (cur == null) {
			cur = new Node (s);
			//draw new node there
		} else if (cur.key.equals(s)) {
			//ANIMATE EQUAL
		} else if (cur.key.compareTo(s) > 0) {
			if (cur.right == null) {
				cur.right = new Node (s);
				//draw new node there
			} else {
				insertHelper (s, cur.right);
				//print going right
			}
			
		} else {
			if (cur.left == null) {
				cur.left = new Node (s);
				//draw new node there
			} else {
				insertHelper (s, cur.left);
				//print going left
			}
		}
		
	}
	
	public void delete (String s) {
		if (s == "") {
			return;
		}
		Node toDelete = findNode (s, root);
		hibbardDeletion (toDelete);
	}
	
	private Node findNode(String key, Node cur) {
		
		if (cur == null) {
			//print not found
			return null;
		} else if (key.compareTo(cur.key) < 0) {
			return findNode (key, cur.left);
		} else if (key.compareTo(cur.key) > 0) {
			return findNode (key, cur.right);
		} else {
			return cur;
		}
	}
	
	private void hibbardDeletion (Node cur) {
		
		if (cur.left == null && cur.right == null) {
			cur = null;
		} else if (cur.left == null) {
			cur = cur.right;
		} else if (cur.right == null) {
			cur = cur.left;
		}
		
		Node min = cur.right;
		while (min.left != null) {
			min = min.left;
		}
		cur.key = min.key;
		min = null;		
	}

}
