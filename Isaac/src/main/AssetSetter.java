package main;
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA
//SECK SERIGNE ~ IBRAHIM KALILOU SIMPARA

import entity.NPC_OldMan;
import monster.Monster_Fly;
import monster.Monster_Spider;
import object.OBJ_Half_Red_Heart;
import object.OBJ_Key;


public class AssetSetter {
	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		gp.obj[0] = new OBJ_Key(gp);
		gp.obj[0].worldX = gp.tileSize * 34;
		gp.obj[0].worldY = gp.tileSize * 3;
		
		gp.obj[1] = new OBJ_Half_Red_Heart(gp);
		gp.obj[1].worldX = gp.tileSize * 33;
		gp.obj[1].worldY = gp.tileSize * 1;
		
		gp.obj[2] = new OBJ_Half_Red_Heart(gp);
		gp.obj[2].worldX = gp.tileSize * 21;
		gp.obj[2].worldY = gp.tileSize * 22;
		
		gp.obj[3] = new OBJ_Half_Red_Heart(gp);
		gp.obj[3].worldX = gp.tileSize * 31;
		gp.obj[3].worldY = gp.tileSize * 4;
		
		gp.obj[4] = new OBJ_Half_Red_Heart(gp);
		gp.obj[4].worldX = gp.tileSize * 11;
		gp.obj[4].worldY = gp.tileSize * 4;
		
		gp.obj[5] = new OBJ_Half_Red_Heart(gp);
		gp.obj[5].worldX = gp.tileSize * 32;
		gp.obj[5].worldY = gp.tileSize * 10;
		
		
		
		
		


	}

	public void setNPC() {

		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize * 44;
		gp.npc[0].worldY = gp.tileSize * 3;

		gp.npc[1] = new NPC_OldMan(gp);
		gp.npc[1].worldX = gp.tileSize * 11;
		gp.npc[1].worldY = gp.tileSize * 21;
		
		gp.npc[2] = new NPC_OldMan(gp);
		gp.npc[2].worldX = gp.tileSize * 31;
		gp.npc[2].worldY = gp.tileSize * 21;
		
		
		gp.npc[3] = new NPC_OldMan(gp);
		gp.npc[3].worldX = gp.tileSize * 21;
		gp.npc[3].worldY = gp.tileSize * 21;

	}

	public void setMonter() {
		//Spider
		gp.monster[0] = new Monster_Spider(gp);
		gp.monster[0].worldX = gp.tileSize * 13;
		gp.monster[0].worldY = gp.tileSize * 21;
		
		gp.monster[3] = new Monster_Spider(gp);
		gp.monster[3].worldX = gp.tileSize * 43;
		gp.monster[3].worldY = gp.tileSize * 4;
		
		gp.monster[3] = new Monster_Spider(gp);
		gp.monster[3].worldX = gp.tileSize * 4;
		gp.monster[3].worldY = gp.tileSize * 40;
		
		gp.monster[4] = new Monster_Spider(gp);
		gp.monster[4].worldX = gp.tileSize * 13;
		gp.monster[4].worldY = gp.tileSize * 21;
		
		gp.monster[5] = new Monster_Spider(gp);
		gp.monster[5].worldX = gp.tileSize * 30;
		gp.monster[5].worldY = gp.tileSize * 24;
		
		gp.monster[6] = new Monster_Spider(gp);
		gp.monster[6].worldX = gp.tileSize * 10;
		gp.monster[6].worldY = gp.tileSize * 24;
		
		gp.monster[7] = new Monster_Spider(gp);
		gp.monster[7].worldX = gp.tileSize * 30;
		gp.monster[7].worldY = gp.tileSize * 26;
		
		
		gp.monster[8] = new Monster_Spider(gp);
		gp.monster[8].worldX = gp.tileSize * 46;
		gp.monster[8].worldY = gp.tileSize * 4;
		
		
		gp.monster[9] = new Monster_Spider(gp);
		gp.monster[9].worldX = gp.tileSize * 50;
		gp.monster[9].worldY = gp.tileSize * 5;
		
		gp.monster[10] = new Monster_Spider(gp);
		gp.monster[10].worldX = gp.tileSize * 20;
		gp.monster[10].worldY = gp.tileSize * 41;
		
		
		gp.monster[11] = new Monster_Spider(gp);
		gp.monster[11].worldX = gp.tileSize * 20;
		gp.monster[11].worldY = gp.tileSize * 42;
		
		gp.monster[12] = new Monster_Spider(gp);
		gp.monster[12].worldX = gp.tileSize * 10;
		gp.monster[12].worldY = gp.tileSize * 44;
		
		gp.monster[13] = new Monster_Spider(gp);
		gp.monster[13].worldX = gp.tileSize * 12;
		gp.monster[13].worldY = gp.tileSize * 34;
		
		gp.monster[14] = new Monster_Spider(gp);
		gp.monster[14].worldX = gp.tileSize * 63;
		gp.monster[14].worldY = gp.tileSize * 39;
		
		gp.monster[15] = new Monster_Spider(gp);
		gp.monster[15].worldX = gp.tileSize * 59;
		gp.monster[15].worldY = gp.tileSize * 44;
		
		gp.monster[16] = new Monster_Spider(gp);
		gp.monster[16].worldX = gp.tileSize * 59;
		gp.monster[16].worldY = gp.tileSize * 39;
		
		gp.monster[17] = new Monster_Spider(gp);
		gp.monster[17].worldX = gp.tileSize * 55;
		gp.monster[17].worldY = gp.tileSize * 40;
		
		
		gp.monster[18] = new Monster_Spider(gp);
		gp.monster[18].worldX = gp.tileSize * 50;
		gp.monster[18].worldY = gp.tileSize * 38;
		
		gp.monster[19] = new Monster_Spider(gp);
		gp.monster[19].worldX = gp.tileSize * 30;
		gp.monster[19].worldY = gp.tileSize * 32;
		
		gp.monster[20] = new Monster_Spider(gp);
		gp.monster[20].worldX = gp.tileSize * 20;
		gp.monster[20].worldY = gp.tileSize * 34;
		
		gp.monster[21] = new Monster_Spider(gp);
		gp.monster[21].worldX = gp.tileSize * 22;
		gp.monster[21].worldY = gp.tileSize * 32;
		
		gp.monster[23] = new Monster_Spider(gp);
		gp.monster[23].worldX = gp.tileSize * 23;
		gp.monster[23].worldY = gp.tileSize * 33;
		
		gp.monster[24] = new Monster_Spider(gp);
		gp.monster[24].worldX = gp.tileSize * 64;
		gp.monster[24].worldY = gp.tileSize * 4;
		
		gp.monster[25] = new Monster_Spider(gp);
		gp.monster[25].worldX = gp.tileSize * 47;
		gp.monster[25].worldY = gp.tileSize * 4;
		
		gp.monster[26] = new Monster_Spider(gp);
		gp.monster[26].worldX = gp.tileSize * 45;
		gp.monster[26].worldY = gp.tileSize * 22;
		
		gp.monster[27] = new Monster_Spider(gp);
		gp.monster[27].worldX = gp.tileSize * 4;
		gp.monster[27].worldY = gp.tileSize * 22;
		
		gp.monster[28] = new Monster_Spider(gp);
		gp.monster[28].worldX = gp.tileSize * 4;
		gp.monster[28].worldY = gp.tileSize * 24;
		
		gp.monster[29] = new Monster_Spider(gp);
		gp.monster[29].worldX = gp.tileSize * 14;
		gp.monster[29].worldY = gp.tileSize * 22;
		
		gp.monster[30] = new Monster_Spider(gp);
		gp.monster[30].worldX = gp.tileSize * 9;
		gp.monster[30].worldY = gp.tileSize * 21;
		
		gp.monster[31] = new Monster_Spider(gp);
		gp.monster[31].worldX = gp.tileSize * 14;
		gp.monster[31].worldY = gp.tileSize * 16;
		
		gp.monster[32] = new Monster_Spider(gp);
		gp.monster[32].worldX = gp.tileSize * 4;
		gp.monster[32].worldY = gp.tileSize * 14;
		
		gp.monster[33] = new Monster_Spider(gp);
		gp.monster[33].worldX = gp.tileSize * 8;
		gp.monster[33].worldY = gp.tileSize * 14;
		
		gp.monster[34] = new Monster_Spider(gp);
		gp.monster[34].worldX = gp.tileSize * 18;
		gp.monster[34].worldY = gp.tileSize * 14;
		
		
		gp.monster[35] = new Monster_Spider(gp);
		gp.monster[35].worldX = gp.tileSize * 28;
		gp.monster[35].worldY = gp.tileSize * 13;
		
		
		gp.monster[36] = new Monster_Spider(gp);
		gp.monster[36].worldX = gp.tileSize * 48;
		gp.monster[36].worldY = gp.tileSize * 14;
		
		
		
		
		
		
		
		
		gp.monster[2] = new Monster_Fly(gp);
		gp.monster[2].worldX = gp.tileSize * 46;
		gp.monster[2].worldY = gp.tileSize * 5;
		
		gp.monster[2] = new Monster_Fly(gp);
		gp.monster[2].worldX = gp.tileSize * 23;
		gp.monster[2].worldY = gp.tileSize * 13;
		
		gp.monster[37] = new Monster_Fly(gp);
		gp.monster[37].worldX = gp.tileSize * 23;
		gp.monster[37].worldY = gp.tileSize * 19;
		
		gp.monster[38] = new Monster_Fly(gp);
		gp.monster[38].worldX = gp.tileSize * 9;
		gp.monster[38].worldY = gp.tileSize * 23;
		
		gp.monster[39] = new Monster_Fly(gp);
		gp.monster[39].worldX = gp.tileSize * 14;
		gp.monster[39].worldY = gp.tileSize * 18;
		
		gp.monster[40] = new Monster_Fly(gp);
		gp.monster[40].worldX = gp.tileSize * 4;
		gp.monster[40].worldY = gp.tileSize * 17;
		
		gp.monster[41] = new Monster_Fly(gp);
		gp.monster[41].worldX = gp.tileSize * 8;
		gp.monster[41].worldY = gp.tileSize * 16;
		
		gp.monster[42] = new Monster_Fly(gp);
		gp.monster[42].worldX = gp.tileSize * 18;
		gp.monster[42].worldY = gp.tileSize * 15;
		
		
		gp.monster[43] = new Monster_Fly(gp);
		gp.monster[43].worldX = gp.tileSize * 28;
		gp.monster[43].worldY = gp.tileSize * 11;
		
		
		gp.monster[44] = new Monster_Fly(gp);
		gp.monster[44].worldX = gp.tileSize * 47;
		gp.monster[44].worldY = gp.tileSize * 10;
		
		
		gp.monster[45] = new Monster_Fly(gp);
		gp.monster[45].worldX = gp.tileSize * 48;
		gp.monster[45].worldY = gp.tileSize * 6;
		
		gp.monster[46] = new Monster_Fly(gp);
		gp.monster[46].worldX = gp.tileSize * 7;
		gp.monster[46].worldY = gp.tileSize * 40;
		
		gp.monster[47] = new Monster_Fly(gp);
		gp.monster[47].worldX = gp.tileSize * 16;
		gp.monster[47].worldY = gp.tileSize * 21;
		
		gp.monster[48] = new Monster_Fly(gp);
		gp.monster[48].worldX = gp.tileSize * 33;
		gp.monster[48].worldY = gp.tileSize * 24;
		
		gp.monster[49] = new Monster_Fly(gp);
		gp.monster[49].worldX = gp.tileSize * 12;
		gp.monster[49].worldY = gp.tileSize * 24;
		
		gp.monster[50] = new Monster_Fly(gp);
		gp.monster[50].worldX = gp.tileSize * 32;
		gp.monster[50].worldY = gp.tileSize * 26;
		
		
		gp.monster[51] = new Monster_Fly(gp);
		gp.monster[51].worldX = gp.tileSize * 48;
		gp.monster[51].worldY = gp.tileSize * 3;
		
	
	}
}


