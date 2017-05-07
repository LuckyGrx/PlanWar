package com.mn.entities;

import java.util.List;

import com.cn.build.GamePanel;
import com.cn.resources.Rescourse;

public class Animation implements Runnable {
	private Enemy enemy;
	private Hero hero;
	private GamePanel flyPanel;
	private List<Enemy> enemys;

	public Animation(GamePanel flyPanel, List<Enemy> enemys, Enemy enemy) {
		this.flyPanel = flyPanel;
		this.enemy = enemy;
		this.enemys = enemys;
		new Thread(this).start();
	}

	public Animation(GamePanel flyPanel, Hero hero) {
		this.flyPanel = flyPanel;
		this.hero = hero;
		new Thread(this).start();
	}

	public void run() {
		if (enemy != null) {
			while (enemys.contains(enemy)) {
				drawAnimation();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if (hero != null) {
			while (hero.isAlive()) {
				drawAnimation();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void drawAnimation() {
		if (enemy != null) {
			enemy.setBomb(true);
			
			if (enemy.getImage() == Rescourse.enemy1Fly1) // 1
				enemy.setImage(Rescourse.enemy1BlowUp1);
			else if (enemy.getImage() == Rescourse.enemy1BlowUp1)
				enemy.setImage(Rescourse.enemy1BlowUp2);
			else if (enemy.getImage() == Rescourse.enemy1BlowUp2)
				enemy.setImage(Rescourse.enemy1BlowUp3);
			else if (enemy.getImage() == Rescourse.enemy1BlowUp3)
				enemy.setImage(Rescourse.enemy1BlowUp4);
			else if (enemy.getImage() == Rescourse.enemy1BlowUp4) {
				enemys.remove(enemy);
			}

			else if (enemy.getImage() == Rescourse.enemy2Fly1
					|| enemy.getImage() == Rescourse.enemy2Fly2||enemy.getImage()==Rescourse.enemy2Hit1) // 2
				enemy.setImage(Rescourse.enemy2BlowUp1);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp1)
				enemy.setImage(Rescourse.enemy2BlowUp2);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp2)
				enemy.setImage(Rescourse.enemy2BlowUp3);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp3)
				enemy.setImage(Rescourse.enemy2BlowUp4);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp4)
				enemy.setImage(Rescourse.enemy2BlowUp5);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp5)
				enemy.setImage(Rescourse.enemy2BlowUp6);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp6)
				enemy.setImage(Rescourse.enemy2BlowUp7);
			else if (enemy.getImage() == Rescourse.enemy2BlowUp7) {
				enemys.remove(enemy);
			}

			else if (enemy.getImage() == Rescourse.enemy3Fly1||enemy.getImage()==Rescourse.enemy3Hit1) // 3
				enemy.setImage(Rescourse.enemy3BlowUp1);
			else if (enemy.getImage() == Rescourse.enemy3BlowUp1)
				enemy.setImage(Rescourse.enemy3BlowUp2);
			else if (enemy.getImage() == Rescourse.enemy3BlowUp2)
				enemy.setImage(Rescourse.enemy3BlowUp3);
			else if (enemy.getImage() == Rescourse.enemy3BlowUp3)
				enemy.setImage(Rescourse.enemy3BlowUp4);
			else if (enemy.getImage() == Rescourse.enemy3BlowUp4) {
				enemys.remove(enemy);
			}
		}

		if (hero != null) {
			if (hero.getImage() == Rescourse.hero1
					|| hero.getImage() == Rescourse.hero2)
				hero.setImage(Rescourse.heroBlowUp1);
			else if (hero.getImage() == Rescourse.heroBlowUp1)
				hero.setImage(Rescourse.heroBlowUp2);
			else if (hero.getImage() == Rescourse.heroBlowUp2)
				hero.setImage(Rescourse.heroBlowUp3);
			else if (hero.getImage() == Rescourse.heroBlowUp3)
				hero.setImage(Rescourse.heroBlowUp4);
			else if (hero.getImage() == Rescourse.heroBlowUp4) {
				hero.setAlive(false);
				flyPanel.addStartGamePanel();
			}

		}
	}

}
