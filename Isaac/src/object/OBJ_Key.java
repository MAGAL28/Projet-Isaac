package object;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {

	public OBJ_Key(GamePanel gp) {
		super(gp);

		name = "Key";
		prixObject = 3.0;
		down1 = setup("/objects/Key",gp.tileSize, gp.tileSize);
		collision = true;

	}
}
