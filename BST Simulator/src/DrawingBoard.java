// given a BST, draws it

public class DrawingBoard {
	// creates an appropriate frame
	public static void createFrame () {
		StdDraw.setScale(-0.25, 1.25);	// makes a margin of 0.25 for the frame
		StdDraw.show();
	}
	
	public static void startPage() {
		// intro animation?
		
		// welcome message?
		String welcome = "Welcome to our binary search tree simulator!";
		StdDraw.text(0.5, 1, welcome);
		
		// "add node" button
		StdDraw.rectangle(0, 0, 0.2, 0.1);
		String addNode = "Add node";
		StdDraw.text(0, 0, addNode);
	}
}
