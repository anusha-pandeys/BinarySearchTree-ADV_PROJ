public class Node {
	String key;
	Node left;
	Node right;
	Node prev;
	double x;
	double y;
	int depth;
	
	public Node () {
		key = null;
		left = null;
		right = null;
		prev = null;
		depth = 0;
		x = 0.5;
		y = 0.7;
    }
    public Node (String s) {
    	key = s;
    }


}