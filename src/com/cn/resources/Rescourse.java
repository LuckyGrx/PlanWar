package com.cn.resources;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Rescourse {	
	static {
		try {
			bg1=new ImageIcon(ImageIO.read(new File("image/bg_01.jpg"))).getImage();
			bg2=new ImageIcon(ImageIO.read(new File("image/bg_02.jpg"))).getImage();
			
			hero1=new ImageIcon(ImageIO.read(new File("image/hero_fly_1.png"))).getImage();
			hero2=new ImageIcon(ImageIO.read(new File("image/hero_fly_2.png"))).getImage();
			heroBlowUp1=new ImageIcon(ImageIO.read(new File("image/hero_blowup_1.png"))).getImage();
			heroBlowUp2=new ImageIcon(ImageIO.read(new File("image/hero_blowup_2.png"))).getImage();
			heroBlowUp3=new ImageIcon(ImageIO.read(new File("image/hero_blowup_3.png"))).getImage();
			heroBlowUp4=new ImageIcon(ImageIO.read(new File("image/hero_blowup_4.png"))).getImage();
			
			bullet1=new ImageIcon(ImageIO.read(new File("image/bullet1.png"))).getImage();
			bullet2=new ImageIcon(ImageIO.read(new File("image/bullet2.png")).getSubimage(0, 0, 6, 14)).getImage();
			
			enemy1Fly1=new ImageIcon(ImageIO.read(new File("image/enemy1_fly_1.png"))).getImage();
			enemy1BlowUp1=new ImageIcon(ImageIO.read(new File("image/enemy1_blowup_1.png"))).getImage();
			enemy1BlowUp2=new ImageIcon(ImageIO.read(new File("image/enemy1_blowup_2.png"))).getImage();
			enemy1BlowUp3=new ImageIcon(ImageIO.read(new File("image/enemy1_blowup_3.png"))).getImage();
			enemy1BlowUp4=new ImageIcon(ImageIO.read(new File("image/enemy1_blowup_4.png"))).getImage();
			
			enemy2Fly1=new ImageIcon(ImageIO.read(new File("image/enemy2_fly_1.png"))).getImage();
			enemy2Fly2=new ImageIcon(ImageIO.read(new File("image/enemy2_fly_2.png"))).getImage();
			enemy2Hit1=new ImageIcon(ImageIO.read(new File("image/enemy2_hit_1.png"))).getImage();
			enemy2BlowUp1=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_1.png"))).getImage();
			enemy2BlowUp2=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_2.png"))).getImage();
			enemy2BlowUp3=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_3.png"))).getImage();
			enemy2BlowUp4=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_4.png"))).getImage();
			enemy2BlowUp5=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_5.png"))).getImage();
			enemy2BlowUp6=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_6.png"))).getImage();
			enemy2BlowUp7=new ImageIcon(ImageIO.read(new File("image/enemy2_blowup_7.png"))).getImage();
			
			enemy3Fly1=new ImageIcon(ImageIO.read(new File("image/enemy3_fly_1.png"))).getImage();
			enemy3Hit1=new ImageIcon(ImageIO.read(new File("image/enemy3_hit_1.png"))).getImage();
			enemy3BlowUp1=new ImageIcon(ImageIO.read(new File("image/enemy3_blowup_1.png"))).getImage();
			enemy3BlowUp2=new ImageIcon(ImageIO.read(new File("image/enemy3_blowup_2.png"))).getImage();
			enemy3BlowUp3=new ImageIcon(ImageIO.read(new File("image/enemy3_blowup_3.png"))).getImage();
			enemy3BlowUp4=new ImageIcon(ImageIO.read(new File("image/enemy3_blowup_4.png"))).getImage();
			
			enemy4Fly1=new ImageIcon(ImageIO.read(new File("image/enemy4_fly_1.png"))).getImage();
			
			enemy5Fly1=new ImageIcon(ImageIO.read(new File("image/enemy5_fly_1.png"))).getImage();
			
			bomb=new ImageIcon(ImageIO.read(new File("image/bomb.png"))).getImage();
			
			pause1=new ImageIcon(ImageIO.read(new File("image/game_pause.png"))).getImage();
			pause2=new ImageIcon(ImageIO.read(new File("image/game_pause_hl.png"))).getImage();
			
			gameLoading1=new ImageIcon(ImageIO.read(new File("image/shoot_background.png")).getSubimage(0, 38,200, 37)).getImage();
			gameLoading2=new ImageIcon(ImageIO.read(new File("image/shoot_background.png")).getSubimage(0, 0, 200, 37)).getImage();
			gameLoading3=new ImageIcon(ImageIO.read(new File("image/shoot_background.png")).getSubimage(480, 662, 200, 37)).getImage();
			gameLoading4=new ImageIcon(ImageIO.read(new File("image/shoot_background.png")).getSubimage(480, 840, 450, 90)).getImage();
			
			buttonBg=new ImageIcon(ImageIO.read(new File("image/button_bg.png"))).getImage();
			buttonHoverBg=new ImageIcon(ImageIO.read(new File("image/button_hover_bg.png"))).getImage();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Image bg1;
	public static Image bg2;
	
	public static Image hero1;
	public static Image hero2;
	public static Image heroBlowUp1;
	public static Image heroBlowUp2;
	public static Image heroBlowUp3;
	public static Image heroBlowUp4;
	
	public static Image bullet1;
	public static Image bullet2;
	
	public static Image enemy1Fly1;
	public static Image enemy1BlowUp1;
	public static Image enemy1BlowUp2;
	public static Image enemy1BlowUp3;
	public static Image enemy1BlowUp4;
	
	public static Image enemy2Fly1;
	public static Image enemy2Fly2;
	public static Image enemy2Hit1;
	public static Image enemy2BlowUp1;
	public static Image enemy2BlowUp2;
	public static Image enemy2BlowUp3;
	public static Image enemy2BlowUp4;
	public static Image enemy2BlowUp5;
	public static Image enemy2BlowUp6;
	public static Image enemy2BlowUp7;
	
	public static Image enemy3Fly1;
	public static Image enemy3Hit1;
	public static Image enemy3BlowUp1;
	public static Image enemy3BlowUp2;
	public static Image enemy3BlowUp3;
	public static Image enemy3BlowUp4;
	
	public static Image enemy4Fly1;
	
	public static Image enemy5Fly1;
	
	public static Image bomb;
	
	public static Image pause1;
	public static Image pause2;
	
	
	public static Image gameLoading1;
	public static Image gameLoading2;
	public static Image gameLoading3;
	public static Image gameLoading4;
	
	public static Image buttonBg;
	public static Image buttonHoverBg;
	
}
