package ball;

import java.util.ArrayList;

import com.sun.prism.paint.Color;

import processing.core.PApplet;

public class BallArray extends PApplet {

	ArrayList<BallBlueprint> b = new ArrayList<BallBlueprint>();

	public void setup() {
		background (255, 255, 255);
		size (500, 500);
		
		for(int i = 0; i < 1000; i++) {
			b.add(new BallBlueprint (this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), random(255), random(255), random(255)));
		}
		
		}

	public void draw() {
		fill(0, 0, 0, 15);
		noStroke();
		rect(0, 0, width, height);
		
		for(int i = 0; i < b.size(); i++) {
			b.get(i).drive();
			b.get(i).display();
		}
	}
}