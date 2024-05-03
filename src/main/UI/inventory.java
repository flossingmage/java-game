package src.main.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import src.main.GamePanel;

public class inventory {

    public GamePanel gamePanel;
    Font font;

    public inventory(GamePanel gamePanel, Font font) {
        this.gamePanel = gamePanel;
        this.font = font;
    }

    public void inventoryOpen(Graphics2D g2d){
        int width = 200;
        int height = 400;
        g2d.setColor(Color.WHITE);
       // g2d.fillRect(gamePanel.screenWidth - width,0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
       // g2d.drawString("Inventory", gamePanel.screenWidth - width + 50, 20);
    }
    
}
