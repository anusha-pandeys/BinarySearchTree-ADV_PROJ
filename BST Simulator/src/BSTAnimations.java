public class BSTAnimations {
	Button message;
	private final static double R = 0.07;
	private final static double CIRCLE_EDGE = Math.sqrt(0.2) * R + 0.015;
	private final static double TEXT_SIZE = 16 / BSTSimulator.CANVAS_HEIGHT;
	
	public static void drawNode(Node n) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, n.key);
		
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
		StdDraw.filledRectangle(BSTSimulator.X_SCALE / 16, BSTSimulator.Y_SCALE / 16, BSTSimulator.X_SCALE / 16, BSTSimulator.Y_SCALE / 16);
		
		// draw new line
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenColor();
		StdDraw.line(0, BSTSimulator.Y_SCALE / 16 - TEXT_SIZE, BSTSimulator.X_SCALE / 8, BSTSimulator.Y_SCALE / 16 - TEXT_SIZE);
		StdDraw.setPenRadius();
		
		// display new text
		StdDraw.text(BSTSimulator.X_SCALE / 16, BSTSimulator.Y_SCALE / 16, s);
	}

}