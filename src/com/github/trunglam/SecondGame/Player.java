package com.github.trunglam.SecondGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	private Image sprite = null;
	private float height;
	private float x;
	private float y;
	private float width;
	private boolean jumping = false;
	
	public Player(String imageFile) throws SlickException {
		sprite = new Image(imageFile);
		height = sprite.getHeight();
		width = sprite.getWidth();
		x = SecondGame.CENTER_X;
		y = SecondGame.SURFACE_Y - this.getHeight();
	}
	public void setJump(boolean isJumping) {
		jumping = isJumping;
	}
	public boolean isJump() {
		return jumping;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Image getImage() {
		return sprite;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);	
	}
}
