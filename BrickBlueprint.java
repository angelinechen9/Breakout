package ball;

import processing.core.PApplet;

public class BrickBlueprint {
	PApplet p;
	
	// color
	public float r;
	public float g;
	public float b;
	
	// size
	public float length;
	public float width;
	
	// location
	public float x;
	public float y;
	
	public BrickBlueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
			tempWidth, float tempR, float tempG, float tempB) {
		p = tempApp;
		x = tempX;
		y = tempY;
		length = tempLength;
		width = tempWidth;
		r = tempR;
		g = tempG;
		b = tempB;
	}
	
	public void display () {
		p.fill (r, g, b);
		p.rect (x, y, length, width);
	}
}