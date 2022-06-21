package object;



import entity.Entity;
import main.GamePanel;

public class OBJ_Red_Heart extends Entity {


	public OBJ_Red_Heart(GamePanel gp) {
		super(gp);
		name = "Red_Heart";
		down1 = setup("/objects/Red_Heart",gp.tileSize, gp.tileSize);

	}

}
