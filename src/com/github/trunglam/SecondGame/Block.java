package com.github.trunglam.SecondGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Block {
	
	private float x, y, width, height;
	Image image = null;
	public Block(String imageFile, float x, float y) throws SlickException {
		image = new Image(imageFile);
		this.x = x;
		this.y = y;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY()+2, width, height);
	}
	
	public Rectangle getTopBounds() {
		return new Rectangle(getX(), getY(), width, height*.1f);
	}
	
	public float getX() {
		return x + SecondGame.x;
	}
	
	public float getY() {
		return y + SecondGame.y;
	}
	
	public Image getImage() {
		return image;
	}
}
