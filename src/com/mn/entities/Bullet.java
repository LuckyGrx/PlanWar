package com.mn.entities;

import java.awt.Image;
import java.util.List;

import com.cn.build.GamePanel;
import com.cn.resources.Rescourse;

public class Bullet extends FlyObject{
	
	public final static int BULLET_WIDTH=6;
	public final static int BULLET_HEIGHT=14;
	
	private final static int speed=20;
	private GamePanel flyPanel;
	private boolean isTwoBullet;
	
	public Bullet(int x, int y,GamePanel flyPanel,Image bullet) {
		super(x,y,bullet.getWidth(null),bullet.getHeight(null),bullet);
		if(bullet==Rescourse.bullet1)
			isTwoBullet=false;
		else if(bullet==Rescourse.bullet2)
			isTwoBullet=true;
		this.flyPanel=flyPanel;
	}
	
	public Enemy hitEnemys(){
		List<Enemy> enemys = this.flyPanel.returnEnemys() ;
		for(int i = 0 ; i < enemys.size() ; i ++){
			Enemy e = enemys.get(i) ;
			if(this.collision(e)){
				if (e.getImage() == Rescourse.enemy2Fly1
						|| e.getImage() == Rescourse.enemy2Fly2)
					e.setImage(Rescourse.enemy2Hit1);
				else if(e.getImage() == Rescourse.enemy3Fly1)
					e.setImage(Rescourse.enemy3Hit1);

					e.setStrength(e.getStrength()-1);
				return e ;
			}
		}
		return null ;
	}
	
	public boolean isTwoBullet() {
		return isTwoBullet;
	}

	public void setTwoBullet(boolean isTwoBullet) {
		this.isTwoBullet = isTwoBullet;
	}
	public int getSpeed() {
		return speed;
	}
}
