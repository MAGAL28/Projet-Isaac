package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Full_Red_Heart extends Entity {
	
	public OBJ_Full_Red_Heart(GamePanel gp) {
		super(gp);
		name = "HUD_heart_red_full";
		prixObject = 2.0;
		down1 = setup("/objects/HUD_heart_red_full", gp.tileSize, gp.tileSize);
		collision = true;
	}
}
