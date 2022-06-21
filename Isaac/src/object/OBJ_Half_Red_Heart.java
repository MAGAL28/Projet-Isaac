package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Half_Red_Heart extends Entity {

	public OBJ_Half_Red_Heart(GamePanel gp) {
		super(gp);
		name = "HUD_heart_red_half";
		prixObject = 1.0;
		down1 = setup("/objects/HUD_heart_red_half", gp.tileSize, gp.tileSize);
		collision = true;
	}
}
