package com.mn.entities;

import java.awt.Image;

public class Treasure extends FlyObject {
	private int speed=30;
	private boolean isAlive=true;
	
	private boolean isDown=true;

	public Treasure(int x, Image enemy5Fly1) {
		super(x, -enemy5Fly1.getHeight(null), enemy5Fly1.getWidth(null), enemy5Fly1.getHeight(null), enemy5Fly1);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isDown() {
		return isDown;
	}
	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
