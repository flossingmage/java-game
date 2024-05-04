package src.main.UI;

import java.awt.image.BufferedImage;

public class StorgeSlot {
    public boolean empty = true;
    public String item = "";
    public int quantity = 0;
    public BufferedImage image;

    public StorgeSlot(String item, BufferedImage image) {
        {
            this.empty = false;
            this.item = item;
            this.image = image;
            this.quantity = 1;

        }
    }

}
