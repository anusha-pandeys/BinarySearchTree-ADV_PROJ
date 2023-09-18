
public class Button {
	// fields
	private double x;
	private double y;
	private double width;
	private double height;
	private String text;
	
	public Button (double x, double y, double width, double height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		StdDraw.rectangle(x, y, width/2, height/2);
		StdDraw.text(x, y, text);
	}
	
	private boolean isInArea(double mouseX, double mouseY) {
		return (mouseX < x + width / 2 && mouseX > x - width / 2 && mouseY < y + height / 2 && mouseY > y - height / 2);
	}
	
	public boolean isClicked() {
		return StdDraw.isMousePressed() && isInArea(StdDraw.mouseX(), StdDraw.mouseY());
	}
}
