// 1. create ball object that bounces
// 2. create a paddle at the bottom of the screen, it should follow your mouse's x coordinate
// 3. make the ball bounce off the paddle rather than the bottom of the screen
// 4. use a for loop to add bricks to an array list, their coordinates should allow them to be in a 10 X 10 grid

package ball;

import java.util.ArrayList;

import processing.core.PApplet;

public class Breakout extends PApplet {
	
	BallBlueprint ball = new BallBlueprint(this, 100, 300, 25, 25, 3, 5, 0, 0, 0);
	PaddleBlueprint paddle = new PaddleBlueprint(this, mouseX, 475, 100, 25, 1, 0, 0, 255);
	ArrayList<BrickBlueprint> b = new ArrayList<BrickBlueprint>();
	int gamestate = 0; // 0: run, 1: win, 2: lose
	int counter1 = 0;
	int counter2 = 0;

	
	public void setup() {
		size (500, 500);
		background (255, 255, 255);
		brick();
	}
	
	public void draw() {
		if (counter2 == 0) {
		fill (255, 255, 255);
		rect (0, 0, width, height);
		background (255, 255, 255);
		textSize (50);
		fill (0, 0, 0);
		text ("Breakout", 150, 300);
		textSize (25);
		fill (0, 0, 0);
		text ("Move Paddle to Hit Bricks with Ball", 50, 325);
		textSize (25);
		fill (0, 0, 0);
		text ("Press Mouse to Start", 125, 350);
		textSize (25);
		fill (0, 0, 0);
		text ("Press Key to Restart", 125, 375);
		displaybrick();
		ball.display();
		paddle.display();
		if (mousePressed) {
			counter1++;
		}
		if (counter1 >= 1) {
			ball.drive();
			paddle.drive();
			bounce();
			notdisplaybrick();
			game();
		}
		}
		
		if (keyPressed) {
			counter2++;
			brick();
			ball.setv(3,5);
		}
		if (counter2 > 0) {
			fill (255, 255, 255);
			rect (0, 0, width, height);
			background (255, 255, 255);
			textSize (50);
			fill (0, 0, 0);
			text ("Breakout", 150, 300);
			textSize (25);
			fill (0, 0, 0);
			text ("Move Paddle to Hit Bricks with Ball", 50, 325);
			textSize (25);
			fill (0, 0, 0);
			text ("Press Mouse to Start", 125, 350);
			textSize (25);
			fill (0, 0, 0);
			text ("Press Key to Restart", 125, 375);
			displaybrick();
			ball.display();
			paddle.display();
			ball.drive();
			paddle.drive();
			bounce();
			for (int i = 0; i < b.size(); i++) {
				if (ball.x > b.get(i).x && ball.x < b.get(i).x + 50 && ball.y > b.get(i).y && ball.y < b.get(i).y + 25) {
					ball.vy *= -1;
					b.remove(i);
				}
			}
			if ((ball.y + ball.length >= height) && (ball.getx() < paddle.getx() || ball.getx() > paddle.getx() + 100)) {
				text ("You Lost", 200, 400);
			}
			if (b.size() == 0){
				textSize (25);
				fill (0, 0, 0);
				text ("You Won", 200, 400);
				ball.setv(0,0);
			}
			restart();
		}
	}
	
	private void bounce() {
		if (ball.getx() > paddle.getx() && ball.getx() < paddle.getx() + 100 && ball.gety() + 12.5 > paddle.gety()) {
			ball.setv(ball.getvx(), -ball.getvy());
		}
	}
	
	private void brick() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				b.add(new BrickBlueprint (this, 50 * i, 25 * j, 50, 25, 0, 255, 255));
			}
		}
	}
	
	private void displaybrick() {
		for(int i = 0; i < b.size(); i++) {
			b.get(i).display();
		}
	}

	private void notdisplaybrick() {
		for (int i = 0; i < b.size(); i++) {
			if (ball.x > b.get(i).x && ball.x < b.get(i).x + 50 && ball.y > b.get(i).y && ball.y < b.get(i).y + 25) {
				ball.vy *= -1;
				b.remove(i);
			}
		}
	}
	
	private void game() {
		if ((ball.y + ball.length >= height) && (ball.getx() < paddle.getx() || ball.getx() > paddle.getx() + 100)) {
			gamestate = 2;
			ball.setv(0, 0);
		}
		else if (b.size() == 0) {
			gamestate = 1;
		}
		
		if (gamestate == 2) {
			textSize (25);
			fill (0, 0, 0);
			text ("You Lost", 200, 400);
		}
		else if (gamestate == 1) {
			textSize (25);
			fill (0, 0, 0);
			text ("You Won", 200, 400);
			ball.setv(0,0);
		}
	}
	
	private void restart() {
		if ((ball.y + ball.length >= height) && (ball.getx() < paddle.getx() || ball.getx() > paddle.getx() + 100)) {
			gamestate = 2;
			ball.setv(0, 0);
		}
		else if (b.size() == 0) {
			gamestate = 1;
		}
		
		if (gamestate == 2) {
			textSize (25);
			fill (0, 0, 0);
			text (" ", 200, 400);
		}
		else if (gamestate == 1) {
			textSize (25);
			fill (0, 0, 0);
			text (" ", 200, 400);
			ball.setv(0,0);
		}
	}
}