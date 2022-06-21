package entity;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import java.util.Random;

import main.GamePanel;


public class NPC_OldMan extends Entity {

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		direction = "right";
		speed = 1;
		
		getImage();

	}
	public void getImage() {

		up1 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		up2 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		down1 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		down2 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		left1 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		left2 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		right1 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);
		right2 = setup("/npc/Cricket's_Head",gp.tileSize, gp.tileSize);

	}
	public void setAction() {
		actionLockCounter++;
		if (actionLockCounter == 20) {
			Random random = new Random();
			int i = random.nextInt(100) + 1;// pick up a numer from 1 to 100
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			actionLockCounter = 0;

		}
	}


}
