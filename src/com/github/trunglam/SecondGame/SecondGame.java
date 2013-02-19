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
	Block firstBlock = null, secondBlock = null;
	static float x, y, verticalSpeed;
	public static final float SURFACE_Y = 288;
	public static final float CENTER_X = 400;
	boolean stop = true;
	
	public SecondGame() {
		super("SecondGame");
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setBackground(Color.red);
		land.draw(x, y);
		player.getImage().draw(player.getX(), player.getY());
		firstBlock.getImage().draw(firstBlock.getX(), firstBlock.getY());
		secondBlock.getImage().draw(secondBlock.getX(), secondBlock.getY());
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		x = 0;
		y = 0;
		verticalSpeed = 0;
		land = new Image("dat/level_1.png");
		player = new Player("dat/walk0001.png");
		firstBlock = new Block("dat/ground32x32.png", 288, SURFACE_Y - 32);
		secondBlock = new Block("dat/ground32x32.png", 288-32, SURFACE_Y);
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
		
		if (input.isKeyDown(Input.KEY_W) && stop) {
			System.out.println(stop);
			verticalSpeed = -.2f * delta;
			player.setJump(true);
			stop = false;
		}
		
		if (y > 100 && player.isJump()) {
			verticalSpeed = .2f * delta;
		}
		
		if (player.isJump()) {
			if (!stop)
				y -= verticalSpeed;
		}
		else {
			player.setJump(false);
		}
		
		if (player.getBounds().intersects(firstBlock.getBounds())) {
			if (firstBlock.getX() < player.getX()){
				x -=.1f * delta;								
			}
			else
				x += .1f * delta;

		}
		
		if (player.getBounds().intersects(firstBlock.getTopBounds())) {
			if (!stop)
				stop = true;
			if (player.isJump())
				player.setJump(false);
		}
		
		
		if (player.getBounds().intersects(secondBlock.getTopBounds())) {
			if (!stop)
				stop = true;
			if (player.isJump())
				player.setJump(false);
		}
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SecondGame());
		app.setDisplayMode(800, 320, false);
		app.start();
	}

}
