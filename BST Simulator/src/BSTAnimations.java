public class BSTAnimations {
	Button message;
	private final double R = 0.07;
	private final double CIRCLE_EDGE = Math.sqrt(0.2) * R + 0.015;
	
	public BSTAnimations() {
		message = new Button(0.5, 1, 0.5, 0.2, "");
	}
	
	public void startHighlight (Node n) {
		if (n == null) {
			return;
		}
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, n.key);
		StdDraw.pause(500);
	}
	
	public void stopHighlight (Node n) {
		if (n == null) {
			return;
		}
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, n.key);
	}
	
	public void print (String text) {
		message.changeText(text, StdDraw.WHITE);
		StdDraw.pause(1500);
		message.changeText("", StdDraw.WHITE);
		StdDraw.pause(500);
	}
	
	public void drawNode(Node n) {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, n.key);
		
	}
	
	public void drawLine (Node parent, Node child) {
		StdDraw.setPenColor(StdDraw.BLUE);
		if (child == parent.right) {
			StdDraw.line(parent.x + CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x - CIRCLE_EDGE, child.y + CIRCLE_EDGE);
		} else {
			StdDraw.line(parent.x - CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x + CIRCLE_EDGE, child.y + CIRCLE_EDGE);
		}
	}
	
	public void deleteNode(Node parent, Node child) {
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
	
	public static void printToScreen(String s) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(0.5, -0.175, 0.75, 0.075);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, -0.175, s);
	}

}
