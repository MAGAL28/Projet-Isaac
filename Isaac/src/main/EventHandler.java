package main;

public class EventHandler {

	GamePanel gp;
	KeyHandler pressed;
	int eventRectDefaultX, eventRectDefaultY;
	EventRect eventRect[][];
	int previousEventX, previousEventY;
	boolean canTouchEvent = false;

	public EventHandler(GamePanel gp) {
		this.gp = gp;
		eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

		int col = 0;
		int row = 0;
		while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[col][row] = new EventRect();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 5;
			eventRect[col][row].height = 5;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
			col++;
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
			}
		}
	}

//Objects infligeants des dégâts / damage dealing items
	public void checkEvent() {

		// ckeck if the player character is more than 1 tile away from the last event
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if (distance > gp.tileSize) {
			canTouchEvent = true;
		}
		if (canTouchEvent == true) {

			if (hit(47, 4, "any") == true) {
				//System.out.println("collision");
				damagePit(47, 4, gp.gameState);
			}
			if (hit(37, 17, "any") == true) {
				System.out.println("collision");
				damagePit(36, 17, gp.gameState);
			}

			if (hit(1, 42, "any") == true) {
				
				damagePit(0, 42, gp.gameState);
			}
			if (hit(32, 32, "any") == true) {
				damagePit(31, 32, gp.gameState);
			}
			if (hit(22, 10, "any") == true) {
				damagePit(21, 10, gp.gameState);
			}
			if (hit(44, 23, "any") == true) {
				System.out.println("collision");
				damagePit(43, 23, gp.gameState);
			}
			if (hit(39, 1, "any") == true) {
				headingP(39, 1, gp.gameState);

			}
		}

	}

	public boolean hit(int col, int row, String reqDirection) {
		boolean hit = false;

		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
		eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

		if (gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
			if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
				hit = true;

				previousEventX = gp.player.worldX;
				previousEventY = gp.player.worldY;

			}
		}
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[col][row].x = eventRectDefaultX;
		eventRect[col][row].y = eventRectDefaultY;

		return hit;
	}

	public void damagePit(int col, int row, int gameState) {
		gp.gameState = gameState;
		gp.player.life = gp.player.life - 1;
		eventRect[col][row].eventDone = true;

		canTouchEvent = false;
	}

	public void headingP(int col, int row, int gameState) {
		if (gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.life = gp.player.maxLife;
		}
		gp.keyH.enterPressed = false;
	}

}
