package com.cn.build;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.resources.Rescourse;

public class GameDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGTH = 600;

	private GamePanel gamePlayingPanel;
	private GameLoadingPanel gameLoadingPanel;
	private JLabel planeLabel;

	GameDialog() throws IOException {
		this.loadImage();
		this.initComponents();
		this.setBackgroundImage();
	}

	private void loadImage() throws IOException {// 处理开始的空白
		new Rescourse();
	}

	private void initComponents() {
		this.setTitle("飞机大战");
		this.setSize(GAME_WIDTH, GAME_HEIGTH);

		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeigth = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth - GAME_WIDTH) / 2,
				(screenHeigth - GAME_HEIGTH) / 2);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) throws IOException {
		new GameDialog().loadGame();
	}

	public void loadGame() {
		Container c = this.getContentPane();
		c.removeAll();
		this.repaint();
		if (this.gameLoadingPanel == null) {
			this.gameLoadingPanel = new GameLoadingPanel();
		}

		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(Box.createVerticalGlue());// 加入一段不可见的控件
		c.add(this.gameLoadingPanel);
		c.add(Box.createVerticalGlue());
		this.gameLoadingPanel.loadingGame();

		this.startGame();
	}

	public void setBackgroundImage() {
		JLabel bgLabel1 = new JLabel(new ImageIcon(Rescourse.bg1));
		this.getLayeredPane().add(bgLabel1, new Integer(Integer.MIN_VALUE));
		bgLabel1.setLocation(0, 0);
		bgLabel1.setSize(GAME_WIDTH, GAME_HEIGTH);
		((JPanel) this.getContentPane()).setOpaque(false);
	}

	private void addPlaneLabel() {
		planeLabel = new JLabel(new ImageIcon(Rescourse.hero1));
		planeLabel.setSize(Rescourse.hero1.getWidth(null),
				Rescourse.hero1.getHeight(null));
		planeLabel.setLocation(GAME_WIDTH / 2 - Rescourse.hero1.getWidth(null)
				/ 2, GAME_HEIGTH - Rescourse.hero1.getHeight(null) - 23);
		planeLabel.setOpaque(false);
		this.add(planeLabel);
	}

	private void startGame() {
		Container c = this.getContentPane();
		c.remove(gameLoadingPanel);
		addPlaneLabel();
		this.repaint();
		this.gamePlayingPanel = new GamePanel(this);
		c.setLayout(new BorderLayout());
		c.add(this.gamePlayingPanel, BorderLayout.CENTER);
		gamePlayingPanel.setFocusable(true);
		gamePlayingPanel.requestFocus();

		this.remove(planeLabel);
	}

}
