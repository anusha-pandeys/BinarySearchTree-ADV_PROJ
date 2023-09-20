// given a BST, draws it

public class DrawingBoard {
	// creates an appropriate frame
	public static void createFrame () {
		StdDraw.setScale(-0.25, 1.25);	// makes a margin of 0.25 for the frame
		StdDraw.show();
	}
	
	// sets up the beginning of the BST simulator
	public static void startPage() {
		// intro animation?
		
		// welcome message
		String welcome = "Welcome to our binary search tree simulator!";
		StdDraw.text(0.5, 1, welcome);
		
		// make "add node" button
		Button addNode = new Button(0, 0, 0.4, 0.2, "Add node");
		
		// make "delete node" button
		Button deleteNode = new Button(1, 0, 0.4, 0.2, "Delete node");
		
		// waits to collect data & sends collected info to BST
		while (true) {
			String insertData = addNode.getData();
			if (insertData != null) {	// this is means that an input has been given to insert to BST
				//// THIS IS WHERE WE WOULD SEND AN INPUT MESSAGE TO THE BST!!!
				System.out.println("insert: " + insertData);
			}
			String deleteData = deleteNode.getData();
			if (deleteData != null) {	// this is means that an input has been given to delete from BST
				//// THIS IS WHERE WE WOULD SEND A DELETE MESSAGE TO THE BST!!!
				System.out.println("delete: " + deleteData);
			}
		}
	}
}
