package com.cn.build;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.resources.Rescourse;

public class GameLoadingPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image textImg;
	private JLabel planeLabel;
	private JLabel textLabel;
	private ImageIcon[] planeImgList;

	public GameLoadingPanel() {
		this.createLoadingPanel();
	}

	private void createLoadingPanel() {
		this.planeImgList = new ImageIcon[3];
		this.planeImgList[0] = new ImageIcon(
				Rescourse.gameLoading1);
		this.planeImgList[1] = new ImageIcon(
				Rescourse.gameLoading2);
		this.planeImgList[2] = new ImageIcon(
				Rescourse.gameLoading3);
		this.textImg = Rescourse.gameLoading4;
		planeLabel = new JLabel();
		textLabel = new JLabel(new ImageIcon(this.textImg));
		
		this.setLayout(new GridLayout(2, 2,100,0));
		JPanel panel1 = new JPanel();
		panel1.add(planeLabel);
		panel1.setOpaque(false);
		
		JPanel panel2 = new JPanel();
		panel2.add(textLabel);
		panel2.setOpaque(false);
		
		this.setOpaque(false);
		this.add(panel2);
		this.add(panel1);
	}

	public void loadingGame() {
		int times = 9;
		for (int i = 0; i <times; i++) {
				this.planeLabel.setIcon(this.planeImgList[i%3]);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
