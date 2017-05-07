package com.mn.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.cn.resources.Rescourse;

public class FlyObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image image;

	public FlyObject(int x,int y,int width,int height,Image bullet2) {
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.image = bullet2;
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image enemy2Hit1) {
		this.image = enemy2Hit1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean collision(FlyObject other) {
		Rectangle rec1 = null;
		Rectangle rec2 = null;
		
		rec1=new Rectangle(this.x , this.y , this.width , this.height) ;
		
		if(other.getImage()==Rescourse.hero1||other.getImage()==Rescourse.hero2)
			rec2=new Rectangle(other.x+other.width/3 , other.y , other.width/3 , other.height) ;
		else
			rec2=new Rectangle(other.x , other.y , other.width , other.height) ;
		
		if (rec1.intersects(rec2)) 
			return true;
		else
			return false;
	}

}
