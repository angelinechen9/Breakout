package ball;

import processing.core.PApplet;

public class BallandPaddle extends PApplet {
	
	BallBlueprint ball1 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 255, 0, 0);
	BallBlueprint ball2 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 255, 200, 0);
	BallBlueprint ball3 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 255, 255, 0);
	BallBlueprint ball4 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 0, 255, 0);
	BallBlueprint ball5 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 0, 0, 255);
	BallBlueprint ball6 = new BallBlueprint(this, random(500), random(500), 25, 25, random(-5, 5), random(-5, 5), 255, 0, 255);
	
	public void setup() {
		size (500, 500);
		background (255, 255, 255);
	}
	
	public void draw() {
		background(255);
		ball1.display();
		ball2.display();
		ball3.display();
		ball4.display();
		ball5.display();
		ball6.display();
		ball1.drive();
		ball2.drive();
		ball3.drive();
		ball4.drive();
		ball5.drive();
		ball6.drive();
	}

}