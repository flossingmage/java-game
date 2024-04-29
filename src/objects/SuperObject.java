package src.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import src.main.GamePanel;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public int WorldX, WorldY;
    public boolean collisionOn = false;

    public void draw(Graphics2D g2d, GamePanel gamePanel) {
        g2d.drawImage(image, WorldX * gamePanel.tileSize - gamePanel.player.worldX + gamePanel.player.screenX,
                WorldY * gamePanel.tileSize - gamePanel.player.worldY + gamePanel.player.screenY, gamePanel.tileSize,
                gamePanel.tileSize,
                null);
    }

    public void interact() {
        System.out.println("interact");
    }

}
