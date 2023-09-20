
public class Button {
	// fields
	private double x;
	private double y;
	private double width;
	private double height;
	private final int ENTER = 10;
	private final int BACKSPACE = 8;
	
	public Button (double x, double y, double width, double height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(x, y, width/2, height/2);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(x, y, text);
	}
	
	public void changeText(String newText) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(x, y, width/2, height/2);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(x, y, newText);
	}
	
	// returns true if the given mouse x and y coordinates are within the area of the button
	private boolean isInArea(double mouseX, double mouseY) {
		return (mouseX < x + width / 2 && mouseX > x - width / 2 && mouseY < y + height / 2 && mouseY > y - height / 2);
	}
	
	// returns true if the button has been clicked
	public boolean isClicked() {
		return StdDraw.isMousePressed() && isInArea(StdDraw.mouseX(), StdDraw.mouseY());
	}
	
	// returns any typed data if the mouse is clicked (stops collecting data when enter is pressed)
	public String getData() {
		if (isClicked()) {	// if the button is pressed (to input data)
			String input = "";
			while (!StdDraw.isKeyPressed(ENTER)) {	// wait until enter key is pressed
				if (StdDraw.hasNextKeyTyped()) {	// if another key is pressed
					char newKey = StdDraw.nextKeyTyped();
					if (newKey == BACKSPACE && input.length() > 0) {	// if it is backspace
						input = input.substring(0, input.length() - 1);	// then delete a character
					} else if (newKey != ENTER) {
						input += newKey;	// otherwise, add it to the input string
					}
				}
				StdDraw.pause(100);	// to keep the screen from constantly refreshing - makes text look almost blurry
				
				// make a blank box for where the input text will go
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.filledRectangle(0.5, 0, 0.2, 0.1);
				// display the current input on the screen
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(0.5, 0, input);
			}
			// makes what you've typed disappear
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(0.5, 0, 0.2, 0.1);
			StdDraw.setPenColor(StdDraw.BLACK);
			
			return input;
		}
		return null;
	}
}
