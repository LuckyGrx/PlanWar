package com.mn.entities;

import java.awt.Image;
import com.cn.build.GameDialog;
import com.cn.build.GamePanel;
import com.cn.resources.Rescourse;

public class Hero extends FlyObject implements Runnable {
	private int speed = 2;
	private GamePanel flyPanel;
	private boolean isAlive = true;

	public Hero(GamePanel flyPanel, Image hero1) {
		super(GameDialog.GAME_WIDTH / 2 - hero1.getWidth(null) / 2,
				GameDialog.GAME_HEIGTH - hero1.getHeight(null) - 23, hero1
						.getWidth(null), hero1.getHeight(null), hero1);

		this.flyPanel = flyPanel;
		new Thread(this).start();
	}

	public void moveUp() {
		if (y - speed >= 0)
			y -= speed;
		else
			y = 0;
	}

	public void moveDown() {
		if (y + speed <= GameDialog.GAME_HEIGTH - image.getHeight(null) - 23)
			y += speed;
		else
			y = GameDialog.GAME_HEIGTH - image.getHeight(null) - 23;
	}

	public void moveLeft() {
		if (x - speed >= 0)
			x -= speed;
		else
			x = 0;
	}

	public void moveRight() {
		if (x + speed <= GameDialog.GAME_WIDTH - image.getWidth(null))
			x += speed;
		else
			x = GameDialog.GAME_WIDTH - image.getWidth(null);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void fire() {
		if (!isAlive)
			return;
		int bulletX;
		int bulletY;
		Bullet b;
		if (flyPanel.isTwoBullet()) {
			bulletX = this.x + Bullet.BULLET_WIDTH + 2;
			bulletY = this.y + Bullet.BULLET_HEIGHT;
			b = new Bullet(bulletX, bulletY, flyPanel, Rescourse.bullet2);

			Bullet c = new Bullet(this.x + Bullet.BULLET_WIDTH + 48, this.y
					+ Bullet.BULLET_HEIGHT, flyPanel, Rescourse.bullet2);
			flyPanel.getBullets(c);
		} else {
			bulletX = this.x + image.getWidth(null) / 2 - Bullet.BULLET_WIDTH
					/ 2;
			bulletY = this.y + Bullet.BULLET_HEIGHT;
			b = new Bullet(bulletX, bulletY, flyPanel, Rescourse.bullet1);
		}
		flyPanel.getBullets(b);
	}

	public void run() {
		while (!flyPanel.isTwoBullet()) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fire();
		}
		for (int i = 0; i < 70; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fire();
		}
		flyPanel.setTwoBullet(false);
		new Thread(this).start();
	}
}
