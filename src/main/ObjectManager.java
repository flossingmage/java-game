package src.main;

import src.objects.Coin;
import src.objects.Door;

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
    }

}
