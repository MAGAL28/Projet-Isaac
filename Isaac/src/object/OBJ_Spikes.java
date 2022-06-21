package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Spikes extends Entity {

	public OBJ_Spikes(GamePanel gp) {
		super(gp);
		name = "Spikes";
		down1 = setup("/objects/Spikes", gp.tileSize, gp.tileSize);
	}

}
