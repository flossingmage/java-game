package src.main;

import src.objects.Coin;
import src.objects.Door;
import src.objects.Health_Potion;
import src.objects.Mana_Potion;
import src.objects.equipment.Chestplate;
import src.objects.equipment.Helmet;
import src.objects.equipment.Pants;
import src.objects.equipment.Sword;

public class ObjectManager {

    public GamePanel gamePanel;

    public ObjectManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void placeObject() {

        gamePanel.objects[0] = new Door();
        gamePanel.objects[0].WorldX = 13;
        gamePanel.objects[0].WorldY = 28;

        gamePanel.objects[2] = new Door();
        gamePanel.objects[2].WorldX = 16;
        gamePanel.objects[2].WorldY = 33;

        gamePanel.objects[3] = new Door();
        gamePanel.objects[3].WorldX = 15;
        gamePanel.objects[3].WorldY = 36;

        gamePanel.objects[4] = new Door();
        gamePanel.objects[4].WorldX = 20;
        gamePanel.objects[4].WorldY = 36;

        gamePanel.objects[5] = new Door();
        gamePanel.objects[5].WorldX = 20;
        gamePanel.objects[5].WorldY = 20;

        gamePanel.objects[6] = new Coin();
        gamePanel.objects[6].WorldX = 25;
        gamePanel.objects[6].WorldY = 22;

        gamePanel.objects[7] = new Health_Potion();
        gamePanel.objects[7].WorldX = 27;
        gamePanel.objects[7].WorldY = 22;

        gamePanel.objects[8] = new Sword();
        gamePanel.objects[8].WorldX = 25;
        gamePanel.objects[8].WorldY = 27;

        gamePanel.objects[9] = new Mana_Potion();
        gamePanel.objects[9].WorldX = 27;
        gamePanel.objects[9].WorldY = 27;

        gamePanel.objects[10] = new Helmet();
        gamePanel.objects[10].WorldX = 25;
        gamePanel.objects[10].WorldY = 32;

        gamePanel.objects[11] = new Chestplate();
        gamePanel.objects[11].WorldX = 27;
        gamePanel.objects[11].WorldY = 32;

        gamePanel.objects[12] = new Pants();
        gamePanel.objects[12].WorldX = 25;
        gamePanel.objects[12].WorldY = 37;
    }

}
