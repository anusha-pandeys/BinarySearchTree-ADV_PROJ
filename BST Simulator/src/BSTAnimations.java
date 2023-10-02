public class BSTAnimations {
	private static Button topMessage = new Button(BSTSimulator.X_SCALE / 2, BSTSimulator.Y_SCALE * 15 / 16, BSTSimulator.X_SCALE * 6 / 8, BSTSimulator.Y_SCALE / 8, "Welcome!"); 
	private final static double R = 0.07;
	private final static double CIRCLE_EDGE = Math.sqrt(0.2) * R + 0.015;
	private final static double TEXT_SIZE = 16 / BSTSimulator.CANVAS_HEIGHT;
	
	public static void startHighlight (Node n) {
		if (n == null) {
			return;
		}
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, Integer.toString(n.key));
		StdDraw.pause(500);
	}
	
	public static void stopHighlight (Node n) {
		if (n == null) {
			return;
		}
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, Integer.toString(n.key));
	}
	
	public static void printToTop(String text) {
		topMessage.changeText(text, StdDraw.WHITE);
		StdDraw.pause(1000);
		topMessage.changeText("", StdDraw.WHITE);
		StdDraw.pause(50);
	}
	
	public static void drawNode(Node n) {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, Integer.toString(n.key));
		
	}
	
	public static void drawLine(Node parent, Node child) {
		StdDraw.setPenColor(StdDraw.BLUE);
		if (child == parent.right) {
			StdDraw.line(parent.x + CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x - CIRCLE_EDGE, child.y + CIRCLE_EDGE);
		} else {
			StdDraw.line(parent.x - CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x + CIRCLE_EDGE, child.y + CIRCLE_EDGE);
		}
	}
	
	public static void deleteNode(Node parent, Node child) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(child.x, child.y, R + 0.01);
		if (parent != null) {
			StdDraw.setPenRadius(0.004);
			if (child == parent.right) {
				StdDraw.line(parent.x + CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x - CIRCLE_EDGE, child.y + CIRCLE_EDGE);
			} else {
				StdDraw.line(parent.x - CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x + CIRCLE_EDGE, child.y + CIRCLE_EDGE);
			}
		}
	}
	
	public static void print(String s) {
		// "cover up" previous text
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(BSTSimulator.X_SCALE / 2, BSTSimulator.Y_SCALE / 16, BSTSimulator.X_SCALE / 16, BSTSimulator.Y_SCALE / 16);
		
		// draw new line
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenColor();
		StdDraw.line(BSTSimulator.X_SCALE * 7 / 16, BSTSimulator.Y_SCALE / 16 - TEXT_SIZE, BSTSimulator.X_SCALE * 9 / 16, BSTSimulator.Y_SCALE / 16 - TEXT_SIZE);
		StdDraw.setPenRadius();
		
		// display new text
		StdDraw.text(BSTSimulator.X_SCALE / 2, BSTSimulator.Y_SCALE / 16, s);
	}

}