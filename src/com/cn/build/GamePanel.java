package com.cn.build;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.resources.Rescourse;
import com.mn.entities.Animation;
import com.mn.entities.Bullet;
import com.mn.entities.Enemy;
import com.mn.entities.Hero;
import com.mn.entities.Treasure;

public class GamePanel extends JPanel implements Runnable, KeyListener,
		ActionListener {
	private static final long serialVersionUID = 7834065031511566889L;

	private List<Bullet> bullets = new LinkedList<Bullet>();
	private List<Enemy> enemys = Collections.synchronizedList(new LinkedList<Enemy>());
	private static final Random rand = new Random();

	private long score;
	private long time;
	private int bombNumber;
	private boolean isTwoBullet;
	private boolean isRunning;
	private boolean isUp;

	private Hero hero;
	private Treasure treasure;
	private JPanel pausePanel;

	private JPanel startGamePanel;
	private GameDialog gameDialog;
	private GameButton pauseButton;

	public GamePanel(GameDialog gameDialog) {
		initComponents();
		initVariables(gameDialog);
		setPauseButton();
	}

	private void initComponents() {
		this.setDoubleBuffered(true);
		this.setOpaque(false);
		this.addKeyListener(this);
		this.setSize(GameDialog.GAME_WIDTH, GameDialog.GAME_HEIGTH);
		this.setVisible(true);
		this.setLayout(null);

	}

	private void initVariables(GameDialog gameDialog) {
		hero = new Hero(this, Rescourse.hero1);
		isTwoBullet = false;
		isRunning = true;
		isUp = false;
		bombNumber = 0;
		score = 0;
		time = 0;
		this.gameDialog = gameDialog;
		new Thread(this).start();
	}

	private void setPauseButton() {
		pauseButton = new GameButton();
		pauseButton.addActionListener(this);
		pauseButton.setActionCommand("pauseButton");
		pauseButton.setSize(Rescourse.pause1.getWidth(null),
				Rescourse.pause1.getHeight(null));
		pauseButton.setLocation(2, 2);
		pauseButton.setOpaque(false);
		this.add(pauseButton);
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (bombNumber != 0 && hero.isAlive()) {
			g.drawImage(Rescourse.bomb, 0, GameDialog.GAME_HEIGTH
					- Rescourse.bomb.getHeight(null) - 23,
					Rescourse.bomb.getWidth(null),
					Rescourse.bomb.getHeight(null), null);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 25));
			g2d.drawString("" + bombNumber, Rescourse.bomb.getWidth(null),
					GameDialog.GAME_HEIGTH - Rescourse.bomb.getHeight(null) + 5);
		}

		if (hero.isAlive())
			hero.draw(g);

		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			b.draw(g);
		}
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			e.draw(g);
		}

		if (treasure != null) {
			if (treasure.isAlive())
				treasure.draw(g);
		}

		if (hero.isAlive()) {
			g.setColor(Color.black);// 画出得分
			g.setFont(new Font("宋体", Font.BOLD, 25));
			g.drawString(score + "", Rescourse.pause1.getWidth(null) + 10, 23);
		}
	}

	private synchronized void setAnimation() {// 动画效果synchronized
		hero.setImage(hero.getImage() == Rescourse.hero2 ? Rescourse.hero1
				: Rescourse.hero2);
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			if (!e.isBomb()) {
				if (e.getImage() == Rescourse.enemy2Fly1
						|| e.getImage() == Rescourse.enemy2Fly2) {
					e.setImage(e.getImage() == Rescourse.enemy2Fly1 ? Rescourse.enemy2Fly2
							: Rescourse.enemy2Fly1);
				} else if (e.getImage() == Rescourse.enemy2Hit1) {
					e.setImage(Rescourse.enemy2Fly1);
				} else if (e.getImage() == Rescourse.enemy3Hit1) {
					e.setImage(Rescourse.enemy3Fly1);
				}
			}

		}
	}

	public void run() {
		while (isRunning) {
			setAnimation();
			setEnemyType();
			setTreasureType();

			onChangeTreasureLocation(treasure);

			for (int i = 0; i < bullets.size(); i++) {
				Bullet b = bullets.get(i);
				onChangeBulletLocation(b);
			}
			for (int i = 0; i < enemys.size(); i++) {
				Enemy e = enemys.get(i);
				onChangeEnemyLocation(e);
			}

			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			time++;
		}
	}

	private void setEnemyType() {

		if (hero.isAlive()) {
			if ((time + 1) % 700 == 0) {
				enemys.add(new Enemy(this, rand.nextInt(GameDialog.GAME_WIDTH
						- Rescourse.enemy2Fly1.getWidth(null)),
						Rescourse.enemy2Fly1));

			} else if (time % 10 == 0) {
				int a = rand.nextInt(13);
				if (a == 0)
					enemys.add(new Enemy(this, rand
							.nextInt(GameDialog.GAME_WIDTH
									- Rescourse.enemy3Fly1.getWidth(null)),
							Rescourse.enemy3Fly1));
				else if (1 <= a && 7 >= a)
					enemys.add(new Enemy(this, rand
							.nextInt(GameDialog.GAME_WIDTH
									- Rescourse.enemy1Fly1.getWidth(null)),
							Rescourse.enemy1Fly1));
				else
					;
			}
		}
	}

	private void setTreasureType() {
		if (hero.isAlive()) {
			if ((time+1) % 900 == 0) {
				isUp = false;
				if (rand.nextInt(2) == 0)
					treasure = new Treasure(rand.nextInt(GameDialog.GAME_WIDTH
							- Rescourse.enemy4Fly1.getWidth(null)),
							Rescourse.enemy4Fly1);
				else
					treasure = new Treasure(rand.nextInt(GameDialog.GAME_WIDTH
							- Rescourse.enemy5Fly1.getWidth(null)),
							Rescourse.enemy5Fly1);
			}
		}

	}

	private void onChangeTreasureLocation(Treasure t) {// 宝物的位置
		if (t != null) {
			if (t.isDown()) {
				if (t.getY() < GameDialog.GAME_HEIGTH / 3 || isUp) {
					t.setY(t.getY() + t.getSpeed());
				} else
					t.setDown(false);
			} else {
				if (t.getY() >= -t.getImage().getHeight(null))
					t.setY(t.getY() - t.getSpeed());
				else {
					t.setDown(true);
					isUp = true;
					t.setSpeed(4);
				}
			}

			if (t.collision(hero) && t.isAlive()) {
				if (t.getImage() == Rescourse.enemy4Fly1) {
					bombNumber += 1;
				} else {
					isTwoBullet = true;
				}
				t.setAlive(false);
			}
		}
	}

	private void onChangeBulletLocation(Bullet b) {// 子弹的位置
		if (b != null) {
			b.setY(b.getY() - b.getSpeed());
			if (b.getY() <= 20) {
				this.bullets.remove(b);
			}
			Enemy e = b.hitEnemys();
			if (e != null) {
				if (e.getStrength() <= 0) {
					if (e.getImage() == Rescourse.enemy1Fly1) {
						score += 1000;
					} else if (e.getImage() == Rescourse.enemy2Fly1
							|| e.getImage() == Rescourse.enemy2Fly2
							|| e.getImage() == Rescourse.enemy2Hit1) {// boss炸的话，周围全炸
						for (int i = 0; i < enemys.size(); i++) {
							Enemy ep = enemys.get(i);
							if (e.collision(ep)) {
								if (ep.getImage() == Rescourse.enemy1Fly1) {// 不加自己
									score += 1000;
								} else {
									score += 5000;
								}
								new Animation(this, enemys, ep);
							}
						}
						score += 30000;
					} else {
						score += 5000;
					}
					new Animation(this, enemys, e);
				}
				this.bullets.remove(b);
			}

		}
	}

	private void onChangeEnemyLocation(Enemy e) {
		if (e != null) {
			e.setY(e.getY() + e.getSpeed());
			if (e.getY() > GameDialog.GAME_HEIGTH) {
				enemys.remove(e);
			}
			if (e.collision(hero)) {
				new Animation(this, hero);
			}
		}
	}

	public void getBullets(Bullet b) {
		bullets.add(b);
	}

	public List<Enemy> returnEnemys() {
		return enemys;
	}

	public void keyPressed(KeyEvent e) {
		if (!isRunning)
			return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			hero.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			hero.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			hero.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			hero.moveRight();
			break;
		case KeyEvent.VK_ENTER:// 暂停
			addPauseGamePanel();
			break;
		case KeyEvent.VK_SHIFT:// 爆炸
			pushBomb();
			break;
		}
	}

	private synchronized void pushBomb() {
		if (bombNumber != 0) {
			for (int i = 0; i < enemys.size(); i++) {
				Enemy e = enemys.get(i);
				if (e.getImage() == Rescourse.enemy1Fly1) {
					score += 1000;
				} else if (e.getImage() == Rescourse.enemy2Fly1
						|| e.getImage() == Rescourse.enemy2Fly2
						|| e.getImage() == Rescourse.enemy2Hit1) {
					score += 30000;
				} else {
					score += 5000;
				}
				new Animation(this, enemys, e);
			}
			bombNumber--;
		}
	}

	private void addPauseGamePanel() {
		isRunning = false;
		pausePanel = new PausePanel(this);
		this.add(pausePanel);
	}

	private void setLoadingPanel() {
		this.remove(pauseButton);

		JLabel loadingLabel = new JLabel();

		loadingLabel.setLocation(this.getWidth() / 4, this.getHeight() / 4);
		loadingLabel.setSize(this.getWidth() / 2, this.getHeight() / 4);
		loadingLabel.setOpaque(false);

		this.add(loadingLabel);

		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			e.setSpeed(8);
		}
		
		if(treasure!=null){
			if(treasure.isAlive())
				treasure.setSpeed(8);
		}

		int mark = 0;
		while (!enemys.isEmpty()) {
			if (mark % 3 == 0)
				loadingLabel.setIcon(new ImageIcon(Rescourse.gameLoading1));
			else if (mark % 3 == 1)
				loadingLabel.setIcon(new ImageIcon(Rescourse.gameLoading2));
			else if (mark % 3 == 2)
				loadingLabel.setIcon(new ImageIcon(Rescourse.gameLoading3));
			mark++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.remove(loadingLabel);
	}

	public void addStartGamePanel() {
		setLoadingPanel();
		startGamePanel = new StartGamePanel(this);
		this.add(startGamePanel);
	}

	private void continueGame() {
		isRunning = true;
		new Thread(this).start();
		this.remove(pausePanel);
	}

	private void restartGame() {
		gameDialog.loadGame();
	}

	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		if (actionCmd.equals("继续")) {
			continueGame();
		} else if (actionCmd.equals("重新开始")) {
			restartGame();
		} else if (actionCmd.equals("pauseButton")) {
			if (isRunning)
				addPauseGamePanel();
		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public boolean isTwoBullet() {
		return isTwoBullet;
	}

	public void setTwoBullet(boolean isTwoBullet) {
		this.isTwoBullet = isTwoBullet;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
