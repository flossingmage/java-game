package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI{
    GamePanel gamePanel;
    Font font = new Font("Arial", Font.BOLD,20);

    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        g2d.drawString("Health: " + gamePanel.player.Health, 10, 20);
        if (gamePanel.keyHandler.inventoryPressed){
            inventoryOpen(g2d);
        }

    }

    public void inventoryOpen(Graphics2D g2d){
        int width = 200;
        int height = 400;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(gamePanel.screenWidth - width,0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Inventory", gamePanel.screenWidth - width + 50, 20);
    }
    
}
