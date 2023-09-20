public class BSTAnimations {
	Node root;
	Button message;
	
	public BSTAnimations() {
		root = new Node();
		message = new Button(0.5, 0, 0.4, 0.2, "");
	}
	
	public void print (String text) {
		message.changeText(text);
		StdDraw.pause(500);
		message.changeText("");
	}
	
	

}
