package src.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import src.main.*;
import src.objects.PickUp;
import src.objects.SuperObject;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public static int NumOfCoins = 0;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        soidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        Health = 3;
        worldX = 25 * gamePanel.tileSize;
        worldY = 25 * gamePanel.tileSize;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("../../res/player/up1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/up2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/up3.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("../../res/player/up4.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("../../res/player/up5.png"));
            down = ImageIO.read(getClass().getResourceAsStream("../../res/player/down1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/down2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/down3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("../../res/player/down4.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("../../res/player/down5.png"));
            left = ImageIO.read(getClass().getResourceAsStream("../../res/player/left1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/left2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/left3.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("../../res/player/left4.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("../../res/player/left5.png"));
            right = ImageIO.read(getClass().getResourceAsStream("../../res/player/right1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../../res/player/right2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../../res/player/right3.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("../../res/player/right4.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("../../res/player/right5.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            }
            if (keyHandler.downPressed) {
                direction = "down";
            }
            if (keyHandler.leftPressed) {
                direction = "left";
            }
            if (keyHandler.rightPressed) {
                direction = "right";
            }

            // collision check
            collisionOn = false;
            gamePanel.collisionCheck.checkTile(this);

            // move if no collision
            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            // cycle through sprites for movement animation
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum < 4) {
                    spriteNum++;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        // interact with object
        if (keyHandler.interactPressed) {

            try {
                for (SuperObject object : gamePanel.objects) {
                    if (object != null) {
                        if (object.interactable(worldX, worldY, direction, soidArea, gamePanel.tileSize) != null) {
                            object.interactable(worldX, worldY, direction, soidArea, gamePanel.tileSize).interact();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("No object to interact with");
            }
        }

        // check if player is on a coin
        for (SuperObject object : gamePanel.objects) {
            if (object != null) {
                if (object.isOnPlayer(worldX, worldY, soidArea, gamePanel.tileSize) != null) {
                    if (object instanceof PickUp)
                        ((PickUp) object).onCollision();
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                switch (spriteNum) {
                    case 1:
                        image = up1;
                        break;
                    case 2:
                        image = up2;
                        break;
                    case 3:
                        image = up3;
                        break;
                    case 4:
                        image = up4;
                        break;
                }
                break;
            case "down":
                switch (spriteNum) {
                    case 1:
                        image = down1;
                        break;
                    case 2:
                        image = down2;
                        break;
                    case 3:
                        image = down3;
                        break;
                    case 4:
                        image = down4;
                        break;
                }
                break;
            case "left":
                switch (spriteNum) {
                    case 1:
                        image = left1;
                        break;
                    case 2:
                        image = left2;
                        break;
                    case 3:
                        image = left3;
                        break;
                    case 4:
                        image = left4;
                        break;
                }
                break;
            case "right":
                switch (spriteNum) {
                    case 1:
                        image = right1;
                        break;
                    case 2:
                        image = right2;
                        break;
                    case 3:
                        image = right3;
                        break;
                    case 4:
                        image = right4;
                        break;
                }
                break;
            case "default":
                image = down;
                break;
        }
        g2d.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
