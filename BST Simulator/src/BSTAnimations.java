public class BSTAnimations {
	Button message;
	private final double R = 0.07;
	private final double CIRCLE_EDGE = Math.sqrt(0.2) * R + 0.015;
	
	public BSTAnimations() {
		message = new Button(0.5, 1, 0.5, 0.2, "");
	}
	
	public void print (String text) {
		message.changeText(text);
		StdDraw.pause(1500);
		message.changeText("");
		StdDraw.pause(500);
	}
	
	public void drawNode(Node n) {
		StdDraw.setPenColor(StdDraw.RED);
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

}
