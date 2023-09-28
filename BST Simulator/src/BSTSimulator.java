import java.awt.Color;

/**
 * 
 * Use this class to handle the main features of your application.
 * You should add additional classes as appropriate to support good modularity and reduce redundancy.
 *
 */

public class BSTSimulator {
	// makes the canvas size 90% the size of the school laptop screens
	public static final double CANVAS_WIDTH = 1366 * 0.9;
	public static final double CANVAS_HEIGHT = 768 * 0.9;
	public static final double X_SCALE = CANVAS_WIDTH / CANVAS_HEIGHT;
	public static final double Y_SCALE = 1;
	private static final Color buttonColor = StdDraw.PINK;
	
	public static void main(String[] args) {
		// generate STDraw window
		createFrame();
		startPage();
	}
	
	// creates an appropriate frame
	public static void createFrame () {
		StdDraw.setCanvasSize((int) CANVAS_WIDTH, (int) CANVAS_HEIGHT);
		// scales the canvas to fit the resolution
		StdDraw.setXscale(0, X_SCALE);
		StdDraw.setYscale(0, Y_SCALE);
		StdDraw.show();
	}
	
	// sets up the beginning of the BST simulator
	public static void startPage() {		
		// make BST
		BST bst = new BST();
		
		// coordinates and dimensions of the buttons
		double x = X_SCALE / 16;
		double y = Y_SCALE * 15 / 16;
		double dy = Y_SCALE / 8;
		double width = X_SCALE / 8;
		double height = Y_SCALE / 8;
		
		// make "insert node" button
		Button insert = new Button(x, y, width, height, "Insert", buttonColor);
		
		// make "delete node" button
		Button delete = new Button(x, y - dy, width, height, "Delete", buttonColor);
		
		// make "find node" button
		Button find = new Button(x, y - 2 * dy, width, height, "Find", buttonColor);
		
		// make "pre-order print" button
		Button clear = new Button(x, y - 3 * dy, width, height, "Clear", buttonColor);
		
		// make "in-order print" button
		Button preOrderPrint = new Button(x, y - 4 * dy, width, height, "Pre-order", buttonColor);
		
		// make "post-order print" button
		Button inOrderPrint = new Button(x, y - 5 * dy, width, height, "In-order", buttonColor);
		
		// make "clear" button
		Button postOrderPrint = new Button(x, y - 6 * dy, width, height, "Post-order", buttonColor);
		
		// make area to type
		BSTAnimations.print("");
		
		// waits to collect data & sends collected info to BST
		while (true) {
			// check to see if insert has been pressed
			String insertData = insert.getData();
			if (insertData != null) bst.insert(insertData);
			
			// check to see if delete has been pressed
			String deleteData = delete.getData();
			if (deleteData != null) bst.delete(deleteData);
			
			// check to see if find has been pressed
			String findData = find.getData();
			if (findData != null) bst.find(findData);
			
			// check to see if pre-order print has been pressed
			if (preOrderPrint.isClicked()) bst.preOrderPrint();
			
			// check to see if in-order print has been pressed
			if (inOrderPrint.isClicked()) bst.inOrderPrint();
			
			// check to see if post-order print has been pressed
			if (postOrderPrint.isClicked()) bst.postOrderPrint();
			
			// check to see if clear has been pressed
			if (clear.isClicked()) bst.clear();
		}
	}
}