package com.cn.build;

import javax.swing.JPanel;

public class PausePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7813208763922621060L;
	private GameButton continueButton;
	private GameButton startGameButton;

	private String[] nameString = { new String("继续"), new String("重新开始") };

	public PausePanel(GamePanel gamePanel) {
		initComponents(gamePanel);
	}

	private void initComponents(GamePanel gamePanel) {

		this.continueButton = new GameButton(nameString[0]);
		this.continueButton.addActionListener(gamePanel);
		this.continueButton.setActionCommand(nameString[0]);
		this.continueButton.setOpaque(false);
		this.continueButton.setVisible(true);

		this.startGameButton = new GameButton(nameString[1]);
		this.startGameButton.addActionListener(gamePanel);
		this.startGameButton.setActionCommand(nameString[1]);
		this.startGameButton.setOpaque(false);
		this.startGameButton.setVisible(true);

		this.setSize(GameDialog.GAME_WIDTH/2, GameDialog.GAME_HEIGTH/2);
		this.setLocation(gamePanel.getX()+GameDialog.GAME_WIDTH/4, gamePanel.getY()+GameDialog.GAME_HEIGTH/4);
		this.setOpaque(false);
	
		this.add(continueButton);
		this.add(startGameButton);
		
		continueButton.setSize(GameDialog.GAME_WIDTH/2, GameDialog.GAME_HEIGTH/8);
		continueButton.setLocation(this.getX()*1/4, this.getY()*3/8);
		
		startGameButton.setSize(GameDialog.GAME_WIDTH, GameDialog.GAME_HEIGTH/8);
		startGameButton.setLocation(this.getX()*1/4, continueButton.getY()+GameDialog.GAME_HEIGTH/8);
		
	}
}
