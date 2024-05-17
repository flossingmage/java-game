package src.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;
import src.objects.PickUp;

public class inventory {

    public GamePanel gamePanel;
    Font font;
    public static ArrayList<StorgeSlot> storgeSlots = new ArrayList<StorgeSlot>();
    int width = 200;
    int height = 400;

    public inventory(GamePanel gamePanel, Font font) {
        this.gamePanel = gamePanel;
        this.font = font;
    }

    public void inventoryOpen(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(gamePanel.screenWidth - width, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Inventory", gamePanel.screenWidth - width + 50, 20);
        drawSlots(g2d);
        try {
            g2d.drawImage(ImageIO.read(getClass().getResourceAsStream("../../res/UI/inventory_selector.png")),
                    gamePanel.screenWidth - width + 5 + (40 * KeyHandler.right), 40 + (40 * KeyHandler.down), 31, 32,
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pickedUpItem(PickUp item) {
        boolean itemExists = false;
        for (StorgeSlot storgeSlot : storgeSlots) {
            if (!storgeSlot.empty && storgeSlot.item.equals(item)) {
                itemExists = true;
                storgeSlot.quantity++;
                break;
            }
        }
        if (!itemExists) {
            storgeSlots.add(new StorgeSlot(item));
        }
    }

    public void drawSlots(Graphics2D g2d) {
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        for (int i = 0; i < storgeSlots.size(); i++) {
            g2d.drawRect(gamePanel.screenWidth - width + 5 + (40 * (i % 5)), 40 + (40 * (i / 5)), 30, 30);
            g2d.drawImage(storgeSlots.get(i).item.image, gamePanel.screenWidth - width + 6 + (40 * (i % 5)),
                    41 + (40 * (i / 5)), 28, 28, null);
            g2d.drawString("x" + storgeSlots.get(i).quantity, gamePanel.screenWidth - width + 5 + (40 * (i % 5)),
                    50 + (40 * (i / 5)));
        }
    }

    public static void useItem() {
        if (!storgeSlots.get(KeyHandler.down * 5 + KeyHandler.right).empty) {
            storgeSlots.get(KeyHandler.down * 5 + KeyHandler.right).item.useItem();
            storgeSlots.get(KeyHandler.down * 5 + KeyHandler.right).quantity--;
            if (storgeSlots.get(KeyHandler.down * 5 + KeyHandler.right).quantity == 0) {
                storgeSlots.remove(KeyHandler.down * 5 + KeyHandler.right);
            }
        }
    }

}
