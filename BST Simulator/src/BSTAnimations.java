public class BSTAnimations {
	private final static double R = 0.05;
	public static final double PANEL_WIDTH = BSTSimulator.X_SCALE/8 + R;
	public static final double WIDTH = BSTSimulator.X_SCALE - PANEL_WIDTH;
	public static final double HEIGHT = 1 - (3.0/32);
	private static Button topMessage = new Button(WIDTH / 2 + PANEL_WIDTH, BSTSimulator.Y_SCALE * 15.0 / 16, WIDTH / 8 + 1.0/4, BSTSimulator.Y_SCALE / 8, "Welcome!"); 
	private final static double CIRCLE_EDGE = R / Math.sqrt(2);
	private final static double TEXT_SIZE = 16 / BSTSimulator.CANVAS_HEIGHT;
	
	
	public static void drawTree(Node n) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(WIDTH/2 + PANEL_WIDTH - R, HEIGHT/2, WIDTH/2, HEIGHT/2);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		double dy = HEIGHT/7;
		drawTreeHelper (n, HEIGHT - dy, dy, PANEL_WIDTH, PANEL_WIDTH + WIDTH);
	}
	
	private static void drawTreeHelper (Node n, double y, double dy, double lowerW, double upperW) {
		if (n == null) {
			return;
		} 
		
		n.x = (upperW - lowerW) / 2 + lowerW;
		n.y = y;
		
		if (n.prev == null) {
			drawNode(n);
		} else {
			drawLineToParent(n);
			drawNode(n);
		}
		drawTreeHelper(n.left, y - dy, dy, lowerW, n.x);
		drawTreeHelper(n.right, y - dy, dy, n.x, upperW);
		
	}
	
	private static void drawNode (Node n) {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(n.x, n.y, R);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n.x, n.y, Integer.toString(n.key));
		
	}
	
	private static void drawLineToParent(Node n) {
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.line(n.prev.x, n.prev.y, n.x, n.y);
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