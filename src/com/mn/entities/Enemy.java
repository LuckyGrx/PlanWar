package com.mn.entities;

import java.awt.Image;
import java.util.Random;

import com.cn.build.GamePanel;
import com.cn.resources.Rescourse;

public class Enemy extends FlyObject {

	private static final Random rand = new Random();
	private int speed;
	private int strength;
	private boolean isBomb;

	private GamePanel gamePanel;
	
	public Enemy(GamePanel gamePanel,int x,Image enemy2Fly1) {
		super(x,-2*enemy2Fly1.getHeight(null),enemy2Fly1.getWidth(null),enemy2Fly1.getHeight(null),enemy2Fly1);
		this.gamePanel=gamePanel;
		isBomb=false;
		addSpeed();
		if(enemy2Fly1==Rescourse.enemy2Fly1)
			this.strength=25;
		else if(enemy2Fly1==Rescourse.enemy3Fly1)
			this.strength=5;
		else
			this.strength=1;
		
		
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	

	private void addSpeed() {//´ý´¦Àí
		if(image==Rescourse.enemy2Fly1)//1-
			speed=(int) (gamePanel.getScore()/1000000+1);
		else if(image==Rescourse.enemy1Fly1){
			speed = rand.nextInt((int) (gamePanel.getScore()/100000+6));//2-
			while (speed < 2) {
				speed = rand.nextInt((int) (gamePanel.getScore()/100000+6));
			}
		}
		else{
			speed = rand.nextInt((int) (gamePanel.getScore()/500000+4));// 2-
			while (speed < 2) {
				speed = rand.nextInt((int) (gamePanel.getScore()/500000+4));
			}
		}
		this.setSpeed(speed);
	}
}
