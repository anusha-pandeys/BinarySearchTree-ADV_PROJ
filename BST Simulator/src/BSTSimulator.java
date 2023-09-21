/**
 * 
 * Use this class to handle the main features of your application.
 * You should add additional classes as appropriate to support good modularity and reduce redundancy.
 *
 */

public class BSTSimulator {
	public static void main(String[] args) {
		// set up BST here
		
		// generate STDraw window
		createFrame();
		startPage();
	}
	
	// creates an appropriate frame
	public static void createFrame () {
		StdDraw.setScale(-0.25, 1.25);	// makes a margin of 0.25 for the frame
		StdDraw.show();
	}
	
	// sets up the beginning of the BST simulator
	public static void startPage() {
		// intro animation?
		
		//commenting this out since i wasn't sure how to make it go away
		//when the rest of the code started to work
		/*
		// welcome message
		String welcome = "Welcome to our binary search tree simulator!";
		StdDraw.text(0.5, 1, welcome);
		*/
		
		// make BST
		BST bst = new BST();
		
		// make "add node" button
		Button add = new Button(0.125, 0, 0.125, 0.2, "Add");
		
		// make "delete node" button
		Button delete = new Button(0.375, 0, 0.125, 0.2, "Delete");
		
		// make "find node" button
		Button find = new Button(0.625, 0, 0.125, 0.2, "Find");
		
		// make "pre-order print" button
		Button preOrderPrint = new Button(0.875, 0, 0.125, 0.2, "Pre-order print");
		
		// make "in-order print" button
		//Button inOrderPrint = new Button(0.625, 0, 0.125, 0.2, "In-order print");
		
		// make "post-order print" button
		//Button postOrderPrint = new Button(0.750, 0, 0.125, 0.2, "Post-order print");
		
		// make "clear" button
		//Button clearOrderPrint = new Button(0.875, 0, 0.125, 0.2, "Clear all");
		
		// waits to collect data & sends collected info to BST
		while (true) {
			// check to see if insert has been pressed
			String insertData = checkInput(add);
			bst.insert(insertData);
			
			// check to see if delete has been pressed
			String deleteData = checkInput(delete);
			bst.delete(deleteData);
			
			// check to see if find has been pressed
			
			// check to see if pre-order print has been pressed
			
			// check to see if in-order print has been pressed
			
			// check to see if post-order print has been pressed
			
			// check to see if clear has been pressed
		}
	}
	
	public static String checkInput(Button button) {
		String data = button.getData();
		if (data != null) {	// this is means that an input has been given
			return data;
		}
		return "";
	}
	

}

