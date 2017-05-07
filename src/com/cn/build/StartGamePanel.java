package com.cn.build;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2467774657539894280L;
	private JLabel titleLabel;
    private JLabel scoreLabel;
	private GameButton continueButton;

	public StartGamePanel(GamePanel gamePanel) {
		initComponents(gamePanel);
	}

	private void initComponents(GamePanel gamePanel) {
		
		this.titleLabel=new JLabel("飞机大战分数");
		this.titleLabel.setBackground(Color.gray);
		this.titleLabel.setFont(new Font("Dialog",Font.BOLD,25));
		this.titleLabel.setOpaque(true);
		this.titleLabel.setVisible(true);

		this.scoreLabel=new JLabel(gamePanel.getScore()+"");
		this.scoreLabel.setBackground(Color.gray);
		this.scoreLabel.setFont(new Font("Dialog",Font.BOLD,30));
		this.scoreLabel.setOpaque(true);
		this.scoreLabel.setVisible(true);

		this.continueButton = new GameButton("重新开始");
		this.continueButton.addActionListener(gamePanel);
		this.continueButton.setActionCommand("重新开始");
		this.continueButton.setOpaque(false);
		this.continueButton.setVisible(true);

		this.setSize(GameDialog.GAME_WIDTH/2, GameDialog.GAME_HEIGTH/3);
		this.setLocation(gamePanel.getX()+GameDialog.GAME_WIDTH/4, gamePanel.getY()+GameDialog.GAME_HEIGTH/3);
		this.setOpaque(true);
	
		this.add(titleLabel);
		this.add(scoreLabel);
		this.add(continueButton);
		
		titleLabel.setSize(this.getWidth(), this.getHeight()*2/10);
		titleLabel.setLocation(0,0);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);//居中
		
		scoreLabel.setSize(this.getWidth(), this.getHeight()*5/10);
		scoreLabel.setLocation(0,this.getHeight()*2/10);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		
		continueButton.setSize(this.getWidth()*1/8, this.getHeight()*3/10);
		continueButton.setLocation(this.getWidth()/8, this.getHeight()*7/10);
		
		
		this.setBackground(Color.gray);
		
	}

}
