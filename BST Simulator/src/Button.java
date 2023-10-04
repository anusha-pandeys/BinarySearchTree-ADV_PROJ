import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Button {
	// fields
	private double x;
	private double y;
	private double width;
	private double height;
	private final int ENTER = 10;
	private final int BACKSPACE = 8;
	
	public Button(double x, double y, double width, double height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		changeText(text, StdDraw.WHITE);
	}
	
	public Button(double x, double y, double width, double height, String text, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		changeText(text, color);
	}
	
	public void changeText(String newText, Color color) {
		StdDraw.setPenColor(color);
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
	public String getStringData() {
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
				
				// display the current input on the screen
				BSTAnimations.print(input);
			}
			
			// erase what you typed
			BSTAnimations.print("");
			
			// return what you typed
			return input;
		}
		return null;
	}
	
	public Integer getIntData() {
		String input = getStringData();
		if (input != null) {
			Integer num;
			try {	// try to parse the value
				num = Integer.parseInt(input);
				return num;
			} catch (NumberFormatException e) {	
				BSTAnimations.printToTop ("ENTER A NUMBER");
			}
		}
		return null;
	}
	
	public ArrayList<Integer> readFile() {
		String filePath = getStringData();
		if (filePath != null) {	// if the input is a CSV file
			BufferedReader in = null;
			ArrayList<Integer> values = new ArrayList<Integer>();
			try {
				in = new BufferedReader(new FileReader(new File(filePath)));
				String text;
				boolean done = false;	// remains false until there is nothing left to read from the file
				while (!done) {
					try {
						text = in.readLine();	// takes in a line from the given file
						String[] splitText = text.split(", ");	// splits the line of text into an array
						for (int i = 0; i < splitText.length; i++) {	// converts the string array into an integer array
							Integer num = null;
							try {
								num = Integer.parseInt(splitText[i]);
								values.add(num);
							} catch (NumberFormatException e) {	
								// if the value is not valid, then don't add it to the BST
							}
						}
					} catch (IOException e) {
						// no more text to read
						done = true;
					} catch (NullPointerException e) {
						// no more text to read
						done = true;
					}
				}
				in.close();
				return values;
			} catch (FileNotFoundException e) {
				BSTAnimations.printToTop("FILE NOT FOUND");
			} catch (IOException e) {
				// this is here to catch any exception that closing the BufferedReader throws
			}
		}
		return null;
	}
}
