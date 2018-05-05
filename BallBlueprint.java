// Ball Class
// 1. make a new project / package and make a class called Ball
// 2. give your Ball blueprint attributes (including x and y velocities)
// 3. give your Ball blueprint a constructor
// 4. give your Ball blueprint a display function
// 5. give your Ball blueprint a bounce function (it should bounce off both walls and the ceiling and floor)
// 6. make a client class, you can add multiple balls, make them change color size when they hit the walls, etc.

package ball;

import processing.core.PApplet;

public class BallBlueprint {
	PApplet p;
	
	// color
	public float r;
	public float g;
	public float b;
	
	// size
	public float length;
	public float width;
	
	// speed
	public float vx;
	public float vy;
	
	// location
	public float x;
	public float y;
	
	public BallBlueprint(PApplet tempApp, float tempX, float tempY, float tempLength, float
			tempWidth, float tempVX, float tempVY, float tempR, float tempG, float tempB) {
		p = tempApp;
		x = tempX;
		y = tempY;
		length = tempLength;
		width = tempWidth;
		vx = tempVX;
		vy = tempVY;
		r = tempR;
		g = tempG;
		b = tempB;
	}
	
	public void display () {
		p.fill (r, g, b);
		p.ellipse (x, y, length, width);
		p.ellipse (x - 13, y - 13, length / 2, width / 2);
		p.ellipse (x + 13, y - 13, length / 2, width / 2);
	}
	
	public void drive() {
		x = x + vx;
		if (x + width >= p.width || x < 0) {
			vx *= -1;
		}
		y = y + vy;
		if (y + length >= p.height || y < 0) {
			vy *= -1;
		}
	}
	
	public float getx() {
		return x;
	}
	
	public float gety() {
		return y;
	}
	
	public float getvx() {
		return vx;
	}
	
	public float getvy() {
		return vy;
	}
	
	public void setv(float tempvx, float tempvy) {
		vx = tempvx * -1;
		vy = tempvy * -1;
	}
	
}