public class BSTAnimations {
	public static final double PANEL_WIDTH = 0.25;
	public static final double WIDTH = BSTSimulator.X_SCALE - PANEL_WIDTH;
	public static final double HEIGHT = 1 - (3.0/32);
	
	private static Button topMessage = new Button(WIDTH / 2 + PANEL_WIDTH, BSTSimulator.Y_SCALE * 15.0 / 16, WIDTH - PANEL_WIDTH, BSTSimulator.Y_SCALE / 8, "Welcome!"); 
	private final static double R = 0.04;
	private final static double CIRCLE_EDGE = R / Math.sqrt(2);
	//private final static double CIRCLE_EDGE_OLD = Math.sqrt(0.2) * R + 0.015;
	private final static double TEXT_SIZE = 16 / BSTSimulator.CANVAS_HEIGHT;
	
	
	public static void drawTree(Node n) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(WIDTH/2 + PANEL_WIDTH, HEIGHT/2, WIDTH/2, HEIGHT/2);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		double depth = depth(n);
		double maxWidth = Math.pow(2, depth - 1);
		double dy = HEIGHT/9;
		double dx = 0.15;
		if (maxWidth/2 * dx > PANEL_WIDTH) {
			dx = (WIDTH * 15.0 /16) /maxWidth;
		}
		drawTreeHelper (n, WIDTH/2 + PANEL_WIDTH, HEIGHT - dy, dx, dy);
	}
	
	private static void drawTreeHelper (Node n, double x, double y, double dx, double dy) {
		if (n == null) {
			return;
		} 
		n.x = x;
		n.y = y;
		
		if (n.prev == null) {
			drawNode(n);
		} else {
			drawNode(n);
			drawLineToParent(n);
		}
		drawTreeHelper(n.left, x - dx, y - dy, dx, dy);
		drawTreeHelper(n.right, x + dx, y - dy, dx, dy);
		
	}
	
	private static void drawNode (Node n) {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, Integer.toString(n.key));
		
	}
	
	private static void drawLineToParent(Node n) {
		StdDraw.setPenColor(StdDraw.BLUE);
//		if (n == n.prev.right) {
//			StdDraw.line(n.prev.x + CIRCLE_EDGE, n.prev.y - CIRCLE_EDGE, n.x - CIRCLE_EDGE, n.y + CIRCLE_EDGE);
//		} else {
//			StdDraw.line(n.prev.x - CIRCLE_EDGE, n.prev.y - CIRCLE_EDGE, n.x + CIRCLE_EDGE, n.y + CIRCLE_EDGE);
//		}
		
		
		if (n == n.prev.right) {
			StdDraw.line(n.prev.x + CIRCLE_EDGE, n.prev.y - CIRCLE_EDGE, n.x - CIRCLE_EDGE, n.y + CIRCLE_EDGE);
		} else {
			StdDraw.line(n.prev.x - CIRCLE_EDGE, n.prev.y - CIRCLE_EDGE, n.x + CIRCLE_EDGE, n.y + CIRCLE_EDGE);
		}
	}
	
	private static double depth(Node cur) {
        if (cur == null) {
            return 0;
        } 
        /* compute the depth of each subtree */
        double left = depth(cur.left);
        double right = depth(cur.right);
 
        /* use the larger one */
        if (left > right) {
        	return (left + 1);
        }
        return (right + 1);
    }
	
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
	
///////////////////////////////
	
//	public static void drawNode(Node n) {
//		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
//		StdDraw.filledCircle(n.x, n.y, R);
//		
//		StdDraw.setPenColor(StdDraw.BLACK);
//		StdDraw.text(n.x, n.y, Integer.toString(n.key));
//		
//	}
//	
//	public static void drawLine(Node parent, Node child) {
//		StdDraw.setPenColor(StdDraw.BLUE);
//		if (child == parent.right) {
//			StdDraw.line(parent.x + CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x - CIRCLE_EDGE, child.y + CIRCLE_EDGE);
//		} else {
//			StdDraw.line(parent.x - CIRCLE_EDGE, parent.y - CIRCLE_EDGE, child.x + CIRCLE_EDGE, child.y + CIRCLE_EDGE);
//		}
//	}
	
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
	
///////////////////////////////////////////////
	
	public static void print(String s) {
		// "cover up" previous text
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(WIDTH / 2 + PANEL_WIDTH, HEIGHT / 16, (WIDTH - PANEL_WIDTH) / 2, HEIGHT / 16);
		
		// draw new line
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenColor();
		StdDraw.line(WIDTH /2 + PANEL_WIDTH - 1.0/8 , HEIGHT / 16 - TEXT_SIZE, WIDTH /2 + PANEL_WIDTH + 1.0/8, HEIGHT / 16 - TEXT_SIZE);
		StdDraw.setPenRadius();
		
		// display new text
		StdDraw.text(WIDTH /2 + PANEL_WIDTH, HEIGHT / 16, s);
	}

}