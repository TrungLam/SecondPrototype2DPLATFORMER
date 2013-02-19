package com.github.trunglam.SecondGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SecondGame extends BasicGame{
	
	Image land = null;
	Player player = null;
	Block firstBlock = null;
	static float x, y, verticalSpeed;
	public static final float SURFACE_Y = 288;
	public static final float CENTER_X = 400;
	boolean stop = false;
	
	public SecondGame() {
		super("SecondGame");
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setBackground(Color.red);
		land.draw(x, y);
		player.getImage().draw(player.getX(), player.getY());
		firstBlock.getImage().draw(firstBlock.getX(), firstBlock.getY());
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		x = 0;
		y = 0;
		verticalSpeed = 0;
		land = new Image("dat/level_1.png");
		player = new Player("dat/walk0001.png");
		firstBlock = new Block("dat/ground32x32.png", 288, SURFACE_Y - 32);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_A)) {
			x += .1f * delta;
		}
		if (input.isKeyDown(Input.KEY_D)) {
			x -= .1f * delta;
		}
		
		if (input.isKeyDown(Input.KEY_W) && !player.isJump()) {
			verticalSpeed = -.2f * delta;
			player.setJump(true);
		}
		
		if (y > 100 && player.isJump()) {
			verticalSpeed = .2f * delta;
		}
		
		if ( y >= 0 && player.isJump()) {
			if (!stop)
				y -= verticalSpeed;
		}
		else {
			y = 0;
			player.setJump(false);
		}
		
		if (player.getBounds().intersects(firstBlock.getBounds())) {
			System.out.println("woo");
			x -=.1f * delta;
		}
		
		if (player.getBounds().intersects(firstBlock.getTopBounds())) {
			System.out.println("foo");
			stop = true;
		}
		else{
			stop = false;
		}
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SecondGame());
		app.setDisplayMode(800, 320, false);
		app.start();
	}

}
