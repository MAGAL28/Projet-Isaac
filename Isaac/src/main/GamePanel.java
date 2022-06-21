package main;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;

import entity.Player;

import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	// Screen SETTINGS
	final int originalTileSize = 13;
	final int scale = 5;

	public final int tileSize = originalTileSize * scale; //
	public final int maxScreenCol = 9;
	public final int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol; //
	public final int screenHeight = tileSize * maxScreenRow;//

	// WORLD SITTINGS
	public final int maxWorldCol = 67;
	public final int maxWorldRow = 50;
//	public final int worldWidth = tileSize * maxWorldCol;
//	public final int worldHeight = tileSize * maxWorldRow;

	// FPS
	int FPS = 40;

	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound se = new Sound();// SOUND Class
	Sound music = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;

	// ENTITY AND OBJECT
	public Player player = new Player(this, keyH);
	public Entity obj[] = new Entity[50];// Nombres d'objets qui peut etre augmenter
	public Entity npc[] = new Entity[10];
	public Entity monster[] = new Entity[100];
	ArrayList<Entity> entityList = new ArrayList<>();

	// Game STATE
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int titleState = 0;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonter();
		// playMusic(0);
		stopMusic();
		gameState = titleState;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();

	}

	// Methode 1
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS; // 0.016666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			
			// long currentTime = System.nanoTime();
			// System.out.println("current Time" + currentTime);

			// System.out.println("The game loop is running ");
			// 1 UPDATE: update information such as character position
			update();
			// 2 DRAW : draw the screen with the update information
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Methode 2
//	public void run() {
//		double drawInterval = 1000000000 / FPS;
//		double delta = 0;
//		long lastTime = System.nanoTime();
//		long currentTime;
//		long timer = 0;
//		int drawCount = 0;
//		while (gameThread != null) {
//			currentTime = System.nanoTime();
//			delta += (currentTime - lastTime) / drawInterval;
//			timer += (currentTime - lastTime);
//			lastTime = currentTime;
//
//			if (delta >= 1) {
//				update();
//				repaint();
//				delta--;
//				drawCount++;
//			}
//			if (timer >= 1000000000) {
//			//	System.out.println("FPS :" + drawCount);
//				drawCount = 0;
//				timer = 0;
//			}
//		}
//
//	}
	GamePanel gp;

	public void update() {
		if (gameState == playState) {
			// Player Isaaac
			player.update();
			// NPC
			for (int i = 0; i < npc.length; i++) {
				if (npc[i] != null) {
					npc[i].update();
				}
			}
			for (int i = 0; i < monster.length; i++) {
				if (monster[i] != null) {
					if (monster[i].alive == true && monster[i].dying == false) {
						monster[i].update();
					}
					if (monster[i].alive == false) {
						monster[i] = null;
					}
				}
			}

		}
		if (gameState == pauseState) {
			// nothing
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		// DEBUG
		long drawStart = 0;
		if (keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		// TITLE SCREEN #17
		if (gameState == titleState) {
			ui.draw(g2);
		}
		// OTHERS #17
		else {
			// TILE
			tileM.draw(g2);
			// ADD ANTITIES TO THE LIST
			entityList.add(player);
			for (int i = 0; i < npc.length; i++) {
				if (npc[i] != null) {
					entityList.add(npc[i]);
				}
			}
			// Objects
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] != null) {
					entityList.add(obj[i]);
				}
			}
			for (int i = 0; i < monster.length; i++) {
				if (monster[i] != null) {
					entityList.add(monster[i]);

				}
			}
			// sort
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					int result = Integer.compare(e1.worldY, e2.worldY);
					return result;
				}

			});
			// DRAW ENTITIES
			for (int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			// EMPRTY LIST
			entityList.clear();

			// UI
			ui.draw(g2);

		}

		if (keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("draw Time :" + passed, 5, 200);
			System.out.println("Draw Time " + passed);
		}

		g2.dispose();

	}

	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}

	public void stopMusic() {
		music.stop();
	}

	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}

}
