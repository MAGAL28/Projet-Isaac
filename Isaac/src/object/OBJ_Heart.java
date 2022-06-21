package object;



import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
	
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		name = "Heart";
		image = setup("/objects/HUD_heart_red_full",gp.tileSize, gp.tileSize);
		image2 = setup("/objects/HUD_heart_red_half",gp.tileSize, gp.tileSize);
		image3 = setup("/objects/HUD_heart_red_empty",gp.tileSize, gp.tileSize);
		

		
	}
}
