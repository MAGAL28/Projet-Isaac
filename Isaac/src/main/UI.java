package main;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//#10
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import entity.Entity;
import object.OBJ_Heart;


public class UI {
	GamePanel gp;
	Graphics g2;
	Font arial_20, arial_50B;
//	BufferedImage keyImage;
	BufferedImage heart_full, heart_half, heart_blank;;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameOver = false;
	public double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	public int commandNum = 0;

	public UI(GamePanel gp) {

		this.gp = gp;
		arial_20 = new Font("Arial", Font.PLAIN, 20);
		arial_50B = new Font("Arial", Font.PLAIN, 50);
//		OBJ_Key key = new OBJ_Key(gp);
//		keyImage = key.image;

		// Créate HUD OBJECT
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}

	public void draw(Graphics g2) {

		this.g2 = g2;
		g2.setFont(arial_20);
		g2.setColor(Color.white);
		// TITLE SATE #17
		if (gp.gameState == gp.titleState) {
			drawPlayerLife();
			drawTileScreen();
		}
		if (gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		if (gp.gameState == gp.pauseState) {

			drawPlayerLife();
			drawPauseScreen();

		}
	}

	public void drawPlayerLife() {
		int x = gp.tileSize / 2;
		int y = gp.tileSize / 2;
		int i = 0;
		// DRAW MAX HEART
		while (i < gp.player.maxLife / 2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
		x = gp.tileSize / 2;
		y = gp.tileSize / 2;
		i = 0;
		// DRAW CURRENT LIFE
		while (i < gp.player.life) {
			g2.drawImage(heart_half, x, y, null);
			i++;
			if (i < gp.player.life) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
	}
	// #17

	public void drawTileScreen() {
		g2.setColor(new Color(204, 51, 0));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

		// TITLE NAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
		String text = "BINDING OF ISAAC";
		int x = getXforCenteredText(text) - 90;
		int y = gp.tileSize;
		// SHADOW
		g2.setColor(Color.black);
		g2.drawString(text, x + 5, y + 5);
		// Main Color
		g2.setColor(Color.white);
		g2.drawString(text, x, y);

		// Isaac Image

		x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
		y += gp.tileSize;

		g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

		// Menu
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
		text = "NEW GAME";
		x = getXforCenteredText(text) - 190;
		y = gp.tileSize * 5;
		g2.drawString(text, x, y);
		if (commandNum == 0) {
			g2.drawString(">", x - gp.tileSize + 50, y);
		}

		text = "LOAD GAME";
		x = getXforCenteredText(text) - 185;
		y = (int) (gp.tileSize * 5.5);
		g2.drawString(text, x, y);
		if (commandNum == 1) {
			g2.drawString(">", x - gp.tileSize + 44, y);
		}

		text = "QUIT";
		x = getXforCenteredText(text) - 213;
		y = (int) (gp.tileSize * 6);
		g2.drawString(text, x, y);
		if (commandNum == 2) {
			g2.drawString(">", x - gp.tileSize + 50, y);
		}

	}

	public void drawPauseScreen() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
		String text = "PAUSE";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight / 2;

		g2.drawString(text, x, y);
	}

	public int getXforCenteredText(String text) {
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth - length - 50;
		return x;

	}
}
