package src.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int Health;
    public int worldX, worldY;
    public int speed;

    // movement animation
    public BufferedImage up, up1, up2, up3, up4, down, down1, down2, down3, down4, left, left1, left2, left3, left4,
            right, right1, right2, right3, right4;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    // hitbox
    public Rectangle soidArea;
    public boolean collisionOn = false;
}
