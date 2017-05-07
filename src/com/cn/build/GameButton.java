package com.cn.build;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.cn.resources.Rescourse;

public class GameButton extends JButton implements ImageObserver, MouseListener {

	private static final long serialVersionUID = 1L;
	private String text;
	private final String BUTTON_HOVER = "BUTTON_HOVER";
	private final String BUTTON_NORMAL = "BUTTON_NORMAL";
	private final String BUTTON_PAUSE = "BUTTON_PAUSE";
	private final String BUTTON_PAUSE_HL = "BUTTON_PAUSE_HL";
	private String buttonStatus;

	public GameButton() {
		super();
		this.text = "";
		initButton();
	}

	public GameButton(String text) {
		super();
		this.text = text;
		initButton();
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	private void initButton() {
		if (!text.equals(""))
			this.buttonStatus = BUTTON_NORMAL;
		else
			this.buttonStatus = BUTTON_PAUSE;
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.addMouseListener(this);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		try {
			// this.buttonSoundPlayer = new
			// SoundPlayer(Config.BUTTON_ACTION_AUDIO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image buttonBgImg = null;
		if (this.buttonStatus.equals(BUTTON_NORMAL)) {
			buttonBgImg = new ImageIcon(Rescourse.buttonBg).getImage();//
		} else if (this.buttonStatus.equals(BUTTON_HOVER)) {
			buttonBgImg = new ImageIcon(Rescourse.buttonHoverBg).getImage();
		} else if (this.buttonStatus.equals(BUTTON_PAUSE)) {
			buttonBgImg = new ImageIcon(Rescourse.pause1).getImage();
		} else if (this.buttonStatus.equals(BUTTON_PAUSE_HL)) {
			buttonBgImg = new ImageIcon(Rescourse.pause2).getImage();
		}
		int buttonWidth = buttonBgImg.getWidth(this);
		int buttonHeight = buttonBgImg.getHeight(this);

		this.setSize(buttonWidth, buttonHeight);
		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

		 
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(buttonBgImg, 0, 0, buttonWidth, buttonHeight, this);
			FontMetrics metric = g.getFontMetrics();
			Rectangle2D rect = metric.getStringBounds(text, g);
			if (!text.equals("")){
			g2d.drawString(text,
					(float) (buttonWidth / 2 - rect.getWidth() / 2),
					(float) ((buttonHeight / 2) + ((metric.getAscent() + metric
							.getDescent()) / 2 - metric.getDescent())));
		}

	}

	private void buttonHover() {
		if (this.buttonStatus.equals(BUTTON_NORMAL))
			this.buttonStatus = BUTTON_HOVER;
		else if (this.buttonStatus.equals(BUTTON_PAUSE))
			this.buttonStatus = BUTTON_PAUSE_HL;
	}

	private void buttonNormal() {
		if (this.buttonStatus.equals(BUTTON_HOVER))
			this.buttonStatus = BUTTON_NORMAL;
		else if (this.buttonStatus.equals(BUTTON_PAUSE_HL))
			this.buttonStatus = BUTTON_PAUSE;
	}

	public void mouseClicked(MouseEvent e) {
		buttonHover();
	}

	public void mousePressed(MouseEvent e) {
		buttonHover();
	}

	public void mouseReleased(MouseEvent e) {
		buttonNormal();
	}

	public void mouseEntered(MouseEvent e) {
		buttonHover();
		// this.buttonSoundPlayer.play();
	}

	public void mouseExited(MouseEvent e) {
		buttonNormal();
	}

}
