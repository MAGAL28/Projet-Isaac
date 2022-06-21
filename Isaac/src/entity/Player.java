package entity;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

//	GamePanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	int standCounter = 0;

	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
//		this.gp = gp;
		this.keyH = keyH;
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

		// solidArea = new Rectangle(0,0,gp.tileSize,48);
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 32;
		solidArea.width = 32;

		attactArea.width = 36;
		attactArea.height = 36;

		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
	}

	public void setDefaultValues() {
//		worldX = gp.tileSize * 8;
//		worldY = gp.tileSize * 6;
		worldX = (int) (gp.tileSize * 40.5);
		worldY = (int) (gp.tileSize * 4.5);
		speed = 4.0;
		direction = "down";

		// PLAYER STATUS
		maxLife = 6;
		life = maxLife;
		pieces = 15.0;

	}

	public void getPlayerImage() {

		up1 = setup("/player/downR", gp.tileSize, gp.tileSize);
		up2 = setup("/player/downL", gp.tileSize, gp.tileSize);
		down1 = setup("/player/Isaac_up1", gp.tileSize, gp.tileSize);
		down2 = setup("/player/Isaac_up2", gp.tileSize, gp.tileSize);
		left1 = setup("/player/Isaac_left", gp.tileSize, gp.tileSize);
		left2 = setup("/player/Isaac_left2", gp.tileSize, gp.tileSize);
		right1 = setup("/player/Isaac_right", gp.tileSize, gp.tileSize);
		right2 = setup("/player/Isaac_right2", gp.tileSize, gp.tileSize);

	}

	public void getPlayerAttackImage() {
		attactUp1 = setup("/player/attackUp", gp.tileSize, gp.tileSize * 2);
		attactUp2 = setup("/player/attackUp", gp.tileSize, gp.tileSize * 2);
		attactDown1 = setup("/player/attackDown1", gp.tileSize, gp.tileSize * 2);
		attactDown2 = setup("/player/attackDown2", gp.tileSize, gp.tileSize * 2);
		attactLeft1 = setup("/player/attackLeft", gp.tileSize * 2, gp.tileSize);
		attactLeft2 = setup("/player/attackLeft", gp.tileSize * 2, gp.tileSize);
		attactRight1 = setup("/player/attackRight", gp.tileSize * 2, gp.tileSize);
		attactRight2 = setup("/player/attackRight", gp.tileSize * 2, gp.tileSize);
	}

	public void update() {
		if (attacking == true) {
			attacking();
		} else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true || keyH.enterPressed == true) {

			if (keyH.upPressed == true) {
				direction = "up";
				if (collisionOn == false) {
					worldY -= speed;

				}

			}
			if (keyH.downPressed == true) {
				direction = "down";
				if (collisionOn == false) {
					worldY += speed;
				}

			}
			if (keyH.leftPressed == true) {
				direction = "left";
				if (collisionOn == false) {
					worldX -= speed;
				}

			}
			if (keyH.rightPressed == true) {
				direction = "right";
				if (collisionOn == false) {
					worldX += speed;
				}

			}
			// gp.keyH.enterPressed = false;

			collisionOn = false;
			gp.cChecker.checkTile(this);

			// CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			// Check NPC collision
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);

			// CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);

			// CHECK EVENT

			gp.eHandler.checkEvent();

			// If Collision False; Player can move

			// checkColTile();
			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		} else {
			standCounter++;
			if (standCounter == 20)
				spriteNum = 1;
			standCounter = 0;
		}
		// Outside of key if statement
		if (invincible == true) {
			invincibleCounter++;
			if (invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}

	}

	public void pickUpObject(int i) {
		if (i != 999) {// gp.obj[i] = null;
			String objectName = gp.obj[i].name;
			switch (objectName) {
			case "Key":
				if (gp.player.pieces >= gp.obj[i].prixObject) {
					gp.player.pieces = gp.player.pieces - gp.obj[i].prixObject;
					gp.obj[i] = null;

				}
				break;
			case "HUD_heart_red_half":
				if (gp.player.pieces >= gp.obj[i].prixObject && gp.player.life < gp.player.maxLife) {
					gp.player.pieces = gp.player.pieces - gp.obj[i].prixObject;
					gp.player.life = (int) (gp.player.life + gp.obj[i].prixObject);
					gp.obj[i] = null;

				}
				break;
			case "HUD_heart_red_full":
				if (gp.player.pieces >= gp.obj[i].prixObject && gp.player.life < gp.player.maxLife) {
					gp.player.pieces = gp.player.pieces - gp.obj[i].prixObject;
					gp.player.life = (int) (gp.player.life + gp.obj[i].prixObject);
					gp.obj[i] = null;
					
				}
				break;
			case "Spikes":
				if (gp.player.pieces >= gp.obj[i].prixObject) {
					gp.player.pieces = gp.player.pieces - gp.obj[i].prixObject;
					gp.obj[i] = null;

				}
				break;

			}

		}

	}

	public void interactNPC(int i) {
		if(gp.keyH.enterPressed == true) {
			if(i != 999) {
		
			}else {
				gp.playSE(11);
				attacking = true;
			}
		}

	}

	public void attacking() {
		spriteCounter++;

		if (spriteCounter <= 5) {
			spriteNum = 1;
		}
		if (spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
			// Save the current worldX, worldY, solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;

			// Adjust player's worldX/Y for the attactArea
			switch (direction) {
			case "up":
				worldY -= attactArea.height;
				break;
			case "down":
				worldY = attactArea.height;
				break;
			case "left":
				worldX -= attactArea.width;
				break;
			case "right":
				worldX += attactArea.width;
				break;

			}
			// attactArea become solidArea;
			solidArea.width = attactArea.width;
			solidArea.height = attactArea.height;
			// Check monster collision with the updated worldX/Y and solidArea
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			damageMonster(monsterIndex);

			// After checking collsion, resotre the original data
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;

		}
		if (spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}

	}

	public void contactMonster(int i) {
		if (i != 999) {
			if (invincible != true) {
				gp.playSE(10);
				life -= 1;
				invincible = true;
			}

		}
	}

	public void damageMonster(int i) {
		if (i != 999) {
			if (gp.monster[i].invincible == false) {
				gp.playSE(2);
				gp.monster[i].life -= 1;
				gp.monster[i].invincible = true;
				gp.monster[i].damageReaction();
				if (gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
				}
			}
		}
	}

	public void draw(Graphics g2) {

		BufferedImage image = null;
		int tempsScreenX = screenX;
		int tempsScreenY = screenY;
		switch (direction) {
		case "up":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = up1;
				}
				if (spriteNum == 2) {
					image = up2;
				}
			}
			if (attacking == true) {
				tempsScreenY = screenY - gp.tileSize;
				if (spriteNum == 1) {
					image = attactUp1;
				}
				if (spriteNum == 2) {
					image = attactUp2;
				}
			}
			break;
		case "down":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = down1;
				}
				if (spriteNum == 2) {
					image = down2;
				}
			}
			if (attacking == true) {
				if (spriteNum == 1) {
					image = attactDown1;
				}
				if (spriteNum == 2) {
					image = attactDown2;
				}
			}
			break;
		case "left":
			if (attacking == false) {
				tempsScreenX = screenX - gp.tileSize;
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
			}
			if (attacking == true) {
				if (spriteNum == 1) {
					image = attactLeft1;
				}
				if (spriteNum == 2) {
					image = attactLeft2;
				}
			}
			break;
		case "right":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
			}
			if (attacking == true) {
				if (spriteNum == 1) {
					image = attactRight1;
				}
				if (spriteNum == 2) {
					image = attactRight2;
				}
			}
			break;
		}

		g2.drawImage(image, tempsScreenX, tempsScreenY, null);



	}

}


