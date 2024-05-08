package src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import src.main.GamePanel;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public int WorldX, WorldY;
    public boolean collisionOn = false;
    public boolean interactable = false;

    public void draw(Graphics2D g2d, GamePanel gamePanel) {
        g2d.drawImage(image, WorldX * gamePanel.tileSize - gamePanel.player.worldX + gamePanel.player.screenX,
                WorldY * gamePanel.tileSize - gamePanel.player.worldY + gamePanel.player.screenY, gamePanel.tileSize,
                gamePanel.tileSize,
                null);
    }

    public void interact() {
        System.out.println("interact");
    }

    public SuperObject interactable(int playerX, int playerY, String direction, Rectangle soidArea, int tileSize) {
        if (!interactable)
            return null;
        int left = (playerX + soidArea.x) / tileSize;
        int right = (playerX + soidArea.x + soidArea.width) / tileSize;
        int top = (playerY + soidArea.y) / tileSize;
        int bottom = (playerY + soidArea.y + soidArea.height) / tileSize;
        switch (direction) {
            case "up":
                if ((left == WorldX || right == WorldX) && (top - 1 == WorldY))
                    return this;
                break;
            case "down":
                if ((left == WorldX || right == WorldX) && (bottom + 1 == WorldY))
                    return this;
                break;

            case "left":
                if (left - 1 == WorldX && (top == WorldY || bottom == WorldY))
                    return this;
                break;

            case "right":
                if (right + 1 == WorldX && (top == WorldY || bottom == WorldY))
                    return this;
                break;
        }
        return null;
    }

    public SuperObject isOnPlayer(int playerX, int playerY, Rectangle soidArea, int tileSize) {
        int left = (playerX + soidArea.x) / tileSize;
        int right = (playerX + soidArea.x + soidArea.width) / tileSize;
        int top = (playerY + soidArea.y) / tileSize;
        int bottom = (playerY + soidArea.y + soidArea.height) / tileSize;
        if ((left == WorldX || right == WorldX) && (top == WorldY || bottom == WorldY))
            return this;

        return null;
    }

    public void remove() {
        WorldX = -1;
        WorldY = -1;

    }

}
