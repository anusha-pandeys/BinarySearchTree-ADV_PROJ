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
		
		// make "insert node" button
		Button insert = new Button(0.05, 0.25, 0.25, 0.2, "Insert");
		
		// make "delete node" button
		Button delete = new Button(0.35, 0.25, 0.25, 0.2, "Delete");
		
		// make "find node" button
		Button find = new Button(0.65, 0.25, 0.25, 0.2, "Find");
		
		// make "pre-order print" button
		Button clear = new Button(0.95, 0.25, 0.25, 0.2, "Clear");
		
		// make "in-order print" button
		Button preOrderPrint = new Button(0.05, 0, 0.25, 0.2, "Pre-order");
		
		// make "post-order print" button
		Button inOrderPrint = new Button(0.35, 0, 0.25, 0.2, "In-order");
		
		// make "clear" button
		Button postOrderPrint = new Button(0.65, 0, 0.25, 0.2, "Post-order");
		
		// waits to collect data & sends collected info to BST
		while (true) {
			// check to see if insert has been pressed
			String insertData = insert.getData();
			if (insertData != null) bst.insert(insertData);
			
			// check to see if delete has been pressed
			String deleteData = delete.getData();
			if (deleteData != null) bst.delete(deleteData);
			
			// check to see if find has been pressed
			//String findData = find.getData();
			//bst.find(findData);
			
			// check to see if pre-order print has been pressed
			//if (preOrderPrint.isClicked()) bst.preOrderPrint();
			
			// check to see if in-order print has been pressed
			if (inOrderPrint.isClicked()) bst.inOrderPrint();
			
			// check to see if post-order print has been pressed
			if (postOrderPrint.isClicked()) bst.postOrderPrint();
			
			// check to see if clear has been pressed
			//if (clear.isClicked()) bst.clear();
		}
	}
}

