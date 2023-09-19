
public class Button {
	// fields
	private double x;
	private double y;
	private double width;
	private double height;
	private final int ENTER = 10;
	
	public Button (double x, double y, double width, double height, String text, boolean inputButton) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		StdDraw.rectangle(x, y, width/2, height/2);
		StdDraw.text(x, y, text);
		String data = "";
		if (inputButton) {
			data = waitForData();
		}
		System.out.println(data);
	}
	
	private boolean isInArea(double mouseX, double mouseY) {
		return (mouseX < x + width / 2 && mouseX > x - width / 2 && mouseY < y + height / 2 && mouseY > y - height / 2);
	}
	
	public boolean isClicked() {
		return StdDraw.isMousePressed() && isInArea(StdDraw.mouseX(), StdDraw.mouseY());
	}
	
	public String waitForData() {
		while (true) {
			if (isClicked()) {	// if the button is pressed (to input data)
				String input = "";
				while (!StdDraw.isKeyPressed(ENTER)) {	// wait until enter key is pressed
					// make a blank box for where the input text will go
					
				}
				while (StdDraw.hasNextKeyTyped()) {	// while there are more keys to process
					input += StdDraw.nextKeyTyped();
				}
				return input;
			}
		}
	}
}
